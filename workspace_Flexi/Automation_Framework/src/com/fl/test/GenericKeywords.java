package com.fl.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;  
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class GenericKeywords {
	public static WebDriver driverX;
	public FileInputStream fileInputObj;
	public FileInputStream fileInputTest;
	public Properties propObj;
	public Properties propTestdata;
	public String objectsFilePath = "\\objects\\Object.properties";
	public String testdataFilePath = "\\Testdata\\Testdata.properties";
	
	public GenericKeywords(){
		try{
			fileInputObj = new FileInputStream(System.getProperty("user.dir") + objectsFilePath);
			fileInputTest = new FileInputStream(System.getProperty("user.dir") + testdataFilePath);
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		propObj = new Properties();
		propTestdata = new Properties();
		try {
			propObj.load(fileInputObj);
			propTestdata.load(fileInputTest);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public WebDriver browser(){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
		driverX = new FirefoxDriver();
		return driverX;
	}
	
	public void login(WebDriver driver, String email, String password) throws InterruptedException{
		Thread.sleep(Integer.parseInt(propObj.getProperty("FiveMilliSec")));
		Reporter.log("Application launched.");
		driver.findElement(By.id(propObj.getProperty("LoginEmail"))).sendKeys(email);
		driver.findElement(By.id(propObj.getProperty("LoginPassword"))).sendKeys(password);
		driver.findElement(By.xpath(propObj.getProperty("LoginButton"))).click();
		Reporter.log("Successfully logged into Application.");
		isElementLoaded(driver, By.xpath(propObj.getProperty("WelcomeKeyword")), Integer.parseInt(propObj.getProperty("TwentyMilliSec")));
		Assert.assertEquals(driver.getTitle(), propObj.getProperty("HomePageTitle"));
		Assert.assertTrue(driver.findElement(By.xpath(propObj.getProperty("WelcomeKeyword"))).getText().contains(propObj.getProperty("Welcome")));
	}
	
	public void logout(WebDriver driver, Actions action) throws InterruptedException{
		action.moveToElement(driver.findElement(By.xpath(propObj.getProperty("WelcomeKeyword")))).perform();
		Thread.sleep(Integer.parseInt(propObj.getProperty("ThreeMilliSec")));
		action.moveToElement(driver.findElement(By.xpath(propObj.getProperty("logout")))).click().perform();
		//driver.findElement(By.xpath(propObj.getProperty("logout"))).click();
		Thread.sleep(Integer.parseInt(propObj.getProperty("ThreeMilliSec")));
		Reporter.log("Application Successfully Logged off");
		Assert.assertTrue(driver.findElement(By.xpath(propObj.getProperty("LoginButton"))).isDisplayed());
	}
	
	public WebElement isElementLoaded(WebDriver driver, By elementToBeLoaded, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elementToBeLoaded));
	    return element;
	}
}