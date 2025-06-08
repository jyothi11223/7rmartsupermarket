package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUsersPage;
import Pages.HomePage;
import Pages.LoginPage;
import constant.Constant;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	AdminUsersPage adminuserspage;
	HomePage homepage;
	@Test(groups= {"regression"},description="Verify whether the user is able to add new information in the admin users page",retryAnalyzer=retry.Retry.class)
	public void adminUsersTest()
	{
		String name="admin";
		String password="admin";

		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(name).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickTheSignInButton();
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		//String user="Amyl";
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

