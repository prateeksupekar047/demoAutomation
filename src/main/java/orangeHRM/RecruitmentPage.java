package orangeHRM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPage {

	WebDriver driver;
	WebDriverWait wait;
	Select drpdown;
	
	@FindBy(xpath="//b[text()='Recruitment']")
	WebElement recruitment;
	
	@FindBy(xpath="//a[text()='Vacancies']")
	WebElement vacancies_tab;
	
	@FindBy(xpath="//select[@name='vacancySearch[jobTitle]']")
	WebElement job_title_drpdown;
	
	@FindBy(xpath="//select[@name='vacancySearch[jobVacancy]']")
	WebElement job_vacancy_drpdown;
	
	@FindBy(xpath="//select[@name='vacancySearch[hiringManager]']")
	WebElement hiring_manager_drpdown;
	
	@FindBy(xpath="//select[@name='vacancySearch[status]']")
	WebElement status_drpdown;
	
	@FindBy(xpath="//input[@id='btnSrch']")
	WebElement search_button;
	
	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement add_button;
	
	@FindBy(xpath="//select[@name='addJobVacancy[jobTitle]']")
	WebElement add_job_title_drpdown;
	
	@FindBy(xpath="//input[@name='addJobVacancy[name]']")
	WebElement vacancy_name_field;
	
	@FindBy(xpath="//input[@name='addJobVacancy[hiringManager]']")
	WebElement hiring_manager_field;
	
	@FindBy(xpath="//input[@name='btnSave']")
	WebElement save_button;
	
	@FindBy(xpath="//input[@name='btnBack']")
	WebElement back_button;
	
	@FindBy(xpath="//a[text()='Junior Automation Tester']")
	WebElement stored_data;
	
	public RecruitmentPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void goToRecruitmentPage()
	{
		wait.until(ExpectedConditions.visibilityOf(recruitment));
		recruitment.click();
		wait.until(ExpectedConditions.visibilityOf(vacancies_tab));
        vacancies_tab.click();
	}
	
	public void selectJobTitle()
	{
		wait.until(ExpectedConditions.visibilityOf(job_title_drpdown));
	    drpdown =new Select(job_title_drpdown);
		drpdown.selectByValue("4");
	}
	
	public void selectVacancy()
	{
		drpdown = new Select(job_vacancy_drpdown);
		drpdown.selectByVisibleText("All");
	}
	
	public void selectHiringManager()
	{
		drpdown = new Select(hiring_manager_drpdown);
		drpdown.selectByVisibleText("All");
	}
	
	public void selectStatus()
	{
		drpdown = new Select(status_drpdown);
		drpdown.selectByValue("1");
	}
	
	public void clickSearch()
	{
		search_button.click();
	}
	
	public void clickAddToAddVacancy()
	{
		add_button.click();
	}
	
	public void enterData()
	{
		wait.until(ExpectedConditions.visibilityOf(add_job_title_drpdown));
		drpdown = new Select(add_job_title_drpdown);
		drpdown.selectByValue("26");
		vacancy_name_field.sendKeys("Junior Automation Tester");
		hiring_manager_field.sendKeys("Kevin Mathews");
		save_button.click();
		wait.until(ExpectedConditions.visibilityOf(back_button));
		back_button.click();
	}

	public void validateAddedVacancy()
	{
		wait.until(ExpectedConditions.visibilityOf(job_title_drpdown));
		drpdown =new Select(job_title_drpdown);
		drpdown.selectByValue("26");
		drpdown = new Select(job_vacancy_drpdown);
		drpdown.selectByVisibleText("Junior Automation Tester");
		search_button.click();
		stored_data.isDisplayed();
	}
	
}
