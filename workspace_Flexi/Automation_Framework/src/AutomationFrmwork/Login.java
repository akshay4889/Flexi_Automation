package AutomationFrmwork;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class Login extends AutomationFrmwork.BaseClass{
	
	@Test(priority=1)
	public void WrongUsernameWhileLogin() throws InterruptedException {
		Thread.sleep(Integer.parseInt(Objects.getProperty("FiveMilliSec")));
		Reporter.log("Application launched.");
		driver.findElement(By.id(Objects.getProperty("LoginEmail"))).sendKeys(Testdata.getProperty("EmailID")+"wrong");
		driver.findElement(By.id(Objects.getProperty("LoginPassword"))).sendKeys(Testdata.getProperty("Password"));
		driver.findElement(By.xpath(Objects.getProperty("LoginButton"))).click();
		Thread.sleep(Integer.parseInt(Objects.getProperty("ThreeMilliSec")));
		Assert.assertEquals(driver.getTitle(), Objects.getProperty("LoginPageTitle"));
		Assert.assertTrue(driver.findElement(By.xpath(Objects.getProperty("IncorrectUsernameAndPasswordXPATH"))).getText().contains(Objects.getProperty("IncorrectUsername")) );
	}

	@Test(priority=2)
	public void WrongPasswordWhileLogin() throws InterruptedException {
		Thread.sleep(Integer.parseInt(Objects.getProperty("FiveMilliSec")));
		Reporter.log("Application launched.");
		driver.findElement(By.id(Objects.getProperty("LoginEmail"))).sendKeys(Testdata.getProperty("EmailID"));
		driver.findElement(By.id(Objects.getProperty("LoginPassword"))).sendKeys(Testdata.getProperty("Password")+"wrong");
		driver.findElement(By.xpath(Objects.getProperty("LoginButton"))).click();
		Thread.sleep(Integer.parseInt(Objects.getProperty("ThreeMilliSec")));
		Assert.assertEquals(driver.getTitle(), Objects.getProperty("LoginPageTitle"));
		Assert.assertTrue(driver.findElement(By.xpath(Objects.getProperty("IncorrectUsernameAndPasswordXPATH"))).getText().contains(Objects.getProperty("IncorrectPassword")) );
	}
	
	@Test(priority=3)
	public void loginToApp() throws InterruptedException {		
		GenKeywords.login(driver, Testdata.getProperty("EmailID"), Testdata.getProperty("Password"));
		//GenKeywords.logout(driver, action);
	}
}