package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopcommerce.HomePageUI;

public class HomePageObjects extends BasePage {
	private WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isHomePageLoginSliderIsDisplayed () {
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOMEPAGE_SLIDER);
	}

	public RegisterPageObjects clicktoRegisterLink() {
		waitForElementCLickable(driver, HomePageUI.REGISTER_lINK);
		clickToElement(driver, HomePageUI.REGISTER_lINK);
		return new RegisterPageObjects(driver);
		
	}

	public LoginPageObjects clickToLoginLink() {
		waitForElementCLickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return new LoginPageObjects(driver);
		
	}

	

}
