package orangeHRMTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import basePackage.Pojo;
import orangeHRM.HomePage;
import orangeHRM.LogIn;
import orangeHRM.RecruitmentPage;

public class RecruitmentPageValidation extends Pojo {
	
WebDriver driver;
	

//@BeforeSuite
//public void openBrowser()
//{
//	   driver = openChromeBrowser("https://opensource-demo.orangehrmlive.com/index.php/auth/login");   
//}




    @BeforeClass
    public void logIn()
    {
	    LogIn login = new LogIn(driver);
	    login.sendUsername();
	    login.sendpass();
	    login.clickOnSignIn();
//     	Screenshot screencap = new Screenshot();
//	    screencap.getScreenshot();
    }
	
	@Test
	public void validateRecruitmentPage()
	{
		RecruitmentPage recruit = new RecruitmentPage(driver);
		recruit.goToRecruitmentPage();
		recruit.selectJobTitle();
		recruit.selectVacancy();
		recruit.selectHiringManager();
		recruit.selectStatus();
		recruit.clickSearch();
	}
	
	@Test(priority=1)
	public void addVacancy()
	{
		RecruitmentPage recruit = new RecruitmentPage(driver);
		recruit.goToRecruitmentPage();
        recruit.clickAddToAddVacancy();
        recruit.enterData();
        recruit.validateAddedVacancy();
//        Assert.assertEquals(true, true);
	}
	
//	@AfterTest
//	public void logout()
//	{
//		HomePage home = new HomePage(driver);
//		home.clickOnAvatar();
//		home.clickOnLogOut();
//	}
	
	@AfterSuite
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
