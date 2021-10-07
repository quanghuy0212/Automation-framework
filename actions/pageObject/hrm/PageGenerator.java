package pageObject.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGenerator extends BasePage {
	WebDriver driver;

	public static LoginPO getLoginPage(WebDriver driver) {

		return new LoginPO(driver);
	}
	
	public static AddEmployeePO getAddEmployeePage(WebDriver driver) {

		return new AddEmployeePO(driver);
	}
	
	public static DashboardPO getDashboardPage(WebDriver driver) {
		
		return new DashboardPO(driver);
	}
	
	public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
		
		return new EmployeeListPO(driver);
	}
	
	public static PersonalDetailsPO getPersonalDetailsPage(WebDriver driver) {
		
		return new PersonalDetailsPO(driver);
	}
}
