package selenium_practice;

import static org.testng.Assert.assertEqualsNoOrder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {
	WebDriver driver;
	String browser="chrome",stremail,str1,str2;
	boolean check=false;
	
	public static WebDriver OpenBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\a.a.dhiman\\Sumit Wankhede\\Selenium Softwares\\Selenium Softwares\\SeleniumDrivers\\chromedriver.exe");
			return new ChromeDriver();
		}
		else 
			return null;
	}
	
	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException {
		driver=TestNG.OpenBrowser(browser);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closeDriver() throws InterruptedException {
		Thread.sleep(3000);
		//driver.close();
	}
	
	@Test(priority=1, enabled=false)
	public void RegisterOnMercury() throws InterruptedException {
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
		//Home page verification
		Assert.assertEquals(driver.getTitle(),"Register: Mercury Tours");
		
		//Filling registration details
		driver.findElement(By.name("firstName")).sendKeys("Abhishek"); Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("done");
		driver.switchTo().defaultContent();
		driver.findElement(By.name("lastName")).sendKeys("Dhiman"); Thread.sleep(2000);
		driver.findElement(By.name("phone")).sendKeys("8951381845"); Thread.sleep(2000);
		
		//WebElement for userName text field
		WebElement email=driver.findElement(By.id("userName"));
		email.sendKeys("ateamas007@gmail.com"); Thread.sleep(2000);
		stremail=email.getText();		
		
		
		if(stremail=="ateamas009@gmail.com") {
			/*Alert alert1=driver.switchTo().alert();
			alert1.sendKeys("Email already exit");
			driver.switchTo().defaultContent();*/
			System.out.println("Email already exist");
		}
		else if(stremail==null){
			/*Alert alert2=driver.switchTo().alert();
			alert2.sendKeys("field is empty");
			driver.switchTo().defaultContent();*/
			System.out.println("Field cannot be empty");
		} 
		else {
		driver.findElement(By.name("address1")).sendKeys("SMQ 1087-1");
		driver.findElement(By.name("address2")).sendKeys("Air Force Station");
		driver.findElement(By.name("city")).sendKeys("BHUJ"); Thread.sleep(2000);
		driver.findElement(By.name("state")).sendKeys("Gujarat"); Thread.sleep(2000);
		driver.findElement(By.name("postalCode")).sendKeys("370001"); Thread.sleep(2000);
		
		//country drop box
		Thread.sleep(2000);
		WebElement Country=driver.findElement(By.name("country"));
		Select drop=new Select(Country);
		drop.selectByVisibleText("INDIA"); Thread.sleep(2000);
		
		//user information
		driver.findElement(By.id("email")).sendKeys("asabhishek"); Thread.sleep(2000);
		WebElement pwd=driver.findElement(By.name("password")); 
		pwd.sendKeys("password456"); Thread.sleep(2000);
		driver.findElement(By.name("confirmPassword")).sendKeys("password456");Thread.sleep(2000);
		System.out.println(str1);
		
		//password and confirm password verification
		Assert.assertEquals(pwd.getText(),"password456");
		System.out.println("Confirmed");
		driver.findElement(By.name("register")).click();
		// Alert message
		//Alert alert3=driver.switchTo().alert();
		System.out.println("Registration is successful");
		//driver.switchTo().defaultContent();
		}
		
	}
	
	@Test(priority=2)
	public void AutomateLogin() throws InterruptedException {
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		
		//Adding implicit time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("userName")).sendKeys("mercury"); Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("mercury"); Thread.sleep(2000);
		driver.findElement(By.name("login")).click();
		str2=driver.getTitle();
		
		//login page title verification
		Assert.assertEquals(str2,"Find a Flight: Mercury Tours:");
		System.out.println("Login page matched");
	
	}
	
	

}
//JavascriptExecutor js=(JavascriptExecutor) driver;
//js.executeScript("alert("this a warning")");
