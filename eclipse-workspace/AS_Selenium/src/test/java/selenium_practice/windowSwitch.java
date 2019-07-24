package selenium_practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class windowSwitch {
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
		driver.get("https://www.licindia.in/");
		driver.findElement(By.xpath("//*[@id=\"socialThings2\"]/ul/li[1]/a/img")).click();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> it=s.iterator();
		String mw=it.next();
		String tw=it.next();
		//switching to facebook
		driver.switchTo().window(tw);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("sigmasix");
		Thread.sleep(5000);
		driver.switchTo().window(mw);
		Thread.sleep(3000);
		driver.switchTo().window(tw);
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(3000);
		
		//switch to main window
		driver.switchTo().window(mw);
		driver.findElement(By.xpath("//*[@id=\"socialThings2\"]/ul/li[2]/a/img")).click();
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> itt=s1.iterator();
		String mww=itt.next();
		String tw1=itt.next();
		
		//switching to twitter
		driver.switchTo().window(tw1);Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"signin-dropdown\"]/div[3]/form/div[1]/input")).sendKeys("ASHU");
		Thread.sleep(3000);
		driver.switchTo().window(mww);
		Thread.sleep(3000);
		driver.switchTo().window(tw1);
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(3000);
	}
	
	
	@AfterMethod
	public  void closeBrowser() {
		System.out.println("TEST RUN SUCCESSFUL");
		driver.quit();
	}
	
	@BeforeMethod
	public void launch() throws InterruptedException {
		
		driver=windowSwitch.getbrowser(browser);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}


}
