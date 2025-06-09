package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageContactPage;
import constant.Constant;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{
	ManageContactPage managecontactpage;
	HomePage homepage;
	@Test(description="Verify whether the user is able to add new contact information to the manage contact page")
	public void verifyWhetherTheUserIsAbleToAddNewContact() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
	    String password=ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		//loginpage.enterThePassword(password);
		homepage=loginpage.clickTheSignInButton();
		//ManageContactPage managecontactpage=new ManageContactPage(driver);
		String mail = ExcelUtility.getStringData(1, 0, "managecontact");
		String phone = ExcelUtility.getIntegerData(1, 1, "managecontact");
		String address = ExcelUtility.getStringData(1, 2, "managecontact");
		String dtime = ExcelUtility.getIntegerData(1, 3, "managecontact");
		String dcharge = ExcelUtility.getIntegerData(1, 4, "managecontact");
		
		/*String mail="jyothipta1993@gmail.com";
		String phone="1234567890";
		String address="abc,kzm,tvm";
		String dtime="5";
		String dcharge="15";*/
		managecontactpage=homepage.moreinfoManageContact();
		managecontactpage.actionbutton().phone(phone).email(mail).address(address).deliverytime(dtime).deliverychargelimit(dcharge);
		//managecontactpage.actionbutton();
		//managecontactpage.phone(phone);
		//managecontactpage.email(mail);
		//managecontactpage.address(address);
		//managecontactpage.deliverytime(dtime);
		//managecontactpage.deliverychargelimit(dcharge);
		//managecontactpage.deliverytime(dtime);
		managecontactpage.update();
		boolean isalertdisplayed=managecontactpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed,Constant.MANAGECONTACTADDINFOERROR);
	}
	
}
