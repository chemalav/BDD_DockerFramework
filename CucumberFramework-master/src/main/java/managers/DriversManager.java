package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import enums.DriverType;
import enums.EnvironmentType;

public class DriversManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	public DriversManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}
	
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}
	
	private WebDriver createDriver() {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}
	
	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private WebDriver createLocalDriver() {	
        switch (driverType) {
        case FIREFOX : 
        	driver = WebDriverManager.firefoxdriver().create();
	    	break;
        case CHROME : 
        	driver = WebDriverManager.chromedriver().create();
    		break;
        case INTERNETEXPLORER : 
        	driver = WebDriverManager.iedriver().create();
    		break;
		case CHROMIUM:
			driver = WebDriverManager.chromiumdriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		case OPERA:
			driver = WebDriverManager.operadriver().create();
			break;
		case SAFARI:
			driver = WebDriverManager.safaridriver().create();
		default:
			break;
        }
        
        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	
	
	public void quitDriver() {
		driver.close();
		//driver.quit();		
	}

}
