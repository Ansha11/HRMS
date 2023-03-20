package com.HRMS.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.HRMS.Constants.Constants;

public class OrganizationPage {
public WebDriver driver;

public Select selectobj;
@FindBy(xpath="//span[text()='Organization']")
WebElement organization;
@FindBy(xpath="//a[text()=' Company']")
WebElement company;
@FindBy(xpath="//button[text()=' Add New']")
WebElement addNew;
@FindBy(name="name")
WebElement companyName;
@FindBy(xpath="//select[@name='company_type']")
WebElement companyType;
@FindBy(name="registration_no")
WebElement regNumber;
@FindBy(name="contact_number")
WebElement contactNumber;
@FindBy(name="email")
WebElement email;
@FindBy(name="website")
WebElement url;

@FindBy(name="username")
WebElement user;
@FindBy(name="password")
WebElement pass;
@FindBy(name="city")
WebElement city;
@FindBy(name="zipcode")
WebElement zipcode;
@FindBy(xpath="//select[@name='country']")
WebElement country;
@FindBy(id="logo")
WebElement logo;
@FindBy(xpath="//button[text()=' Save ']")
WebElement save;
@FindBy(xpath="//input[@type='search']")
WebElement search;
@FindBy(xpath="//td[text()='John Manuel']")
WebElement addedBy;
@FindBy(xpath="//th[text()=' Email']")
WebElement emailField;
public OrganizationPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickOrganization() {
	organization.click();
}
public void clickCompany() {
	company.click();
}
public void clickAddNew() {
	addNew.click();
}
public void setcompanyname(String name) {
	companyName.sendKeys(name);
}
public String selectCompanyType() {
selectobj=new Select(companyType);
selectobj.selectByIndex(4);
String company=selectobj.getFirstSelectedOption().getText();
return company;
}
public void setRegistrationNumber(int number) {
	regNumber.sendKeys(String.valueOf(number));
}
public void setContactNumber(int number1) {
	contactNumber.sendKeys(String.valueOf(number1));
}
public void setemail(String email1) {
	email.sendKeys(email1);
}
public void setWebsiteUrl(String url1) {
	url.sendKeys(url1);
}
public void setUsername(String username) {
	user.sendKeys(username);
}
public void setPassword(String password) {
	pass.sendKeys(password);
}
public void setCity(String city1) {
	city.sendKeys(city1);
}
public void setZipcode(int code) {
	zipcode.sendKeys(String.valueOf(code));
}
public void selectCountry(String country1) {
selectobj=new Select(country);
selectobj.selectByVisibleText(country1);
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
public boolean emailMessage() {
	return emailField.isDisplayed();
}
}