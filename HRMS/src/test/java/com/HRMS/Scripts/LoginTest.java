package com.HRMS.Scripts;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Base.TestBase;
import com.HRMS.Constants.Constants;
import com.HRMS.Constants.ExtentLogMessage;
import com.HRMS.Pages.LoginPage;
import com.HRMS.Utilities.ExcelUtilities;
import com.HRMS.Listeners.TestListener;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.HRMS.DataProvider.DataProviders;
public class LoginTest extends TestBase  {
	LoginPage objLogin;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	String loginTestdataSheet=Constants.Sheet1;

	@Test(dataProviderClass = DataProviders.class,dataProvider="ValidUserInvalidPassword",
			priority=1,description="Verifying LoginPage with valid username and invalid password",
			retryAnalyzer=com.HRMS.Listeners.RetryAnalyzer.class)
	public void verifyLoginValidUserInvalidPassword(String username,int password)  {
		objLogin=new LoginPage(driver);
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		Assert.assertEquals(objLogin.LoginAccountText(),Constants.LOGIN_ACCOUNT_TEXT);
		extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
	}

	@Test(dataProviderClass = DataProviders.class,dataProvider="InvalidUserValidPassword",
			priority=2,description="Verifying LoginPage with invalid username and valid password")
	public void verifyLoginInvalidUserValidPassword(String username,int password) {
		objLogin=new LoginPage(driver);
		objLogin.clearLoginFields();
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		Assert.assertEquals(objLogin.LoginAccountText(),Constants.LOGIN_ACCOUNT_TEXT);
		extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
	}

	@Test(dataProviderClass = DataProviders.class,dataProvider="InvalidUserInvalidPassword",
			priority=3,description="Verifying LoginPage with invalid username and invalid password",retryAnalyzer=com.HRMS.Listeners.RetryAnalyzer.class)
	public void verifyLoginInvalidUserInvalidPassword(String username,int password) {
		objLogin=new LoginPage(driver);
		objLogin.clearLoginFields();
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		Assert.assertEquals(objLogin.LoginAccountText(),Constants.LOGIN_ACCOUNT_TEXT);
		extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
	}

	@Test(dataProviderClass = DataProviders.class,dataProvider="ValidUserValidPassword",priority=4,
			description="Verifying LoginPage with valid username and password",groups= {"smoke"})
	public void verifyLoginValidUserValidPassword(String username,int password) {
		objLogin=new LoginPage(driver);
		objLogin.clearLoginFields();
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		Assert.assertEquals(objLogin.DemoHRMSText(),Constants.LOGIN_DEMOHRMS_TEXT);
		extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_SUCCESS_MESSAGE);
		extentTest.get().assignCategory("smoke");
	}

}














