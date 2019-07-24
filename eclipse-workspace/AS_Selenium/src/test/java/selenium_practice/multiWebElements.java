package selenium_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class multiWebElements {
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
		//WebElement droplocation=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select"));
		//Select dropdown=new Select(droplocation);
		List<WebElement>links=driver.findElements(By.tagName("a"));
		int p=links.size();
		System.out.println("No. of links ="+p);
		for(int i=0;i<p;++i) {
			if(!links.get(i).getText().equals(" "))
			System.out.println(links.get(i).getText());
		}
			
	}
	
	
	@AfterMethod
	public  void closeBrowser() {
		System.out.println("TEST RUN SUCCESSFUL");
		driver.close();
	}
	
	@BeforeMethod
	public void launch() throws InterruptedException {
		
		driver=dropList.getbrowser(browser);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}


}
