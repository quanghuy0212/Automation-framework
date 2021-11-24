package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.HomePageUI;
import pageUIs.bankguru.NewCustomerUI;

public class NewCustomerPO extends BasePage {
	private WebDriver driver;
	
	public NewCustomerPO(WebDriver driver) {
		this.driver=driver;
	}
	
	public void inputToCustomerNameTextbox(WebDriver driver, String textboxName,String value) {
		 waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME,textboxName);
		 sendkeyToElement(driver,BasePageUI.TEXT_BOX_BY_NAME,value,textboxName);
	}

	public void clickToMaleRadioButton(WebDriver driver) {
		waitForElementCLickable(driver, NewCustomerUI.MALE_RADIO_BUTTON);
		clickToElement(driver, NewCustomerUI.MALE_RADIO_BUTTON);
	}

	public void inputToDOBTextbox(WebDriver driver,String attributeName,String value) {
		removeAttributeInDOM(driver, NewCustomerUI.DOB_TEXTBOX, attributeName);
		waitForElementVisible(driver,NewCustomerUI.DOB_TEXTBOX);
		sendkeyToElement(driver,NewCustomerUI.DOB_TEXTBOX, value);
	}

	public void inputToAddressField(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXTAREA_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXTAREA_BY_NAME, value, textboxName);
	}

	public void inputToCityTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
	}

	public void inputToStateTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
	}

	public void inputToPINTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
		
	}

	public void inputToPhoneNumBerTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);		
	}

	public void inputToEmailTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);		
	}

	public void inputToPasswordTextBox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);		
	}

	public void clickToSubmitButton(WebDriver driver,String buttonName) {
		waitForElementCLickable(driver, BasePageUI.BUTTON_BY_NAME, buttonName);
		clickToElement(driver, BasePageUI.BUTTON_BY_NAME, buttonName);		
	}

	public boolean verifyToastRegisterSuccessfully(WebDriver driver) {
		waitForElementVisible(driver, NewCustomerUI.REGISTER_SUCCESFULLY_TOAST);
		return isElementDisplayed(driver, NewCustomerUI.REGISTER_SUCCESFULLY_TOAST);
	}

	public String verifyCustomerName(WebDriver driver, String tdText) {
		waitForElementVisible(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
		return getTextElement(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
	}

	public String verifyGender(WebDriver driver, String tdText) {
		waitForElementVisible(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
		return getTextElement(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
	}

	public String verifyDOB(WebDriver driver, String tdText) {
		waitForElementVisible(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
		return getTextElement(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
	}

	public String verifyAddress(WebDriver driver, String tdText) {
		waitForElementVisible(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
		return getTextElement(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
	}

	public String verifyCity(WebDriver driver, String tdText) {
		waitForElementVisible(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
		return getTextElement(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
	}

	public String verifyState(WebDriver driver, String tdText) {
		waitForElementVisible(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
		return getTextElement(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
	}

	public String verifyPin(WebDriver driver, String tdText) {
		waitForElementVisible(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
		return getTextElement(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
	}

	public String verifyPhoneNumber(WebDriver driver, String tdText) {
		waitForElementVisible(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
		return getTextElement(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
	}

	public String verifyEmail(WebDriver driver, String tdText) {
		waitForElementVisible(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
		return getTextElement(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
	}

	public String getCustomerID(WebDriver driver, String tdText) {
		waitForElementVisible(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
		return getTextElement(driver,NewCustomerUI.VERIFY_INFO_REGISTER_SUCCESSFUL_BY_TEXT,tdText);
	}

	public void openGuru99Site(WebDriver driver,String pageUrl) {
		openPageUrl(driver,pageUrl);
	}
}
