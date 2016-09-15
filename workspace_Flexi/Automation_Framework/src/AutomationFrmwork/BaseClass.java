package AutomationFrmwork;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.fl.test.GenericKeywords;

public class BaseClass {

	WebDriver driver;
	GenericKeywords GenKeywords = new GenericKeywords();
	Properties Objects = GenKeywords.propObj;
	Properties Testdata = GenKeywords.propTestdata;
	Actions action;

	@BeforeMethod
	public void RedirectToLoginPage() throws NumberFormatException, InterruptedException{
		Thread.sleep(Integer.parseInt(Objects.getProperty("ThreeMilliSec")));
		driver.get(Objects.getProperty("LoginPage"));		
	}
		
	@BeforeClass
	public void launchBrowser() throws NumberFormatException, InterruptedException {
		driver = GenKeywords.browser();
		driver.manage().window().maximize();
		action = new Actions(driver);
	}
	
	@AfterClass
	public void terminateBrowser() {
		try { 
	        if (driver != null) {
	            driver.quit(); 
	        } 
	    } catch (Exception e) { 
	        System.out.println(e.getMessage()); 
	    }
	    driver = null;
	}
}