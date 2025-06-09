package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import constant.Constant;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	ManageNewsPage managenewspage;
	HomePage homepage;
@Test(description="Verify whether the user is able to add new news information to the manage news page successfully")

public void verifyWhetherTheUserIsAbleToAddNewNewsInformation() throws IOException
{
	String username=ExcelUtility.getStringData(1, 0, "loginpage");
    String password=ExcelUtility.getStringData(1, 1, "loginpage");
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterTheUsername(username).enterThePassword(password);
	//loginpage.enterThePassword(password);
	homepage=loginpage.clickTheSignInButton();
	
	//ManageNewsPage manage=new ManageNewsPage(driver);
	String news="Have a nice day";
	managenewspage=homepage.moreinfomanagenews();
	managenewspage.newMethod().textFieldMethod(news).save();
	/*manage.textFieldMethod(news);
	manage.save();*/
	boolean isalertavailable=managenewspage.isAlertDisplayed();
	Assert.assertTrue(isalertavailable,Constant.MANAGENEWSADDINFOERROR);
	
}
	
@Test
public void verifyWhetherTheSaveButtonIsDisplayedSuccessfully() throws IOException
{
	String username=ExcelUtility.getStringData(1, 0, "loginpage");
    String password=ExcelUtility.getStringData(1, 1, "loginpage");
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterTheUsername(username).enterThePassword(password);
	//loginpage.enterThePassword(password);
	homepage=loginpage.clickTheSignInButton();	
	
	//ManageNewsPage manage=new ManageNewsPage(driver);
	managenewspage=homepage.moreinfomanagenews();
	managenewspage.newMethod().isSaveButtonDisplayed();
	/*manage.newMethod();
	manage.isSaveButtonDisplayed();*/
}
@Test(description="Verify whether the user is able to delete  news information from manage news page successfully")
public void verifyWhetherTheUserIsAbleToDeleteNewsInformationSuccessfully() throws IOException
{
	String username=ExcelUtility.getStringData(1, 0, "loginpage");
    String password=ExcelUtility.getStringData(1, 1, "loginpage");
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterTheUsername(username).enterThePassword(password);
	//loginpage.enterThePassword(password);
	homepage=loginpage.clickTheSignInButton();	
	//ManageNewsPage manage=new ManageNewsPage(driver);
	managenewspage=homepage.moreinfomanagenews();
	managenewspage.deleteMethod(); 
	//managenewspage.deleteAlert();
	boolean isalertavailable=managenewspage.isAlertDisplayed();
	Assert.assertTrue(isalertavailable,Constant.NANAGENEWSDLTINFOERROR);
}
}
