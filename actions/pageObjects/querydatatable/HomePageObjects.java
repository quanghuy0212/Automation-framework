package pageObjects.querydatatable;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.query.HomePageUI;

public class HomePageObjects extends BasePage {
	WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementCLickable(driver, HomePageUI.OPEN_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.OPEN_PAGE_BY_NUMBER, pageNumber);
		
	}

	public boolean isActivedByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
	}

	public void inputToHeaderTextboxByName(String headerName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME,headerName);
		sendkeyToElement(driver,HomePageUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		
	}

	public void clickIconAction(String countryName, String iconName) {
		waitForElementCLickable(driver, HomePageUI.BUTTON_ACCTON_ON_TABLE,countryName,iconName);
		clickToElement(driver, HomePageUI.BUTTON_ACCTON_ON_TABLE, countryName,iconName);
		
	}

	

	public void findCountryByInputToTextbox(String headerName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
	}

	
	public void inputToTextboxByRowNumber(String headerName, String rowIndex, String value) {
		int columnIndex=getElementSize(driver, HomePageUI.HEADER_NAME_INDEX, headerName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, rowIndex,String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, value,rowIndex,String.valueOf(columnIndex));
	}
	
	public void clicktoIconByRowNumber(String rowIndex,String iconAction) {
		waitForElementCLickable(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex,iconAction);
		clickToElement(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex,iconAction);
	}
}
 