package selenium_practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderMethod {
	
	
	@Test(dataProvider="dataInUse")
	public void testCase(String pname,String ppass) {
		System.out.println(pname+"------"+ppass);
	}
	
	@DataProvider(name="dataInUse")
	public Object[][] gettingData(){
		Object obj[][]= {{"Abhishek","001"},{"Tushar","002"},{"Parul","003"}};
		return obj;
		
	}

}
