package com.HRMS.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.HRMS.Constants.Constants;
import com.HRMS.Utilities.PageUtilities;

public class ProjectManagerPage {
	public WebDriver driver;

	@FindBy(xpath="//span[text()='Project Manager']")
	private WebElement projectManager;
	@FindBy(xpath="//a[text()=' Projects ']")
	private WebElement project;
	@FindBy(xpath="//span[text()='2']")
	private WebElement projectCount;
	@FindBy(xpath="//a[text()=' Home']")
	private WebElement home;
	@FindBy(xpath="//a[text()='2']")
	private WebElement homePgprojCount;
	@FindBy(xpath="//label[text()='Search:']")
	private WebElement search;
	@FindBy(xpath="//a[text()=' Clients ']")
	private WebElement client;
	@FindBy(xpath="//button[text()=' Add New']")
	private WebElement addNew;
	@FindBy(name="name")
	private WebElement name;
	@FindBy(name="email")
	private WebElement email;
	@FindBy(xpath="//select[@name='country']")
	private WebElement country;
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement save;
	@FindBy(xpath="//button[text()=' Save']")
	private WebElement saveButton;
	@FindBy(xpath="//a[text()=' Tax Type ']")
	private WebElement tax;
	@FindBy(name="tax_name")
	private WebElement taxName;
	@FindBy(name="tax_rate")
	private WebElement taxRate;;
	@FindBy(xpath="//select[@name='tax_type']")
	private WebElement taxType;
	@FindBy(xpath="//td[text()='Fixed']")
	private WebElement taxTypeListed;


	public ProjectManagerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void  scrollWindow() {
		PageUtilities.scrollWindow(driver, projectManager);
	}
	public void clickProjectManager() {
		projectManager.click();
	}
	public void clickProject() {
		project.click();
	}
	public String checkProjectCount() {
		return(projectCount.getText());

	}
	public String checkHomePageProjectCount() {
		home.click();
		return(homePgprojCount.getText());
	}

	public void addNewClientData() {
		projectManager.click();
		client.click();
		addNew.click();
	}
	public void setNameandEmail(String name1,String email1) {
		name.sendKeys(name1);	
		email.sendKeys(email1);

	}
	
	public String selectCountry() {
		Select obj=PageUtilities.selectClassDropdown(driver,country);
		obj.selectByIndex(1);
		String countryselected=obj.getFirstSelectedOption().getText();
		save.click();

		return countryselected;
	}

	public void clickSave() {
		save.click();
	}
	public void addNewTax() {
		tax.click();
		taxName.sendKeys(Constants.TAX_NAME);
		taxRate.sendKeys(String.valueOf(Constants.TAX_RATE));
		Select obj=PageUtilities.selectClassDropdown(driver,taxType);
		obj.selectByIndex(1);
		saveButton.click();
	}
	public String searchTaxType() {
		search.sendKeys(Constants.TAX_NAME);
		return(taxTypeListed.getText());
	}

}





