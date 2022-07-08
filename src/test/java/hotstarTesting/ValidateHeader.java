package hotstarTesting;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import basePackage.Pojo;
import hotstar.HeaderValidation;

public class ValidateHeader extends Pojo {

WebDriver driver;
	
	@BeforeSuite
	public void openBrowser()
	{
		driver = openChromeBrowser("https://www.hotstar.com/in");
		
	}

	@Test 
	public void validateOptionTab() 
	{
		HeaderValidation option = new HeaderValidation(driver);
		option.clickOnHamburger();
		
	}
	
	@Test (priority=1, dependsOnMethods= {"validateOptionTab"})
	public void validateGenresTab() 
	{
		HeaderValidation genres = new HeaderValidation(driver);
		genres.moveToGenres();
		
	}
	
	@Test (priority=2, dependsOnMethods= {"validateOptionTab"})
	public void validateChannels() 
	{
		HeaderValidation channels = new HeaderValidation(driver);
		channels.moveToChannels();
		
	}
	
	@Test(priority=3, dependsOnMethods= {"validateOptionTab"})
	public void validateLanguages() 
	{
		HeaderValidation languages = new HeaderValidation(driver);
		languages.moveToLanguages();
		
	}
	
	@Test (priority =10)
	public void takeScreenshot() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		HeaderValidation header = new HeaderValidation(driver);
		header.validateHeader();
	}
	
	@Test(priority=5)
	public void ValidateOtherTabs() throws InterruptedException
	{
		HeaderValidation header = new HeaderValidation(driver);
        header.moveToOtherTabs();
        Thread.sleep(3000);
        header.enterSearchField();
	}
	
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{   
		Thread.sleep(2000);
		driver.quit();
	}
}
