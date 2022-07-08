package hotstarTesting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hotstar.LogoValidation;

public class ValidateLogos {

WebDriver driver;
	
	public String timestamp()
	{
		return new SimpleDateFormat("yyyy-MM-dd_hhmmss").format(new Date());
	}
	
	public void ss() throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\eclipse\\ss\\image"+timestamp()+".jpg");
		FileHandler.copy(source, dest);
		
	}
	
	
	@BeforeClass
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.hotstar.com/in");
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void validateDisneyTab() throws IOException, InterruptedException
	{
		LogoValidation logo = new LogoValidation(driver);
		logo.clickOnDisneyTab();
		ss();
	}
	
	@Test(priority=2)
	public void validateDisneyLogo() throws IOException, InterruptedException
	{
		LogoValidation logo = new LogoValidation(driver);
		logo.clickOnDisneyLogo();
	}
	
	@Test(priority=0)
	public void validateKidsLogo() throws IOException, InterruptedException
	{
		LogoValidation logo = new LogoValidation(driver);
		logo.clickOnKidsLogo();
		ss();
	}
	
	
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
