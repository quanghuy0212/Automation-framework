package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.DepositUI;
import pageUIs.bankguru.EditAccountUI;
import pageUIs.bankguru.HomePageUI;
import pageUIs.bankguru.NewCustomerUI;
import pageUIs.bankguru.WithdrawalUI;

public class WithdrawalPO extends BasePage {
	private WebDriver driver;
	
	public WithdrawalPO(WebDriver driver) {
		this.driver=driver;
	}

	public boolean verifyWithdrawalPageIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver,WithdrawalUI.WITHDRAWAL_PAGE_DISPLAYED);
		return isElementDisplayed(driver,WithdrawalUI.WITHDRAWAL_PAGE_DISPLAYED);
	}

	public void inputToAccountIDTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME,textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME,value,textboxName);
	}

	public void inputToAmoutTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME,textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME,value,textboxName);
	}

	public void inputToDescriptionTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME,textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME,value,textboxName);		
	}

	public void clickToSubmitButton(WebDriver driver,String buttonName) {
		waitForElementCLickable(driver,BasePageUI.BUTTON_BY_NAME,buttonName);
		clickToElement(driver,BasePageUI.BUTTON_BY_NAME,buttonName);
	}

	public boolean verifyTransactionDetailsOfWithDrawalForAccountToastIsDisplayed(WebDriver driver,String accountID) {
		waitForElementVisible(driver,WithdrawalUI.TRANSACTION_DETAILS_FOR_ACCOUNT_VERIFY,accountID);
		return isElementDisplayed(driver,WithdrawalUI.TRANSACTION_DETAILS_FOR_ACCOUNT_VERIFY,accountID);
	}

	public String verifyCurrentBalance(WebDriver driver) {
		waitForElementVisible(driver, WithdrawalUI.VERIFY_CURRENT_BALANCE);
		return getTextElement(driver, WithdrawalUI.VERIFY_CURRENT_BALANCE);
	}

	public LoginPO openGuru99Site(WebDriver driver, String urlPage) {
		openPageUrl(driver,urlPage);
		return loginPage=PageGenerator.getLoginPage(driver);
	}

	LoginPO loginPage;
	
}
	