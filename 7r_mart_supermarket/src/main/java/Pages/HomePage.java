package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")WebElement userlogo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")WebElement moreinfomanagecategory;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement moreinfomanagecontact;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement moreinfomanagefooter;
	@FindBy(xpath="//a[contains(@href,'uniqassosiates.com/admin/list-news')]")WebElement moreinfomanagenews;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and contains(@class,'small-box-footer')]")WebElement moreinfoadminuser;
	public ManageContactPage moreinfoManageContact()
	{
		moreinfomanagecontact.click();
		return new ManageContactPage(driver);
	}
	public ManageCategoryPage moreinfoManageCategory()
	{
		moreinfomanagecategory.click();
		return new ManageCategoryPage(driver);
	}
	public ManageFooterText moreinfomanagefooter()
	{
		moreinfomanagefooter.click();
		return new ManageFooterText(driver);
	}	
	public ManageNewsPage moreinfomanagenews()
	{
		moreinfomanagenews.click();
		return new ManageNewsPage(driver);
	}
	public AdminUsersPage moreinfoadminuser()
	{
		moreinfoadminuser.click();
		return new AdminUsersPage(driver);
	}

	public void userlogo()
	{
		Actions actions=new Actions(driver);
		actions.click(userlogo).build().perform();
		//userlogo.click();
		//Select select=new Select(userlogo);
		//select.selectByVisibleText("Logout");
	}
	public void logout()
	{
		logout.click();
	}
	
}
