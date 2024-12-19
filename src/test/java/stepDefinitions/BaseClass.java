package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.ebayCart_page;
import utilities.CommonUtilities;

public class BaseClass {

	WebDriver ldriver;
	Properties config;
	CommonUtilities utilities;

	// Page objects
	static ebayCart_page ebayPage;

	// ***Methods**//

	// Opening browser
	public void setUp() throws IOException {
		if (ldriver == null) {
			// Load properties file
			config = new Properties();
			FileInputStream configData = new FileInputStream("src/test/resources/properties/config.properties");
			config.load(configData);

			// getting the browse from config
			String browserType = config.getProperty("browser");

			// Launch browser
			if (browserType.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", config.getProperty("chromepath"));
				// ChromeOptions options = new ChromeOptions();
				ldriver = new ChromeDriver();
			}

		}

	}
	
	//launching url
	public void launchApplication() {
		
		String url = config.getProperty("url");
		ldriver.get(url);
		
		//maximize
		ldriver.manage().window().maximize();
			
	}
	
	//close all browsers
	public void closeBrowser() {
	if(ldriver!= null) {
		ldriver.quit();
	}
	}

}
