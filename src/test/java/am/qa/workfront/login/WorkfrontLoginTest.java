package am.qa.workfront.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.workfront.util.DriverUtil;
import am.qa.workfront.util.ReadFromFileUtil;
import am.qa.workfront.guest.page.WorkfrontGuestPage;
import am.qa.workfront.member.page.WorkfrontMemberPage;
import am.qa.workfront.page.login.WorkfrontLoginPage;
import am.qa.workfront.test.base.WorkfrontBaseTest;

public class WorkfrontLoginTest extends WorkfrontBaseTest{
	
	
	@Test
	public void workfrontLoginTest() throws Exception {
		
		
		//printing requirements
		System.out.println("##### Requirements are ####");
		System.out.println("The first goal is to do exploratory testing and find as many issues as you can. Believe me, there are a lot of issues. The result of this part should be a spreadsheet with issues description. \r\n" + 
				"The second goal is to automate \"Login\" and \"Task Creation\" flows. The result of this part should be your codes shared with me and a video recording that will confirm successful tests passing.");
		//reading properties from property file 
		String email = ReadFromFileUtil.getProperties("email");
		String password = ReadFromFileUtil.getProperties("password");
		System.out.println("## Login basic flow test ##");
		WorkfrontGuestPage guest = new WorkfrontGuestPage(driver);
		WorkfrontLoginPage login = guest.openLoginPage();//Opening login page by clicking on "SignIn" button
		System.out.println("1. Opening login page");
		System.out.println("2. Filling login credentials and submitting");
		login.doLogin(email, password);
		
		System.out.println("Verify member home page is displayed");
		Assert.assertTrue(DriverUtil.waitForElementPresent(driver, 3, WorkfrontMemberPage.memberLeftMenuXPath));
		Assert.assertTrue(DriverUtil.waitForElementPresent(driver, 3, WorkfrontMemberPage.memberTasksContainerPath));	
		
		
	}

}
