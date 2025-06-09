package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageFooterText;
import constant.Constant;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base{
	ManageFooterText managefootertextpage;
	HomePage homepage;
@Test(description="Verify whether the user is able to add new information to the manage footer page")
public void verifyWhetherTheUserIsAbleToAddNewInformation() throws IOException
{
	String username=ExcelUtility.getStringData(1, 0, "loginpage");
    String password=ExcelUtility.getStringData(1, 1, "loginpage");
	//String name="admin";
	//String password="admin";

	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterTheUsername(username).enterThePassword(password);
	//loginpage.enterThePassword(password);
	homepage=loginpage.clickTheSignInButton();
	
	ManageFooterText managefootertest=new ManageFooterText(driver);
	managefootertextpage=homepage.moreinfomanagefooter();
	String address=ExcelUtility.getStringData(1, 0, "managefooter");
    String email=ExcelUtility.getStringData(1, 1, "managefooter");
    String number=ExcelUtility.getStringData(1, 0, "managefooter");
	managefootertextpage.actionbutton().address(address).email(email).phone(number).update();
	/*managefootertest.address();
	managefootertest.email();
	managefootertest.phone();
	managefootertest.update();*/
	boolean isalertdisplayed=managefootertextpage.alert();
	Assert.assertTrue(isalertdisplayed,Constant.MANAGEFOOTERADDINFOERROR);
}

@Test
public void verifyWhetherTheUpdateButtonIsDisplayedSuccessfully() throws IOException
{
	String username=ExcelUtility.getStringData(1, 0, "loginpage");
    String password=ExcelUtility.getStringData(1, 1, "loginpage");
	//String name="admin";
	//String password="admin";

	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterTheUsername(username).enterThePassword(password);
	//loginpage.enterThePassword(password);
	homepage=loginpage.clickTheSignInButton();
	
	//ManageFooterText managefootertest=new ManageFooterText(driver);
	managefootertextpage=homepage.moreinfomanagefooter();
	managefootertextpage.actionbutton().isUpdateButtonDisplayed();
	//managefootertest.isUpdateButtonDisplayed();
	boolean isbuttondisplayed=managefootertextpage.alert();
	Assert.assertTrue(isbuttondisplayed);
}
}
