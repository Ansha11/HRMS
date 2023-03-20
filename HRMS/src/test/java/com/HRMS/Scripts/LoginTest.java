package com.HRMS.Scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

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

public class LoginTest extends TestBase  {
	LoginPage objLogin;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	String sheet1=Constants.Sheet1;
	
	@Test(priority=1,description="Verifying LoginPage with valid username and invalid password",
			retryAnalyzer=com.HRMS.Listeners.RetryAnalyzer.class)
	public void verifyLoginValidUserInvalidPassword() throws IOException {
		objLogin=new LoginPage(driver);
		String username=ExcelUtilities.getCellStringData(0, 0,sheet1);
		int password=ExcelUtilities.getCellNumericData(0, 1,sheet1);
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		String loginTextActual=objLogin.LoginAccountText();
		Assert.assertEquals(loginTextActual,Constants.LOGIN_ACCOUNT_TEXT);
		extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
	}
	@Test(priority=2,description="Verifying LoginPage with invalid username and valid password")
	public void verifyLoginInvalidUserValidPassword() throws IOException {
		objLogin=new LoginPage(driver);
		objLogin.clearLoginFields();
		String username=ExcelUtilities.getCellStringData(1, 0,sheet1);
		int password=ExcelUtilities.getCellNumericData(1, 1,sheet1);
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		String loginTextActual=objLogin.LoginAccountText();
		Assert.assertEquals(loginTextActual,Constants.LOGIN_ACCOUNT_TEXT);
		extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);

	}
	@Test(priority=3,description="Verifying LoginPage with invalid username and invalid password",retryAnalyzer=com.HRMS.Listeners.RetryAnalyzer.class)
	public void verifyLoginInvalidUserInvalidPassword() throws IOException {
		objLogin=new LoginPage(driver);
		objLogin.clearLoginFields();
		String username=ExcelUtilities.getCellStringData(2, 0,sheet1);
		int password=ExcelUtilities.getCellNumericData(2, 1,sheet1);
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		String loginTextActual=objLogin.LoginAccountText();
		Assert.assertEquals(loginTextActual,Constants.LOGIN_ACCOUNT_TEXT);
		extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);

	}
	@Test(priority=4,description="Verifying LoginPage with valid username and password",groups= {"smoke"})
	public void verifyLoginValidUserValidPassword() throws IOException{
		objLogin=new LoginPage(driver);
		objLogin.clearLoginFields();
		String username=ExcelUtilities.getCellStringData(3, 0,sheet1);
		int password=ExcelUtilities.getCellNumericData(3, 1,sheet1);
		objLogin.setUsername(username);
		objLogin.setPassword(password);
		objLogin.clickLogin();
		String demoHRMSTextActual=objLogin.LoginDemoHRMSText();
		Assert.assertEquals(demoHRMSTextActual,Constants.LOGIN_DEMOHRMS_TEXT);
		extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_PASSED_MESSAGE);
		extentTest.get().assignCategory("smoke");
	}
}
