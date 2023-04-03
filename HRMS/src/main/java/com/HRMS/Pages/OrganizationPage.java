package com.HRMS.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.HRMS.Constants.Constants;
import com.HRMS.Utilities.PageUtilities;

public class OrganizationPage {
	public WebDriver driver;

	@FindBy(xpath="//span[text()='Organization']")
	private WebElement organization;
	@FindBy(xpath="//a[text()=' Company']")
	private WebElement companyButton;
	@FindBy(xpath="//button[text()=' Add New']")
	private WebElement addNew;
	@FindBy(name="name")
	private WebElement companyName;
	@FindBy(xpath="//select[@name='company_type']")
	private WebElement companyType;
	@FindBy(name="registration_no")
	private WebElement regNumber;
	@FindBy(name="contact_number")
	private WebElement contactNumber;
	@FindBy(name="email")
	private WebElement email;
	@FindBy(name="website")
	private WebElement url;
	@FindBy(name="username")
	private WebElement user;
	@FindBy(name="password")
	private WebElement pass;
	@FindBy(name="city")
	private WebElement city;
	@FindBy(name="zipcode")
	private WebElement zipcode;
	@FindBy(xpath="//select[@name='country']")
	private WebElement country;
	@FindBy(id="logo")
	private WebElement logo;
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement save;
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;
	@FindBy(xpath="//td[text()='John Manuel']")
	private WebElement addedBy;
	@FindBy(xpath="//a[text()=' Official Documents']")
	private WebElement officialDocuments;
	@FindBy(xpath="//span[@class='fa fa-eye']")
	private WebElement view;
	@FindBy(xpath="//td[text()='		  Driving License']")
	private WebElement documentType;
	@FindBy(xpath="//button[text()='Close']")
	private WebElement close;
	@FindBy(xpath="//a[text()=' Location']")
	private WebElement location;
	@FindBy(xpath="//select[@name='company']")
	private WebElement companySelect;
	@FindBy(name="name")
	private WebElement locationName;
	@FindBy(xpath="//td[text()='Bangalore']")
	private WebElement searchLocation;
	@FindBy(id="xin_table_info")
	private WebElement searchResult;
	@FindBy(xpath="//a[text()=' Designation']")
	private WebElement designation;
	@FindBy(xpath="//select[@name='company_id']")
	private WebElement company;
	@FindBy(xpath="//select[@id='aj_subdepartments']")
	private WebElement mainDepartment;
	@FindBy(name="designation_name")
	private WebElement designationName;
	@FindBy(xpath="//a[text()=' Company Policy']")
	private WebElement companyPolicy;
	@FindBy(name="title")
	private WebElement title;
	@FindBy(xpath="//td[text()='Nine hours work']")
	private WebElement titleCheck;
	@FindBy(xpath="//span[@class='fa fa-pencil']")
	private WebElement editPolicy;
	@FindBy(xpath="//input[@name='title' and @value='Nine hours work']")
	private WebElement titleUpdate;
	@FindBy(xpath="//button[text()='Update']")
	private WebElement update;
	@FindBy(xpath="//td[text()='Non smoking policy']")
	private WebElement newPolicy;
	@FindBy(xpath="//span[@class='fa fa-trash']")
	private WebElement delete;
	@FindBy(xpath="//button[text()=' Confirm']")
	private WebElement confirm;

	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOrganization() {
		organization.click();
	}
	public void clickCompany() {
		companyButton.click();
		addNew.click();
	}
	public void setcompanyname(String name) {
		companyName.sendKeys(name);
	}
	public String selectCompanyType() {
		Select obj=PageUtilities.selectClassDropdown(driver,companyType);
		obj.selectByIndex(4);
		String company=obj.getFirstSelectedOption().getText();
		return company;
	}
	public void setRegistrationNumberandContactNumber(int regNum,int contNum) {
		regNumber.sendKeys(String.valueOf(regNum));
		contactNumber.sendKeys(String.valueOf(contNum));
	}
	public void setEmailandUrl(String email1,String url1) {
		email.sendKeys(email1);
		url.sendKeys(url1);
	}
	public void setUsernameandPassword(String username,String password) {
		user.sendKeys(username);
		pass.sendKeys(password);
	}
	public void setCity(String city1) {
		city.sendKeys(city1);
	}
	public void setZipcode(int code) {
		zipcode.sendKeys(String.valueOf(code));
	}
	public void selectCountry(String country1) {
		Select obj=PageUtilities.selectClassDropdown(driver, country);
		obj.selectByVisibleText(country1);

	}
	public void setLogo() {
		logo.sendKeys(Constants.LOGO_PATH);
	}
	public void clickSave() {
		save.click();

	}
	public void enterSearchData(String searchCompany) {
		search.sendKeys(searchCompany);
	}
	public String checkAddedEmployee() {
		String empName=addedBy.getText();
		return empName;
	}
	public void clickOfficialDocuments() {
		officialDocuments.click();
		view.click();
	}
	public String checkDocumentType() {
		return(documentType.getText());
	}
	public void clickClose() {
		close.click();

	}
	public void setLocation(String location1) {
		location.click();
		addNew.click();
		Select objComp=PageUtilities.selectClassDropdown(driver, companySelect);
		objComp.selectByVisibleText(Constants.COMPANY);
		locationName.sendKeys(location1);
		city.sendKeys(location1);
		Select objCountry=PageUtilities.selectClassDropdown(driver, country);
		objCountry.selectByVisibleText(Constants.COUNTRY_SELECT);
		save.click();
	}
	public void searchCompany() {
		search.sendKeys(Constants.COMPANY);
	}
	public boolean addedLocationStatus() {
		return(searchLocation.isDisplayed());

	}

	public void addNewDesignation() {
		designation.click();
		Select obj=PageUtilities.selectClassDropdown(driver, company);
		obj.selectByVisibleText(Constants.COMPANY_NAME);
		Select objDept=PageUtilities.selectClassDropdown(driver,mainDepartment);
		objDept.selectByIndex(1);
		designationName.sendKeys(Constants.DESIGNATION_NAME);
		save.click();
	}
	public boolean checkDesignationListed() {
		return(searchResult.isDisplayed());
	}
	public void addCompanyPolicy() {
		companyPolicy.click();
		Select obj=PageUtilities.selectClassDropdown(driver, companySelect);
		obj.selectByVisibleText(Constants.COMPANY_NAME);
		title.sendKeys(Constants.POLICY_TITLE);
		save.click();
	}
	public boolean checkAddedTitle() {
		search.sendKeys(Constants.POLICY_TITLE);
		return(titleCheck.isDisplayed());
	}
	public void updateCompanyPolicy() {
		editPolicy.click();
		titleUpdate.clear();
		titleUpdate.sendKeys(Constants.NEW_POLICY_TITLE);
		update.click();
	}
	public boolean checkNewPolicy() {
		return(newPolicy.isDisplayed());	
	}
	public void deletePolicy() {
		delete.click();
		confirm.click();
	}
}