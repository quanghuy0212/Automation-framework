package commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class BaseTest extends BasePage {
	
	private WebDriver driver;
	private String projectLocation=System.getProperty("user.dir");
	private String osName= System.getProperty("os.name");
	protected final Log log;
	
	protected BaseTest() {
		log=LogFactory.getLog(getClass());
	}
	
	
	public enum BROWSER{
		CHROME,FIREFOX,IE,SAFARI,EDGE, EDGE_CHROMIUM,H_CHROME,H_FIREFOX;
	}
	
	public enum OS{
		WIN,MAC_OSX,LINUX
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		BROWSER browser= BROWSER.valueOf(browserName.toUpperCase());
		if(browser==BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserdrivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("Driver init at Base Test =" + driver.toString());
			}
		else if(browser==BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserdrivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser==BROWSER.EDGE) {
			System.setProperty("webdriver.edge.driver", projectLocation + "\\browserdrivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else {
			throw new RuntimeException("please enter correct browser name");
		}
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BROWSER browser= BROWSER.valueOf(browserName.toUpperCase());
		if(browser==BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectLocation + getSlash("browserdrivers") + "geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("Driver init at Base Test =" + driver.toString());
			}
		else if(browser==BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver", projectLocation + getSlash("browserdrivers") + "chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser==BROWSER.EDGE) {
			System.setProperty("webdriver.edge.driver", projectLocation + getSlash("browserdrivers") + "msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else {
			throw new RuntimeException("please enter correct browser name");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}
	
	private String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else if (isWindows()) {
			folderName = "\\" + folderName + "\\";
		} else {
			folderName = null;
		}
		return folderName;
	}
	
	private String getSlash(String folderName) {
		String separator=File.separator;
		return separator + folderName + separator;
	}
	

	private boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0);
	}

	private boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	
}
