package com.HRMS.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Base.TestBase;
import com.HRMS.Constants.Constants;
import com.HRMS.Constants.ExtentLogMessage;
import com.HRMS.Listeners.TestListener;
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
	
  @Test(priority=22,description="verify the given country is selected",groups= {"regression"})
  public void verifyCountrySelection()  {
	  objProject =new ProjectManagerPage(driver);
	 objProject.scrollWindow();
	  objProject.clickProjectManager();
	 objProject.addNewClientData();
	  String name=RandomUtilities.getfName();
	  String email=RandomUtilities.getRandomEmail();
	  objProject.setName(name);
	  objProject.setEmail(email);
  objProject.selectCountry();
  objProject.clickSave();
String country_Actual=objProject.selectCountry();
Assert.assertEquals(country_Actual,Constants.COUNTRY_EXPECTED);
extentTest.get().log(Status.PASS, ExtentLogMessage.COUNTRYSELECTION_MESSAGE);
extentTest.get().assignCategory("regression");

}
  @Test(priority=23,description="verify the added tax type ")
  public void verifyTaxTypeEntered()  {
	  objProject =new ProjectManagerPage(driver);
	  objProject.scrollWindow();
	  objProject.addNewTax();
	 Assert.assertEquals(objProject.searchTaxType(),Constants.TAX_TYPE);
	extentTest.get().log(Status.PASS, ExtentLogMessage.TAX_TYPE_MESSAGE);

  }
 
}