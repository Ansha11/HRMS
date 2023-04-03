package com.HRMS.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Base.TestBase;
import com.HRMS.Constants.Constants;
import com.HRMS.Constants.ExtentLogMessage;
import com.HRMS.DataProvider.DataProviders;
import com.HRMS.Listeners.TestListener;
import com.HRMS.Pages.OrganizationPage;
import com.HRMS.Utilities.ExcelUtilities;
import com.HRMS.Utilities.RandomUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class OrganizationTest extends TestBase{
	OrganizationPage objOrg;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	String OrganizationSheet=Constants.Sheet2;

	@Test(dataProviderClass = DataProviders.class,dataProvider="CompanyType",priority=11,
			description="verify the  company details added person is displayed",groups= {"regression"})
	public void verifyAddedPersonDetails(String companyName,int regNumber,int contactNumber,String url,String username,String password,String city,int zipcode)  {
		objOrg=new OrganizationPage(driver);
		objOrg.clickOrganization();
		objOrg.clickCompany();
		objOrg.setcompanyname(companyName);
		objOrg.selectCompanyType();
		objOrg.setRegistrationNumberandContactNumber(regNumber,contactNumber);
		String email=RandomUtilities.getRandomEmail();
		objOrg.setEmailandUrl(email,url);
		objOrg.setUsernameandPassword(username,password);
		objOrg.setCity(city);
		objOrg.setZipcode(zipcode);
		objOrg.selectCountry(Constants.COUNTRY_SELECT);
		objOrg.setLogo();
		objOrg.clickSave();
		objOrg.enterSearchData(companyName);
		Assert.assertEquals(objOrg.checkAddedEmployee(),Constants.ADDEDPERSON);
		extentTest.get().log(Status.PASS, ExtentLogMessage.ADDEDPERSON_INFO);
		extentTest.get().assignCategory("regression");

	}
	@Test(priority=12,description="verify the type of Official documents attached")
	public void verifyOfficialDocumentsType()  {
		objOrg=new OrganizationPage(driver);
		objOrg.clickOfficialDocuments();
		objOrg.checkDocumentType();
		Assert.assertEquals(objOrg.checkDocumentType(),Constants.DOCUMENT_TYPE);
		objOrg.clickClose();
		extentTest.get().log(Status.PASS, ExtentLogMessage.DOCUMENT_ADDED_MESSAGE);

	}
	@Test(priority=13,description="verify the entered location is listed")
	public void verifyLocationDetails()  {
		objOrg=new OrganizationPage(driver);
		objOrg.setLocation(Constants.LOCATION);
		objOrg.searchCompany();
		Assert.assertTrue(objOrg.addedLocationStatus());
		extentTest.get().log(Status.PASS, ExtentLogMessage.LOCATION_MESSAGE);

	}
	
	@Test(priority=14,description="verify the added designation is listed")
	public void verifyDesignationAdded() {  
		objOrg=new OrganizationPage(driver);
		objOrg.addNewDesignation();
		Assert.assertTrue(objOrg.checkDesignationListed());
		extentTest.get().log(Status.PASS, ExtentLogMessage.DESIGNATION_MESSAGE);

	}
	
	@Test(priority=15,description="verify new company policy  is added")
	public void verifyAddedCompaanyPolicyTitle() {  
		objOrg=new OrganizationPage(driver);
		objOrg.addCompanyPolicy();
		objOrg.clickOrganization();
		Assert.assertTrue(objOrg.checkAddedTitle());
		extentTest.get().log(Status.PASS, ExtentLogMessage.POLICY_ADDED_MESSAGE);

	}
	@Test(priority=16,description="verify the company policy  is updated")
	public void verifyCompanyPolicyUpdated() {  
		objOrg=new OrganizationPage(driver);
		objOrg.updateCompanyPolicy();
		Assert.assertTrue(objOrg.checkNewPolicy());
		objOrg.deletePolicy();
		extentTest.get().log(Status.PASS, ExtentLogMessage.POLICY_UPDATE_MESSAGE);

}
	}