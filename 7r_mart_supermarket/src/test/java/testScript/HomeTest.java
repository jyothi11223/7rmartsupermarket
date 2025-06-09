package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.LoginPage;
import utilities.ExcelUtility;
import Pages.HomePage;

public class HomeTest extends Base {
	@Test
	public void verifyWhetherTheUserIsAbleToLogout() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password).clickTheSignInButton();
		// loginpage.enterThePassword(password);
		// loginpage.clickTheSignInButton();

		HomePage logoutpage = new HomePage(driver);
		logoutpage.userlogo();

		logoutpage.logout();
	}
}
