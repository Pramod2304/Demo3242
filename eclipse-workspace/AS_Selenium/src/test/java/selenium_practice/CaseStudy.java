package selenium_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CaseStudy {
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
		driver=CaseStudy.browserLaunch(browser);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		System.out.println("TEST RUN IS SUCCESSFUL");
		Thread.sleep(5000);
	}
	
	@Test         //CaseStudy Scenario 1:Register on TestMeApp
	public void TestMeApp() throws InterruptedException {   
		driver.get("http://localhost:8013/TestMeApp");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("sigmasix007");
		//username error
		driver.findElement(By.id("firstName")).sendKeys("Abhishek");
		WebElement err=driver.findElement(By.id("err"));
		//checking availability of username
		str4=err.getText();
		if(str4.equalsIgnoreCase("Available")){
			driver.findElement(By.id("lastName")).sendKeys("Dhiman");
			driver.findElement(By.name("password")).sendKeys("abhishek");
			driver.findElement(By.xpath("//*[@id=\"pass_confirmation\"]")).sendKeys("abhishek");
			driver.findElement(By.xpath("//*[@id=\"gender\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("ateamas09@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("8951381845");
			driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[9]/div/div/img")).click();
			WebElement month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
			Select drop=new Select(month);
			drop.selectByVisibleText("Jul");
			WebElement year=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"));
			Select drop1=new Select(year);
			drop1.selectByVisibleText("1996");
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[5]/a")).click();
			driver.findElement(By.id("address")).sendKeys("DDC2, ground floor, gurugram");
			//security question
			WebElement question=driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]"));
			Select drop2=new Select(question);
			drop2.selectByIndex(0);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"answer\"]")).sendKeys("Sonipat");
			driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[13]/div/input[1]")).click();
			Thread.sleep(5000);
		}
		else {
			Thread.sleep(5000);
			System.out.println("enter new user name");
			driver.close();
		}
			
	}
	

}
