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

	@Test(priority=1,description="verify the given project is listed")
	  public void verifyProjectSearch() throws IOException {
		  objProject =new ProjectManagerPage(driver);
		  objProject.scrollWindow();
		  objProject.clickProjectManager();
		  String project_search=Constants.PROJECT_SEARCH;
		  objProject.enterSearchData(project_search);
		  String searchInfo_Actual=objProject.getSearchInfo();
		  Assert.assertEquals(searchInfo_Actual,Constants.PROJECT_SEARCH_DETAILS1);
			extentTest.get().log(Status.PASS, ExtentLogMessage.PROJECTSEARCH_MESSAGE);

	}
  @Test(priority=2,description="verifying save button status")
  public void verifySaveButtonStatus() throws IOException {
	  objProject =new ProjectManagerPage(driver);
	  objProject.scrollWindow();
	 objProject.addNewClientData();
	  Assert.assertTrue(objProject.checkSaveButtonStatus());
		extentTest.get().log(Status.PASS, ExtentLogMessage.SAVEBUTTON_STATUS);

  }
  
  @Test(priority=3,description="verify the given country is selected")
  public void verifyCountrySelection() throws IOException {
	  String name=RandomUtilities.getfName();
	  String email=RandomUtilities.getRandomEmail();
	  objProject.setName(name);
	  objProject.setEmail(email);
  objProject.selectCountry();
  objProject.clickSave();
String country_Actual=objProject.selectCountry();
Assert.assertEquals(country_Actual,Constants.COUNTRY_EXPECTED);
extentTest.get().log(Status.PASS, ExtentLogMessage.COUNTRYSELECTION_MESSAGE);

}
}