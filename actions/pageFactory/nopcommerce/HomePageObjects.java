package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BaseFactory;
import commons.BasePage;
import pageUIs.user.nopcommerce.HomePageUI;

public class HomePageObjects extends BaseFactory {
	 WebDriver driver;
	
	 /*public static final String HOMEPAGE_SLIDER="//div[@id='nivo-slider']";
	public static final String REGISTER_lINK="//a[text()='Register']";
	public static final String LOGIN_LINK="//a[text()='Log in']";
	*/
	 
	 @FindBy(xpath = "//div[@id='nivo-slider']")
	 WebElement homePageSlider;
	 
	 @FindBy(xpath="//a[text()='Register']")
	 WebElement registerLink;
	 
	 @FindBy(xpath="//a[text()='Log in']")
	 WebElement loginLink;
	 
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isHomePageLoginSliderIsDisplayed () {
		waitForElementVisible(driver, homePageSlider);
		return isElementDisplayed(driver, homePageSlider);
	}

	public void clicktoRegisterLink() {
		waitForElementCLickable(driver, registerLink);
		clickToElement(driver, registerLink);
		
	}

	public void clickToLoginLink() {
		waitForElementCLickable(driver, loginLink);
		clickToElement(driver, loginLink);
		
	}

}
