package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BalanceEnquiryUI;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.DepositUI;
import pageUIs.bankguru.EditAccountUI;
import pageUIs.bankguru.FundTransferUI;
import pageUIs.bankguru.HomePageUI;
import pageUIs.bankguru.NewCustomerUI;
import pageUIs.bankguru.WithdrawalUI;

public class BalanceEnquiryPO extends BasePage {
	private WebDriver driver;
	
	public BalanceEnquiryPO(WebDriver driver) {
		this.driver=driver;
	}

	public boolean verifyFundTransferPageIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, FundTransferUI.FUND_TRANSFER_PAGE_DISPLAYED);
		return isElementDisplayed(driver, FundTransferUI.FUND_TRANSFER_PAGE_DISPLAYED);
	}

	public void inputToPayersAccountIDTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
	}

	public void inputToPayeesAccountIDTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);		
	}

	public void inputToAmountTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);		
	}

	public void inputToDescriptionTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);		
	}

	public void clickToSubmitButton(WebDriver driver,String buttonName) {
		waitForElementCLickable(driver, BasePageUI.BUTTON_BY_NAME, buttonName);
		clickToElement(driver, BasePageUI.BUTTON_BY_NAME, buttonName);
	}

	public String verifyPayeesAccountID(WebDriver driver, String tdText) {
		waitForElementVisible(driver, FundTransferUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);
		return getTextElement(driver, FundTransferUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);
		
	}

	public String verifyAmountTransfer(WebDriver driver, String tdText) {
		waitForElementVisible(driver, FundTransferUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);
		return getTextElement(driver, FundTransferUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);	}

	public String verifyDescriptionTransfer(WebDriver driver, String tdText) {
		waitForElementVisible(driver, FundTransferUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);
		return getTextElement(driver, FundTransferUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);	}

	public String verifyAccountID(WebDriver driver, String tdText) {
		waitForElementVisible(driver, FundTransferUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);
		return getTextElement(driver, FundTransferUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);	}

	public boolean verifyBalanceEnquiryPageIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, BalanceEnquiryUI.BALANCE_ENQUIRY_PAGE_DISPLAYED);
		return isElementDisplayed(driver, BalanceEnquiryUI.BALANCE_ENQUIRY_PAGE_DISPLAYED);
	}

	public void inputAccountIDToTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);
	}

	public String verifyBalanceDetailsForAccountIsDisplayed(WebDriver driver,String tdText) {
		waitForElementVisible(driver, BasePageUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);
		return getTextElement(driver,  BasePageUI.VERIFY_VALUE_ON_TABLE_BY_TEXT, tdText);
	}

	public LoginPO openGuru99Site(WebDriver driver, String urlPage) {
		openPageUrl(driver, urlPage);
		return loginPage=PageGenerator.getLoginPage(driver);
	}
	
	LoginPO loginPage;



	
}
	