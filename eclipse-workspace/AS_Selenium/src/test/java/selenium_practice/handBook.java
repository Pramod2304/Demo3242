package selenium_practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//handbook module 6

public class handBook {
	WebDriver driver;
	String browser="chrome",str1,str2,str3,str4;
	
	public static WebDriver browserLaunch(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\a.a.dhiman\\Sumit Wankhede\\Selenium Softwares\\Selenium Softwares\\SeleniumDrivers\\chromedriver.exe");
			return new ChromeDriver();
		}
		//Internet explorer browser
		else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\a.a.dhiman\\Sumit Wankhede\\Selenium Softwares\\Selenium Softwares\\SeleniumDrivers\\IEDriver.exe");
			return new InternetExplorerDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\a.a.dhiman\\Sumit Wankhede\\Selenium Softwares\\Selenium Softwares\\SeleniumDrivers\\geckodriver.exe");
			return new FirefoxDriver();
		}
		
		else
			return null;
	}
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		driver=handBook.browserLaunch(browser);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		System.out.println("TEST RUN IS SUCCESSFUL");
		Thread.sleep(5000);
		driver.close();
	}

	@Test         //CaseStudy Scenario 2:Login on TestMeApp
	public void TestMeApp() throws InterruptedException {
		driver.get("http://localhost:8013/TestMeApp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement aboutUs=driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/a/span"));
		WebElement office=driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/a/span"));
		WebElement sbc=driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/ul/li[2]/a/span"));
		//hovering on elements
		Thread.sleep(2000);
		Actions mouse=new Actions(driver);
		mouse.moveToElement(aboutUs).perform();
		Thread.sleep(2000);
		mouse.moveToElement(office).perform();
		Thread.sleep(2000);
		mouse.moveToElement(sbc).click().perform();;
		// switching windows
		Set<String> s=driver.getWindowHandles();
		Iterator<String> it=s.iterator();
		String mw=it.next();
		String tw=it.next();
		//switching to new window
		driver.switchTo().window(tw);
		Thread.sleep(3000);
		driver.switchTo().window(mw);
		Thread.sleep(3000);
		driver.switchTo().window(tw).close();
		driver.switchTo().window(mw);
		mouse.moveToElement(aboutUs).perform();
		Thread.sleep(3000);
		}


}
