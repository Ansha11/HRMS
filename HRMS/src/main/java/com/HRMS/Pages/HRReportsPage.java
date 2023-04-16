package com.HRMS.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.HRMS.Constants.Constants;
import com.HRMS.Utilities.PageUtilities;

public class HRReportsPage {
	public WebDriver driver;

	@FindBy(xpath="//span[text()='HR Reports']")
	WebElement hrReports;
	@FindBy(xpath="//a[text()=' Attendance Report ']")
	WebElement attendenceReport;
	@FindBy(xpath="//a[text()=' Projects Report ']")
	WebElement projectReport;
	@FindBy(xpath="//select[@name='project_id']")
	WebElement projectSelect;
	@FindBy(xpath="//button[text()=' Get ']")
	WebElement get;
	@FindBy(xpath="//td[text()='Not Started']")
	WebElement statusListed;
	@FindBy(xpath="//select[@name='company_id']")
	WebElement company;
	//@FindBy(xpath="//select[@name='employee_id']")
	//WebElement employee;
	//@FindBy(xpath="//td[text()='Absent']")
	//WebElement attendenceStatus;
	@FindBy(xpath="//a[text()=' User Roles Report ']")
	WebElement userRolesReport;
	@FindBy(xpath="//select[@name='role_id']")
	WebElement userRoles;
	@FindBy(id="xin_table_info")
	WebElement resultDisp;
	@FindBy(xpath="//a[text()=' Employees Report ']")
	WebElement employeesReport;
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	@FindBy(xpath="//td[text()='jsmith12']")
	WebElement idListed;
	
	public HRReportsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void scrollPage() {
		PageUtilities.scrollWindow(driver, hrReports);
	}
	public void clickHRReports() {
		hrReports.click();
	}
	
public void checkProjectReport() {
	PageUtilities.scrollWindow(driver,projectReport);
	projectReport.click();
	Select obj=PageUtilities.selectClassDropdown(driver, projectSelect);
	obj.selectByVisibleText(Constants.PROJECT_FILTER);
	get.click();
}
	public String checkStatus() {
		return(statusListed.getText());
	}
	
	public void clickUserRolesReport() {
		PageUtilities.scrollWindow(driver,userRolesReport);
		userRolesReport.click();

	}
	public void selectRoles() {
		Select obj=PageUtilities.selectClassDropdown(driver,userRoles );
		obj.selectByIndex(2);
		get.click();
	}
	public boolean checkReportisDisplayed() {
		return(resultDisp.isDisplayed());

	}
	public void clickEmployeesReport() {
		PageUtilities.scrollWindow(driver,employeesReport );
		employeesReport.click();
		
	}
	public void searchEmployeeName() {
		search.sendKeys(Constants.EMPLOYEE_NAME);
	}
	public String checkEmployeeID() {
		return(idListed.getText());
	}
}
