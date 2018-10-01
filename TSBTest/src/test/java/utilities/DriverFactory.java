package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	public static WebDriver open(String browserType) {
		if(browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sanjot\\Downloads\\geckodriver-v0.22.0-win64\\geckodriver.exe");	
			return new FirefoxDriver();
		}
		
		else if (browserType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Sanjot\\Downloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");	
			return new InternetExplorerDriver();
			
		}
		else {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sanjot\\Downloads\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
		}
		
		}

}
