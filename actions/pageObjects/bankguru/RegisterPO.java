package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankguru.BasePageUI;
import pageUIs.bankguru.RegisterPageUI;

public class RegisterPO extends BasePage {
		private WebDriver driver;
		private LoginPO loginPage;
		
		public RegisterPO (WebDriver driver) {
			this.driver=driver;
		}

		public void inputEmailToTextBox(WebDriver driver,String textboxByName,String value) {
			waitForElementVisible(driver, BasePageUI.TEXT_BOX_BY_NAME,textboxByName);
			sendkeyToElement(driver, BasePageUI.TEXT_BOX_BY_NAME, value,textboxByName);
		}

		public void clickToSubmitButton(WebDriver driver,String buttonByName) {
			waitForElementCLickable(driver, BasePageUI.BUTTON_BY_NAME,buttonByName);
			clickToElement(driver, BasePageUI.BUTTON_BY_NAME,buttonByName);
		}

		public String getTextUserIDOnTable(WebDriver driver) {
			waitForElementVisible(driver, RegisterPageUI.USERNAME_ON_TABLE);
			return getTextElement(driver, RegisterPageUI.USERNAME_ON_TABLE);
		}

		public String getPasswordOnTable(WebDriver driver) {
			waitForElementVisible(driver, RegisterPageUI.PASSWORD_ON_TABLE);
			return getTextElement(driver, RegisterPageUI.PASSWORD_ON_TABLE);
		}

		public LoginPO backToLoginPage(WebDriver driver, String pageUrl) {
			openPageUrl(driver, pageUrl);
			return loginPage=PageGenerator.getLoginPage(driver);
			
			
		}
}
