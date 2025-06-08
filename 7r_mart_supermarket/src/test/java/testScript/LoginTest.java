package testScript;

import Pages.LoginPage;
import constant.Constant;
import utilities.ExcelUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest extends Base{
	@Test(groups= {"regression"},description="Verify whether the user is able to login to the application with correct username and correct password successfully",retryAnalyzer=retry.Retry.class)
public void loginTest() throws IOException//it is the test case where we are giving the credentials
{
	String username="admin";
	String password="admin";
//String username=ExcelUtility.getStringData(1, 0, "loginpage");
//String password=ExcelUtility.getStringData(1, 1, "loginpage");
	LoginPage loginpage=new LoginPage(driver);//we need to pass the credentials to the login page so createobj of login page and pass driver as an argument
	loginpage.enterTheUsername(username);
	loginpage.enterThePassword(password);
	loginpage.clickTheSignInButton();
	boolean ishomepageavailable=loginpage.isDashboardDisplay();
	Assert.assertTrue(ishomepageavailable,Constant.LOGINCORRECTUSERNAMECORRECTPASSWORD);
}
	@Test(description="Verify whether the user is able to login to the application with incorrect username and correct password successfully")
	public void loginTest1()
	{
		String username="abcd";//credentials with wrong username and correct password
		String password="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		boolean isalertavailable=loginpage.isAlertDisplay();
		Assert.assertTrue(isalertavailable,Constant.LOGININCORRECTUSERNAMECORRECTPASSWORD);
	}
	@Test(description="Verify whether the user is able to login to the application with correct username and incorrect password successfully")
	public void loginTest2()
	{
		String username="admin";//credentials with wrong username and correct password
		String password="abcd";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		boolean isalertavailable=loginpage.isAlertDisplay();
		Assert.assertTrue(isalertavailable,Constant.LOGININCORRECTUSERNAMEINCORRECTPASSWORD);
	}	
	@Test(description="Verify whether the user is able to login to the application with incorrect username and incorrect password successfully")
	public void loginTest3()
	{
		String username="abcd";//credentials with wrong username and correct password
		String password="abcd";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		boolean isalertavailable=loginpage.isAlertDisplay();
		Assert.assertTrue(isalertavailable,Constant.LOGININCORRECTUSERNAMEINCORRECTPASSWORD);
	}	
}
