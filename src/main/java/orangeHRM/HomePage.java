package orangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	
	@FindBy(xpath="//b[text()='Admin']")
	WebElement AdminTab;
	
	@FindBy(xpath="//b[text()='PIM']")
	WebElement PIMtab;
	
	@FindBy(xpath="//a[@id='welcome']")
	WebElement Avatar;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 act= new Actions(driver);
	}

	public void validateAdminTab()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Admin']")));
	    AdminTab.isDisplayed();
	    act.moveToElement(AdminTab);
	}
	
	public void validatePIMTab()
	{
		PIMtab.isDisplayed();
		act.moveToElement(PIMtab);
	}
	
	public void clickOnAvatar()
	{
		Avatar.click();
	}
	
	public void clickOnLogOut()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Logout']")));
		logout.click();
	}
	

}
