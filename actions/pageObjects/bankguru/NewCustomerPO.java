package pageObjects.bankguru;

import org.openqa.selenium.Keys;
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

	public String getCustomerIDForOtherUser(WebDriver driver,String tdText) {
		waitForElementVisible(driver, BasePageUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);
		return getTextElement(driver, BasePageUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);
	}

	public void openNewAccountOnSubMenu(WebDriver driver, String subMenuText) {
		waitForElementCLickable(driver,HomePageUI.SUB_MENU_BY_TEXT, subMenuText);
		clickToElement(driver,HomePageUI.SUB_MENU_BY_TEXT, subMenuText);
		
	}

	public void inputToNameTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver,BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
		pressKeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, Keys.TAB, textboxName);
	}

	public String verifyErrorMessageIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver,NewCustomerUI.ERROR_MESSAGE_NAME_FIELD);
		return getTextElement(driver, NewCustomerUI.ERROR_MESSAGE_NAME_FIELD);
	}

	public String verifyErrorMessageAddressIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver,NewCustomerUI.ERROR_MESSAGE_ADDRESS_FIELD);
		return getTextElement(driver, NewCustomerUI.ERROR_MESSAGE_ADDRESS_FIELD);
	}

	public String verifyErrorMessageCityIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver,NewCustomerUI.ERROR_MESSAGE_CITY_FIELD);
		return getTextElement(driver, NewCustomerUI.ERROR_MESSAGE_CITY_FIELD);	}

	public String verifyErrorMessageStateIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver,NewCustomerUI.ERROR_MESSAGE_CITY_FIELD);
		return getTextElement(driver, NewCustomerUI.ERROR_MESSAGE_CITY_FIELD);	
	}

	public String verifyErrorMessagePinIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver,NewCustomerUI.ERROR_MESSAGE_PIN_FIELD);
		return getTextElement(driver, NewCustomerUI.ERROR_MESSAGE_PIN_FIELD);
	}

	public void checkInputToAddressField(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXTAREA_BY_NAME, textboxName);
		sendkeyToElement(driver,BasePageUI.TEXTAREA_BY_NAME, value, textboxName);
		pressKeyToElement(driver, BasePageUI.TEXTAREA_BY_NAME, Keys.TAB, textboxName);		
	}

	public void checkInputToCityTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver,BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
		pressKeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, Keys.TAB, textboxName);
	}

	public void checkInputToStateTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver,BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
		pressKeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, Keys.TAB, textboxName);		
	}

	public void checkInputToPINTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver,BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
		pressKeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, Keys.TAB, textboxName);		
	}

	public void checkInputToPhoneNumBerTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver,BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
		pressKeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, Keys.TAB, textboxName);			
	}

	public String verifyErrorMessageTelephoneIsDisplayed(WebDriver driver2) {
		waitForElementVisible(driver,NewCustomerUI.ERROR_MESSAGE_TELEPHONE_FIELD);
		return getTextElement(driver, NewCustomerUI.ERROR_MESSAGE_TELEPHONE_FIELD);
	}

	public void checkInputToEmailTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver,BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
		pressKeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, Keys.TAB, textboxName);		
	}

	public String verifyErrorMessageEmailIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver,NewCustomerUI.ERROR_EMAIL_EMAIL_FIELD);
		return getTextElement(driver, NewCustomerUI.ERROR_EMAIL_EMAIL_FIELD);
	}

}
