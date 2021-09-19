package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObjects;
import pageObjects.nopcommerce.LoginPageObjects;
import pageObjects.nopcommerce.MyAccountPageObjects;
import pageObjects.nopcommerce.OrdersPageObjects;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObjects;
import pageObjects.nopcommerce.SearchPageObjects;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_04_Dynamic_Locator extends BaseTest {
	WebDriver driver;
	String emailaddress,password;
	String projectLocation=System.getProperty("user.dir");
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		driver=getBrowserDriver(browserName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
		
	}

	@Test
	public void Login_01_Register_To_System() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}
