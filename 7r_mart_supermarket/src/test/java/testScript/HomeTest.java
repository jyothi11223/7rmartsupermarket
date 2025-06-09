package testScript;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.HomePage;

public class HomeTest extends Base{
	@Test
	public void verifyWhetherTheUserIsAbleToLogout()
	{
		String name="admin";
		String password="admin";

		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(name);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		
		HomePage logoutpage=new HomePage(driver);
		logoutpage.userlogo();
		
		logoutpage.logout();
	}
}
