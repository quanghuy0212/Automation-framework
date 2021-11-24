package pageObjects.bankguru;

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
}
