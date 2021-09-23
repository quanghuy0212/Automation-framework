package pageUIs.admin.nopcommerce;

public class ProductSearchPageUI {
	public static final String PRODUCT_NAME_TEXTBOX="//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON="//button[@id='search-products']";
	public static final String EDIT_BUTTON_BY_PRODUCT_NAME="//td[text()='%s']/following-sibling::td/a";
	public static final String SUCCESS_MESSAGE_NAME="//div[contains(@class,'alert-success') and contains(string(),'%s')]";
	public static final String PRODUCT_IMAGE_BY_PRODUCT_NAME="//td[text()='%s']/preceding-sibling::td/img[contains(@src,'%s')]";
	
	
	
}
