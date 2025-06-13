package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeDependsOn {
	WebDriver driver; 
	
	@Test 
	public void students() { 
		driver=new ChromeDriver(); 
		Reporter.log("students",true); 
		} 
	
	@Test 
	public void staffs() { 
		driver=new ChromeDriver(); 
		Reporter.log("staffs",true); 
		} 
	
	@Test(dependsOnMethods = {"students","staffs"}) 
	public void advancedSelenium() { 
		driver.get("https://www.instagram.com/"); 
		Reporter.log("advancedSelenium",true); } 
	
	
	@Test(dependsOnMethods = {"advancedSelenium","students"}) 
	public void test() { 
		driver.findElement(By.name("username")).sendKeys("asdfghjkl"); 
		Reporter.log("test",true); } 
	
	
	@Test(priority = -10) 
	public void system() { 
		Reporter.log("lkjhgfdsa",true); 
		} 
}
