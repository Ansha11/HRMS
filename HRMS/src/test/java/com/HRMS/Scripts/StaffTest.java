package com.HRMS.Scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Base.TestBase;
import com.HRMS.Constants.Constants;
import com.HRMS.Constants.ExtentLogMessage;
import com.HRMS.Listeners.TestListener;
import com.HRMS.Pages.StaffPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class StaffTest extends TestBase {
	StaffPage objStaff;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	@Test(priority=1,description="Verifying entries selected",groups= {"smoke"})
	public void checkEntries() {
		objStaff=new StaffPage(driver);
		objStaff.clickStaffButton();
		objStaff.clickEmployeeButton();
		String entries_Actual= objStaff.selectEntries();
		Assert.assertEquals(entries_Actual,Constants.ENTRIES_COUNT_EXPECTED);
		extentTest.get().log(Status.PASS, ExtentLogMessage.ENTRIES_MESSAGE);
		extentTest.get().assignCategory("smoke");

	}
	@Test(priority=2,description="Verify the company is selected",groups= {"smoke"})
	public void verifyCompanySelection() {
		objStaff=new StaffPage(driver);
		objStaff.clickStaffDirectoryButton();
		objStaff.selectCompany();
		String company_Actual= objStaff.selectCompany();
		Assert.assertEquals(company_Actual, Constants.COMPANY_NAME_EXPECTED);
		extentTest.get().log(Status.PASS, ExtentLogMessage.COMPANY_SELECTED);
		extentTest.get().assignCategory("smoke");

	}
	@Test(priority=3,description="Verify company details are displayed",groups= {"regression"})
	public void selectedCompanyRecords() {
		objStaff=new StaffPage(driver);
		objStaff.clickGetButton();
		String dispMsgActual= objStaff.checkMessageDisplayed();
		Assert.assertEquals(dispMsgActual, Constants.COMPANYDETAILS_MSG);
		extentTest.get().log(Status.PASS, ExtentLogMessage.COMPANY_MESSAGE);
		extentTest.get().assignCategory("regression");

	}
	@Test(priority=4,description="Verify filter button is enabled")

	public void filterButtonStatus() {
		objStaff=new StaffPage(driver);
		objStaff.clickEmployeelastLogin();
		Assert.assertTrue(objStaff.filterButtonisEnabled());
		extentTest.get().log(Status.PASS, ExtentLogMessage.FILTERBUTTON_STATUS);

	}
	@Test(priority=5,description="Verify Active Option is displayed")

	public void checkActiveOption() {
		objStaff=new StaffPage(driver);
		objStaff.clickEmployeelastLogin();
		objStaff.clickFilterButton();
		objStaff.selectCompanytoFilter();
		objStaff.clickGetButton();
		objStaff.clickStaffButton();
		Assert.assertTrue(objStaff.activeIsDisplayed());
		extentTest.get().log(Status.PASS, ExtentLogMessage.ACTIVE_OPTION);


	}
}