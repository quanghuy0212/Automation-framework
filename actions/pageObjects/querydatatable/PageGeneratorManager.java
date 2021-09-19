package pageObjects.querydatatable;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	
	private static HomePageObjects homePage;
	
    private PageGeneratorManager() {
		
	}

	public static HomePageObjects getHomePage(WebDriver driver) {
		if (homePage==null) {
			homePage= new HomePageObjects(driver);
		}
		return homePage;
	}
}
