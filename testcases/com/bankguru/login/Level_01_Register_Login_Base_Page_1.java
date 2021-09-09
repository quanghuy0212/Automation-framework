package com.bankguru.login;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Level_01_Register_Login_Base_Page_1 {
	WebDriver driver;
	BasePage basePage;
	String username,password,loginPageUrl, email;
	String projectLocation=System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserdrivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		email= "quanghuy" + getRandomEmail() + "@gmail.com";
		
		basePage=new BasePage();
	}

	@Test
	public void Login_01_Register_To_System() {
		loginPageUrl=basePage.getPageUrl(driver);
		basePage.clickToElement(driver, "//a[text()='here']");
		basePage.sendkeyToElement(driver, "//input[@name='emailid']", email);
		basePage.clickToElement(driver, "//input[@name='btnLogin']");
		username = basePage.getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
		password=basePage.getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
		
	}
	
	@Test
	public void Login_02_Login_To_System() {
		basePage.openPageUrl(driver, loginPageUrl);
		basePage.sendkeyToElement(driver, "//input[@name='uid']", username);
		basePage.sendkeyToElement(driver, "//input[@name='password']", password);
		basePage.clickToElement(driver, "//input[@type='submit']");
		
	}

	@AfterClass
	public void afterClass() {
	}

	public int getRandomEmail() {
		Random ran=new Random();
		return ran.nextInt(9999);
	}
}
