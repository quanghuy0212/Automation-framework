package pageObjects.bankguru;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.LoginPageUI;

public class LoginPO extends BasePage {
	private WebDriver driver;
	private HomePagePO homePage;
	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToHereLinkToGetAccount(WebDriver driver) {
		waitForElementCLickable(driver,LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}

	public void inputUserNametoTextBox(WebDriver driver,String textboxByName,String value) {
			waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME,textboxByName);
			sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value,textboxByName);
	}

	public void inputPasswordToTextBox(WebDriver driver,String textboxByName,String value) {
		waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME, textboxByName);
		sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value,textboxByName);
	}

	public HomePagePO clickToLoginButton(WebDriver driver,String buttonByName) {
			waitForElementCLickable(driver, BasePageUI.BUTTON_BY_NAME,buttonByName);
			clickToElement(driver,  BasePageUI.BUTTON_BY_NAME,buttonByName);
			return homePage=PageGenerator.getHomePage(driver);
	}

	
}

