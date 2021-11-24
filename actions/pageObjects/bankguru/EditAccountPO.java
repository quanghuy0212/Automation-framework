package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.EditAccountUI;
import pageUIs.bankguru.HomePageUI;
import pageUIs.bankguru.NewCustomerUI;

public class EditAccountPO extends BasePage {
	private WebDriver driver;
	
	public EditAccountPO(WebDriver driver) {
		this.driver=driver;
	}

	public boolean verifyEditAccountPageIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, EditAccountUI.EDIT_ACCOUNT_PAGE_DISPLAYED_TEXT);
		return isElementDisplayed(driver, EditAccountUI.EDIT_ACCOUNT_PAGE_DISPLAYED_TEXT);
	}

	public void inputToAccountIDTextbox(WebDriver driver, String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME,textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value,textboxName);
	}

	public void clickToSubmitButton(WebDriver driver, String buttonName) {
		waitForElementCLickable(driver, BasePageUI.BUTTON_BY_NAME,buttonName);
		clickToElement(driver, BasePageUI.BUTTON_BY_NAME,buttonName);
	}

	public void changeTypeOfAccountToCurrent(WebDriver driver,String dropdownName,String textValue) {
		waitForElementCLickable(driver,BasePageUI.DEFAULT_DROPDOWN_BY_NAME,dropdownName);
		selectDropdownByText(driver, BasePageUI.DEFAULT_DROPDOWN_BY_NAME,textValue,dropdownName);
	}

	public boolean verifyEditAccountSuccessfully(WebDriver driver) {
		waitForElementVisible(driver, EditAccountUI.EDIT_ACCOUNT_SUCCESSFULLT_TOAST);
		return isElementDisplayed(driver, EditAccountUI.EDIT_ACCOUNT_SUCCESSFULLT_TOAST);
	}

	public LoginPO openGuru99Site(WebDriver driver,String urlPage) {
		openPageUrl(driver, urlPage);
		return loginPage=PageGenerator.getLoginPage(driver);
	}
	
	LoginPO loginPage;
	
}
