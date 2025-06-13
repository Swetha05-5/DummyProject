package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeEnabled {
	 @Test(enabled = false) 
	 public void students() { 
		 Reporter.log("students",true); 
		 } 
	 }

