package pageObjects.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.DeleteCustomerUI;
import pageUIs.bankguru.DepositUI;
import pageUIs.bankguru.EditAccountUI;
import pageUIs.bankguru.HomePageUI;
import pageUIs.bankguru.NewCustomerUI;

public class DeleteCustomerPO extends BasePage {
	private WebDriver driver;
	
	public DeleteCustomerPO(WebDriver driver) {
		this.driver=driver;
	}

	
	LoginPO loginPage;

	public boolean verifyDeleteCustomerPageIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver, DeleteCustomerUI.DELETE_CUSTOMER_PAGE_DISPLAYED);
		return isElementDisplayed(driver, DeleteCustomerUI.DELETE_CUSTOMER_PAGE_DISPLAYED);
	}

	public void inputToCustomerIDTextbox(WebDriver driver,String textboxName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value, textboxName);	
	}

	public void pressTabFromKeyboard(WebDriver driver,String textboxName) {
		waitForElementVisible(driver,BasePageUI.TEXT_BOX_BY_NAME, textboxName);
		pressKeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, Keys.TAB, textboxName);
	}

	public String verifyCustomerIDErrorMessageIsDisplayed(WebDriver driver) {
		waitForElementVisible(driver,DeleteCustomerUI.ERROR_MESSAGE_CUSTOMERID);
		return getTextElement(driver, DeleteCustomerUI.ERROR_MESSAGE_CUSTOMERID);
	}
}
	