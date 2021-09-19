package com.admin.nopcommerce;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.admin.nopcommerce.DashboardPageObject;
import pageObject.admin.nopcommerce.LoginPageObject;
import pageObject.admin.nopcommerce.PageGeneratorManager;
import pageObject.admin.nopcommerce.ProductDetailsPageObject;
import pageObject.admin.nopcommerce.ProductSearchPageObject;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_UploadFiles extends BaseTest {
	WebDriver driver;
	String emailaddress,password;
	String projectLocation=System.getProperty("user.dir");
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		
		driver=getBrowserDriver(browserName,appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		loginPage=PageGeneratorManager.getLoginPage(driver);
		
		loginPage.inputToEmailTextBox("");
		loginPage.inputToPasswordTextBox("");
		dashboardPage=loginPage.clickToLoginButton("");
		searchProductPage=dashboardPage.openSubMenuPageByName("Catalog","Products");
		searchProductPage.inputToProductNameTextbox("Apple MacBook Pro 13-inch");
		searchProductPage.clickToSearchButton();
		productDetailsPage= searchProductPage.clickToEditButtonByProductName("");
		
		
	}

	
	public void Login_01_Upload_File() {
		productDetailsPage.clickToExpandPanelByName("Pictures");
		productDetailsPage.uploadPictureByFileName("");
		productDetailsPage.isPictureUploadedSuccessByFileName();
		productDetailsPage.enterToAltTextbox("23");
		productDetailsPage.enterToTitleTextbox("34");
		productDetailsPage.enterToDisplayOrderTextbox("");
		productDetailsPage.clickToAddProductPictureButton();
		Assert.assertTrue(productDetailsPage.isPictureImageDisplayed("","","",""));
		searchProductPage=productDetailsPage.clickToSaveButton();
		Assert.assertTrue(searchProductPage.isSuccessMessageDisplayed("The product has been updated successfully."));
		searchProductPage.inputToProductNameTextbox("Apple MacBook Pro 13-inch");
		searchProductPage.clickToSearchButton();
		Assert.assertTrue(searchProductPage.isPictureImageUploaded("macbook air","Apple MacBook Pro 13-inch"));
		productDetailsPage=searchProductPage.clickToEditButtonByProductName("Apple MacBook Pro 13-inch");
		productDetailsPage.clickToExpandPanelByName("Pictures");	
		productDetailsPage.clickToDeleteButtonAtPictureName("macbook air"); // Accept Alert
		Assert.assertTrue(productDetailsPage.isMessageDisplayedInTable("No data available in table"));
		searchProductPage=productDetailsPage.clickToSaveButton();
		searchProductPage.inputProductNameTextBox("");
		searchProductPage.clickToSearchButton();
		Assert.assertTrue(searchProductPage.isPictureImageUpdate("default-image","Apple MacBook Pro 13-inch"));
	}
	
	
	
	@Test
	public void TC_04() {
		
			
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	LoginPageObject loginPage;
	ProductDetailsPageObject productDetailsPage;
	ProductSearchPageObject searchProductPage;
	DashboardPageObject dashboardPage;
}
	
	
