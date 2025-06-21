package campaign;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import objectrepository.CreateCampaignPage;
import objectrepository.HomePage;
import utilityclasses.BaseClass;
import utilityclasses.ExcelUtility;

@Listeners(utilityclasses.ListnerUtility.class)

public class CreateCampaignTest extends BaseClass {
	
	ExcelUtility excel=new ExcelUtility();
	
	@Test(groups={"smoke","Regression"})
	public void CreateCampaignWithMandatoryFieldsTest() throws InterruptedException, IOException {
		
		//Home Page
		HomePage  hp = new HomePage(driver);
		hp.getCreateCampaignBtn().click();
		
		//Create Campaign 
		CreateCampaignPage cp =new CreateCampaignPage(driver);
		cp.getCampaignNameTF().sendKeys(excel.readDataFromExcelFile("Campaign", 1, 2));
		cp.getTargetSizeTF().sendKeys(excel.readNumericDataFromExcelFile("Campaign", 1, 3));
		cp.getCreateCampaignSubmitBtn().click();

	}}