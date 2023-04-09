package com.HRMS.Pages;

import org.openqa.selenium.WebDriver;

import com.HRMS.Constants.Constants;
import com.HRMS.Utilities.RandomUtilities;


public class PageFunctions  {

	//public WebDriver driver;
	public void setTrainerDetails(WebDriver driver) {
		TrainingPage objTraining=new TrainingPage(driver);

		String fname=RandomUtilities.getfName();
		String lname=RandomUtilities.getlName();
		String email=RandomUtilities.getRandomEmail();
		objTraining.addNewTrainer(fname, lname,email);
		objTraining.setContactNumber(Constants.CONTACT_NUMBER);
		objTraining.selectCompany();
	}
	public void addNewCompanyDetails(WebDriver driver,String companyName,int regNo,int contactNo,String url,String username,String password,String city,int zipcode) {
		OrganizationPage  objOrg=new OrganizationPage(driver);
		objOrg.setcompanyname(companyName);
		objOrg.selectCompanyType();
		objOrg.setRegistrationNumberandContactNumber(regNo,contactNo);
		String email=RandomUtilities.getRandomEmail();
		objOrg.setEmailandUrl(email,url);
		objOrg.setUsernameandPassword(username,password);
		objOrg.setCity(city);
		objOrg.setZipcode(zipcode);
		objOrg.selectCountry(Constants.COUNTRY_SELECT);
		objOrg.setLogo();
		objOrg.clickSave();

}
	public void setNameandEmail(WebDriver driver)
{
	ProjectManagerPage objProject=new ProjectManagerPage (driver);
	String name=RandomUtilities.getfName();
	String email=RandomUtilities.getRandomEmail();
	objProject.setNameandEmail(name,email);
}
}