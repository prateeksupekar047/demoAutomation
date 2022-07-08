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

public class HeaderValidation {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	public void screenshot(WebDriver driver) throws IOException
	{
		String timestamp = new SimpleDateFormat("YYYY_MM_DD-hhmmss").format(new Date());
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\eclipse\\ss\\image"+timestamp+".jpg");
		FileHandler.copy(source, dest);
	}
	
	
	
	@FindBy(xpath = "//div[@class='icon-wrapper']")
	WebElement hamburger_icon;
	
	@FindBy(xpath = "(//div[@class='link-container']//a)[1]")
	WebElement channels;
	
	@FindBy(xpath = "(//div[@class='link-container']//a)[2]")
	WebElement languages;
	
	@FindBy(xpath = "//div[text()='Genres']")
	WebElement genres;
	
	@FindBy(xpath = "//input[@id='searchField']")
	WebElement search_field;
	
	@FindBy(xpath = "//div[text()='Movies']")
	WebElement movies;
	
	@FindBy(xpath = "//div[text()='Sports']")
	WebElement sports;

	
	
	
	public HeaderValidation(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	
	
	public void clickOnHamburger() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='icon-wrapper']")));
		act.moveToElement(hamburger_icon).perform();
	}
	
	public void moveToGenres() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Genres']")));
		act.moveToElement(genres).perform();
	}
	
	public void moveToLanguages()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='link-container']//a)[2]")));
		act.moveToElement(languages).perform();
	}
	
	public void moveToChannels()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='link-container']//a)[1]")));
		act.moveToElement(channels).perform();
	}
	
	public void enterSearchField()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchField']")));
		search_field.click();
		search_field.sendKeys("marvel");
		
	}
	
	public void moveToOtherTabs()
	{
		act.moveToElement(movies).perform();
		act.moveToElement(sports).perform();
	}
	
	
	public void validateHeader() throws IOException
	{
		screenshot(driver);
	}
	

}
