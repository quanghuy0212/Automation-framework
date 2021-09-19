package com.query.datatable;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.querydatatable.HomePageObjects;
import pageObjects.querydatatable.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_05_Data_Table extends BaseTest {
	WebDriver driver;
	String emailaddress,password;
	String projectLocation=System.getProperty("user.dir");
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		
		driver=getBrowserDriver(browserName,appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		homePage= PageGeneratorManager.getHomePage(driver);	
	}

	
	public void Login_01_Register_To_System() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		homePage.openPageByNumber("10");
		Assert.assertTrue(homePage.isActivedByNumber("10"));
		homePage.sleepInSecond(1);
		
		homePage.openPageByNumber("5");
		Assert.assertTrue(homePage.isActivedByNumber("5"));
	}
	
	
	
	
	public void TC_03_Click_Button_Action() {
		homePage.clickIconAction("Afghanistan","remove");
		homePage.sleepInSecond(3);
		homePage.clickIconAction("Angola","remove");

	}
	
	@Test
	public void TC_04() {
		homePage.inputToTextboxByRowNumber("Company","2","Alo");
		homePage.sleepInSecond(1);
		homePage.inputToTextboxByRowNumber("Contact Person","1","Alo");
			
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	HomePageObjects homePage;
}
	
	
