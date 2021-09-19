package pageUIs.query;

public class HomePageUI {
	public static final String OPEN_PAGE_BY_NUMBER="//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGING_BY_NUMBER_ACTIVE="//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_NAME="//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String BUTTON_ACCTON_ON_TABLE="//td[@data-key='country' and text()='%s']/preceding-sibling::td/button[@class='qgrd-%s-row-btn']";
	public static final String HEADER_NAME_INDEX="//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_ROW_INDEX="//tr[%s]/td[%s]/input";
	public static final String ACTION_BUTTON_BY_ROW_INDEX="//tr[@id][%s]//button[@title='%s']";
}
