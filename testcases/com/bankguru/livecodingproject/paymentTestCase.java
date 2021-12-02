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

public class paymentTestCase extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser'" + browserName + "' and navigare to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		driver.manage().window().maximize();
		emailRegister = getRandomEmail();
		emailOtherUserRegister = getRandomEmail();
		paymentData=PaymentData.getPayment();
		urlPage = "http://demo.guru99.com/v4/";
		passwordCus = "emailrandom" + getRandomNumber();
		loginPage = PageGenerator.getLoginPage(driver);
	}

	@Test
	public void TC_01_Create_New_Other_User() {
		log.info("Click to here link to get username and password");
		loginPage.clickToHereLinkToGetAccount(driver);
		registerPage = PageGenerator.getRegisterPage(driver);

		log.info("Input Email To Textbox");
		registerPage.inputEmailToTextBox(driver, "emailid", emailOtherUserRegister);

		log.info("Click to Submit button");
		registerPage.clickToSubmitButton(driver, "btnLogin");

		log.info("Get Attribute UserID ");
		otheruserID = registerPage.getTextUserIDOnTable(driver);

		log.info("Get Attribute Password");
		passwordOtherUser = registerPage.getPasswordOnTable(driver);

		log.info("Back To LoginPage");
		registerPage.backToLoginPage(driver, urlPage);
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("Input UserName to TextBox");
		loginPage.inputUserNametoTextBox(driver, "uid", otheruserID);

		log.info("Input Password to TextBox");
		loginPage.inputPasswordToTextBox(driver, "password", passwordOtherUser);

		log.info("Click to Login Button");
		homePage = loginPage.clickToLoginButton(driver, "btnLogin");

		homePage = PageGenerator.getHomePage(driver);

		log.info("Verify Toast Manager Page is Displayed");
		verifyTrue(homePage.ToastManagerPageisDisplayed(driver));

		log.info("Open New Customer Page on SubMenu");
		homePage.clickToNewCustomerOnSubMenu(driver, "New Customer");

		newCustomerPage = PageGenerator.getNewCustomerPage(driver);

		log.info("Input To Customer Name Textbox");
		newCustomerPage.inputToCustomerNameTextbox(driver, "name",paymentData.getcustomerName());

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
		newCustomerPage.inputToEmailTextbox(driver, "emailid", emailOtherUserRegister);

		log.info("Input to PasswordTextbox ");
		newCustomerPage.inputToPasswordTextBox(driver, "password", paymentData.getPassword());

		log.info("Click To Submit Button");
		newCustomerPage.clickToSubmitButton(driver, "sub");

		log.info("Verify Toast Register Successfully");
		verifyTrue(newCustomerPage.verifyToastRegisterSuccessfully(driver));

		log.info("Get Customer ID");
		otherUserCustomerID = newCustomerPage.getCustomerID(driver, "Customer ID");

		log.info("Verify CustomerName");
		verifyEquals(newCustomerPage.verifyCustomerName(driver, "Customer Name"), paymentData.getcustomerName());

		log.info("Verify Gender");
		verifyEquals(newCustomerPage.verifyGender(driver, "Gender"), paymentData.getGender());

		log.info("Verify DOB");
		verifyEquals(newCustomerPage.verifyDOB(driver, "Birthdate"), paymentData.getDob());

		log.info("Verify Address");
		verifyEquals(newCustomerPage.verifyAddress(driver, "Address"), paymentData.getAddress());

		log.info("Verify City");
		verifyEquals(newCustomerPage.verifyCity(driver, "City"), paymentData.getdobOutput());

		log.info("Verify State");
		verifyEquals(newCustomerPage.verifyState(driver, "State"), paymentData.getState());

		log.info("Verify Pin");
		verifyEquals(newCustomerPage.verifyPin(driver, "Pin"), paymentData.getPin());

		log.info("Verify Phone Number");
		verifyEquals(newCustomerPage.verifyPhoneNumber(driver, "Mobile No."), paymentData.getMobile());

		log.info("Verify Email");
		verifyEquals(newCustomerPage.verifyEmail(driver, "Email"), emailOtherUserRegister);

		///////////////////////////////////////
		log.info("Open New Account On SubMenu");
		newCustomerPage.openNewAccountOnSubMenu(driver, "New Account");
		newAccountPage = PageGenerator.getNewAccountPage(driver);

		log.info("Verify Add New Account Page");
		verifyTrue(newAccountPage.AddNewAccountPageIsDisplayed(driver));

		log.info("Input To Customer ID Textbox");
		newAccountPage.inputCustomerIDToTextbox(driver, "cusid", otherUserCustomerID);

		log.info("Select Account Type in Combobox");
		newAccountPage.selectAccountTypeInDropdown(driver, "selaccount", "Savings");

		log.info("Input To Initial Deposit Textbox");
		newAccountPage.inputToInitialDepositTextbox(driver, "inideposit", paymentData.getInitialDeposit());

		log.info("Click To Submit button");
		newAccountPage.clickToSubmitButton(driver, "button2");

		log.info("Verify Add New Account Successfully");
		verifyTrue(newAccountPage.verifyAddNewAccountSuccessfully(driver));

		log.info("Get Account ID from Table");
		otherUserAccountID = newAccountPage.getAccountIDFromTable(driver);

	}

	@Test
	public void TC_02_Create_New_Customer_And_Checked_Created_Succesfully() {

		log.info("Open Guru99 Site");
		newCustomerPage.openGuru99Site(driver, urlPage);

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

	}

	@Test
	public void TC_03_Edit_Customer_Account_And_Check_Edit_Succesfully() {
		log.info("Open Guru99 Site");
		newCustomerPage.openGuru99Site(driver, urlPage);
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("Input UserID To Textbox");
		loginPage.inputUserNametoTextBox(driver, "uid", userID);

		log.info("Input Password To Textbox");
		loginPage.inputPasswordToTextBox(driver, "password", password);

		log.info("Click To Submit Button");
		homePage = loginPage.clickToLoginButton(driver, "btnLogin");

		log.info("Open EditCustomer On SubMenu");
		editCustomerPage = homePage.clickToEditCustomerOnSubMenu(driver, "Edit Customer");

		log.info("Verify text Edit Customer Form IsDisplayed");
		verifyTrue(editCustomerPage.verifyTextEditCustomerIsDisplayed(driver));

		log.info("Input CustomerID To Textbox");
		editCustomerPage.inputCustomerIDToTextbox(driver, "cusid", customerID);

		log.info("Click To Submit Button");
		editCustomerPage.clickToSubmitButton(driver, "AccSubmit");

		log.info("Input To Edit Address");
		editCustomerPage.inputToEditAddress(driver, "addr", paymentData.getEditAddress());

		log.info("Input To Edit City");
		editCustomerPage.inputToEditCity(driver, "city", paymentData.getEditCity());

		log.info("Input To Edit State");
		editCustomerPage.inputToEditState(driver, "state", paymentData.getEditState());

		log.info("Input To Edit Pin");
		editCustomerPage.inputToEditPin(driver, "pinno", paymentData.getEditPin());

		log.info("Click To Submit button");
		editCustomerPage.clickToSubmitButtonForEdit(driver, "sub");

		log.info("Verify Toast Edit Successfully");
		verifyTrue(editCustomerPage.verifyToastEditSuccessfully(driver));

	}

	@Test
	public void TC_04_Add_New_Account() {
		log.info("Open Guru99 site");
		loginPage = editCustomerPage.openGuru99Site(driver, urlPage);
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("Input UserID To Textbox");
		loginPage.inputUserNametoTextBox(driver, "uid", userID);

		log.info("Input Password To Textbox");
		loginPage.inputPasswordToTextBox(driver, "password", password);

		log.info("Click To Submit Button");
		homePage = loginPage.clickToLoginButton(driver, "btnLogin");

		log.info("Open New Account On SubMenu");
		homePage.openNewAccountOnSubMenu(driver, "New Account");
		newAccountPage = PageGenerator.getNewAccountPage(driver);

		log.info("Verify Add New Account Page");
		verifyTrue(newAccountPage.AddNewAccountPageIsDisplayed(driver));

		log.info("Input To Customer ID Textbox");
		newAccountPage.inputCustomerIDToTextbox(driver, "cusid", customerID);

		log.info("Select Account Type in Combobox");
		newAccountPage.selectAccountTypeInDropdown(driver, "selaccount", "Savings");

		log.info("Input To Initial Deposit Textbox");
		newAccountPage.inputToInitialDepositTextbox(driver, "inideposit", paymentData.getInitialDeposit());

		log.info("Click To Submit button");
		newAccountPage.clickToSubmitButton(driver, "button2");

		log.info("Verify Add New Account Successfully");
		verifyTrue(newAccountPage.verifyAddNewAccountSuccessfully(driver));

		log.info("Get Account ID from Table");
		accountID = newAccountPage.getAccountIDFromTable(driver);

	}

	@Test
	public void TC_05_Edit_Account() {
		log.info("Open Guru 99 Site");
		loginPage = newAccountPage.openGuru99Site(driver, urlPage);
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("Input UserID To Textbox");
		loginPage.inputUserNametoTextBox(driver, "uid", userID);

		log.info("Input Password To Textbox");
		loginPage.inputPasswordToTextBox(driver, "password", password);

		log.info("Click To Submit Button");
		homePage = loginPage.clickToLoginButton(driver, "btnLogin");

		log.info("Open Edit Account on SubMenu");
		editAccountPage = homePage.openEditAccountOnSubMenu(driver, "Edit Account");
		editAccountPage = PageGenerator.getEditAccountPage(driver);

		log.info("Verify Edit Account Page Is Displayed");
		verifyTrue(editAccountPage.verifyEditAccountPageIsDisplayed(driver));

		log.info("Input AccountID To Textbox");
		editAccountPage.inputToAccountIDTextbox(driver, "accountno", accountID);

		log.info("Click to Submit Button");
		editAccountPage.clickToSubmitButton(driver, "AccSubmit");

		log.info("Change Type Of Account To Current");
		editAccountPage.changeTypeOfAccountToCurrent(driver, "a_type", "Current");

		log.info("Click To Submit Button");
		editAccountPage.clickToSubmitButton(driver, "AccSubmit");

		log.info("Verify Edit Account Successfully");
		verifyTrue(editAccountPage.verifyEditAccountSuccessfully(driver));

	}

	@Test
	public void TC_06_Tranfer_Money_Into_A_Current_Account() {
		log.info("Open Guru99 Site");
		loginPage = editAccountPage.openGuru99Site(driver, urlPage);
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("Input UserID To Textbox");
		loginPage.inputUserNametoTextBox(driver, "uid", userID);

		log.info("Input Password To Textbox");
		loginPage.inputPasswordToTextBox(driver, "password", password);

		log.info("Click To Submit Button");
		homePage = loginPage.clickToLoginButton(driver, "btnLogin");

		depositPage = homePage.clickToDepositOnSubMenu(driver, "Deposit");
		depositPage = PageGenerator.getDepositPage(driver);

		log.info("Verify Deposit Page Is Displayed");
		verifyTrue(depositPage.verifyDepositPageIsDisplayed(driver));

		log.info("Input AccountID To Textbox");
		depositPage.inputAccountIDToTextbox(driver, "accountno", accountID);

		log.info("Input Amount To Textbox");
		depositPage.inputAmountToTextbox(driver, "ammount", paymentData.getAmount());

		log.info("Input Description To Textbox");
		depositPage.inputDescriptionToTextbox(driver, "desc", paymentData.getDescription());

		log.info("Click to Submit Button");
		depositPage.clickToSubmitButton(driver, "AccSubmit");

		log.info("Verify Transaction details of Deposit for Account");
		verifyTrue(depositPage.verifyTransactionDetailsForAccount(driver, accountID));

		log.info("Verify Current Amount");
		verifyEquals(depositPage.verifyCurrentAmount(driver), paymentData.getCurrentBalace());

	}

	@Test
	public void TC_07_WithDraw_Money_From_Current_Account() {
		log.info("Open Guru99 Site");
		loginPage = depositPage.openGuru99Site(driver, urlPage);
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("Input UserID To Textbox");
		loginPage.inputUserNametoTextBox(driver, "uid", userID);

		log.info("Input Password To Textbox");
		loginPage.inputPasswordToTextBox(driver, "password", password);

		log.info("Click To Submit Button");
		homePage = loginPage.clickToLoginButton(driver, "btnLogin");

		log.info("Open Withdrawal On SubMenu");
		withdrawalPage = homePage.openWithdrawaOnSubMenu(driver, "Withdrawal");
		withdrawalPage = PageGenerator.getWithdrawalPage(driver);

		log.info("Verify WithdrawalPage Is Displayed");
		verifyTrue(withdrawalPage.verifyWithdrawalPageIsDisplayed(driver));

		log.info("Input To AccountID Textbox");
		withdrawalPage.inputToAccountIDTextbox(driver, "accountno", accountID);

		log.info("Input To Amount Textbox");
		withdrawalPage.inputToAmoutTextbox(driver, "ammount", paymentData.getAmountWithdrawal());

		log.info("Input TO Description Textbox");
		withdrawalPage.inputToDescriptionTextbox(driver, "desc", paymentData.getdescriptionWithdrawal());

		log.info("Click To Submit Button");
		withdrawalPage.clickToSubmitButton(driver, "AccSubmit");

		log.info("Verify Transaction details of Withdrawal for Account");
		verifyTrue(withdrawalPage.verifyTransactionDetailsOfWithDrawalForAccountToastIsDisplayed(driver, accountID));

		log.info("Verify Current Balance");
		verifyEquals(withdrawalPage.verifyCurrentBalance(driver), paymentData.getCurrentBalanceWithdrawal());
		System.out.println(accountID);
		System.out.println(otherUserCustomerID);

	}

	@Test
	public void TC_08_Transfer_The_Money_Into_Another_Account() {
		log.info("Open Guru99 Site");
		loginPage = withdrawalPage.openGuru99Site(driver, urlPage);
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("Input UserID To Textbox");
		loginPage.inputUserNametoTextBox(driver, "uid", userID);

		log.info("Input Password To Textbox");
		loginPage.inputPasswordToTextBox(driver, "password", password);

		log.info("Click To Submit Button");
		homePage = loginPage.clickToLoginButton(driver, "btnLogin");

		log.info("Open Fund Transfer On SubMenu");
		fundTransferPage = homePage.openFundTransferOnSubMenu(driver, "Fund Transfer");
		fundTransferPage = PageGenerator.getFundTransferPage(driver);

		log.info("Verify Fund Transfer Page Is Displayed");
		verifyTrue(fundTransferPage.verifyFundTransferPageIsDisplayed(driver));

		log.info("Input To Payers AccountID");
		fundTransferPage.inputToPayersAccountIDTextbox(driver, "payersaccount", accountID);

		log.info("Input To Payees AccountID");
		fundTransferPage.inputToPayeesAccountIDTextbox(driver, "payeeaccount", otherUserAccountID);

		log.info("Input To Amount Textbox");
		fundTransferPage.inputToAmountTextbox(driver, "ammount", paymentData.getAmountTransfer());

		log.info("Input To Description Textbox");
		fundTransferPage.inputToDescriptionTextbox(driver, "desc", paymentData.getDescriptionTransfer());

		log.info("Click To Submit Button");
		fundTransferPage.clickToSubmitButton(driver, "AccSubmit");

		log.info("Verify AccountID");
		verifyEquals(fundTransferPage.verifyAccountID(driver, "From Account Number"), accountID);

		log.info("Verify Payees Account ID");
		verifyEquals(fundTransferPage.verifyPayeesAccountID(driver, "To Account Number"), otherUserAccountID);

		log.info("Verify Amount Transfer");
		verifyEquals(fundTransferPage.verifyAmountTransfer(driver, "Amount"), paymentData.getAmountTransfer());

		log.info("Verify Description Transfer");
		verifyEquals(fundTransferPage.verifyDescriptionTransfer(driver, "Description"), paymentData.getDescriptionTransfer());

	}

	@Test
	public void TC_09_Check_Current_Account_Balance_Equal_3000() {
		log.info("Open Guru 99 Site");
		loginPage = fundTransferPage.openGuru99Site(driver, urlPage);
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("Input UserID To Textbox");
		loginPage.inputUserNametoTextBox(driver, "uid", userID);

		log.info("Input Password To Textbox");
		loginPage.inputPasswordToTextBox(driver, "password", password);

		log.info("Click To Submit Button");
		homePage = loginPage.clickToLoginButton(driver, "btnLogin");

		log.info("Open Balance Enquiry On SubMenu");
		balanceEnquiryPage = homePage.openBalaceEnquiryOnSubMenu(driver, "Balance Enquiry");

		log.info("Verify Balance Enquiry Page Is Displayed");
		verifyTrue(balanceEnquiryPage.verifyBalanceEnquiryPageIsDisplayed(driver));

		log.info("Input AccountID To Textbox");
		balanceEnquiryPage.inputAccountIDToTextbox(driver, "accountno", accountID);

		log.info("Click To Submit Button");
		balanceEnquiryPage.clickToSubmitButton(driver, "AccSubmit");

		log.info("Verify Balance Details for Account Is Displayed");
		verifyEquals(balanceEnquiryPage.verifyBalanceDetailsForAccountIsDisplayed(driver, "Balance"), paymentData.getBalance());

	}

	@Test
	public void TC_10_Delete_All_Account() {
		log.info("Open Guru99 Site");
		loginPage = balanceEnquiryPage.openGuru99Site(driver, urlPage);
		loginPage = PageGenerator.getLoginPage(driver);

		log.info("Input UserID To Textbox");
		loginPage.inputUserNametoTextBox(driver, "uid", userID);

		log.info("Input Password To Textbox");
		loginPage.inputPasswordToTextBox(driver, "password", password);

		log.info("Click To Submit Button");
		homePage = loginPage.clickToLoginButton(driver, "btnLogin");

		log.info("Open Delete Account On SubMenu");
		deleteAccountPage = homePage.openDeleteAccountOnSubMenu(driver, "Delete Account");

		log.info("Verify Delete Account Is Displayed");
		verifyTrue(deleteAccountPage.verifyDeleteAccountPageIsDisplayed(driver));

		log.info("Input CustomerID To Textbox");
		deleteAccountPage.inputCustomerIDToTextbox(driver, "accountno", accountID);

		log.info("Click To Submit Button");
		deleteAccountPage.clickToSubmitButton(driver, "AccSubmit");
		sleepInSecond(2);

		log.info("Veiry message Delete Successfully");
		verifyEquals(deleteAccountPage.verifyMessageDeleteSuccessfully(driver), "Account Deleted Sucessfully");
		
		log.info("Accept alert");
		deleteAccountPage.acceptAlert(driver);
		sleepInSecond(2);
		
		log.info("Open Edit Account On SubMenu");
		deleteAccountPage.openEditAccountOnSubMenu(driver,"Edit Account");

		log.info("Check Edit Account Page Is Displayed");
		verifyTrue(deleteAccountPage.verifyEditAccountPageIsDisplayed(driver));
		
		log.info("Input AccountID To Textbox");
		deleteAccountPage.inputAccountIDToTextbox(driver,"accountno",accountID);

		log.info("Click To Submit Button");
		deleteAccountPage.clickToSubmitButtonOnEditCustomerPage(driver,"AccSubmit");
		sleepInSecond(2);

		log.info("Verify message display with content 'Account does not exist");
		verifyEquals(deleteAccountPage.verifyMessageDisplayed(driver),"Account does not exist");

	
	}

	
	
	/*
	 * @Test public void TC_11_Delete_Exist_Customer_Account() {
	 * log.info("Open Guru 99 Site");
	 * loginPage=deleteAccountPage.openGuru99Site(driver,urlPage);
	 * loginPage=PageGenerator.getLoginPage(driver);
	 * 
	 * log.info("Input UserID To Textbox"); loginPage.inputUserNametoTextBox(driver,
	 * "uid", userID);
	 * 
	 * log.info("Input Password To Textbox");
	 * loginPage.inputPasswordToTextBox(driver, "password", password);
	 * 
	 * log.info("Click To Submit Button"); homePage =
	 * loginPage.clickToLoginButton(driver, "btnLogin");
	 * 
	 * log.info("Open Delete Customer On SubMenu");
	 * deleteCustomerPage=homePage.openDeleteCustomerOnSubMenu(
	 * driver,"Delete Customer");
	 * deleteCustomerPage=PageGenerator.getDeleteCustomerPage(driver);
	 * 
	 * log.info("Verify Delete Customer Page Is Displayed");
	 * verifyTrue(deleteCustomerPage.verifyDeleteCustomerPageIsDisplayed(driver));
	 * 
	 * log.info("Input To CustomerID textbox");
	 * deleteCustomerPage.inputToCustomerIDTextbox(driver,"cusid",customerID);
	 * 
	 * log.info("Click to Submit Button");
	 * deleteCustomerPage.clickToSubmitButton(driver,"AccSubmit");
	 * 
	 * log.info("Verify Delete Customer Successfully");
	 * verifyEquals(deleteCustomerPage.verifyCustomerDeleteSuccessfully(driver)
	 * ,"Customer Deleted Successfully");
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
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
	NewCustomerPO newCustomerPage;
	EditCustomerPO editCustomerPage;
	NewAccountPO newAccountPage;
	EditAccountPO editAccountPage;
	DepositPagePO depositPage;
	WithdrawalPO withdrawalPage;
	FundTransferPO fundTransferPage;
	BalanceEnquiryPO balanceEnquiryPage;
	DeleteAccountPO deleteAccountPage;
	DeleteCustomerPO deleteCustomerPage;
	PaymentData paymentData;

	String emailRegister,emailOtherUserRegister,urlPage,passwordCus,otheruserID,passwordOtherUser,otherUserCustomerID,otherUserAccountID;
	String userID,password,customerID,accountID;
	
}
