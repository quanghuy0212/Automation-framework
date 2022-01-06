package TestExercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01() {
		driver.get("https://bc-sf-filter-demo-1.myshopify.com/collections/tops");
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='boost-search-wrapper']//input[@type='search']")));
		driver.findElement(By.xpath("//div[@class='boost-search-wrapper']//input[@type='search']")).sendKeys("top");

		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='boost-pfs-search-suggestion-item boost-pfs-search-suggestion-item-product boost-pfs-ui-item']")));
		Assert.assertTrue(verifyProductIsDisplayed());
		
		
		 
	}

	public boolean verifyProductIsDisplayed() {
		List<WebElement> productNames = driver.findElements(By.xpath(
				"//li[@class='boost-pfs-search-suggestion-item boost-pfs-search-suggestion-item-product boost-pfs-ui-item']"));
		for (WebElement productName : productNames) {
			String nameOfProduct = productName.getAttribute("data-title");
			if (nameOfProduct.contains("top")) {
				return true;
			}
		}
		return false;

	}

	@AfterClass
	public void beforeTest() {
		driver.quit();
	}

}
