package takeScreenShot;

import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import reportConfig.ExtentTestListener;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

@Parameters({"browser","url"})
@Listeners(TestListener.class)
public class screenshotTestFailed_ReportNG extends BaseTest{
	WebDriver driver;
	String screenshotLocation=System.getProperty("user.dir") + "/screenshotReportNG/";
	String homePage;
	String projectLocation=System.getProperty("user.dir");
	String emailAddress="quanghuy" + randomEmail() +"@gmail.com";
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserdrivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage=driver.getCurrentUrl();
		
	}

	@Test
	public void TC_01_Register() {
		log.info("Click_To_Register_Link");
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		log.info("Click To Male Radio Button");
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		log.info("Input To FirstName Textbox");
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Quang");
		log.info("Input to LastName Textbox");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Huy");
		log.info("Input to Email Address");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress); 
		log.info("Input to Password");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		log.info("Input to Confirm Password");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");
		log.info("Click to Register Button");
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		log.info("Verify registration Success");
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Your registration completed']")).isDisplayed());
	}
	
	@Test
	public void TC_02_Login() {
		sleepInSecond(2);
		log.info("Click to Logout link");
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		log.info("Click to Login Link");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		log.info("Input to Email");
		driver.findElement(By.xpath("//input[@class='email']")).sendKeys(emailAddress);
		log.info("Input to Password");
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys("123456");
		log.info("Click to Login Button");
		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
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
	
	public int randomEmail() {
		Random ran= new Random();
		return ran.nextInt(999999);
	}
}
