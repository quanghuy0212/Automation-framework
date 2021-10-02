package takeScreenShot;

import org.testng.annotations.Test;

import commons.BaseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Listeners(TestListener.class)
public class screenshotTestFailed2_Extent_Report extends BaseTest{
	
	WebDriver driver;
	String screenshotLocation=System.getProperty("user.dir") + "/screenshotReportNG/";
	String homePage;
	String projectLocation=System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserdrivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage=driver.getCurrentUrl();
	}

	@Test
	public void Tc_01() {
		log.info("Check Text 01");
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()=\"Hình ảnh\"]")).getText(),"Hình ảnh");
		log.info("Check text 02");
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()=\"Gmail\"]")).getText(),"Gmail");
	}
	
	@Test
	public void TC_02() {
		log.info("check text 03");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='SIvCob' and text()='Google có các thứ tiếng:  ']")).getText(),"Google");
		
	}
	
	public WebDriver getWebDriver() {
		return this.driver;
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
