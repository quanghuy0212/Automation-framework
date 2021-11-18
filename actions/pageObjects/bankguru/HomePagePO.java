package pageObjects.bankguru;

import org.apache.commons.codec.binary.Base32;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.HomePageUI;

public class HomePagePO extends BasePage {
	private WebDriver driver;

	public HomePagePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean ToastManagerPageisDisplayed(WebDriver driver) {
		waitForAllElementVisible(driver, HomePageUI.TOAST_WELCOME_TO_MANAGER_PAGE);
		return isElementDisplayed(driver, HomePageUI.TOAST_WELCOME_TO_MANAGER_PAGE);
	}

	public void clickToNewCustomerOnSubMenu(WebDriver driver,String subMenuName) {
		waitForElementCLickable(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
	}

	public void inputToCustomerNameTextbox(WebDriver driver, String textboxName,String value) {
		 waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME,textboxName);
		 sendkeyToElement(driver,BasePageUI.TEXT_BOX_BY_NAME,value,textboxName);
	}

	public void clickToMaleRadioButton(WebDriver driver) {
		waitForElementCLickable(driver, HomePageUI.MALE_RADIO_BUTTON);
		clickToElement(driver, HomePageUI.MALE_RADIO_BUTTON);
	}

	public void inputToDOBTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver,BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		//removeAttributeInDOM(driver, BasePageUI.TEXT_BOX_BY_NAME, attributeName,textboxName);
		sendkeyToElement(driver,BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
	}

	public void inputToAddressField(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
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
}
