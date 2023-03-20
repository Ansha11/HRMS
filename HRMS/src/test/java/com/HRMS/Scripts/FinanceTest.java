package com.HRMS.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Base.TestBase;
import com.HRMS.Constants.Constants;
import com.HRMS.Constants.ExtentLogMessage;
import com.HRMS.Listeners.TestListener;
import com.HRMS.Pages.FinancePage;
import com.HRMS.Utilities.ExcelUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class FinanceTest extends TestBase {
	FinancePage objFinance;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	String sheet3=Constants.Sheet3;

  @Test(priority=1,description="verify Add New Account is displayed")
  public void checkAddNewAccountText() {
	  objFinance=new FinancePage(driver);
	  Assert.assertTrue(objFinance.addNewAccount());
		extentTest.get().log(Status.PASS, ExtentLogMessage.ADDNEWACCOUNT_MESSAGE);

  }
  @Test(priority=2,description="verify newly added account details are listed")
  public void addAccountDetails() throws IOException {
	  objFinance=new FinancePage(driver);
	  String accountName=ExcelUtilities.getCellStringData(0, 0, sheet3);
	  int accountBalance=ExcelUtilities.getCellNumericData(1, 0, sheet3);
	  int accountNumber=ExcelUtilities.getCellNumericData(2,0,sheet3);
	  objFinance.addAccountName(accountName);
	  objFinance.addAccountBalance(accountBalance);
	  objFinance.addAccountNumber(accountNumber);
	  objFinance.clickSave();
	  String accountNameEntered_Actual=objFinance.checkEnteredAccountName();
	  Assert.assertEquals(accountNameEntered_Actual, Constants.ACCOUNTNAME_EXPECTED);
		extentTest.get().log(Status.PASS, ExtentLogMessage.ACCOUNT_DETAILS);

	  
}
}