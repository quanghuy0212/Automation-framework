package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

public class ProductDetailsPageObject {
	WebDriver driver;
	
	public ProductDetailsPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToExpandPanelByName(String string) {
		// Get tag i attribute
		// not contains (fa-plus)
		// if contains: click i
		
	}

	public void uploadPictureByFileName(String string) {
		// TODO Auto-generated method stub
		
	}

	public void isPictureUploadedSuccessByFileName() {
		// TODO Auto-generated method stub
		
	}

	public void enterToAltTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void enterToTitleTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void enterToDisplayOrderTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void clickToAddProductPictureButton() {
		// TODO Auto-generated method stub
		
	}

	public boolean isPictureImageDisplayed(String string, String string2, String string3, String string4) {
		// TODO Auto-generated method stub
		return false;
	}

	public ProductSearchPageObject clickToSaveButton() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickToDeleteButtonAtPictureName(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean isMessageDisplayedInTable(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}
