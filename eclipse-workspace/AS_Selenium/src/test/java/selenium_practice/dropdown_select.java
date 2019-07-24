package selenium_practice;

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

public class dropdown_select {
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
	public void mercuryLaunch() throws InterruptedException {
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		Thread.sleep(4000);
		WebElement droplocation=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select"));
		Select dropdown=new Select(droplocation); // select class to create drop down
		dropdown.selectByIndex(14);   //selecting using index value
		Thread.sleep(4000);
		dropdown.selectByValue("3"); // using html script to get the value
		Thread.sleep(4000);
		dropdown.selectByVisibleText("INDIA");// text in drop down
	    Thread.sleep(4000);
	}
	@AfterMethod
	public  void closeBrowser() {
		System.out.println("TEST RUN SUCCESSFUL");
		driver.close();
	}
	
	@BeforeMethod
	public void launch() throws InterruptedException {
		
		driver=dropdown_select.getbrowser(browser);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}


}
