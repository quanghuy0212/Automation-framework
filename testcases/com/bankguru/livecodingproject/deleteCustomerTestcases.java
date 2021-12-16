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

public class deleteCustomerTestcases extends BaseTest {

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
		deleteCustomerPage = homePage.openDeleteCustomerOnSubMenu(driver, "Delete Customer");
		deleteCustomerPage=PageGenerator.getDeleteCustomerPage(driver);

		log.info("Verify text Edit Customer Form IsDisplayed");
		verifyTrue(deleteCustomerPage.verifyDeleteCustomerPageIsDisplayed(driver));

		/*
		 * log.info("Input Customer ID To Textbox");
		 * editCustomerPage.inputCustomerIDToTextbox(driver, "cusid", customerID);
		 * 
		 * log.info("Click To Submit Button");
		 * editCustomerPage.clickToSubmitButton(driver, "AccSubmit");
		 */
	}
	
	@Test
	public void TC_02_Verify_CustomerID_Cannot_Be_Empty() {
		log.info("Do Not Input Value To CustomerID Textbox");
		deleteCustomerPage.inputToCustomerIDTextbox(driver,"cusid","");
		
		log.info("Press Tab From Keyboard");
		deleteCustomerPage.pressTabFromKeyboard(driver,"cusid");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(deleteCustomerPage.verifyCustomerIDErrorMessageIsDisplayed(driver),"Customer ID is required");
		
	}
	
	@Test
	public void TC_03_Verify_CustomerID_Must_Be_Numeric() {
		log.info("Input Characters To CustomerID Textbox");
		deleteCustomerPage.inputToCustomerIDTextbox(driver,"cusid","abc");
				
		log.info("Verify Error Message Is Displayed");
		verifyEquals(deleteCustomerPage.verifyCustomerIDErrorMessageIsDisplayed(driver),"Characters are not allowed");
		
	}
	
	@Test
	public void TC_04_Verify_CustomerID_Cannot_Have_Special_Characters() {
		log.info("Input Special Characters To CustomerID Textbox");
		deleteCustomerPage.inputToCustomerIDTextbox(driver,"cusid","@!#");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(deleteCustomerPage.verifyCustomerIDErrorMessageIsDisplayed(driver),"Special characters are not allowed");
		
	}
	
	@Test
	public void TC_05_Verify_CustomerID_Cannot_Have_Black_Space() {
		log.info("Input Blank Space To CustomerID Textbox");
		deleteCustomerPage.inputToCustomerIDTextbox(driver,"cusid","123 12");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(deleteCustomerPage.verifyCustomerIDErrorMessageIsDisplayed(driver),"Characters are not allowed");
		
	}
	
	@Test
	public void TC_06_Verify_CustomerID_Cannot_Be_Space() {
		log.info("Input Blank Space To CustomerID Textbox");
		deleteCustomerPage.inputToCustomerIDTextbox(driver,"cusid"," ");
		
		log.info("Verify Error Message Is Displayed");
		verifyEquals(deleteCustomerPage.verifyCustomerIDErrorMessageIsDisplayed(driver),"First character can not have space");
		
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
	DeleteCustomerPO deleteCustomerPage;

}
