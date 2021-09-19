package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyAccountPageObjects extends BasePage{
	private WebDriver driver;
	
	public MyAccountPageObjects(WebDriver driver) {
		this.driver=driver;
	}
}
