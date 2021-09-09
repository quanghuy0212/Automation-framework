package com.nopcommerce.login;

import org.testng.annotations.Test;

import pageObjects.nopcommerce.HomePageObjects;
import pageObjects.nopcommerce.LoginPageObjects;
import pageObjects.nopcommerce.RegisterPageObjects;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Register_Logic_Page_Objects {
	WebDriver driver;
	String emailaddress,password;
	String projectLocation=System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		System.getProperty("webdriver.gecko.driver", projectLocation + "\\browserdrivers\\geckodriver.exe");
		driver=new FirefoxDriver();
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
	}
	
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
	}
	
	HomePageObjects homePage;
	LoginPageObjects loginPage;
	RegisterPageObjects registerPage;

	private String getRandomEmail() {
		Random random=new Random();
		return "testing" + random.nextInt(9999) + "@gmail.com";
	}
}
