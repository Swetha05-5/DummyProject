package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeThreadPoolSize {
	
	 @Test(invocationCount = 5,threadPoolSize = 3) 
	 public void students() 
	 { 
		 WebDriver driver=new ChromeDriver();
		 Reporter.log("students",true); 
		 } 
	 }


