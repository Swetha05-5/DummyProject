package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "loginDetails") 
	public void login(String userName,String password) { 
		System.out.println(userName+"-->"+password); } 
	
	@DataProvider 
	public Object[][] loginDetails(){ 
		Object[][] objArr=new Object[4][2]; 
		objArr[0][0]="Kavya"; 
		objArr[0][1]="K@123"; 
		objArr[1][0]="Blessy"; 
		objArr[1][1]="B@123"; 
		objArr[2][0]="Shrikanth"; 
		objArr[2][1]="S@123"; 
		objArr[3][0]="Azim"; 
		objArr[3][1]="A@123"; 
		return objArr; } 

}
