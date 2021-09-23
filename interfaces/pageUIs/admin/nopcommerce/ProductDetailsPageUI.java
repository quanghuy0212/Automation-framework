package pageUIs.admin.nopcommerce;

public class ProductDetailsPageUI {
	public static final String TOOGLE_ICON_BY_CARD_NAME="//div[@class='card-title' and contains(string(),'%s')]/following-sibling::div//i";
	public static final String ALT_TEXTBOX_AD_NEW="//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_TEXTBOX_AD_NEW="//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String DISPLAY_ORDER_AD_NEW="//input[@id='AddPictureModel_DisplayOrder']";
	public static final String PRODUCT_PICTURE_BLOCK_BY_FILE_NAME="//div[@class='upload-picture-block']//img[contains(@src,'%s')]";
	public static final String BUTT0N_ADD_NEW_PRODUCT_PICTURE="//button[@id='addProductPicture']";
	public static final String PICTURE_TABLE_BY_NAME_ORDER_ALT_TITLE="//a[contains(@href,'%s')]/parent::td/following-sibling::td[@data-columnname='DisplayOrder' and text()='%s']/following-sibling::td[@data-columnname='OverrideAltAttribute' and text()='%s']/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text()='%s']";
	public static final String BUTTON_SAVE="//button[@name='save']";
	public static final String DELETE_BUTTON_BY_TITLE="//td[ text()='%s']/following-sibling::td/a[contains(string(),'%s')]";
	
	



}
