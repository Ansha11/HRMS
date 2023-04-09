package com.HRMS.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.HRMS.Constants.Constants;
import com.HRMS.Utilities.PageUtilities;
import com.HRMS.Utilities.WaitUtilities;

public class StaffPage {
	public WebDriver driver;

	@FindBy(xpath="//span[text()='Staff']")
	private WebElement staff;

	@FindBy(xpath="//a[text()=' Roles & Privileges']")
	private WebElement roles;
	@FindBy(xpath="//button[text()=' Add New']")
	private WebElement addNew;
	@FindBy(name="role_name")
	private WebElement roleName;
	@FindBy(xpath="//select[@id='role_access']")
	private WebElement selectAccess;
	@FindBy(name="hrsale_form")
	private WebElement save;
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;
	@FindBy(xpath="//label[text()=' Events & Meetings']")
	private WebElement eventsAndMeetings;
	@FindBy(xpath="//label[text()=' Core HR']")
	private WebElement coreHR;
	@FindBy(xpath="//span[@class='fa fa-trash']")
	private WebElement deleteRole;
	@FindBy(xpath="//button[text()=' Confirm']")
	private WebElement confirm;
	@FindBy(xpath="//td[text()='No matching records found']")
	private WebElement deletedRoleMsg;
	@FindBy(xpath="//a[text()=' Staff Directory']")
	private WebElement staffDirectory;
	@FindBy(xpath="//select[@name='company_id']")
	private WebElement company;
	@FindBy(xpath="//button[text()=' Get']")
	private WebElement getButton;
	@FindBy(xpath="//a[text()='John Manuel']")
    private WebElement staffName;
	@FindBy(xpath="//a[text()=' Employees Last Login']")
	private WebElement employeeLastlogin;
	@FindBy(xpath="//button[text()=' Filter']")
	private WebElement filter;
	@FindBy(xpath="//span[text()='Active']")
	private WebElement active;

	public StaffPage(WebDriver driver) {
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}

	public void clickStaffButton() {
		staff.click();
	}
	public void clickRolesAndPrivileges() {
		roles.click();
		addNew.click();

	}
	public void addNewRole(String role) {
		roleName.sendKeys(role);
		Select obj=PageUtilities.selectClassDropdown(driver, selectAccess);
		obj.selectByIndex(2);
	}
	public boolean coreHRCheckboxStatus(){
		boolean coreHR_Status=coreHR.isSelected();
		eventsAndMeetings.click();
		save.click();
		search.sendKeys(Constants.ROLE_NAME);
		return coreHR_Status;
	}
	public String deleteAddedRole() {
		deleteRole.click();
		confirm.click();
		return(deletedRoleMsg.getText());
	}
	public void clickStaffDirectoryButton() {
		staffDirectory.click();
	}
	public String selectCompany() {
		Select obj=PageUtilities.selectClassDropdown(driver, company);
		obj.selectByVisibleText(Constants.COMPANY_NAME);
		String companyName=obj.getFirstSelectedOption().getText();
		return companyName;
	}
	public void clickGetButton() {
		getButton.click();
	}
	public String checkStaffDisplayed() {
		String msgDisplayed=staffName.getText();
		return msgDisplayed;
	}
	public void clickEmployeelastLogin() {
		employeeLastlogin.click();
	}
	public boolean checkFilterButtonStatus() {
		boolean filterStatus=filter.isEnabled();
		return filterStatus;
	}
	public void clickFilterButton() {
		filter.click();
	}
	public String selectCompanytoFilter() {
		Select obj=PageUtilities.selectClassDropdown(driver, company);
		obj.selectByVisibleText(Constants.COMPANY_NAME);
		String companyFilter=obj.getFirstSelectedOption().getText();
		return companyFilter;
	}
	public boolean activeOptionStatus() {
		boolean active_Status=active.isDisplayed();
		return active_Status;
	}
}
