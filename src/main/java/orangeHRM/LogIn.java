package orangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement button;
	
	
	
	public LogIn(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void sendUsername()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtUsername']")));
		username.sendKeys("Admin");
	}
	
	public void sendpass()
	{
		password.sendKeys("admin123");
	}
	
	public void clickOnSignIn()
	{
		button.click();
	}

}
