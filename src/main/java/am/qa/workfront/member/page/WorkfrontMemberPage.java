package am.qa.workfront.member.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.workfront.page.base.PageObject;

public class WorkfrontMemberPage extends PageObject {

	public WorkfrontMemberPage(WebDriver driver) {
		super(driver);
	}
	
	public static final String memberLeftMenuXPath = "//div[@class='row']//div[@class='span3']";
	@FindBy(xpath = memberLeftMenuXPath )
	WebElement memberContainer1;
	
	public static final String memberTasksContainerPath = "//div[@class='row']//div[@class='span9']";
	@FindBy(xpath = memberTasksContainerPath )
	WebElement memberContainer2;
	
//	@FindBy(xpath = "//ul[contains(@class, 'nav-list')]//i[@class='icon-file']")
	@FindBy(xpath = "//a[@href='/user/todos/new']")
	WebElement createAToDoButton;
	
	@FindBy(xpath = "//tr//td[text()='First']/..//td//i[contains(@class, 'icon-edit')]")
	WebElement taskEditButton;
	
	@FindBy(xpath = "//tr//td[text()='First']/..//td//a[@data-toggle='modal']")
	WebElement taskDeleteButton;

	@FindBy(xpath = "//div[@class='modal hide in']//button[@type='submit']")
	WebElement taskDeleteConfirmButton;
	
	public static final String confirmWindowXPath="//div[@class='modal hide in']";
	@FindBy(xpath = confirmWindowXPath)
	WebElement confirmWindow;
	
	public WorkfrontToDoSettingsPage openNewTaskPage() {
		createAToDoButton.click();
		return new WorkfrontToDoSettingsPage(driver);
	}
	
	public WorkfrontToDoSettingsPage openTaskEditForm() {
		taskEditButton.click();
		return new WorkfrontToDoSettingsPage(driver);
	}
	
	public void deleteTask() {
		taskDeleteButton.click();
	}
	
	public void deleteTaskConfirm() {
		taskDeleteConfirmButton.click();
	}

}
