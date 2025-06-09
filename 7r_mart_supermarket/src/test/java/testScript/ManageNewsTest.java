package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import constant.Constant;

public class ManageNewsTest extends Base {

	ManageNewsPage managenewspage;
	HomePage homepage;
@Test(description="Verify whether the user is able to add new news information to the manage news page successfully")

public void verifyWhetherTheUserIsAbleToAddNewNewsInformation()
{
	String username="admin";
	String password="admin";
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterTheUsername(username);
	loginpage.enterThePassword(password);
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
public void verifyWhetherTheSaveButtonIsDisplayedSuccessfully()
{
	String username="admin";
	String password="admin";
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterTheUsername(username);
	loginpage.enterThePassword(password);
	homepage=loginpage.clickTheSignInButton();	
	
	//ManageNewsPage manage=new ManageNewsPage(driver);
	managenewspage=homepage.moreinfomanagenews();
	managenewspage.newMethod().isSaveButtonDisplayed();
	/*manage.newMethod();
	manage.isSaveButtonDisplayed();*/
}
@Test(description="Verify whether the user is able to delete  news information from manage news page successfully")
public void verifyWhetherTheUserIsAbleToDeleteNewsInformationSuccessfully()
{
	String username="admin";
	String password="admin";
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterTheUsername(username);
	loginpage.enterThePassword(password);
	homepage=loginpage.clickTheSignInButton();	
	//ManageNewsPage manage=new ManageNewsPage(driver);
	managenewspage=homepage.moreinfomanagenews();
	managenewspage.deleteMethod(); 
	//managenewspage.deleteAlert();
	boolean isalertavailable=managenewspage.isAlertDisplayed();
	Assert.assertTrue(isalertavailable,Constant.NANAGENEWSDLTINFOERROR);
}
}
