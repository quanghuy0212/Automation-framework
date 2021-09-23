package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopcommerce.ProductDetailsPageUI;

public class ProductDetailsPageObject extends BasePage {
	WebDriver driver;
	
	public ProductDetailsPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToExpandPanelByName(String panelName) {
		waitForElementVisible(driver, ProductDetailsPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		String toogleIconStatus=getAttributeValue(driver, ProductDetailsPageUI.TOOGLE_ICON_BY_CARD_NAME, "class", panelName);
		if(toogleIconStatus.contains("fa-plus")) {
			waitForElementCLickable(driver, ProductDetailsPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
			clickToElement(driver, ProductDetailsPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		}
		
	}

	

	public boolean isPictureUploadedSuccessByFileName(String fileName) {
		fileName=fileName.split("\\.")[0];
		waitForElementVisible(driver, ProductDetailsPageUI.PICTURE_TABLE_BY_NAME_ORDER_ALT_TITLE);
		return isElementDisplayed(driver, ProductDetailsPageUI.PICTURE_TABLE_BY_NAME_ORDER_ALT_TITLE, fileName);
		
	}

	public void enterToAltTextbox(String productNameAlt) {
		waitForElementVisible(driver, ProductDetailsPageUI.ALT_TEXTBOX_AD_NEW);
		sendkeyToElement(driver, ProductDetailsPageUI.ALT_TEXTBOX_AD_NEW, productNameAlt);
		
	}

	public void enterToTitleTextbox(String pruductNameTitle) {
		waitForElementVisible(driver, ProductDetailsPageUI.TITLE_TEXTBOX_AD_NEW);
		sendkeyToElement(driver, ProductDetailsPageUI.TITLE_TEXTBOX_AD_NEW, pruductNameTitle);
		
	}

	public void enterToDisplayOrderTextbox(String productNameDisplayOrder) {
		waitForElementVisible(driver, ProductDetailsPageUI.DISPLAY_ORDER_AD_NEW);
		sendkeyToElement(driver, ProductDetailsPageUI.DISPLAY_ORDER_AD_NEW, productNameDisplayOrder);
		
	}

	public void clickToAddProductPictureButton() {
		// TODO Auto-generated method stub
		
	}

	public boolean isPictureImageDisplayed(String imageName, String displayOrder, String imageAlt, String imageTitle) {
		imageName=imageName.replace("","-").toLowerCase(); 
		waitForElementVisible(driver, ProductDetailsPageUI.DISPLAY_ORDER_AD_NEW,imageName,displayOrder,imageAlt,imageTitle);
		return isElementDisplayed(driver, ProductDetailsPageUI.DISPLAY_ORDER_AD_NEW,imageName,displayOrder,imageAlt,imageTitle);
	}

	public ProductSearchPageObject clickToSaveButton() {
		waitForElementCLickable(driver, ProductDetailsPageUI.BUTTON_SAVE);
		clickToElement(driver, ProductDetailsPageUI.BUTTON_SAVE);
		return PageGeneratorManager.getSearchProductPage(driver);
	}

	public void clickToDeleteButtonAtPictureName(String productTitle) {
		waitForElementCLickable(driver, ProductDetailsPageUI.DELETE_BUTTON_BY_TITLE,productTitle);
		clickToElement(driver, ProductDetailsPageUI.DELETE_BUTTON_BY_TITLE,productTitle);
		acceptAlert(driver);
	}

	
}
