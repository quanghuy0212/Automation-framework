package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.DepositUI;
import pageUIs.bankguru.EditAccountUI;
import pageUIs.bankguru.HomePageUI;
import pageUIs.bankguru.NewCustomerUI;

public class DepositPagePO extends BasePage {
	private WebDriver driver;
	
	public DepositPagePO(WebDriver driver) {
		this.driver=driver;
	}

	public boolean verifyDepositPageIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, DepositUI.DEPOSIT_PAGE_DISPLAYED);
		return isElementDisplayed(driver, DepositUI.DEPOSIT_PAGE_DISPLAYED);
	}

	public void inputAccountIDToTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME,value, textboxName);
	}

	public void inputAmountToTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME,value, textboxName);
		
	}

	public void inputDescriptionToTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME,value, textboxName);		
	}

	public boolean verifyTransactionDetailsForAccount(WebDriver driver,String accountID) {
		waitForElementVisible(driver, DepositUI.TRANSACTION_DETAILS_FOR_ACCOUNT_VERIFY, accountID);
		return isElementDisplayed(driver, DepositUI.TRANSACTION_DETAILS_FOR_ACCOUNT_VERIFY, accountID);
	}

	public String verifyCurrentAmount(WebDriver driver) {
		waitForElementVisible(driver,DepositUI.CURRENT_BALANCE);
		return getTextElement(driver,DepositUI.CURRENT_BALANCE);
		
	}

	public void clickToSubmitButton(WebDriver driver,String buttonName) {
		waitForElementCLickable(driver, BasePageUI.BUTTON_BY_NAME, buttonName);
		clickToElement(driver, BasePageUI.BUTTON_BY_NAME, buttonName);
	}

	public LoginPO openGuru99Site(WebDriver driver,String urlPage) {
		openPageUrl(driver, urlPage);
		return loginPage=PageGenerator.getLoginPage(driver);
	}

	LoginPO loginPage;
}
	