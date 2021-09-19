package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopcommerce.LoginPageUI;

public class LoginPageObjects extends BasePage{
	private WebDriver driver;
	
	public LoginPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public void inputEmailAddress(String emailaddress) {
		waitForElementVisible(driver, LoginPageUI.EMAILADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAILADDRESS_TEXTBOX, emailaddress);
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public HomePageObjects clickToLoginButton() {
		waitForElementCLickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new HomePageObjects(driver);
	}

}
