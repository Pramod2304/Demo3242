package selenium_practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class execution_flow {
	
	@Test
	public void method1() {
		System.out.println("method=1 executed");
	}
	
	@BeforeMethod
	public void opening() {
		System.out.println("_______________");
		System.out.println("method opening");
	}
	
	@AfterMethod
	public void closing() {
		System.out.println("method closing");
		System.out.println("_______________");
	}
	
	@Test
	public void method2() {
		System.out.println("method=2 executed");
	}
	
	@BeforeClass
	public void classopen() {
		System.out.println("**************");
		System.out.println("class opening");
	}
	
	@AfterClass
	public void classclose() {
		System.out.println("class closing");
		System.out.println("**************");
	}
	
	@BeforeTest
	public void Testopen() {
		System.out.println("\\\\\\\\\\\\");
		System.out.println("test opening");
	}
	
	@AfterTest
	public void testclose() {
		System.out.println("test closing");
		System.out.println("/////////////");
	}
	
	@BeforeSuite
	public void suiteopen() {
		System.out.println("###########");
		System.out.println("suite open ");
		
	}
	
	@AfterSuite
	public void suiteclose() {
		System.out.println("suite close");
		System.out.println("############");
	}

}
