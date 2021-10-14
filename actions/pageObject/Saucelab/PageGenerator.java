package pageObject.Saucelab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGenerator extends BasePage {
	WebDriver driver;

	public static LoginPO getLoginPage(WebDriver driver) {

		return new LoginPO(driver);
	}
	
	public static InventoryPO getInventoryPO(WebDriver driver) {
		
		return new InventoryPO(driver);
	}
	

}
