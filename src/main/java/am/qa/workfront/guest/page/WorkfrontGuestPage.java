package am.qa.workfront.guest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.workfront.page.base.PageObject;
import am.qa.workfront.page.login.WorkfrontLoginPage;

public class WorkfrontGuestPage extends  PageObject{

	public WorkfrontGuestPage(WebDriver driver) {
		super(driver);
	}
	
	public static final String offsetXPath="//div[@class='row well']//div[contains(@class, 'offset')]";
	public static final String loginButtonXPath = "//div[@class='row']//a[@href='/login']" ;
	
	@FindBy(xpath = loginButtonXPath)
	WebElement loginButton;
	
	public WorkfrontLoginPage openLoginPage() {
		loginButton.click();
		return new WorkfrontLoginPage(driver);
	}

}
