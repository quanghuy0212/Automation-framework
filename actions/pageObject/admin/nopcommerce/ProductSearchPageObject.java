package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopcommerce.ProductSearchPageUI;import pageUIs.user.nopcommerce.SearchPageUI;

public class ProductSearchPageObject extends BasePage {
	WebDriver driver;
	
	public ProductSearchPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void inputToProductNameTextbox(String nameProduct) {
		waitForElementVisible(driver,ProductSearchPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX, nameProduct);
		
	}

	public void clickToSearchButton() {
		waitForElementCLickable(driver, ProductSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductSearchPageUI.SEARCH_BUTTON);
		
	}

	public ProductDetailsPageObject clickToEditButtonByProductName(String productName) {
		waitForElementCLickable(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME,productName);
		clickToElement(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		return PageGeneratorManager.getProductDetailsPage(driver);
	}

	public boolean isSuccessMessageDisplayed(String messsageName) {
		waitForElementVisible(driver, ProductSearchPageUI.SUCCESS_MESSAGE_NAME, messsageName);
		return isElementDisplayed(driver, ProductSearchPageUI.SUCCESS_MESSAGE_NAME, messsageName);
	}

	public boolean isPictureImageUploaded(String productImageName, String productName) {
		productImageName=productImageName.replace("","-").toLowerCase();
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productImageName,productName);
		return isElementDisplayed(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productImageName,productName);
	}

	public void inputProductNameTextBox(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean isPictureImageUpdate(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}
}
