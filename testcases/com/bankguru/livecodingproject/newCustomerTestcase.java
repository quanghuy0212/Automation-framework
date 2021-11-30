package com.bankguru.livecodingproject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.data.PaymentData;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.bankguru.BalanceEnquiryPO;
import pageObjects.bankguru.DeleteAccountPO;
import pageObjects.bankguru.DeleteCustomerPO;
import pageObjects.bankguru.DepositPagePO;
import pageObjects.bankguru.EditAccountPO;
import pageObjects.bankguru.EditCustomerPO;
import pageObjects.bankguru.FundTransferPO;
import pageObjects.bankguru.HomePagePO;
import pageObjects.bankguru.LoginPO;
import pageObjects.bankguru.NewAccountPO;
import pageObjects.bankguru.NewCustomerPO;
import pageObjects.bankguru.PageGenerator;
import pageObjects.bankguru.RegisterPO;
import pageObjects.bankguru.WithdrawalPO;

public class newCustomerTestcase extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser'" + browserName + "' and navigare to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		driver.manage().window().maximize();
		urlPage="http://demo.guru99.com/V4";
		emailRegister=getRandomEmail();
		paymentData=PaymentData.getPayment();
		
		loginPage = PageGenerator.getLoginPage(driver);
	}

	@Test
	public void NC_01_Create_New_Customer_And_Checked_Created_Succesfully() {


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
		homePage.clickToNewCustomerOnSubMenu(driver, "New Customer");
		newCustomerPage=PageGenerator.getNewCustomerPage(driver);
	}
	
	@Test
	public void NC_02_Verify_Name_Field_Name_Cannot_Empty() {
		log.info("Don't input value in Name Textbox and press Tab");
		newCustomerPage.inputToNameTextbox(driver,"name","");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageIsDisplayed(driver),"Customer name must not be blank");
	}
	
	@Test
	public void NC_03_Verify_Field_Name_Name_Cannot_Numeric() {
		log.info("Enter numeric value in Name Textbox");
		newCustomerPage.inputToNameTextbox(driver,"name","1234");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageIsDisplayed(driver),"Numbers are not allowed");
	}
	
	@Test
	public void NC_04_Verify_Field_Name_Cannot_Have_Special_Character() {
		log.info("Input Special Character To Name Textbox");
		newCustomerPage.inputToNameTextbox(driver,"name","name@!#");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageIsDisplayed(driver),"Special characters are not allowed");
	}
	
	@Test
	public void NC_05_Verify_Field_Name_Cannot_Have_First_Character_As_Blank_Space() {
		log.info("Input Blank Space To Name Textbox");
		newCustomerPage.inputToNameTextbox(driver,"name"," ");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageIsDisplayed(driver),"First character can not have space");
	}
	
	@Test
	public void NC_06_Verify_Field_Address_Cannot_Be_Empty() {
		log.info("Do Not InputTo Address Textbox");
		newCustomerPage.checkInputToAddressField(driver,"addr","");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageAddressIsDisplayed(driver),"Address Field must not be blank");
	}
	
	@Test
	public void NC_07_Verify_Field_Address_Cannot_Have_First_Black_Space() {
		log.info("Input Blank Space To Address Textbox");
		newCustomerPage.inputToAddressField(driver,"addr"," ");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageAddressIsDisplayed(driver),"First character can not have space");
	}
	
	@Test
	public void NC_08_Verify_Field_City_Cannot_Be_Empty() {
		log.info("Do not Input To City Textbox");
		newCustomerPage.checkInputToCityTextbox(driver,"city","");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageCityIsDisplayed(driver),"City Field must not be blank");
	}
	
	@Test
	public void NC_09_Verify_Field_City_Cannot_Be_Numeric() {
		log.info("Input Numeric To City Textbox");
		newCustomerPage.inputToCityTextbox(driver,"city","1234");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageCityIsDisplayed(driver),"Numbers are not allowed");
	}
	
	@Test
	public void NC_10_Verify_Field_City_Cannot_Have_Special_Character() {
		log.info("Input Special Character To City Textbox");
		newCustomerPage.inputToCityTextbox(driver,"city","City@!#");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageCityIsDisplayed(driver),"Special characters are not allowed");
	}
	
	@Test
	public void NC_11_Verify_Field_City_Cannot_First_Blank_Space() {
		log.info("Input Blank Space To City Textbox");
		newCustomerPage.inputToCityTextbox(driver,"city"," ");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageCityIsDisplayed(driver),"First character can not have space");
	}
	
	@Test
	public void NC_12_Verify_Field_State_Cannot_Be_Empty() {
		log.info("Donnot Input To State Textbox");
		newCustomerPage.checkInputToStateTextbox(driver,"state","");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageStateIsDisplayed(driver),"First character can not have space");
	}
	
	@Test
	public void NC_13_Verify_Field_State_Cannot_Be_Numeric() {
		log.info("Input Numeric To State Textbox");
		newCustomerPage.inputToStateTextbox(driver,"state","1234");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageStateIsDisplayed(driver),"Numbers are not allowed");
	}
	
	@Test
	public void NC_14_Verify_Field_State_Cannot_Have_Special_Character() {
		log.info("Input Special Character To State Textbox");
		newCustomerPage.inputToStateTextbox(driver,"state","state@!#");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageStateIsDisplayed(driver),"Special characters are not allowed");
	}
	
	@Test
	public void NC_15_Verify_Field_State_Cannot_Have_First_Blank_Space() {
		log.info("Input Fist Blank To State Textbox");
		newCustomerPage.inputToStateTextbox(driver,"state"," ");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageStateIsDisplayed(driver),"First character can not have space");
	}
	
	@Test
	public void NC_16_Verify_Field_Pin_Must_Be_Numeric() {
		log.info("Input Numeric To Pin Textbox");
		newCustomerPage.checkInputToPINTextbox(driver,"pinno","abc123");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessagePinIsDisplayed(driver),"Characters are not allowed");
	}
	
	@Test
	public void NC_17_Verify_Field_Pin_Cannot_Empty() {
		log.info("Do Not To Pin Textbox");
		newCustomerPage.inputToPINTextbox(driver,"pinno","");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessagePinIsDisplayed(driver),"PIN Code must not be blank");
	}
	
	@Test
	public void NC_18_Verify_Field_Pin_Must_Have_6_Digits() {
		log.info("Input 2 Digits Pin Textbox");
		newCustomerPage.inputToPINTextbox(driver,"pinno","12");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessagePinIsDisplayed(driver),"PIN Code must have 6 Digits");
	}
	
	@Test
	public void NC_19_Verify_Field_Pin_Cannot_Have_Special_Character() {
		log.info("Input Special Character To Pin Textbox");
		newCustomerPage.inputToPINTextbox(driver,"pinno","@!#");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessagePinIsDisplayed(driver),"Special characters are not allowed");
	}
	
	@Test
	public void NC_20_Verify_Field_Pin_Cannot_Have_First_Blank_Space() {
		log.info("Input First Blank Space To Pin Textbox");
		newCustomerPage.inputToPINTextbox(driver,"pinno"," ");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessagePinIsDisplayed(driver),"First character can not have space");
	}
	
	@Test
	public void NC_21_Verify_Field_Telephone_Cannot_Be_Empty() {
		log.info("Do not enter value To Telephone Textbox");
		newCustomerPage.checkInputToPhoneNumBerTextbox(driver,"telephoneno","");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageTelephoneIsDisplayed(driver),"Mobile no must not be blank");
	}
	
	@Test
	public void NC_22_Verify_Field_Telephone_Cannot_Have_First_Blank_Space() {
		log.info("Input First Character As Blank Space To Telephone Textbox");
		newCustomerPage.inputToPhoneNumBerTextbox(driver,"telephoneno"," ");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageTelephoneIsDisplayed(driver),"First character can not have space");
	}
	
	@Test
	public void NC_23_Verify_Field_Telephone_Cannot_Have_Space() {
		log.info("Input Numeric And Space To Telephone Textbox");
		newCustomerPage.inputToPhoneNumBerTextbox(driver,"telephoneno","123 123");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageTelephoneIsDisplayed(driver),"Characters are not allowed");
	}
	
	@Test
	public void NC_24_Verify_Field_Telephone_Cannot_Have_Special_Character() {
		log.info("Input Special Character To Telephone Textbox");
		newCustomerPage.inputToPhoneNumBerTextbox(driver,"telephoneno","@!@!#");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageTelephoneIsDisplayed(driver),"Special characters are not allowed");
	}
	
	@Test
	public void NC_25_Verify_Field_Email_Cannot_Be_Empty() {
		log.info("Do Not input value To Email Textbox");
		newCustomerPage.checkInputToEmailTextbox(driver,"emailid","");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageEmailIsDisplayed(driver),"Email-ID must not be blank");
	}
	
	@Test
	public void NC_26_Verify_Field_Email_Must_Be_Incorrect() {
		log.info("Input Email Incorrect To Email Textbox");
		newCustomerPage.inputToEmailTextbox(driver,"emailid","guru99@gmail");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageEmailIsDisplayed(driver),"Email-ID is not valid");
	}
	
	@Test
	public void NC_27_Verify_Field_Email_Cannot_Have_Space() {
		log.info("Input Space To Email Textbox");
		newCustomerPage.inputToEmailTextbox(driver,"emailid"," ");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(newCustomerPage.verifyErrorMessageTelephoneIsDisplayed(driver),"");
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

	String userID,password,urlPage,emailRegister;
	
	WebDriver driver;
	LoginPO loginPage;
	HomePagePO homePage;
	RegisterPO registerPage;
	NewCustomerPO newCustomerPage;
	PaymentData paymentData;

}
