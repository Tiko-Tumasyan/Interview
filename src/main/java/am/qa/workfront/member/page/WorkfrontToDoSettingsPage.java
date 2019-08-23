package am.qa.workfront.member.page;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.workfront.util.DriverUtil;

public class WorkfrontToDoSettingsPage extends WorkfrontMemberPage {

	public WorkfrontToDoSettingsPage(WebDriver driver) {
		super(driver);
	}
		
	final String toDoFormXPath = "//div[@class='well']//form[@id='createTodoForm']";
	@FindBy(xpath = toDoFormXPath)
	WebElement toDoForm;
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement titleField;
	
	@FindBy(xpath = "//input[@id='dueDate']")
	WebElement dateField;
	
	@FindBy(xpath = "//select[@name='priority']")
	WebElement priorityDropdown;
	
	@FindBy(xpath = "//select[@id='priority']//option[@value='LOW']")
	WebElement lowPriorityButton;
	
	@FindBy(xpath = "//select[@id='priority']//option[@value='MEDIUM']")
	WebElement mediumPriorityButton;
	
	@FindBy(xpath = "//select[@id='priority']//option[@value='HIGH']")
	WebElement highPriorityButton;
	
	@FindBy(xpath = "//div[@class='form-actions']//button[@type='submit']")
	WebElement createButton;
	
	@FindBy(xpath = "//div[@class='page-header']")
	WebElement calendarCloseClick;
	
	@FindBy(xpath = "//select[@id='status']")
	WebElement statusField;
	
	@FindBy(xpath = "//select[@id='status']//option[@value='true']")
	WebElement statusToDoSelect;
	
	@FindBy(xpath = "//select[@id='status']//option[@value='false']")
	WebElement statusDoneSelect;
	
	@FindBy(xpath = "//i[contains(@class, 'icon-refresh')]")
	WebElement updateParametersButton;
	
	
	public void fillWorkfrontTask1Parameters(String title1, String date1) {
		DriverUtil.waitForElementPresent(driver, 3, toDoFormXPath);
		titleField.clear();
		titleField.sendKeys(title1);
		dateField.sendKeys(Keys.chord(Keys.CONTROL, "a"), date1);
	}
	
	
	public void priorityDropdownOpen() {
		priorityDropdown.click();
	}
	
	public void setLowPriority() {
		lowPriorityButton.click();
	}
	
	public void setHighPriority() {
		highPriorityButton.click();
	}
	
	public void setMediumPriority() {
		mediumPriorityButton.click();
	}
	
	public void closeCalendar() {
		calendarCloseClick.click();
	}
	
	public void selectToDoStatus() {
		statusToDoSelect.click();
	}
	
	public void selectDoneStatus() {
		statusDoneSelect.click();
	}
	
	public void updateParameters() {
		updateParametersButton.click();
	}
	
	public WorkfrontMemberPage submitCreationForm() {
		createButton.click();
		return new WorkfrontMemberPage(driver);
	}

}
