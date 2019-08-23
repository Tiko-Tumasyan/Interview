package am.qa.workfront.util;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {
	
	public static boolean waitForElementPresent(WebDriver driver, int waitSeconds, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return true;
		}
		catch(Exception ex) {
			System.out.println("## Element with xpath " + xpath +" not found...");
			return false;
		}
	}
	

}
