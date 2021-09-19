package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopcommerce.HomePageUI;
import pageUIs.user.nopcommerce.RegisterPageUI;

public class RegisterPageObjects extends BasePage {
	private WebDriver driver;
	
	public RegisterPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	public void clickToMaleRadioButton() {
		waitForElementCLickable(driver, RegisterPageUI.MALE_RADIOBUTTON);
		clickToElement(driver, RegisterPageUI.MALE_RADIOBUTTON);
	}

	public void inputFirstName(String firstname) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
		
	}

	public void inputLastName(String lastname) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXBOX, lastname);
		
	}

	public void inputEmailAddress(String emailaddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAILADDRESS_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAILADDRESS_TEXTBOX, emailaddress);
		
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void inputToConfirmPassword(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, password);
		
	}

	public void clickToRegisterButton() {
		waitForElementCLickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	
	public boolean getTextRegisterSuccess() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public HomePageObjects clickToLogoutButton() {
		waitForElementCLickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return new HomePageObjects(driver);
		
	}

}
