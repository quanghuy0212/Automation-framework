package pageObject.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.hrm.PersonalDetailsPageUI;

public class PersonalDetailsPO extends BasePage{
	WebDriver driver;

	public PersonalDetailsPO(WebDriver driver) {
		this.driver = driver;
	}

	public EmployeeListPO openEmployeeListPage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickToChangePhotoImage() {
		waitForElementCLickable(driver, PersonalDetailsPageUI.AVATAR_IMAGE);
		clickToElement(driver, PersonalDetailsPageUI.AVATAR_IMAGE);
	}

	public boolean isUploadAvatarSuccessMessageDisplayed() {
		waitForElementVisible(driver, PersonalDetailsPageUI.UPLOAD_AVATAR_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, PersonalDetailsPageUI.UPLOAD_AVATAR_SUCCESS_MESSAGE);
	}

	public boolean isNewAvatarImageDisplayed() {
		waitForElementVisible(driver, PersonalDetailsPageUI.AVATAR_IMAGE);
		int imageWidth= Integer.parseInt(getAttributeValue(driver, PersonalDetailsPageUI.AVATAR_IMAGE, "width"));
		int imageHeigh=Integer.parseInt(getAttributeValue(driver, PersonalDetailsPageUI.AVATAR_IMAGE, "heigh"));
		return (imageWidth!=200 || imageHeigh !=200) ;
	}
	
}
