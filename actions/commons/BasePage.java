package commons;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void getUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
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
	
	public void sendkeyToAlert(WebDriver driver, String value) {
		alert=driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	public Alert waitAlertPersence(WebDriver driver) {
		explicitWait=new WebDriverWait(driver,timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindowsID=driver.getWindowHandles();
		for (String windowID : allWindowsID) {
			if(!windowID.equals(parentID)) {
				driver.switchTo().window(windowID);
				break;
			}
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver, String tabTitle) {
		Set<String> allwindowsID= driver.getWindowHandles();
		for (String id : allwindowsID) {
			driver.switchTo().window(id);
			String actualTitle=driver.getTitle();
			if(actualTitle.equals(tabTitle)) {
				break;
			}
		}
	}
	
	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> allwindowsID=driver.getWindowHandles();
		for (String id : allwindowsID) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time*1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	private Alert alert;
	private WebDriverWait explicitWait;
	private long timeout=15;
}
