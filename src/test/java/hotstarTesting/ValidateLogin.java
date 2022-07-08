package hotstarTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hotstar.LoginValidation;

public class ValidateLogin {
	
	public class LoginTest {
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
		public void validateLogin()
		{
			LoginValidation login = new LoginValidation(driver);
			login.initiateLogin();
		}
		
		@AfterClass
		public void closeBrowser()
		{
			driver.quit();
		}

	}
}
