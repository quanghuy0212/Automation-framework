package pageObjects.bankguru;

import org.apache.commons.codec.binary.Base32;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.HomePageUI;

public class HomePagePO extends BasePage {
	private WebDriver driver;
	EditCustomerPO editCustomerPage;

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

	public EditCustomerPO clickToEditCustomerOnSubMenu(WebDriver driver,String subMenuName) {
		waitForElementCLickable(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		return editCustomerPage=PageGenerator.getEditCustomerPage(driver);
	}

	public void openNewAccountOnSubMenu(WebDriver driver,String subMenuName) {
		waitForElementCLickable(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
	}

	public EditAccountPO openEditAccountOnSubMenu(WebDriver driver,String subMenuName) {
		waitForElementCLickable(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		return editAccountPage=PageGenerator.getEditAccountPage(driver);
	}
	
	EditAccountPO editAccountPage;

	public DepositPagePO clickToDepositOnSubMenu(WebDriver driver,String subMenuName) {
		waitForElementCLickable(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		return depositPage=PageGenerator.getDepositPage(driver);
	}

	DepositPagePO depositPage;

	public WithdrawalPO openWithdrawaOnSubMenu(WebDriver driver,String subMenuName) {
		waitForElementCLickable(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		return withdrawalPage=PageGenerator.getWithdrawalPage(driver);
	}
	
	WithdrawalPO withdrawalPage;

	public FundTransferPO openFundTransferOnSubMenu(WebDriver driver,String subMenuName) {
		waitForElementCLickable(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		return fundTransferPage=PageGenerator.getFundTransferPage(driver);
	}
	FundTransferPO fundTransferPage;

	public BalanceEnquiryPO openBalaceEnquiryOnSubMenu(WebDriver driver,String subMenuName) {
		waitForElementCLickable(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		return balanceEnquiryPage=PageGenerator.getBalanceEnquiryPage(driver);
	}
	BalanceEnquiryPO balanceEnquiryPage;

	public DeleteAccountPO openDeleteAccountOnSubMenu(WebDriver driver,String subMenuName) {
		waitForElementCLickable(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		return deleteAccountPage=PageGenerator.getDeleteAccountPage(driver);	}
	
	DeleteAccountPO deleteAccountPage;

	public DeleteCustomerPO openDeleteCustomerOnSubMenu(WebDriver driver,String subMenuName) {
		waitForElementCLickable(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_TEXT, subMenuName);
		return deleteCustomerPage=PageGenerator.getDeleteCustomerPage(driver);
	}
	DeleteCustomerPO deleteCustomerPage;
}
