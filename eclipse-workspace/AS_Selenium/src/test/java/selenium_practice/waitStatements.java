package selenium_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class waitStatements {
	String browser="chrome",str3,str1,str2;
	WebDriver driver;
	
	
	
		public static WebDriver getbrowser(String browser) {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.ie.driver","C:\\Users\\a.a.dhiman\\Sumit Wankhede\\Selenium Softwares\\Selenium Softwares\\SeleniumDrivers\\IEDriverServer.exe");
				return new InternetExplorerDriver();
			}
			
			else if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\a.a.dhiman\\Sumit Wankhede\\Selenium Softwares\\Selenium Softwares\\SeleniumDrivers\\chromedriver.exe");
				return new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\a.a.dhiman\\Sumit Wankhede\\Selenium Softwares\\Selenium Softwares\\SeleniumDrivers\\geckodriver.exe");
				return new FirefoxDriver();
				
			}
			else {
				return null;
			}
	}
	
		@BeforeMethod
	public void launch() throws InterruptedException {
		
		driver=autoLaunchBrowser.getbrowser(browser);
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public  void closeBrowser() {
		driver.close();
	}
	
	@Test
	public void methodCall() throws InterruptedException {
			str1=driver.getTitle();
			str2="Welcome: Mercury Tours";
			str3=driver.getCurrentUrl();
			Assert.assertEquals(str1, str2);
			System.out.println("atucal title="+str1);
			System.out.println("URL="+str3);
			driver.navigate().back();
			driver.navigate().forward();
			Thread.sleep(5000);
			driver.navigate().refresh();
	}

}
