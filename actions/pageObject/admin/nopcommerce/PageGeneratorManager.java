package pageObject.admin.nopcommerce;

import org.openqa.selenium.WebDriver;

import pageObjects.nopcommerce.HomePageObjects;

public class PageGeneratorManager {
	private static LoginPageObject loginPage;
	private static DashboardPageObject dashBoardPage;
	private static ProductDetailsPageObject productdetailsPage;
	private static ProductSearchPageObject searchProductPage;
	
	private PageGeneratorManager() {
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if (loginPage==null) {
			loginPage= new LoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static DashboardPageObject getDashBoardPage(WebDriver driver) {
		if (dashBoardPage==null) {
			dashBoardPage= new DashboardPageObject(driver);
		}
		return dashBoardPage;
	}
	
	public static ProductDetailsPageObject getProductDetailsPage(WebDriver driver) {
		if (productdetailsPage==null) {
			productdetailsPage= new ProductDetailsPageObject(driver);
		}
		return productdetailsPage;
	}
	
	public static ProductSearchPageObject getSearchProductPage(WebDriver driver) {
		if (searchProductPage==null) {
			searchProductPage= new ProductSearchPageObject(driver);
		}
		return searchProductPage;
	}
}
