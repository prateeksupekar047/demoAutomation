package hotstar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginValidation {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy(xpath = "//div[text()='LOGIN']")
	WebElement login_button;
	
	@FindBy(xpath = "//button[text()='Have a Facebook/Email account?']")
	WebElement email_login;
	
	@FindBy(xpath = "//input[@id='emailID']")
	WebElement email_field;
	
	@FindBy(xpath = "//button[contains(text(),'CONTINUE')]")
	WebElement continue_button;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password_field;
	
	@FindBy(xpath = "//button[text()='continue']")
	WebElement continue_button1;
	
	
	
	public LoginValidation(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	
	public void initiateLogin()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='LOGIN']")));
		login_button.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Have a Facebook/Email account?']")));
        email_login.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='emailID']")));
		email_field.sendKeys("pratiksupekar00@gmail.com");
		continue_button.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        password_field.sendKeys("0p047127");
        continue_button1.click();
	}
	

}
