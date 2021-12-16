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

public class editCustomerTestcases extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser'" + browserName + "' and navigare to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		driver.manage().window().maximize();
		urlPage = "http://demo.guru99.com/V4";
		emailRegister = getRandomEmail();
		paymentData=PaymentData.getPayment();

		loginPage = PageGenerator.getLoginPage(driver);
	}

	@Test
	public void TC_01_Create_New_Customer_And_Checked_Created_Succesfully() {

		/*
		 * log.info("Open Guru99 Site"); newCustomerPage.openGuru99Site(driver,
		 * urlPage);
		 */

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

		newCustomerPage = PageGenerator.getNewCustomerPage(driver);

		log.info("Input To Customer Name Textbox");
		newCustomerPage.inputToCustomerNameTextbox(driver, "name", paymentData.getcustomerName());

		log.info("Click To Male Radio Button");
		newCustomerPage.clickToMaleRadioButton(driver);

		log.info("Input To DOB Textbox");
		newCustomerPage.inputToDOBTextbox(driver, "type", paymentData.getDob());

		log.info("Input to Address Textbox");
		newCustomerPage.inputToAddressField(driver, "addr", paymentData.getAddress());

		log.info("Input to City Textbox ");
		newCustomerPage.inputToCityTextbox(driver, "city", paymentData.getCity());

		log.info("Input to State Textbox ");
		newCustomerPage.inputToStateTextbox(driver, "state", paymentData.getState());

		log.info("Input to PIN Textbox ");
		newCustomerPage.inputToPINTextbox(driver, "pinno", paymentData.getPin());

		log.info("Input to Phone Number TextBox ");
		newCustomerPage.inputToPhoneNumBerTextbox(driver, "telephoneno", paymentData.getMobile());

		log.info("Input to Email Textbox ");
		newCustomerPage.inputToEmailTextbox(driver, "emailid", emailRegister);

		log.info("Input to PasswordTextbox ");
		newCustomerPage.inputToPasswordTextBox(driver, "password", paymentData.getPassword());

		log.info("Click To Submit Button");
		newCustomerPage.clickToSubmitButton(driver, "sub");

		log.info("Verify Toast Register Successfully");
		verifyTrue(newCustomerPage.verifyToastRegisterSuccessfully(driver));

		log.info("Get Customer ID");
		customerID = newCustomerPage.getCustomerID(driver, "Customer ID");

		log.info("Verify CustomerName");
		verifyEquals(newCustomerPage.verifyCustomerName(driver, "Customer Name"), paymentData.getcustomerName());

		log.info("Verify Gender");
		verifyEquals(newCustomerPage.verifyGender(driver, "Gender"), paymentData.getGender());

		log.info("Verify DOB");
		verifyEquals(newCustomerPage.verifyDOB(driver, "Birthdate"), paymentData.getdobOutput());

		log.info("Verify Address");
		verifyEquals(newCustomerPage.verifyAddress(driver, "Address"), paymentData.getAddress());

		log.info("Verify City");
		verifyEquals(newCustomerPage.verifyCity(driver, "City"), paymentData.getCity());

		log.info("Verify State");
		verifyEquals(newCustomerPage.verifyState(driver, "State"), paymentData.getState());

		log.info("Verify Pin");
		verifyEquals(newCustomerPage.verifyPin(driver, "Pin"), paymentData.getPin());

		log.info("Verify Phone Number");
		verifyEquals(newCustomerPage.verifyPhoneNumber(driver, "Mobile No."), paymentData.getMobile());

		log.info("Verify Email");
		verifyEquals(newCustomerPage.verifyEmail(driver, "Email"), emailRegister);

		log.info("Open EditCustomer On SubMenu");
		editCustomerPage = homePage.clickToEditCustomerOnSubMenu(driver, "Edit Customer");
		

		log.info("Verify text Edit Customer Form IsDisplayed");
		verifyTrue(editCustomerPage.verifyTextEditCustomerIsDisplayed(driver));

		/*
		 * log.info("Input Customer ID To Textbox");
		 * editCustomerPage.inputCustomerIDToTextbox(driver, "cusid", customerID);
		 * 
		 * log.info("Click To Submit Button");
		 * editCustomerPage.clickToSubmitButton(driver, "AccSubmit");
		 */
	}

	@Test
	public void TC_02_Verify_Customer_ID_Textbox_Is_Not_Empty() {

		log.info("Do Not Enter Value To Customer ID Textbox");
		editCustomerPage.deleteValueInCustomerTextbox(driver,"cusid");

		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageCustomerIDIsDisplayed(driver), "Customer ID is required");

	}
	
	@Test
	public void TC_03_Verify_Customer_ID_Textbox_Must_Be_Numeric() {

		log.info("Input Character And Number To CustomerID Textbox");
		editCustomerPage.inputCustomerIDToTextbox(driver, "cusid", "123abc");

		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageCustomerIDIsDisplayed(driver), "Characters are not allowed");

	}

	@Test
	public void TC_04_Verify_Customer_ID_Textbox_Cannot_Have_Special_Character() {

		log.info("Input Special Character To CustomerID Textbox");
		editCustomerPage.inputCustomerIDToTextbox(driver, "cusid", "123@!#");

		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageCustomerIDIsDisplayed(driver),"Special characters are not allowed");

	}

	@Test
	public void TC_05_Input_Valid_Data_To_Textbox() {

		log.info("Input Special Character To CustomerID Textbox");
		editCustomerPage.inputCustomerIDToTextbox(driver, "cusid", customerID);

		log.info("Click To Submit Button");
		editCustomerPage.clickToSubmitButton(driver, "AccSubmit");

	}

	@Test
	public void TC_06_Verify_Address_Field_Cannot_Be_Empty() {
		log.info("Do Not Input Data To Address Textbox");
		editCustomerPage.inputToEditAddress(driver, "addr", "");

		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageAddressIsDisplayed(driver), "Address Field must not be blank");

	}

	@Test
	public void TC_07_Verify_City_Field_Cannot_Be_Empty() {
		log.info("Do Not Input Data To City Textbox");
		editCustomerPage.inputToEditCity(driver, "city", "");

		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageCityIsDisplayed(driver), "City Field must not be blank");

	}

	@Test
	public void TC_08_Verify_City_Field_Cannot_Be_Numeric() {
		log.info("Input Numeric To City Textbox");
		editCustomerPage.inputToEditCity(driver, "city", "123");

		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageCityIsDisplayed(driver), "Numbers are not allowed");

	}

	@Test
	public void TC_09_Verify_City_Field_Cannot_Have_Special_Character() {
		log.info("Input Special Character To City Textbox");
		editCustomerPage.inputToEditCity(driver, "city", "@!#");

		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageCityIsDisplayed(driver), "Special characters are not allowed");

	}

	@Test
	public void TC_10_Verify_State_Field_Cannot_Be_Empty() {
		log.info("Do not Input Data To State Textbox");
		editCustomerPage.inputToEditState(driver, "state", "");

		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageStateIsDisplayed(driver),"State must not be blank");

	}
	
	@Test
	public void TC_11_Verify_State_Field_Cannot_Be_Numeric() {
		log.info("Input Numeric To State Textbox");
		editCustomerPage.inputToEditState(driver, "state", "123");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageStateIsDisplayed(driver), "Numbers are not allowed");
		
	}
	
	@Test
	public void TC_12_Verify_State_Field_Cannot_Have_Special_Character() {
		log.info("Input Special Character To State Textbox");
		editCustomerPage.inputToEditState(driver, "state", "@!#!");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageStateIsDisplayed(driver), "Special characters are not allowed");
		
	}
	
	@Test
	public void TC_13_Verify_Pin_Field_Must_Be_Numeric() {
		log.info("Input Character To Pin Textbox");
		editCustomerPage.inputToEditPin(driver, "pinno", "123abc");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessagePinIsDisplayed(driver), "Characters are not allowed");
		
	}
	
	@Test
	public void TC_14_Verify_Pin_Field_Cannot_Be_Empty() {
		log.info(" Do Not Input Value To Pin Textbox");
		editCustomerPage.inputToEditPin(driver, "pinno", "");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessagePinIsDisplayed(driver), "PIN Code must not be blank");
		
	}

	
	@Test
	public void TC_15_Verify_Pin_Field_Must_Have_6_Digits() {
		log.info(" Input 5 numerics To Pin Textbox");
		editCustomerPage.inputToEditPin(driver, "pinno", "12345");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessagePinIsDisplayed(driver), "PIN Code must have 6 Digits");
		
	}
	
	@Test
	public void TC_16_Verify_Pin_Field_Cannot_Have_Special_Characters() {
		log.info("Input Special Character To Pin Textbox");
		editCustomerPage.inputToEditPin(driver, "pinno", "123@!#");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessagePinIsDisplayed(driver), "Special characters are not allowed");
		
	}
	
	@Test
	public void TC_17_Verify_Pin_Field_Cannot_Have_Special_Characters() {
		log.info("Input Special Character To Pin Textbox");
		editCustomerPage.inputToEditPin(driver, "pinno", "123@!#");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessagePinIsDisplayed(driver), "Special characters are not allowed");
		
	}
	
	@Test
	public void TC_18_Verify_Telephone_Field_Cannot_Be_Empty() {
		log.info("Do Not Input Value To Telephone Textbox");
		editCustomerPage.inputToEditPin(driver, "telephoneno", "");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageTelephoneIsDisplayed(driver), "Mobile no must not be blank");
		
	}
	
	@Test
	public void TC_19_Verify_Telephone_Field_Cannot_Have_Special_Characters() {
		log.info("Input Special Character To Telephone Textbox");
		editCustomerPage.inputToEditPin(driver, "telephoneno", "@!#");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageTelephoneIsDisplayed(driver), "Special characters are not allowed");
		
	}
	
	@Test
	public void TC_20_Verify_Telephone_Email_Cannot_Be_Empty() {
		log.info("Do Not Input Value To Telephone Textbox");
		editCustomerPage.inputToEditPin(driver, "emailid", "");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageEmailIsDisplayed(driver), "Email-ID must not be blank");
		
	}
	
	@Test
	public void TC_21_Verify_Telephone_Email_Must_Be_Correct_Format() {
		log.info("Input Special Character To Telephone Textbox");
		editCustomerPage.inputToEditPin(driver, "emailid", "alo@gm");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(editCustomerPage.verifyErrorMessageEmailIsDisplayed(driver), "Email-ID is not valid");
		
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

	String userID, password, urlPage, emailRegister, customerID;

	WebDriver driver;
	LoginPO loginPage;
	HomePagePO homePage;
	RegisterPO registerPage;
	NewCustomerPO newCustomerPage;
	PaymentData paymentData;
	EditCustomerPO editCustomerPage;

}
