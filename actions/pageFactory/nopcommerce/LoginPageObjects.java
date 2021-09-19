package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BaseFactory;
import commons.BasePage;
import pageUIs.user.nopcommerce.LoginPageUI;

public class LoginPageObjects extends BaseFactory{
	private WebDriver driver;
	
	/*public static final String EMAILADDRESS_TEXTBOX="//input[@class='email']";
	public static final String PASSWORD_TEXTBOX="//input[@class='password']";
	public static final String LOGIN_BUTTON="//button[text()='Log in']";*/
	
	@FindBy(xpath="//input[@class='email']")
	WebElement emailTextbox;
	
	@FindBy(xpath="//input[@class='password']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginButton;
	
	public LoginPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public void inputEmailAddress(String emailaddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailaddress);
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, passwordTextBox, password);
	}

	public void clickToLoginButton() {
		waitForElementCLickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

}
