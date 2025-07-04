package utilityclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectrepository.HomePage;
import objectrepository.LoginPage;

public class BaseClass {
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;//Static driver that we have created to use in Listener implementation class
	
	@BeforeSuite(groups="smoke")
	public void beforeSuite() {
		System.out.println("Establish the database connection");

	}

	@BeforeTest(groups="smoke")
	public void beforeTest() {
		System.out.println("precondition");
	}

	//@Parameters("Browser")
	@BeforeClass(groups="smoke")
	//public void beforeClass(String browser) throws IOException {
		public void beforeClass() throws IOException {
		String browser = pLib.readDataFromPropertiesFile("Browser");
		System.out.println("Received browser:" + browser);
		if (browser.equalsIgnoreCase("CHROME"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		else if (browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("Safari"))
			driver = new SafariDriver();
		sdriver=driver;//Passing the driver reference to the static driver variable
		System.out.println("Launch the browser");
		System.out.println("Launched browser:" + browser);
		
	}

	@BeforeMethod(groups="smoke")
	public void beforeMethod() throws IOException {
		String url=System.getProperty("url");
		//String url = pLib.readDataFromPropertiesFile("Url");
		String username=System.getProperty("Username");
		//String username = pLib.readDataFromPropertiesFile("Username");
		String password=System.getProperty("Password");
		//String password = pLib.readDataFromPropertiesFile("Password");
	    LoginPage lp = new LoginPage(driver);
		lp.Login(url, username, password);
		System.out.println("Login");
	}

	@AfterMethod(groups="smoke")
	public void afterMethod() {
        HomePage hp = new HomePage(driver);
		hp.logout();
		System.out.println("Logout");
	}

	@AfterClass(groups="smoke")
	public void afterClass() {
		driver.quit();
		System.out.println("Close the browser");
	}

	@AfterTest(groups="smoke")
	public void afterTest() {
		System.out.println("Post condition");
	}

	@AfterSuite(groups="smoke")
	public void afterSuite() {
		System.out.println("Close database connection");
	}

}