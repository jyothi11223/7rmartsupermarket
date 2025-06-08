package testScript;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageCategoryPage;
import constant.Constant;

public class ManageCategoryTest extends Base{
	ManageCategoryPage managecategorypage;
	HomePage homepage;
	@Test(description="Verify whether the user is able to add new category to the manage category page")
	public void manageCategoryTest() throws AWTException
	{
		String name="admin";
		String password="admin";

		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(name).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickTheSignInButton();
		
		ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage=homepage.moreinfoManageCategory().newbutton().category().selectgroup().choosefile().save();
		//managecategorypage.newbutton();
		//managecategorypage.category();
		//managecategorypage.selectgroup();
		//managecategorypage.choosefile();
		//managecategorypage.save();
		boolean isalertdisplayed=managecategorypage.alert();
		Assert.assertTrue(isalertdisplayed,Constant.MANAGECATEGORYADDINFOERROR);
		
	}
}
