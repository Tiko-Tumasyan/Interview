package am.qa.workfront.page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.workfront.util.DriverUtil;
import am.qa.workfront.util.ReadFromFileUtil;
import am.qa.workfront.guest.page.WorkfrontGuestPage;
import am.qa.workfront.member.page.WorkfrontMemberPage;
import am.qa.workfront.page.base.PageObject;

public class WorkfrontLoginPage extends PageObject {

	public WorkfrontLoginPage(WebDriver driver) {
		super(driver);
	}
	
	final String loginWinXPath = "//form[@id='loginForm']";
	@FindBy(xpath = loginWinXPath )
	WebElement loginWin;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	
	
	public void doLogin(String email, String password) {
	
		fillWorkfrontLoginCredentials(email, password);//Filling login credentials
		submitWorkfrontLoginForm();//Submitting login form
	}
	
	public void fillWorkfrontLoginCredentials(String email, String password) {
		DriverUtil.waitForElementPresent(driver, 3, loginWinXPath);
		emailField.clear();
		emailField.sendKeys(email);
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public WorkfrontMemberPage submitWorkfrontLoginForm() {
		submitButton.click();
		return new WorkfrontMemberPage(driver);
	}

}
