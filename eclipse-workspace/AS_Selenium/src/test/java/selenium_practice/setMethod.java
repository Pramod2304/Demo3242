package selenium_practice;


import java.util.HashSet;
import java.util.Set;


public class setMethod {

	
			public static void main(String[] args) {
				
		      Set<Object> s= new HashSet<Object>();
		      s.add("A");
		      s.add("A");s.add("D");s.add("B");s.add("A");
		      System.out.println(s.size());
			}
	}