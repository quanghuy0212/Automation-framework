package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
private static HomePageObjects homePage;
private static LoginPageObjects loginPage;
private static RegisterPageObjects registerPage;
private static SearchPageObjects serachPage;
private static OrdersPageObjects ordersPage;
private static MyAccountPageObjects myAccountPage;
	
	private PageGeneratorManager() {
		
	}

	public static HomePageObjects getHomePage(WebDriver driver) {
		if (homePage==null) {
			homePage= new HomePageObjects(driver);
		}
		return homePage;
	}
	
	public static LoginPageObjects getLoginPage(WebDriver driver) {
		if (loginPage==null) {
			loginPage= new LoginPageObjects(driver);
		}
		return loginPage;
	}
	
	public static RegisterPageObjects getRegisterPage(WebDriver driver) {
		if (registerPage==null) {
			registerPage= new RegisterPageObjects(driver);
		}
		return registerPage;
	}
	
	public static SearchPageObjects getSearchPage(WebDriver driver) {
		if (serachPage==null) {
			serachPage= new SearchPageObjects(driver);
		}
		return serachPage;
	}
	
	
	public static OrdersPageObjects getordersPage(WebDriver driver) {
		if (ordersPage==null) {
			ordersPage= new OrdersPageObjects(driver);
		}
		return ordersPage;
	}
	
	
	public static MyAccountPageObjects getMyAccountPage(WebDriver driver) {
		if (myAccountPage==null) {
			myAccountPage= new MyAccountPageObjects(driver);
		}
		return myAccountPage;
	}
	
	
}
