package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinfield;
	@FindBy(xpath = "//p[@text()='Dashboard']")
	WebElement dashboardfield;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;

	public LoginPage enterTheUsername(String usernamevalue) {
		usernamefield.sendKeys(usernamevalue);
		return this;
	}

	public LoginPage enterThePassword(String passwordvalue) {
		passwordfield.sendKeys(passwordvalue);
		return this;
	}

	public HomePage clickTheSignInButton() {
		signinfield.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplay() {

		return dashboardfield.isDisplayed();

	}

	public boolean isAlertDisplay() {
		return alert.isDisplayed();
	}
}
