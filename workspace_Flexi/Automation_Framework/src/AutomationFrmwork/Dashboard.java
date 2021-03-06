package AutomationFrmwork;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Dashboard extends AutomationFrmwork.BaseClass{
	
	@Test(priority=1)
	public void VerifyApplicationPage() throws InterruptedException {
		GenKeywords.login(driver, Testdata.getProperty("EmailID"), Testdata.getProperty("Password"));
		driver.findElement(By.xpath(Objects.getProperty("ApplicationPageClick"))).click();
		Reporter.log("On Application Page");
		GenKeywords.isElementLoaded(driver, By.xpath(Objects.getProperty("VerifyApplicationPage")), Integer.parseInt(Objects.getProperty("TwentyMilliSec")));
		Assert.assertTrue(driver.findElement(By.xpath(Objects.getProperty("VerifyApplicationPage"))).isDisplayed());
		//GenKeywords.logout();
	}
	
	@Test(priority=2)
	public void VerifySettingsPage() throws InterruptedException {
		GenKeywords.login(driver, Testdata.getProperty("EmailID"), Testdata.getProperty("Password"));
		//driver.findElement(By.xpath(Objects.getProperty("SettingsPageClick"))).click();
		driver.get(Objects.getProperty("SettingsPage"));
		Reporter.log("On Settings Page");
		GenKeywords.isElementLoaded(driver, By.name(Objects.getProperty("SettingSaveChanges")), Integer.parseInt(Objects.getProperty("TwentyMilliSec")));
		Assert.assertTrue(driver.findElement(By.name(Objects.getProperty("SettingSaveChanges"))).isDisplayed());
		//GenKeywords.logout();
	}
	
	@Test(priority=3)
	public void VerifyUploadDocPage() throws InterruptedException {
		GenKeywords.login(driver, Testdata.getProperty("EmailID"), Testdata.getProperty("Password"));
		//driver.findElement(By.xpath(Objects.getProperty("SettingsPageClick"))).click();
		driver.get(Objects.getProperty("UploadDocPage"));
		Reporter.log("On Upload Documents Page");
		GenKeywords.isElementLoaded(driver, By.xpath(Objects.getProperty("VerifyUploadDocPage")), Integer.parseInt(Objects.getProperty("TwentyMilliSec")));
		Assert.assertTrue(driver.findElement(By.xpath(Objects.getProperty("VerifyUploadDocPage"))).isDisplayed());
		//GenKeywords.logout();
	}
}
