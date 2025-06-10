package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")WebElement
	// moreinfomanagecategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement entercategory;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement selectgroup;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	// public void moreinfoManageCategory()
	// {
	// moreinfo.click();
	// }
	public ManageCategoryPage newbutton() {
		newbutton.click();
		return this;
	}

	public ManageCategoryPage category(String enterproduct) {
		//category.sendKeys("Shoes");
		entercategory.clear();
		entercategory.sendKeys(enterproduct);
		return this;
	}

	public ManageCategoryPage selectgroup() {
		selectgroup.click();
		return this;
	}

	public ManageCategoryPage choosefile() throws AWTException {
		PageUtility pageutility = new PageUtility();
		pageutility.click(driver, choosefile);
		/*
		 * Actions actions=new Actions(driver);
		 * actions.click(choosefile).build().perform();
		 * 
		 * StringSelection stringselection=new
		 * StringSelection("\"C:\\Users\\jyoth\\Downloads\\Bottle.jpg\"");
		 * 
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,
		 * null); Robot robot=new Robot(); robot.delay(2500);
		 * 
		 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
		 * 
		 * robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyRelease(KeyEvent.VK_V);
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * return this;
		 */
		// String filepath=Constant.TESTIMAGEFILE;
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileuploadUsingRobertClass(choosefile, Constant.TESTIMAGEFILE);
		return this;

	}

	public ManageCategoryPage save() {
		PageUtility pageutility = new PageUtility();
		pageutility.click(driver, save);
		/*
		 * Actions actions=new Actions(driver); actions.click(save).build().perform();
		 */
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
