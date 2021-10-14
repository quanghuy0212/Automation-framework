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
	String productAvatarAlt="Alt";
	String productAvatarTitle="Title";
	String productAvatarDisplayOrder="1";
	String productAvatarImg="macbook air.jpg";
	String productName="Apple MacBook Pro 13-inch";
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: " + driver);
		driver=getBrowserDriver(browserName,appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		loginPage=PageGeneratorManager.getLoginPage(driver);
		log.info("Input Email To Textbox");
		loginPage.inputToEmailTextBox("admin@yourstore.com");
		log.info("Input Password To Textbox");
		loginPage.inputToPasswordTextBox("admin");
		log.info("Click loggin button");
		dashboardPage=loginPage.clickToLoginButton();
		dashboardPage.openSubMenuPageByName(driver,"Catalog","Products");
		searchProductPage=PageGeneratorManager.getSearchProductPage(driver);
		searchProductPage.inputToProductNameTextbox(productName);
		searchProductPage.clickToSearchButton();
		productDetailsPage= searchProductPage.clickToEditButtonByProductName(productName);
		
		
	}

	@Test
	public void Login_01_Upload_File() {
		log.info("TC_01: Upload Files");
		productDetailsPage.clickToExpandPanelByName("Pictures");
		productDetailsPage.uploadFileAtCardName(driver, "pictures", productAvatarImg);
		Assert.assertTrue(productDetailsPage.isPictureUploadedSuccessByFileName(productName));
		productDetailsPage.enterToAltTextbox(productAvatarAlt);
		productDetailsPage.enterToTitleTextbox(productAvatarTitle);
		productDetailsPage.enterToDisplayOrderTextbox(productAvatarTitle);
		productDetailsPage.clickToAddProductPictureButton();
		Assert.assertTrue(productDetailsPage.isPictureImageDisplayed(productName,productAvatarDisplayOrder,productAvatarAlt,productAvatarTitle));
		searchProductPage=productDetailsPage.clickToSaveButton();
		Assert.assertTrue(searchProductPage.isSuccessMessageDisplayed("The product has been updated successfully."));
		searchProductPage.inputToProductNameTextbox("Apple MacBook Pro 13-inch");
		searchProductPage.clickToSearchButton();
		Assert.assertTrue(searchProductPage.isPictureImageUploaded(productName,productName));
		productDetailsPage=searchProductPage.clickToEditButtonByProductName(productName);
		productDetailsPage.clickToExpandPanelByName("Pictures");	
		productDetailsPage.clickToDeleteButtonAtPictureName(productAvatarTitle); // Accept Alert
		//Assert.assertTrue(productDetailsPage.isMessageDisplayedInTable("No data available in table"));
		searchProductPage=productDetailsPage.clickToSaveButton();
		searchProductPage.inputProductNameTextBox("");
		searchProductPage.clickToSearchButton();
		Assert.assertTrue(searchProductPage.isPictureImageUpdate("default-image","Apple MacBook Pro 13-inch"));
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
	
	
