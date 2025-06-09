package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageCategoryPage;
import constant.Constant;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	ManageCategoryPage managecategorypage;
	HomePage homepage;
	@Test(description="Verify whether the user is able to add new category to the manage category page")
	public void verifyWhetherTheUserIsAbleToAddNewCategory() throws AWTException, IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
	    String password=ExcelUtility.getStringData(1, 1, "loginpage");
		//String name="admin";
		//String password="admin";

		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickTheSignInButton();
		
		ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage=homepage.moreinfoManageCategory().newbutton().category().selectgroup().choosefile().save();
		//managecategorypage.newbutton();
		//managecategorypage.category();
		//managecategorypage.selectgroup();
		//managecategorypage.choosefile();
		//managecategorypage.save();
		boolean isalertdisplayed=managecategorypage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed,Constant.MANAGECATEGORYADDINFOERROR);
		
	}
}
