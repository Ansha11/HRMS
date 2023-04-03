package com.HRMS.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.HRMS.Constants.Constants;
import com.HRMS.Utilities.PageUtilities;

public class TrainingPage {
	public WebDriver driver;
	@FindBy(xpath="//span[text()='Training']")
	private WebElement training;
	@FindBy(xpath="//a[text()=' Training Type ']")
	private WebElement trainingType;
	@FindBy(xpath="//input[@name='type_name']")
	private WebElement addType;
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement save;
	@FindBy(xpath="//td[text()='java']")
	private WebElement type;
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;
	@FindBy(xpath="//span[@class='fa fa-pencil']")
	private WebElement editType;
	@FindBy(xpath="//input[@value='java']")
	private WebElement editTrainingType;
	@FindBy(xpath="//button[text()='Update']")
	private WebElement update;
	@FindBy(xpath="//td[text()='Selenium']")
	private WebElement updatedType;
	@FindBy(xpath="//a[text()=' Trainers List ']")
	private WebElement trainersList;
	@FindBy(xpath="//button[text()=' Add New']")
	private WebElement addNew;
	@FindBy(name="first_name")
	private WebElement firstname;
	@FindBy(name="last_name")
	private WebElement lastname;
	@FindBy(name="contact_number")
	private WebElement contactNumber;
	@FindBy(name="email")
	private WebElement email;
	@FindBy(xpath="//select[@name='company']")
	private WebElement company;
	@FindBy(xpath="//td[text()='12345']")
	private WebElement numberDisplayed;

	public TrainingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickTrainingButton() {
		training.click();
	}
	public boolean checkTraningButtonStatus() {
		boolean typeStatus=training.isEnabled();
		return typeStatus;
	}
	public void setTrainingType(String type) {
		trainingType.click();
		addType.sendKeys(type);
	}
	public void clickSave() {
		save.click();
	}
	public void searchTrainingType(String trainingType) {
		search.sendKeys(trainingType);
	}
	public void editTrainingType(String newType) {
		editType.click();
		editTrainingType.clear();
		editTrainingType.sendKeys(newType);
		update.click();
	}
	public boolean checkUpdatedTrainingType() {
		return(updatedType.isDisplayed());
	}
	public String checkTrainingType() {
		String trainingtype=type.getText();
		return trainingtype;

	}
	public void clicktrainersList() {
		trainersList.click();

	}

	public void addNewTrainer(String fname,String lname,String email1) {
		addNew.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(email1);
	}
	public void setContactNumber(int number) {
		contactNumber.sendKeys(String.valueOf(number));	
	}
	public void selectCompany() {
		Select obj=PageUtilities.selectClassDropdown(driver,company);
		obj.selectByVisibleText(Constants.COMPANY);
		save.click();
		search.sendKeys(Constants.COMPANY);
	}
	public void searchCompany() {
		search.sendKeys(Constants.COMPANY);
	}

	public boolean contactNumberDisplayed() {
		return(numberDisplayed.isDisplayed());

	}
}