package selenium_practice;

import org.testng.annotations.Test;

public class basicAnnotations {
	
	@Test(priority=0)                         
	public void testcase() {
		System.out.println("testcase=1");
	}
	
	@Test(priority=1)
	public void alphaTest1() {
		System.out.println("testcase=2");
		int i=betaTest1();
		System.out.println("betaTest executed="+i);
	}
	
	@Test(priority=-1)
	public int betaTest1() {
		System.out.println("betatest exeuted first");
		return 3;
	}

}
