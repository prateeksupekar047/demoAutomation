package hotstar;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TVTabValidation {

	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	@FindBy(xpath = "//div[text()='TV']")
	WebElement TV;
	
	@FindBy(xpath = "//a[text()='Other Shows']")
	WebElement other_shows;
	
	@FindBy(xpath = "//a[text()='Hotstar Specials']")
	WebElement hotstar_specials;
	
	@FindBy(xpath = "//a[text()='Quix']")
	WebElement quix;
	
	@FindBy(xpath = "//a[text()='more...']")
	WebElement more;
	
	public TVTabValidation(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		act = new Actions(driver);
	}
	
	public void screenshot(WebDriver driver) throws IOException
	{
		String timestamp= new SimpleDateFormat("YYYY_MM_dd-hhmm").format(new Date());
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\eclipse\\ss\\image"+timestamp+".jpg");
		FileHandler.copy(source, dest);
	}
	
	public void hoverOverTV()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='TV']")));
		act.moveToElement(TV).perform();
	}
	
	public void hoverOverOtherShows()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Other Shows']")));
		act.moveToElement(other_shows).perform();
	}
	
	public void hoverOverHotstarSpecials()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Hotstar Specials']")));
        act.moveToElement(hotstar_specials);
	}
	
	public void hoverOverQuix()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Quix']")));
        act.moveToElement(quix);
	}

	public void hoverOvermore()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='more...']")));
        act.moveToElement(more);
	}
	
	public void getScreenshot() throws IOException
	{
		screenshot(driver);
	}
	
}
