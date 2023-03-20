package com.HRMS.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Base.TestBase;
import com.HRMS.Constants.Constants;
import com.HRMS.Constants.ExtentLogMessage;
import com.HRMS.Listeners.TestListener;
import com.HRMS.Pages.OrganizationPage;
import com.HRMS.Utilities.ExcelUtilities;
import com.HRMS.Utilities.RandomUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class OrganizationTest extends TestBase{
	OrganizationPage objOrg;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	String sheet2=Constants.Sheet2;

	@Test(priority=1,description="verify the selected Company")
	public void verifyCompanyType() throws IOException {
		objOrg=new OrganizationPage(driver);
		objOrg.clickOrganization();
		objOrg.clickCompany();
		objOrg.clickAddNew();
		String companyName=ExcelUtilities.getCellStringData(0, 0,sheet2 );
		objOrg.setcompanyname(companyName);
		String companyType=objOrg.selectCompanyType();
		Assert.assertEquals(companyType, Constants.COMPANY_TYPE);
		extentTest.get().log(Status.PASS, ExtentLogMessage.COMPANYTYPE_MESSAGE);

	}
	@Test(priority=2,description="verify the  added person is displayed")
	public void verifyAddedPersonDetails() throws IOException {
		objOrg=new OrganizationPage(driver);
		int regNumber=ExcelUtilities.getCellNumericData(1, 0, sheet2);
		objOrg.setRegistrationNumber(regNumber);
		int contactNumber=ExcelUtilities.getCellNumericData(2, 0, sheet2);
		objOrg.setContactNumber(contactNumber);
		String email=RandomUtilities.getRandomEmail();
		objOrg.setemail(email);
		String url=ExcelUtilities.getCellStringData(3, 0,sheet2 );
		objOrg.setWebsiteUrl(url);
		String username=ExcelUtilities.getCellStringData(4, 0,sheet2 );
		objOrg.setUsername(username);
		String password=ExcelUtilities.getCellStringData(5, 0,sheet2);
		objOrg.setPassword(password);
		String city=ExcelUtilities.getCellStringData(6, 0,sheet2);
		objOrg.setCity(city);
		int zipcode=ExcelUtilities.getCellNumericData(7, 0, sheet2);
		objOrg.setZipcode(zipcode);
		objOrg.selectCountry(Constants.COUNTRY_SELECT);
		objOrg.setLogo();
		objOrg.clickSave();
		String searchCompany=ExcelUtilities.getCellStringData(0, 0,sheet2);
		objOrg.enterSearchData(searchCompany);
		String addedPerson=objOrg.checkAddedEmployee();
		Assert.assertEquals(addedPerson, Constants.ADDEDEMPLOYEE);
		extentTest.get().log(Status.PASS, ExtentLogMessage.ADDEDPERSON_INFO);



	}	  
	@Test(priority=3,description="verify the Email field is present")
	public void verifyEmailFieldStatus() throws IOException {
		objOrg=new OrganizationPage(driver);
		objOrg.clickOrganization();
		Assert.assertTrue(objOrg.emailMessage());
		extentTest.get().log(Status.PASS, ExtentLogMessage.EMAIL_MESSAGE);
	}
}