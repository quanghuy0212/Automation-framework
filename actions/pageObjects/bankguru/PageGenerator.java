package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGenerator extends BasePage {
	WebDriver driver;
	private static LoginPO loginPage;

	public static LoginPO getLoginPage(WebDriver driver) {

		return new LoginPO(driver);
	}
	
	public static HomePagePO getHomePage(WebDriver driver) {
		
		return new HomePagePO(driver);
	}
	
	public static RegisterPO  getRegisterPage(WebDriver driver) {
		
		return new RegisterPO(driver);
	}
	
	
	
	
}
