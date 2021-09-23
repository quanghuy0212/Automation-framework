package commons;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.admin.nopcommerce.PageGeneratorManager;
import pageObject.admin.nopcommerce.ProductSearchPageObject;
import pageObjects.nopcommerce.LoginPageObjects;
import pageObjects.nopcommerce.MyAccountPageObjects;
import pageObjects.nopcommerce.OrdersPageObjects;
import pageObjects.nopcommerce.SearchPageObjects;
import pageUIs.admin.nopcommerce.AdminBasePageUI;
import pageUIs.admin.nopcommerce.DashBoardPageUI;
import pageUIs.user.nopcommerce.HomePageUI;

public class BasePage extends BasePageUI {

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
	
	public String castDynamicLocator(String locator, String...params) {
		return String.format(locator, (Object[])params);
	}
	
	
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator,String... params) {
		getElement(driver, castDynamicLocator(locator, params)).click();
	}
	
	
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value, String...params ) {
		locator=castDynamicLocator(locator, params);
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	
	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public int getElementSize(WebDriver driver, String locator,String... params) {
		return getElements(driver, castDynamicLocator(locator, params)).size();
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public WebElement getElement(WebDriver driver, String locator,String... params) {
		return driver.findElement(getByXpath(castDynamicLocator(locator, params)));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public void selectDropdownByText(WebDriver driver, String locator, String itemText) {
		select=new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}
	
	public String getSelectedItemDropdown(WebDriver driver, String locator) {
		select=new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select=new Select(getElement(driver, locator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, timeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	public String getAttributeValue(WebDriver driver,String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getAttributeValue(WebDriver driver,String locator, String attributeName,String... params) {
		return getElement(driver, castDynamicLocator(locator, params)).getAttribute(attributeName);
	}
	
	public String getTextElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	
	public String getTextElement(WebDriver driver, String locator, String... params) {
		return getElement(driver, castDynamicLocator(locator, params)).getText();
	}
	
	public void checktoCheckboxOrRadio(WebDriver driver, String locator) {
		if(!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String locator) {
		if(isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}
	
	public By getCssValue(String locator) {
		return By.cssSelector(locator);
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
		return getElement(driver, castDynamicLocator(locator, params)).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
		
	}
	
	public void isElementEnable(WebDriver driver, String locator) {
		getElement(driver, locator).isEnabled();
	}
	
	public WebDriver switchToIframeByElement(WebDriver driver, String locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}
	
	public WebDriver switchToDefaultContent(WebDriver driver) {
		return driver.switchTo().defaultContent();
	}
	
	public void hovertoElement(WebDriver driver, String locator) {
		action=new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();;
	}
	
	public void doubleClicktoElement(WebDriver driver, String locator){
		action=new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locator) {
		action=new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}
	
	public void dragAndDropElement(WebDriver driver, String locator, String sourceLocator, String targetLocator) {
		action=new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		action=new Actions(driver);
		action.sendKeys(getElement(driver, locator),key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... params) {
		action=new Actions(driver);
		locator=castDynamicLocator(locator, params);
		action.sendKeys(getElement(driver, locator),key).perform();
	}
	
	public void updateFile(WebDriver driver, String locator, String filename) {
		getElement(driver, "//input[@type='file'").sendKeys(filename);
	}
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}
	
	

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait=new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		explicitWait=new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(castDynamicLocator(locator, params))));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locator) {
		explicitWait=new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	public void waitForElementCLickable(WebDriver driver, String locator) {
		explicitWait=new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementCLickable(WebDriver driver, String locator, String...params) {
		explicitWait=new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(castDynamicLocator(locator, params))));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait=new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator, String... params) {
		explicitWait=new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(castDynamicLocator(locator, params))));
	}
	
	public void waitForAllElementInvisible(WebDriver driver, String locator) {
		explicitWait=new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time*1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public SearchPageObjects openSearchPage(WebDriver driver) {
		waitForElementCLickable(driver,BasePageUI.SEARCH_PAGE_LINK);
		clickToElement(driver, BasePageUI.SEARCH_PAGE_LINK);
		return new SearchPageObjects(driver);
		
	}
	
	public OrdersPageObjects openOrdersPage(WebDriver driver) {
		waitForElementCLickable(driver,BasePageUI.ORDERS_PAGE_LINK);
		clickToElement(driver, BasePageUI.ORDERS_PAGE_LINK);
		return new OrdersPageObjects(driver);
		
	}
	
	public MyAccountPageObjects openMyAccountPage(WebDriver driver) {
		waitForElementCLickable(driver,BasePageUI.MYACCOUNT_PAGE_LINK);
		clickToElement(driver, BasePageUI.MYACCOUNT_PAGE_LINK);
		return new MyAccountPageObjects(driver);
		
	}
	
	public void openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementCLickable(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
	}
	
	//Admin Nopcommerce
	public void uploadMultipleFiles(WebDriver driver,String cardname, String... fileNames) {
		String filePath=GlobalConstants.UPLOAD_FOLDER_PATH;
		String fullFileName="";
		for (String file : fileNames) {
			fullFileName=fullFileName+filePath + file + "\n";
		}
		fullFileName=fullFileName.trim();
		
		getElement(driver, AdminBasePageUI.UPLOAD_FILE_BY_CARD_NAME, cardname).sendKeys(fullFileName);

	}
	
	public ProductSearchPageObject openSubMenuPageByName(WebDriver driver,String menuName, String subMenuName) {
		waitForElementVisible(driver, AdminBasePageUI.MENU_PAGE_BY_NAME, menuName);
		clickToElement(driver, AdminBasePageUI.MENU_PAGE_BY_NAME, menuName);
		waitForElementVisible(driver, AdminBasePageUI.SUB_MENU_BY_NAME, subMenuName);
		clickToElement(driver, AdminBasePageUI.SUB_MENU_BY_NAME, subMenuName);
		return PageGeneratorManager.getSearchProductPage(driver);
	}
	
	public void waitToElementInvisible(WebDriver driver,String locator) {
		By byLocator=By.xpath(locator);
		explicitWait=new WebDriverWait(driver,shortTimeout);
		System.out.println("Start time for wait invisible= " + new Date().toString());
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		System.out.println("End time for waith invisible = " + new Date().toString());
		
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		System.out.println("Start time=" + new Date().toString());
		List<WebElement>elements=getElements(driver,locator);
		if(elements.size()==0) {
			System.out.println("Element not in DOM");
			System.out.println("End time=" + new Date().toString());
			return true;
		}
		else if(elements.size()>0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in Dom but not visible/displayed");
			System.out.println("End time=" + new Date().toString());
			return true;
		}else {
			System.out.println("Element in Dom and visible");
			return false;
		}
		
	}
	
	private Alert alert;
	private Select select;
	private Actions action;
	private long timeout=15;
	private long shortTimeout=5;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
