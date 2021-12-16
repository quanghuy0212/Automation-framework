package pageObjects.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.EditCustomerUI;

public class EditCustomerPO extends BasePage {
	private WebDriver driver;
	
	public EditCustomerPO(WebDriver driver) {
		this.driver=driver;
	}

	public boolean verifyTextEditCustomerIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, EditCustomerUI.VERIFY_EDIT_CUSTOMER_PAGE);
		return isElementDisplayed(driver, EditCustomerUI.VERIFY_EDIT_CUSTOMER_PAGE);
	}

	public void inputCustomerIDToTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME,value, textboxName);
		
	}

	public void clickToSubmitButton(WebDriver driver, String buttonName) {
		waitForElementCLickable(driver, BasePageUI.BUTTON_BY_NAME, buttonName);
		clickToElement(driver, BasePageUI.BUTTON_BY_NAME, buttonName);
	}


	public void inputToEditAddress(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXTAREA_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXTAREA_BY_NAME,value, textboxName);
	}

	public void inputToEditCity(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME,value, textboxName);
	}

	public void inputToEditState(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME,value, textboxName);
	}

	public void inputToEditPin(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME,value, textboxName);		
	}

	public void clickToSubmitButtonForEdit(WebDriver driver, String buttonName) {
		waitForElementCLickable(driver, BasePageUI.BUTTON_BY_NAME, buttonName);
		clickToElement(driver, BasePageUI.BUTTON_BY_NAME, buttonName);
	}

	public boolean verifyToastEditSuccessfully(WebDriver driver) {
		waitForElementVisible(driver, EditCustomerUI.TOAST_EDIT_SUCCESSFULLY);
		return isElementDisplayed(driver, EditCustomerUI.TOAST_EDIT_SUCCESSFULLY);
	}

	public LoginPO openGuru99Site(WebDriver driver,String urlPage) {
		openPageUrl(driver,urlPage);
		return loginPage=PageGenerator.getLoginPage(driver);
	}
	
	LoginPO loginPage;

	public String verifyErrorMessageCustomerIDIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, EditCustomerUI.ERROR_MESSAGE_CUSTOMERID_FIELD);
		return getTextElement(driver,  EditCustomerUI.ERROR_MESSAGE_CUSTOMERID_FIELD);
	}

	public String verifyErrorMessageAddressIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, EditCustomerUI.ERROR_MESSAGE_ADDRESS_FIELD);
		return getTextElement(driver,  EditCustomerUI.ERROR_MESSAGE_ADDRESS_FIELD);
		
	}

	public String verifyErrorMessageCityIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, EditCustomerUI.ERROR_MESSAGE_CITY_FIELD);
		return getTextElement(driver,  EditCustomerUI.ERROR_MESSAGE_CITY_FIELD);
	}

	public String verifyErrorMessageStateIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, EditCustomerUI.ERROR_MESSAGE_STATE_FIELD);
		return getTextElement(driver,  EditCustomerUI.ERROR_MESSAGE_STATE_FIELD);
	}

	public String verifyErrorMessagePinIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, EditCustomerUI.ERROR_MESSAGE_PIN_FIELD);
		return getTextElement(driver,  EditCustomerUI.ERROR_MESSAGE_PIN_FIELD);
	}

	public String verifyErrorMessageTelephoneIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, EditCustomerUI.ERROR_MESSAGE_TELEPHONE_FIELD);
		return getTextElement(driver,  EditCustomerUI.ERROR_MESSAGE_TELEPHONE_FIELD);
	}

	public String verifyErrorMessageEmailIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, EditCustomerUI.ERROR_MESSAGE_EMAIL_FIELD);
		return getTextElement(driver,  EditCustomerUI.ERROR_MESSAGE_EMAIL_FIELD);
	}

	public void deleteValueInCustomerTextbox(WebDriver driver,String textboxName) {
		waitForElementVisible(driver,BasePageUI.TEXT_BOX_BY_NAME,textboxName);
		pressKeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, Keys.DELETE, textboxName);
	}
}
