package selenium_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class switchLaunch {
	String browser="firefox";
	WebDriver driver;
	
	public static WebDriver getbrowser(String browser) {
		switch(browser) {
		case "IE":{
			System.setProperty("webdriver.ie.driver","C:\\Users\\a.a.dhiman\\Sumit Wankhede\\Selenium Softwares\\Selenium Softwares\\SeleniumDrivers\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		
		case "chrome": {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\a.a.dhiman\\Sumit Wankhede\\Selenium Softwares\\Selenium Softwares\\SeleniumDrivers\\chromedriver.exe");
			return new ChromeDriver();
		}
		case "firefox": {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\a.a.dhiman\\Sumit Wankhede\\Selenium Softwares\\Selenium Softwares\\SeleniumDrivers\\geckodriver.exe");
			return new FirefoxDriver();
			
		}
		default: {
			return null;
		}
		}
	}
	@Test
	public void launch() {
		
		driver=autoLaunchBrowser.getbrowser(browser);
		driver.get("http://www.amazon.in");
		driver.close();
	}


}
