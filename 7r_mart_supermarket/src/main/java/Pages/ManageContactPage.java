package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
public WebDriver driver;
public ManageContactPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement moreinfomanagecontact;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement actionbutton;
@FindBy(xpath="//input[@id='email']")WebElement email;
@FindBy(xpath="//button[@type='submit' and @name='Update']")WebElement update;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
@FindBy(xpath="//input[@id='phone']")WebElement phone;
@FindBy(xpath="//textarea[@id='content' and @name='address']")WebElement address;
@FindBy(xpath="//textarea[@name='del_time']")WebElement deliverytime;
@FindBy(xpath="//input[@id='del_limit']")WebElement deliverychargelimit;

//public void moreinfoManageContact()
//{
	//moreinfo.click();
//}
public ManageContactPage actionbutton()
{
	/*Actions actions=new Actions(driver);
	actions.click(actionbutton).build().perform();*/
	/*JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();","actionbutton");*/
	actionbutton.click();
	return this;
}
public ManageContactPage phone(String enterphonenumber)
{
	phone.clear();
	phone.sendKeys(enterphonenumber);
	return this;
}
public ManageContactPage email(String enteremail)
{
	email.clear();
	email.sendKeys(enteremail);
	return this;
}
public ManageContactPage address(String enteraddress)
{
	address.clear();
	address.sendKeys(enteraddress);
	return this;
}

public ManageContactPage deliverytime(String enterdeliverytime)
{
	deliverytime.clear();
	deliverytime.sendKeys(enterdeliverytime);
	return this;
}
public ManageContactPage deliverychargelimit(String enterdeliverychargelimit)
{
	deliverychargelimit.clear();
	deliverychargelimit.sendKeys(enterdeliverychargelimit);
	return this;
}
public ManageContactPage update()
{
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();","update");
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.elementToBeClickable(update));
	PageUtility pageutility=new PageUtility();
	pageutility.click(driver, update);
	/*Actions actions=new Actions(driver);
	actions.click(update).build().perform();*/
	//update.click();
	return this;
}
public boolean alert()
{
	return alert.isDisplayed();
}

}
