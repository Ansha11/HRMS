package com.HRMS.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProjectManagerPage {
public WebDriver driver;
public Select selectobj;
	@FindBy(xpath="//span[text()='Project Manager']")
	WebElement projectManager;
	@FindBy(xpath="//a[text()=' Projects ']")
	WebElement project;
	@FindBy(xpath="//label[text()='Search:']")
	WebElement search;
	@FindBy(xpath="//td[text()='No matching records found']")
	WebElement searchInfo;
	@FindBy(xpath="//a[text()=' Clients ']")
	WebElement client;
	@FindBy(xpath="//button[text()=' Add New']")
	WebElement addNew;
	@FindBy(name="name")
	WebElement name;
	@FindBy(name="email")
	WebElement email;
    @FindBy(xpath="//select[@name='country']")
    WebElement country;
    @FindBy(xpath="//button[text()=' Save ']")
    WebElement save;
	public ProjectManagerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void  scrollWindow() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",projectManager);
	}
	
	public void clickProjectManager() {
		
		projectManager.click();
		project.click();
	}
	public void enterSearchData(String data) {
		search.sendKeys(data);
		
	}
	public String getSearchInfo() {
		String search_info=searchInfo.getText();
		return search_info;
	}
	public void addNewClientData() {
		client.click();
		addNew.click();
	}
	public void setName(String name1) {
		name.sendKeys(name1);	
	}
	public void setEmail(String email1) {
		email.sendKeys(email1);
	}
	public String selectCountry() {
		selectobj=new Select(country);
		selectobj.selectByIndex(1);
		String country=selectobj.getFirstSelectedOption().getText();
		System.out.println(country);
		return country;
	}
	public boolean checkSaveButtonStatus() {
		boolean status=save.isEnabled();
		return status;
	}
	public void clickSave() {
		save.click();
	}
}





