package com.hrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObject.hrm.AddEmployeePO;
import pageObject.hrm.DashboardPO;
import pageObject.hrm.EmployeeListPO;
import pageObject.hrm.LoginPO;
import pageObject.hrm.PageGenerator;
import pageObject.hrm.PersonalDetailsPO;


public class liveCoding extends BaseTest{
	String employeeID, statusValue;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser'"+ browserName +"' and navigare to '"+ appUrl + "'");
		driver=getBrowserDriver(browserName, appUrl);
		loginPage=PageGenerator.getLoginPage(driver);
		statusValue="Enable";
		log.info("Pre-condition - Step 02: Login with Admin role");
		loginPage.enterToTextboxByID(driver, "txtUsername", "Admin");
		loginPage.enterToTextboxByID(driver, "txtPassword", "admin123");
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
		addEmployeePage.enterToTextboxByID(driver, "firstName", "");
		
		log.info("Add New_01 - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "lastName", "");
		
		log.info("Add New_01 - Step 05: Get value of 'Employee ID' ");
		employeeID=addEmployeePage.getTextboxValueByID(driver, "employeeId");
		
		log.info("Add New_01 - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCheckboxByLable(driver,"Create Login Details");
		
		log.info("Add New_01 - Step 07: Enter valid info to 'User Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_name", "");
		
		log.info("Add New_01 - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_password", "");
		
		log.info("Add New_01 - Step 09: Enter valid info to 'Confirm Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "re_password", "");
		
		log.info("Add New_01 - Step 10: Select 'Enable' in 'Status' dropdown");
		addEmployeePage.selectItemInDropdownByID(driver, "status", statusValue);		
		
		log.info("Add New_01 - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");;
		personalDetailsPage=PageGenerator.getPersonalDetailsPage(driver);
		
		log.info("Add New_01 - Step 12: Open 'Employee List' Page");
		personalDetailsPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage=PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add New_01 - Step 13: Enter valid info to 'Employee Name' textbox");
		employeeListPage.enterToTextboxByID(driver, "empsearch_employee_name_empName", "");
		
		log.info("Add New_01 - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		
		log.info("Add New_01 - Step 15: Verify Employee Information displayed at ");
		verifyEquals(employeeListPage.getValueInTableAtColumnNameAndRowIndex(driver, "", "", ""), "");
	}
	
	@Test
	public void TC_02_Login() {
	}
	
	public WebDriver getWebDriver() {
		return this.driver;
	}

	@Parameters({"browser"})
	@AfterClass (alwaysRun=true)
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
