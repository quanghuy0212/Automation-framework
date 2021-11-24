package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.NewAccountUI;

public class NewAccountPO extends BasePage {
	WebDriver driver;

	public NewAccountPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean AddNewAccountPageIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver,NewAccountUI.ADD_NEW_COUNT_PAGE_TEXT);
		return isElementDisplayed(driver,NewAccountUI.ADD_NEW_COUNT_PAGE_TEXT);
	}

	public void inputCustomerIDToTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver,BasePageUI.TEXT_BOX_BY_NAME,textboxName);
		sendkeyToElement(driver,BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
	}

	public void selectAccountTypeInDropdown(WebDriver driver,String dropdownName,String textValue) {
		waitForElementVisible(driver, BasePageUI.DEFAULT_DROPDOWN_BY_NAME, dropdownName);
		selectDropdownByText(driver, BasePageUI.DEFAULT_DROPDOWN_BY_NAME, textValue, dropdownName);
	}

	public void inputToInitialDepositTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver,BasePageUI.TEXT_BOX_BY_NAME,textboxName);
		sendkeyToElement(driver,BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
	}

	public void clickToSubmitButton(WebDriver driver,String buttonName) {
		waitForElementCLickable(driver,BasePageUI.BUTTON_BY_NAME,buttonName);
		clickToElement(driver,BasePageUI.BUTTON_BY_NAME,buttonName);
	}

	public boolean verifyAddNewAccountSuccessfully(WebDriver driver) {
		waitForElementVisible(driver, NewAccountUI.ADD_NEW_ACCOUNT_SUCCESSFULLT_TOAST);
		return isElementDisplayed(driver, NewAccountUI.ADD_NEW_ACCOUNT_SUCCESSFULLT_TOAST);
	}

	public String getAccountIDFromTable(WebDriver driver) {
		waitForElementVisible(driver,NewAccountUI.ACCOUNT_ID_FROM_TABLE);
		return getTextElement(driver,NewAccountUI.ACCOUNT_ID_FROM_TABLE);
	}

	public LoginPO openGuru99Site(WebDriver driver,String urlPage) {
		openPageUrl(driver, urlPage);
		return loginPage=PageGenerator.getLoginPage(driver);
	}
	
	LoginPO loginPage;
}
