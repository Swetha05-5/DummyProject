package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWithAssertions {
	
	@Test 
	public void test() { 
		Assert.assertEquals("hdfc","hfdc"); 
		System.out.println("next line"); 
		} 

}

 class WorkingWithAssertions2 { 
	
	 @Test 
	public void test() { 
		SoftAssert soft=new SoftAssert(); 
		soft.assertEquals("hdfc","hfdc"); 
		System.out.println("next line"); 
		soft.assertAll(); 
		} 
	}