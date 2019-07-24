package selenium_practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class alertmsg {                        

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
	public void alertLaunch() throws InterruptedException{
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Thread.sleep(4000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("alert","box");
		
		/*driver.findElement(By.name("proceed")).click();
		Thread.sleep(5000);
		Alert a=driver.switchTo().alert();
		String alertText=a.getText();
		Thread.sleep(5000);
		System.out.println(alertText);
		a.accept();
		driver.findElement(By.xpath("//*[@id=\"login1\"]")).sendKeys("sigmasix09@gmail.com");
		Thread.sleep(5000);*/
		
	}
	
	
	@AfterMethod
	public  void closeBrowser() {
		System.out.println("TEST RUN SUCCESSFUL");
		driver.close();
	}
	
	@BeforeMethod
	public void launch() throws InterruptedException {
		
		driver=alertmsg.getbrowser(browser);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
}
