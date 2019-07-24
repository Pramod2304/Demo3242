package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class objectInteraction {
	WebDriver driver;
	String browser="chrome",str3,str1,str2;
	
	public static WebDriver getbrowser(String browser) {
		if(browser.equalsIgnoreCase("IE")){
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
	
	@Test
	public void object() throws InterruptedException {
	driver.get("https://www.flipkart.com/");
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div/div[2]/form/div/div[1]/div/input")).sendKeys("sports shoes");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div/div[2]/form/div/div[2]/button")).click();
	Thread.sleep(5000);
	}
	
	@AfterMethod
	public  void closeBrowser() {
		driver.close();
	}
	
	@BeforeMethod
	public void launch() throws InterruptedException {
		
		driver=objectInteraction.getbrowser(browser);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
		
		

}
