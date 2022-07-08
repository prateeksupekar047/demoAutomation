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
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoValidation {


	WebDriver driver;
    WebDriverWait wait;
	
	@FindBy(xpath = "//div[@class='iconClass kids']")
	WebElement kids_logo;
	
	@FindBy(xpath = "//img[@class='brand-logo']")
	WebElement disney_logo;
	
	@FindBy(xpath = "//button[text()='Exit Kids']")
	WebElement exit_kids;
	
	@FindBy(xpath = "//div[text()='Disney+']")
	WebElement disney_tab;
	
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
	
	
	public LogoValidation(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickOnKidsLogo() throws IOException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='iconClass kids']")));
		kids_logo.click();
		ss();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Exit Kids']")));
		exit_kids.click();
	}
	
	public void clickOnDisneyLogo() throws IOException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='brand-logo']")));
		disney_logo.click();
		
	}
	
	public void clickOnDisneyTab() throws IOException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Disney+']")));
		disney_tab.click();
		ss();
		
	}
}
