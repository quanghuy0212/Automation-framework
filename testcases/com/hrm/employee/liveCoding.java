package com.hrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.hrm.AddEmployeePO;
import pageObject.hrm.DashboardPO;
import pageObject.hrm.EmployeeListPO;
import pageObject.hrm.LoginPO;
import pageObject.hrm.PageGenerator;
import pageObject.hrm.PersonalDetailsPO;


public class liveCoding extends BaseTest{
	String employeeID, statusValue,empFullName;
	String adminUserName, adminPassword,empFirstName,empLastName,empUserName,empPassword;
	String avatarFilePath= GlobalConstants.UPLOAD_FOLDER_PATH +"macbook air.jpg";
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser'"+ browserName +"' and navigare to '"+ appUrl + "'");
		driver=getBrowserDriver(browserName, appUrl);
		loginPage=PageGenerator.getLoginPage(driver);
		statusValue="Enabled";
		adminUserName="Admin";
		adminPassword="admin123";
		empFirstName="Quang";
		empLastName="Huy";
		empUserName="quanghuy";
		empPassword="quanghuy0212";
		empFullName=empFirstName + " " +empLastName;
		
		
		log.info("Pre-condition - Step 02: Login with Admin role");
		loginPage.enterToTextboxByID(driver, "txtUsername", adminUserName);
		loginPage.enterToTextboxByID(driver, "txtPassword", adminPassword);
		loginPage.clickToButtonByID(driver, "btnLogin");
		dashboardPage=PageGenerator.getDashboardPage(driver);
		
	}

	@Test
	public void TC_01_Register() {
		log.info("Add New_01 - Step 01: Open 'Employee List' page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage=PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add New_01 - Step 02: Click to 'Add' button");
		employeeListPage.clickToButtonByID(driver, "btnAdd");
		addEmployeePage=PageGenerator.getAddEmployeePage(driver);
		log.info("Add New_01 - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "firstName", empFirstName);
		
		log.info("Add New_01 - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "lastName", empLastName);
		
		log.info("Add New_01 - Step 05: Get value of 'Employee ID' ");
		employeeID=addEmployeePage.getTextboxValueByID(driver, "employeeId","value");
		
		log.info("Add New_01 - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCheckboxByLable(driver,"Create Login Details");
		
		log.info("Add New_01 - Step 07: Enter valid info to 'User Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_name", empUserName);
		
		log.info("Add New_01 - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_password", empPassword);
		
		log.info("Add New_01 - Step 09: Enter valid info to 'Confirm Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "re_password", empPassword);
		
		log.info("Add New_01 - Step 10: Select 'Enable' in 'Status' dropdown");
		addEmployeePage.selectItemInDropdownByID(driver, "status", statusValue);		
		
		log.info("Add New_01 - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");;
		personalDetailsPage=PageGenerator.getPersonalDetailsPage(driver);
		
		log.info("Add New_01 - Step 12: Open 'Employee List' Page");
		personalDetailsPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage=PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add New_01 - Step 13: Enter valid info to 'Employee Name' textbox");
		employeeListPage.enterToTextboxByID(driver, "empsearch_employee_name_empName", empFullName);
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Add New_01 - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		log.info("Add New_01 - Step 15: Verify Employee Information displayed at ");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1"),employeeID);
		
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver,"resultTable", "First (& Middle) Name", "1"), empFirstName);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver,"resultTable", "First (& Middle) Name", "1"), empLastName);
		  
		 		
	}
	
	@Test
	public void TC_02_Upload_Avatar() {
		log.info("Upload avatar 02- Step 01: Login with Employee role");
		loginPage=employeeListPage.logoutToSystem(driver);
		loginPage.enterToTextboxByID(driver, "txtUsername", empUserName);
		loginPage.enterToTextboxByID(driver, "txtPassword", empPassword);
		loginPage.clickToButtonByID(driver, "btnLogin");
		dashboardPage=PageGenerator.getDashboardPage(driver);
		
		log.info("Upload avatar 02- Step 02: Open persional details page");
		dashboardPage.openMenuPage(driver, "My Info");
		personalDetailsPage=PageGenerator.getPersonalDetailsPage(driver);
		
		log.info("Upload avatar 02- Step 03: Click to Change photo image");
		personalDetailsPage.clickToChangePhotoImage();
		
		log.info("Upload avatar 02- Step 04: Upload new Avatar image");
		personalDetailsPage.uploadImage(driver, avatarFilePath);		
		
		log.info("Upload avatar 02- Step 05: Click to upload button");
		personalDetailsPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Upload avatar 02- Step 06: Verify success message is displayed");
		verifyTrue(personalDetailsPage.isUploadAvatarSuccessMessageDisplayed());
		
		log.info("Upload avatar 02- Step 07: Verify avatar image is displayed");
		verifyTrue(personalDetailsPage.isNewAvatarImageDisplayed());

		
	}
	
	public WebDriver getWebDriver() {
		return this.driver;
	}

	@Parameters({"browser"})
	@AfterClass (alwaysRun=false)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition: Close browser" + browserName + "");
		closeBrowserAndDriver();
	}
	
	WebDriver driver;
	LoginPO loginPage;
	AddEmployeePO addEmployeePage;
	DashboardPO dashboardPage;
	EmployeeListPO employeeListPage;
	PersonalDetailsPO personalDetailsPage;
	
	
	
}
