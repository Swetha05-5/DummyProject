package campaign;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectrepository.ContactPage;
import objectrepository.CreateContactPage;
import objectrepository.HomePage;
import utilityclasses.BaseClass;
import utilityclasses.ExcelUtility;

@Listeners(utilityclasses.ListnerUtility.class)

public class CreateContactTest extends BaseClass {
	
	ExcelUtility excel=new ExcelUtility();
	
	@Test(groups="smoke")
	public void CreateContactWithMandatoryFieldsTest() throws InterruptedException, IOException {
		
		//Home Page
		ContactPage contact=new ContactPage(driver);
		contact.getContacts().click();
		
		//Create Contact
		
		CreateContactPage ctt =new CreateContactPage(driver);
		ctt.getCreateContactBtn().click();
		ctt.getOrganizationNameTF().sendKeys(excel.readDataFromExcelFile("Contact", 1, 4));
		ctt.getTitleTF().sendKeys(excel.readDataFromExcelFile("Contact", 1, 5));
		ctt.getContactNameTF().sendKeys(excel.readDataFromExcelFile("Contact", 1, 6));
		ctt.getMobileTF().sendKeys(excel.readNumericDataFromExcelFile("Contact", 1, 7));
		ctt.getCreateContactSubmitBtn();
	
		
		
		
	}}