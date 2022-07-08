package orangeHRMTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.Pojo;
import orangeHRM.HomePage;
import orangeHRM.LogIn;
import utilityPackage.Screenshot;

public class AdminValidation extends Pojo{

WebDriver driver;
	
	@BeforeSuite
	public void openBrowser()
	{
		   driver = openChromeBrowser("https://opensource-demo.orangehrmlive.com/index.php/auth/login");   
	}
	
	@BeforeTest
	public void logIn()
	{
		LogIn login = new LogIn(driver);
		login.sendUsername();
		login.sendpass();
		login.clickOnSignIn();
//		Screenshot screencap = new Screenshot();
//		screencap.getScreenshot();
	}

	@Test
	public void validateHomePage()
	{
		HomePage home = new HomePage(driver);
		home.validateAdminTab();
		home.validatePIMTab();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		HomePage homepage = new HomePage(driver);
	    homepage.clickOnAvatar();
	    homepage.clickOnLogOut();
	}
	
	
	
}
