package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopcommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void inputToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public DashboardPageObject clickToLoginButton() {
		waitForElementCLickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashBoardPage(driver);
	}
}
