package AutomationFrmwork;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fl.test.GenericKeywords;

public class Specs {
	GenericKeywords GenKeywords = new GenericKeywords();
	WebDriver driver = GenKeywords.driver;
	Properties Objects = GenKeywords.propObj;
	Properties Testdata = GenKeywords.propTestdata;
	
	@Test
	public void loginToApp() {
		GenKeywords.login(Testdata.getProperty("EmailID"), Testdata.getProperty("Password"));
	}
	
	@BeforeTest
	public void launchBrowser() {
		driver.manage().window().maximize();
	}

	@AfterTest
	public void terminateBrowser() {
		driver.quit();
	}
}
