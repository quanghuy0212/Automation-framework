package pageUI.hrm;

public class BasePageUI {
	public static final String MENU_BY_PAGE_NAME="//div[@id='mainMenu']//a[string()='%s']";
	public static final String BUTTON_BY_ID="//input[@id='%s']";
	public static final String TEXTBOX_BY_ID="//input[@id='%s']";
	public static final String DROPDOWN_BY_ID="//Select[@id='%s']";
	public static final String CHECKBOX_BY_LABLE="//lable[text()='%s']/following-sibling::input";
	public static final String RADIO_BY_LABLE="//lable[text()='%s']/preceding-sibling::input";
	public static final String TABLE_HEADER_BY_ID_ANDNAME="//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX="//table[@id='%s']/tbody/tr[%s]/td[%s]";
}
