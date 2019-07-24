package selenium_practice;

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

public class CaseStudy2 {
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
		driver=CaseStudy2.browserLaunch(browser);
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
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("sigmasix007");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abhishek");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
		Actions mouse=new Actions(driver);
		//all categories
		WebElement category=driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"));
		WebElement subCat=driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a"));
		mouse.moveToElement(category).click().perform();
		Thread.sleep(2000);
		// hovering mouse to sub category
		mouse.moveToElement(subCat).click().perform();
		Thread.sleep(2000);
		//selecting head
		driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span")).click();
		Thread.sleep(2000);
		//adding to cart
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		Thread.sleep(2000);
		//checking cart
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
		Thread.sleep(2000);
		//check out for billing
		driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
		Thread.sleep(2000);
		//signout
		driver.findElement(By.xpath("/html/body/header/div/div/ul/b/a[2]")).click();
		Thread.sleep(2000);
	
		
		}

}
