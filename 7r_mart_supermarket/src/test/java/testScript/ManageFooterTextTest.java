package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageFooterText;
import constant.Constant;

public class ManageFooterTextTest extends Base{
	ManageFooterText managefootertextpage;
	HomePage homepage;
@Test(description="Verify whether the user is able to add new information to the manage footer page")
public void ManageFooterTest()
{
	String name="admin";
	String password="admin";

	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterTheUsername(name);
	loginpage.enterThePassword(password);
	homepage=loginpage.clickTheSignInButton();
	
	ManageFooterText managefootertest=new ManageFooterText(driver);
	managefootertextpage=homepage.moreinfomanagefooter();
	managefootertextpage.actionbutton().address().email().phone().update();
	/*managefootertest.address();
	managefootertest.email();
	managefootertest.phone();
	managefootertest.update();*/
	boolean isalertdisplayed=managefootertextpage.alert();
	Assert.assertTrue(isalertdisplayed,Constant.MANAGEFOOTERADDINFOERROR);
}

@Test
public void isUpdateButtonDisplayed()
{
	String name="admin";
	String password="admin";

	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterTheUsername(name);
	loginpage.enterThePassword(password);
	homepage=loginpage.clickTheSignInButton();
	
	//ManageFooterText managefootertest=new ManageFooterText(driver);
	managefootertextpage=homepage.moreinfomanagefooter();
	managefootertextpage.actionbutton().isUpdateButtonDisplayed();
	//managefootertest.isUpdateButtonDisplayed();
}
}
