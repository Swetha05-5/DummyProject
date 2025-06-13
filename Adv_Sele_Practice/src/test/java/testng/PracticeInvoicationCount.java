package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeInvoicationCount {
	
		@Test(invocationCount = 5) 
		public void students() { 
			Reporter.log("students",true); 
			} 
		}


