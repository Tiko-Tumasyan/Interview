package am.qa.workfront.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import am.qa.workfront.guest.page.WorkfrontGuestPage;
import am.qa.workfront.util.DriverUtil;

public class WorkfrontBaseTest {

	public WebDriver driver;

	final static String URL = "https://ancient-taiga-22967.herokuapp.com";

	@BeforeClass
	@Parameters({"browser", "driverPath" })
	public void createDriver(String browser, String driverPath) {
		 System.setProperty(browser, driverPath);
		if (browser.contains("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);

		DriverUtil.waitForElementPresent(driver, 3, WorkfrontGuestPage.offsetXPath);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
