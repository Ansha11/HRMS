package com.HRMS.Scripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Base.TestBase;
import com.HRMS.Constants.Constants;
import com.HRMS.Constants.ExtentLogMessage;
import com.HRMS.Listeners.TestListener;
import com.HRMS.Pages.StaffPage;
import com.HRMS.Utilities.PageUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class StaffTest extends TestBase{
	StaffPage objStaff;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	
	@Test(priority=5,description="Verify the coreHR checkbox is not selected and added role is listed",groups= {"regression"})
	public void verifyAddedRoleisListed() {
		objStaff=new StaffPage(driver);
		objStaff.clickStaffButton();
		objStaff.clickRolesAndPrivileges();
		objStaff.addNewRole(Constants.ROLE_NAME);
		boolean coreHRStatus=objStaff.coreHRCheckboxStatus();
		Assert.assertFalse(coreHRStatus);
		extentTest.get().log(Status.PASS, ExtentLogMessage.ROLE_ADDED_MESSAGE);
		extentTest.get().assignCategory("regression");

	}
	@Test(priority=6,description="Verify the newly added role is deleted",groups= {"regression"})
	public void verifyAddedRoleisDeleted() {
		objStaff=new StaffPage(driver);
		Assert.assertEquals(objStaff.deleteAddedRole(),Constants.SEARCH_DETAILS);
		extentTest.get().log(Status.PASS, ExtentLogMessage.ROLE_DELETED_MESSAGE);
		extentTest.get().assignCategory("regression");

	}
	@Test(priority=7,description="Verify the given  company is selected")
	public void verifyCompanySelection() {
		objStaff=new StaffPage(driver);
		objStaff.clickStaffDirectoryButton();
		String company_Actual= objStaff.selectCompany();
		Assert.assertEquals(company_Actual, Constants.COMPANY_NAME);
		extentTest.get().log(Status.PASS, ExtentLogMessage.COMPANY_SELECTED_MESSAGE);

	}
	@Test(priority=8,description="Verify selected company staff details")
	public void verifyCompanyStaffRecords() {
		objStaff=new StaffPage(driver);
		objStaff.clickGetButton();
		String dispMsgActual= objStaff.checkStaffDisplayed();
		Assert.assertEquals(dispMsgActual, Constants.ADDEDPERSON);
		extentTest.get().log(Status.PASS, ExtentLogMessage.STAFF_DISPLAYED_MESSAGE);

	}
	@Test(priority=9,description="Verify filter button is enabled")

	public void verifyfilterButtonStatus() {
		objStaff=new StaffPage(driver);
		objStaff.clickEmployeelastLogin();
		Assert.assertTrue(objStaff.checkFilterButtonStatus());
	extentTest.get().log(Status.PASS, ExtentLogMessage.FILTERBUTTON_STATUS);
	}
	
	@Test(priority=10,description="Verify Active Option is displayed")
	public void checkActiveOptionStatus() {
		objStaff=new StaffPage(driver);
		objStaff.clickFilterButton();
		objStaff.selectCompanytoFilter();
		objStaff.clickGetButton();
		objStaff.clickStaffButton();
		Assert.assertTrue(objStaff.activeOptionStatus());
		extentTest.get().log(Status.PASS, ExtentLogMessage.ACTIVE_OPTION);

	}
}