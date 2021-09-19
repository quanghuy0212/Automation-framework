package commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest extends BasePage {
	
	private WebDriver driver;
	private String projectLocation=System.getProperty("user.dir");
	private String osName= System.getProperty("os.name");
	
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
	
}
