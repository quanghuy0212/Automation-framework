package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopcommerce.HomePageObjects;
import pageFactory.nopcommerce.LoginPageObjects;
import pageFactory.nopcommerce.RegisterPageObjects;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_PageFactory_Register_Logic_Page_Objects extends BaseTest {
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
	}

	@Test
	public void Login_01_Register_To_System() {
		driver.get("https://demo.nopcommerce.com/");
		homePage =new HomePageObjects(driver);
		Assert.assertTrue(homePage.isHomePageLoginSliderIsDisplayed());
		homePage.clicktoRegisterLink();
		registerPage=new RegisterPageObjects(driver);
		
		
		
		//Click to Male RadioButton
		registerPage.clickToMaleRadioButton();
		//Input FirstName
		registerPage.inputFirstName("quang");
		//Input LastName
		registerPage.inputLastName("huy");
		//Input Email
		registerPage.inputEmailAddress(emailaddress);
		//Input Password
		registerPage.inputPassword(password);
		//Confirm Password
		registerPage.inputToConfirmPassword(password);
		registerPage.clickToRegisterButton();
		//Verify Text Success
		Assert.assertTrue(registerPage.getTextRegisterSuccess());
		registerPage.clickToLogoutButton();
		homePage=new HomePageObjects(driver);
		Assert.assertTrue(homePage.isHomePageLoginSliderIsDisplayed());
		}
	
	@Test
	public void Login_02_Login_To_System() {
		homePage.clickToLoginLink();
		loginPage=new LoginPageObjects(driver);
		loginPage.inputEmailAddress(emailaddress);
		loginPage.inputPassword(password);
		loginPage.clickToLoginButton();
		
		homePage=new HomePageObjects(driver);

		
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
