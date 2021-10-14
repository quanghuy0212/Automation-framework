package com.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.Saucelab.InventoryPO;
import pageObject.Saucelab.LoginPO;
import pageObject.Saucelab.PageGenerator;



public class Sort extends BaseTest{
	WebDriver driver;
	LoginPO loginPage;
	InventoryPO inventoryPage;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver=getBrowserDriver(browserName, appUrl);
		loginPage=PageGenerator.getLoginPage(driver);
		loginPage.enterToUserNameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		inventoryPage=loginPage.clickToLoginButton();
		
	}

	@Test
	public void Sort_01_Name() {
		  inventoryPage.selectItemInSortDropdown("Name (A to Z)");
		  verifyTrue(inventoryPage.isProductNameSortAscending());
		  
		  inventoryPage.selectItemInSortDropdown("Name (Z to A)");
		  verifyTrue(inventoryPage.isProductNameSortDescending());
		 	
	}
	
	@Test
	public void Sort_02_Price() {
		inventoryPage.selectItemInSortDropdown("Price (low to high)");
		verifyTrue(inventoryPage.isProductPriceSortDecsending());
	}
	
	public WebDriver getWebDriver() {
		return this.driver;
	}

	@Parameters({"browser"})
	@AfterClass (alwaysRun=false)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition: Close browser" + browserName + "");
		closeBrowserAndDriver();
	}
	
	
	
	
	
}
