package com.HRMS.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Base.TestBase;
import com.HRMS.Constants.Constants;
import com.HRMS.Constants.ExtentLogMessage;
import com.HRMS.Listeners.TestListener;
import com.HRMS.Pages.PageFunctions;
import com.HRMS.Pages.ProjectManagerPage;
import com.HRMS.Utilities.ExcelUtilities;
import com.HRMS.Utilities.RandomUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProjectManagerTest extends TestBase{
	ProjectManagerPage objProject;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	@Test(priority=21,description="verify the project count",groups= {"regression"})
	public void verifyProjectCount() {
		objProject =new ProjectManagerPage(driver);
		objProject.scrollWindow();
		objProject.clickProjectManager();
		objProject.clickProject();
		Assert.assertEquals(objProject.checkProjectCount(),objProject.checkHomePageProjectCount());
		extentTest.get().log(Status.PASS, ExtentLogMessage.PROJECT_COUNT_MESSAGE);
		extentTest.get().assignCategory("regression");

	}

	@Test(priority=22,description="verify the given country is selected")
	public void verifyCountrySelection()  {
		objProject =new ProjectManagerPage(driver);
		objProject.scrollWindow();
		objProject.addNewClientData();
		PageFunctions obj=new PageFunctions();
		obj.setNameandEmail(driver);
		objProject.selectCountry();
		Assert.assertEquals(objProject.selectCountry(),Constants.COUNTRY_EXPECTED);
		extentTest.get().log(Status.PASS, ExtentLogMessage.COUNTRYSELECTION_MESSAGE);

	}
	@Test(priority=23,description="verify the added tax type",groups= {"regression"})
	public void verifyTaxTypeEntered()  {
		objProject =new ProjectManagerPage(driver);
		objProject.scrollWindow();
		objProject.addNewTax();
		Assert.assertEquals(objProject.searchTaxType(),Constants.TAX_TYPE);
		extentTest.get().log(Status.PASS, ExtentLogMessage.TAX_TYPE_MESSAGE);
		extentTest.get().assignCategory("regression");

	}

}