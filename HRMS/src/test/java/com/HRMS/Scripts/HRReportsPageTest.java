package com.HRMS.Scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Base.TestBase;
import com.HRMS.Constants.Constants;
import com.HRMS.Constants.ExtentLogMessage;
import com.HRMS.Listeners.TestListener;
import com.HRMS.Pages.FinancePage;
import com.HRMS.Pages.HRReportsPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class HRReportsPageTest extends TestBase{
	HRReportsPage objHR;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();


	@Test(priority=28,description="verify the status of  selected Project Report",groups= {"smoke"})
	public void verifyProjectReportStatusisListed() {
		objHR=new HRReportsPage(driver);
	       objHR.scrollPage();
	       objHR.clickHRReports();
		objHR.checkProjectReport();
		AssertJUnit.assertEquals(objHR.checkStatus(),Constants.STATUS_LISTED);
		extentTest.get().log(Status.PASS, ExtentLogMessage.STATUS_LISTED);
		extentTest.get().assignCategory("smoke");


	}

	@Test(priority=29,description="verify the UserRoles Report is listed")
	public void verifyUserReportDetails() {
		objHR=new HRReportsPage(driver);
		objHR.clickUserRolesReport();
		objHR.selectRoles();
		AssertJUnit.assertTrue(objHR.checkReportisDisplayed());
		extentTest.get().log(Status.PASS, ExtentLogMessage.USERROLES_REPORT_DETAILS);

	}
	@Test(priority=30,description="verify the employeeID is listed in EmployeeReport",groups= {"smoke"})
	public void verifyEmployeeIDisListed() {
		objHR=new HRReportsPage(driver);
		objHR.clickEmployeesReport();
		objHR.searchEmployeeName();
		AssertJUnit.assertEquals(objHR.checkEmployeeID(),Constants.EMPLOYEE_ID);
		extentTest.get().log(Status.PASS, ExtentLogMessage.EMPLOYEEID_MESSAGE);
		extentTest.get().assignCategory("smoke");

	}
}








