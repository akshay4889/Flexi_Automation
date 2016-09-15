package com.fl.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;  
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericKeywords {
	public FileInputStream fileInputObj;
	public FileInputStream fileInputTest;
	public Properties propObj;
	public Properties propTestdata;
	public WebDriver driver;
	public String objectsFilePath = "\\objects\\Object.properties";
	public String testdataFilePath = "\\Testdata\\Testdata.properties";
	
	public GenericKeywords(){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
		driver = new FirefoxDriver();
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
	
	public void login(String email, String password){
		driver.get(propObj.getProperty("LoginPage"));
		driver.findElement(By.id(propObj.getProperty("LoginEmail"))).sendKeys(email);
		driver.findElement(By.id(propObj.getProperty("LoginPassword"))).sendKeys(password);
		driver.findElement(By.xpath(propObj.getProperty("LoginButton"))).click();
	}
}