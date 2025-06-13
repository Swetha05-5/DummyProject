package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticePriority {

	@Test(priority=-100) 
	public void students() { 
		Reporter.log("students",true); 
		} 
	@Test(priority = 1) 
		public void coolTeacher() { 
		Reporter.log("coolTeacher",true); 
		} 
	@Test(priority = 10) 
	public void Azim() { 
		Reporter.log("Azim",true); 
		} 
	@Test public void Deepanshu() { 
		Reporter.log("Deepanshu",true); 
		} 
	}

