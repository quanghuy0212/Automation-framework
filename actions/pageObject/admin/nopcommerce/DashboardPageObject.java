package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopcommerce.DashBoardPageUI;

public class DashboardPageObject extends BasePage {
	WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver=driver;
	}

	
}
