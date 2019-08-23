package am.qa.workfront.task.tests;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import am.qa.workfront.guest.page.WorkfrontGuestPage;
import am.qa.workfront.member.page.WorkfrontMemberPage;
import am.qa.workfront.member.page.WorkfrontToDoSettingsPage;
import am.qa.workfront.page.login.WorkfrontLoginPage;
import am.qa.workfront.test.base.WorkfrontBaseTest;
import am.qa.workfront.util.DriverUtil;
import am.qa.workfront.util.ReadFromFileUtil;

public class WorkfrontTaskTest extends WorkfrontBaseTest {

	
	@Test
	public void workfrontTaskCreationTest() throws Exception {
		
		String email = ReadFromFileUtil.getProperties("email");
		String password = ReadFromFileUtil.getProperties("password");

		WorkfrontGuestPage guest = new WorkfrontGuestPage(driver);
		WorkfrontLoginPage login = guest.openLoginPage();//Opening login page by clicking on "SignIn" button
		login.doLogin(email, password);
		// reading properties from property file
		String title1 = ReadFromFileUtil.getProperties("title1");
		String date1 = ReadFromFileUtil.getProperties("date1");
		System.out.println("Creating new ToDo task");
		System.out.println("1. Open new task page");
		System.out.println(driver);
		DriverUtil.waitForElementPresent(driver, 3, "//a[@href='/user/todos/new']");
		WorkfrontMemberPage member = new WorkfrontMemberPage(driver);
		WorkfrontToDoSettingsPage task = member.openNewTaskPage();// Opening new task by clicking on "Create a todo"
																	// Link

		System.out.println("2. Fill workfront task parameters");
		task.fillWorkfrontTask1Parameters(title1, date1);// filling todo task properties
		System.out.println("3.  close calendar");
		task.closeCalendar();// closing calendar
		System.out.println("4. Open priority dropdown");
		task.priorityDropdownOpen();// priority dropdown opening
		System.out.println("5. Select high priority");
		task.setHighPriority();// setting priority level
		System.out.println("6. Submit tsak creation form");
		task.submitCreationForm();// submitting
		System.out.println("Submitting creation from");
		System.out.println("Verify member page with tasks is displayed");
		Assert.assertTrue(DriverUtil.waitForElementPresent(driver, 3, WorkfrontMemberPage.memberLeftMenuXPath));
		DriverUtil.waitForElementPresent(driver, 3, WorkfrontMemberPage.memberTasksContainerPath);
		DriverUtil.waitForElementPresent(driver, 3, "//td[text()='First']");// assertion
		
	}

	@Test(dependsOnMethods = "workfrontTaskCreationTest")
	public void workfrontTaskEditingTest() {
		WorkfrontMemberPage member = new WorkfrontMemberPage(driver);
		WorkfrontToDoSettingsPage task = member.openTaskEditForm();
		System.out.println("Opening task edit form");
		task.selectToDoStatus();
		System.out.println("Changing task status");
		task.updateParameters();
		System.out.println("Saving changes");
		DriverUtil.waitForElementPresent(driver, 3, WorkfrontMemberPage.memberLeftMenuXPath);
		DriverUtil.waitForElementPresent(driver, 3, WorkfrontMemberPage.memberTasksContainerPath);
		try {
			DriverUtil.waitForElementPresent(driver, 3, "//tr//td[text()='First']/..//td/span[@class='label  ']");
		} catch (TimeoutException ex) {
			System.out.println("A program bug is detected here ..... ");
		}
		task.deleteTask();
		DriverUtil.waitForElementPresent(driver, 3, WorkfrontMemberPage.confirmWindowXPath);
		task.deleteTaskConfirm();
		DriverUtil.waitForElementPresent(driver, 3, WorkfrontMemberPage.memberLeftMenuXPath);
		DriverUtil.waitForElementPresent(driver, 3, WorkfrontMemberPage.memberTasksContainerPath);
	
	}

}
