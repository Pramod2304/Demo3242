package selenium_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class handBook1 {
	WebDriver driver;
	String browser="chrome",str1,str2,str3,str4,str5;
	
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
		driver=handBook1.browserLaunch(browser);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		System.out.println("TEST RUN IS SUCCESSFUL");
		Thread.sleep(5000);
		driver.close();
	}

	@Test(dataProvider="loginParameter")         //CaseStudy Scenario 2:Login on TestMeApp
	public void TestMeApp(String uname,String pword) throws InterruptedException {
		driver.get("http://newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement username1=driver.findElement(By.name("userName"));
		WebElement password1=driver.findElement(By.name("password"));
		WebElement signIn=driver.findElement(By.name("login"));
		
		if(uname.equals("sigmasix")&&(pword.equals("ashu"))) {
			//entering userName
			username1.sendKeys(uname);
			Thread.sleep(2000);
			//entering password
			password1.sendKeys(pword);
			Thread.sleep(2000);
			signIn.click();
			Thread.sleep(2000);	
			str4="Find a Flight: Mercury Tours:";
			//str5="http://newtours.demoaut.com/mercuryreservation.php?osCsid=a57509030937c5c0a8d79b4735d31da9";
			//checking for title of the page
			Assert.assertEquals(driver.getTitle(), str4);
			System.out.println("Title matches");
			//checking for URL
			//Assert.assertEquals(driver.getCurrentUrl(), str5);
			//System.out.println("URL matches");
			Thread.sleep(3000);
		}
		else
			System.out.println("Invalid user credentials");
		
	}

	@DataProvider(name="loginParameter")
	public Object[][] login(){
		Object obj[][]= {{"sigmasix","ashu"},{"mercury","merccury"},{"tushar","tushar"}};
		return obj;
	}

}
