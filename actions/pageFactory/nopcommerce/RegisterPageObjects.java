package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BaseFactory;

public class RegisterPageObjects extends BaseFactory {
	 WebDriver driver;
	
	 /*public static final String MALE_RADIOBUTTON="//input[@id='gender-male']";
	public static final String FIRSTNAME_TEXTBOX="//input[@name='FirstName']";
	public static final String LASTNAME_TEXBOX="//input[@name='LastName']";
	public static final String EMAILADDRESS_TEXTBOX="//input[@name='Email']";
	public static final String PASSWORD_TEXTBOX="//input[@name='Password']";
	public static final String CONFIRMPASSWORD_TEXTBOX="//input[@name='ConfirmPassword']";
	public static final String REGISTER_BUTTON="//button[@name='register-button']";
	public static final String REGISTER_SUCCESS_MESSAGE="//div[text()='Your registration completed']";
	public static final String LOGOUT_LINK="//a[@class='ico-logout']";*/
	
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement maleRadioButton;
	
	@FindBy(xpath="//input[@name='FirstName']")
	WebElement firstNameTextBox;
	
	@FindBy(xpath="//input[@name='LastName']")
	WebElement lastNameTextBox;
	
	@FindBy(xpath="//input[@name='Email']")
	WebElement emailAdressTextBox;
	
	@FindBy(xpath="//input[@name='Password']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@name='ConfirmPassword']")
	WebElement confirmPasswordTextBox;
	
	@FindBy(xpath="//button[@name='register-button']")
	WebElement registerButton;
	
	@FindBy(xpath="//div[text()='Your registration completed']")
	WebElement registerSuccessMessage;
	
	@FindBy(xpath="//a[@class='ico-logout']")
	WebElement logoutLink;
	 
	 
	public RegisterPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	public void clickToMaleRadioButton() {
		waitForElementCLickable(driver, maleRadioButton);
		clickToElement(driver, maleRadioButton);
	}

	public void inputFirstName(String firstname) {
		waitForElementVisible(driver, firstNameTextBox);
		sendkeyToElement(driver, firstNameTextBox, firstname);
	}

	public void inputLastName(String lastname) {
		waitForElementVisible(driver, lastNameTextBox);
		sendkeyToElement(driver, lastNameTextBox, lastname);
	}

	public void inputEmailAddress(String emailaddress) {
		waitForElementVisible(driver, emailAdressTextBox);
		sendkeyToElement(driver, emailAdressTextBox, emailaddress);
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
	}

	public void inputToConfirmPassword(String password) {
		waitForElementVisible(driver, confirmPasswordTextBox);
		sendkeyToElement(driver, confirmPasswordTextBox, password);
	}

	public void clickToRegisterButton() {
		waitForElementCLickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	
	public boolean getTextRegisterSuccess() {
		waitForElementVisible(driver, registerSuccessMessage);
		return isElementDisplayed(driver, registerSuccessMessage);
	}

	public void clickToLogoutButton() {
		waitForElementCLickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

}
