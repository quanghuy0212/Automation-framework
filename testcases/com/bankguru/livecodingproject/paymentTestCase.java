package com.bankguru.livecodingproject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.bankguru.HomePagePO;
import pageObjects.bankguru.LoginPO;
import pageObjects.bankguru.PageGenerator;
import pageObjects.bankguru.RegisterPO;

public class paymentTestCase extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser'" + browserName + "' and navigare to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		driver.manage().window().maximize();
		emailRegister = getRandomEmail();
		urlPage = "http://demo.guru99.com/v4/";
		customerName="AUTOMATION TESTING";
		dob="01/01/1989";
		address="Thi Tran Can Giuoc Tinh Long An";
		city="Tampa";
		state="FL";
		pin="466250";
		mobile="4555442476";
		emailCus="automation@gmail.com";
		passwordCus="automation";
		loginPage = PageGenerator.getLoginPage(driver);
	}

	@Test
	public void TC_01_Create_New_Customer_And_Checked_Created_Succesfully() {
		log.info("Click to here link to get username and password");
		loginPage.clickToHereLinkToGetAccount(driver);
		registerPage = PageGenerator.getRegisterPage(driver);

		log.info("Input Email To Textbox");
		registerPage.inputEmailToTextBox(driver, "emailid", emailRegister);

		log.info("Click to Submit button");
		registerPage.clickToSubmitButton(driver, "btnLogin");

		log.info("Get Attribute UserID ");
		userID = registerPage.getTextUserIDOnTable(driver);

		log.info("Get Attribute Password");
		password = registerPage.getPasswordOnTable(driver);

		log.info("Back To LoginPage");
		registerPage.backToLoginPage(driver, urlPage);
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("Input UserName to TextBox");
		loginPage.inputUserNametoTextBox(driver, "uid", userID);

		log.info("Input Password to TextBox");
		loginPage.inputPasswordToTextBox(driver, "password", password);

		log.info("Click to Login Button");
		homePage = loginPage.clickToLoginButton(driver, "btnLogin");

		homePage = PageGenerator.getHomePage(driver);

		log.info("Verify Toast Manager Page is Displayed");
		verifyTrue(homePage.ToastManagerPageisDisplayed(driver));

		log.info("Open New Customer Page on SubMenu");
		homePage.clickToNewCustomerOnSubMenu(driver,"New Customer");

		log.info("Input To Customer Name Textbox");
		homePage.inputToCustomerNameTextbox(driver,"name",customerName);

		log.info("Click To Male Radio Button");
		homePage.clickToMaleRadioButton(driver);

		log.info("Input To DOB Textbox");
		homePage.inputToDOBTextbox(driver,"dob",dob);

		log.info("Input to Address Textbox");
		homePage.inputToAddressField(driver,"addr",address);

		log.info("Input to City Textbox ");
		homePage.inputToCityTextbox(driver,"city",city);

		log.info("Input to State Textbox ");
		homePage.inputToStateTextbox(driver,"state",state);

		log.info("Input to PIN Textbox ");
		homePage.inputToPINTextbox(driver,"pinno",pin);
		
		log.info("Input to Phone Number TextBox ");
		homePage.inputToPhoneNumBerTextbox(driver,"telephoneno",mobile);
		
		log.info("Input to Email Textbox ");
		homePage.inputToEmailTextbox(driver,"emailid",mobile);
		
		log.info("Input to PasswordTextbox ");
		homePage.inputToPasswordTextBox(driver,"password",mobile);
		
		log.info("Click To Submit Button");
		homePage.clickToSubmitButton(driver,"sub");
		

	}

	@Test
	public void TC_02_Upload_Avatar() {

	}

	public WebDriver getWebDriver() {
		return this.driver;
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = false)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition: Close browser" + browserName + "");
		closeBrowserAndDriver();
	}

	WebDriver driver;
	LoginPO loginPage;
	HomePagePO homePage;
	RegisterPO registerPage;

	String emailRegister, urlPage, userID,customerName,dob,address,city,state,pin,mobile,emailCus,passwordCus;
	String password;

}
