package hotstarTesting;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hotstar.TVTabValidation;

public class ValidateTVTab {
	
WebDriver driver;
	
	@BeforeClass
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.hotstar.com/in");
		driver.manage().window().maximize();
	}
	
	@Test
	public void validateTV()
	{
		TVTabValidation TV = new TVTabValidation(driver);
		TV.hoverOverTV();
	}
	
	@Test(priority=1, dependsOnMethods = {"validateTV"})
	public void validateOtherShows() throws InterruptedException
	{
		TVTabValidation other_shows = new TVTabValidation(driver);
		other_shows.hoverOverOtherShows();
		Thread.sleep(1000);
	}

	@Test(priority=2, dependsOnMethods = {"validateTV"})
	public void validateHotstarSpecials() throws InterruptedException
	{
		TVTabValidation hotstar_specials = new TVTabValidation(driver);
		hotstar_specials.hoverOverHotstarSpecials();
		Thread.sleep(1500);
	}
	
	@Test(priority=3, dependsOnMethods = {"validateTV"})
	public void validateQuix() throws InterruptedException
	{
		TVTabValidation quix = new TVTabValidation(driver);
		quix.hoverOverQuix();
		Thread.sleep(1500);
	}
	
	@Test(priority=4, dependsOnMethods = {"validateTV"})
	public void validateMore() throws InterruptedException
	{
		TVTabValidation more = new TVTabValidation(driver);
		more.hoverOvermore();
		Thread.sleep(1500);
	}
	
	@Test(priority=5, dependsOnMethods = {"validateHotstarSpecials"})
	public void takeScreenshot() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		TVTabValidation ss = new TVTabValidation(driver);
		ss.getScreenshot();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
