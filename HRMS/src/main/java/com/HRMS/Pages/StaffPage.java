package com.HRMS.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.HRMS.Utilities.WaitUtilities;

public class StaffPage {
	public WebDriver driver;
	public Select selectobj;
	@FindBy(xpath="//span[text()='Staff']")
	WebElement staff;
	@FindBy(xpath="//a[text()=' Employees']")
	WebElement employees;
	@FindBy(xpath="//select[@name='xin_table_length']")
	WebElement entries;
	@FindBy(xpath="//a[text()=' Staff Directory']")
	WebElement staffDirectory;
	@FindBy(xpath="//select[@name='company_id']")
	WebElement company;
	@FindBy(xpath="//button[text()=' Get']")
	WebElement getButton;
	@FindBy(xpath="//div[text()='Record not found.']")
	WebElement dispMsg;
@FindBy(xpath="//a[text()=' Employees Last Login']")
WebElement employeeLastlogin;
@FindBy(xpath="//button[text()=' Filter']")
WebElement filter;
@FindBy(xpath="//span[text()='Active']")
WebElement active;

	public StaffPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickStaffButton() {
		staff.click();
	}
	public void clickEmployeeButton() {
		employees.click();
	}
	public String selectEntries() {
		selectobj=new Select(entries);
		selectobj.selectByIndex(1);
		String entries=selectobj.getFirstSelectedOption().getText();
		return entries;
	}
	public void clickStaffDirectoryButton() {
		staffDirectory.click();
	}
	public String selectCompany() {
		selectobj=new Select(company);
		selectobj.selectByIndex(1);
		String companyName=selectobj.getFirstSelectedOption().getText();
		return companyName;
	}
	public void clickGetButton() {
		getButton.click();
	}
	public String checkMessageDisplayed() {
		String msgDisplayed=dispMsg.getText();
		return msgDisplayed;
	}
public void clickEmployeelastLogin() {
	employeeLastlogin.click();
}
public boolean filterButtonisEnabled() {
	boolean filterStatus=filter.isEnabled();
	return filterStatus;
	
}
public void clickFilterButton() {
	filter.click();
}
public String selectCompanytoFilter() {
	selectobj=new Select(company);
	selectobj.selectByIndex(0);
	String companyFilter=selectobj.getFirstSelectedOption().getText();
	return companyFilter;
}
public boolean activeIsDisplayed() {
	boolean active_Status=active.isDisplayed();
	return active_Status;
}
}
