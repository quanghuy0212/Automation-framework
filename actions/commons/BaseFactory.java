package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFactory {
	WebDriver driver;
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void acceptAlert(WebDriver driver) {
		alert=waitAlertPersence(driver);
		alert.accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		alert=waitAlertPersence(driver);
		alert.dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		alert=waitAlertPersence(driver);
		return alert.getText();
	}
	
	public Alert waitAlertPersence(WebDriver driver) {
		explicitWait=new WebDriverWait(driver,timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void clickToElement(WebDriver driver, WebElement webElement) {
		webElement.click();
	}
	
	public void sendkeyToElement(WebDriver driver, WebElement webElement, String value) {
		webElement.clear();
		webElement.sendKeys(value);
	}
	
	public void waitForElementVisible(WebDriver driver, WebElement webElement) {
		explicitWait=new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void waitForElementCLickable(WebDriver driver, WebElement webElement) {
		explicitWait=new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public boolean isElementDisplayed(WebDriver driver, WebElement webElement) {
		return webElement.isDisplayed();
	}
	
	
	private Alert alert;
	private Select select;
	private Actions action;
	private long timeout=15;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	
}
