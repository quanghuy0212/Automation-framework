package pageUIs.admin.nopcommerce;

public class AdminBasePageUI {
	public static final String MENU_PAGE_BY_NAME="//ul[@role='menu']/li/a/p[contains(text(),'%s')]";
	public static final String SUB_MENU_BY_NAME="//li[contains(@class,'menu-open')]//i[contains(@class,'dot-circle')]/following-sibling::p[contains(text(),' %s')]";
	public static final String UPLOAD_FILE_BY_CARD_NAME="//div[@id='product-%s']//input[@type='file']";
}
