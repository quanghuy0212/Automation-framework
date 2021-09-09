package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.HomePageUI;

public class HomePageObjects extends BasePage {
	private WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isHomePageLoginSliderIsDisplayed () {
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOMEPAGE_SLIDER);
	}

	public void clicktoRegisterLink() {
		waitForElementCLickable(driver, HomePageUI.REGISTER_lINK);
		clickToElement(driver, HomePageUI.REGISTER_lINK);
		
	}

	public void clickToLoginLink() {
		waitForElementCLickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		
	}

}
