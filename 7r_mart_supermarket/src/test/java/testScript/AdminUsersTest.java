package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUsersPage;
import Pages.HomePage;
import Pages.LoginPage;
import constant.Constant;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	AdminUsersPage adminuserspage;
	HomePage homepage;
	@Test(groups= {"regression"},description="Verify whether the user is able to add new information in the admin users page",retryAnalyzer=retry.Retry.class)
	public void verifyWhetherTheUserIsAbleToCreateNewAdminUser() throws IOException
	{
		//String name="admin";
				//String password="admin";
				String username=ExcelUtility.getStringData(1, 0, "loginpage");
				String password=ExcelUtility.getStringData(1, 1, "loginpage");
				LoginPage loginpage=new LoginPage(driver);
				loginpage.enterTheUsername(username).enterThePassword(password);
				//loginpage.enterThePassword(password);
				homepage=loginpage.clickTheSignInButton();
				AdminUsersPage adminuserspage=new AdminUsersPage(driver);
				//String user="jyothi";
				//String pass="abcd1234";
				
				FakerUtility faker=new FakerUtility();
				String user=faker.creatARandomFirstName();
				String pass=faker.creatARandomFirstName();
				adminuserspage=homepage.moreinfoadminuser();
				adminuserspage.createnew().username(user).password(password).userType().save();
					
				//adminuserspage.createnew();
				//adminuserspage.username(user);
				//adminuserspage.password(pass);
				//adminuserspage.userType();
				//adminuserspage.save();
				boolean isalertdisplayed=adminuserspage.alert();
		Assert.assertTrue(isalertdisplayed,Constant.ADMINUSERSADDINFOERROR);
	}
	}

