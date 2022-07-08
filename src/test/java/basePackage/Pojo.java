package basePackage;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pojo {

	public static WebDriver openChromeBrowser(String URL)
	{
		System.setProperty("webdriver.chrome.driver", "src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(URL);
		return driver;
	}
}
