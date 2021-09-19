package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObjects;
import pageObjects.nopcommerce.LoginPageObjects;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObjects;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Register_Logic_Page_Objects extends BaseTest {
	WebDriver driver;
	String emailaddress,password;
	String projectLocation=System.getProperty("user.dir");
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		driver=getBrowserDriver(browserName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		emailaddress= "quang" + getRandomEmail();
		password="123456";
		
		homePage= PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Login_01_Register_To_System() {
		driver.get("https://demo.nopcommerce.com/");
		homePage =new HomePageObjects(driver);
		Assert.assertTrue(homePage.isHomePageLoginSliderIsDisplayed());
		registerPage = homePage.clicktoRegisterLink();
		registerPage.clickToMaleRadioButton();
		registerPage.inputFirstName("quang");
		registerPage.inputLastName("huy");
		registerPage.inputEmailAddress(emailaddress);
		registerPage.inputPassword(password);
		registerPage.inputToConfirmPassword(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.getTextRegisterSuccess());
		homePage= registerPage.clickToLogoutButton();
		Assert.assertTrue(homePage.isHomePageLoginSliderIsDisplayed());
		}
	
	@Test
	public void Login_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputEmailAddress(emailaddress);
		loginPage.inputPassword(password);
		homePage= loginPage.clickToLoginButton();
		
		

		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	HomePageObjects homePage;
	LoginPageObjects loginPage;
	RegisterPageObjects registerPage;

	private String getRandomEmail() {
		Random random=new Random();
		return "testing" + random.nextInt(9999) + "@gmail.com";
	}
}
