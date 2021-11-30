package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.DepositUI;
import pageUIs.bankguru.EditAccountUI;
import pageUIs.bankguru.HomePageUI;
import pageUIs.bankguru.NewCustomerUI;

public class DeleteAccountPO extends BasePage {
	private WebDriver driver;
	
	public DeleteAccountPO(WebDriver driver) {
		this.driver=driver;
	}

	
	LoginPO loginPage;

	public boolean verifyDeleteAccountPageIsDisplayed(WebDriver driver2) {
		// TODO Auto-generated method stub
		return false;
	}

	public void inputCustomerIDToTextbox(WebDriver driver2, String string, String accountID) {
		// TODO Auto-generated method stub
		
	}

	public void clickToSubmitButton(WebDriver driver2, String string) {
		// TODO Auto-generated method stub
		
	}

	public Object verifyMessageDeleteSuccessfully(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void openEditAccountOnSubMenu(WebDriver driver2, String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyEditAccountPageIsDisplayed(WebDriver driver2) {
		// TODO Auto-generated method stub
		return false;
	}

	public void inputAccountIDToTextbox(WebDriver driver2, String string, String accountID) {
		// TODO Auto-generated method stub
		
	}

	public void clickToSubmitButtonOnEditCustomerPage(WebDriver driver2, String string) {
		// TODO Auto-generated method stub
		
	}

	public Object verifyMessageDisplayed(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}
}
	