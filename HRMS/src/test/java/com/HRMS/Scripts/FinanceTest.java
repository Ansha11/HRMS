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

  
  @Test(priority=24,description="verify newly added account is listed",groups= {"smoke"})
  public void verifyAddedAccountDetails()  {
	  objFinance=new FinancePage(driver);
	  objFinance.Scroll();
	  objFinance.clickFinanceButton();
	  objFinance.addAccountDetails();
	  objFinance.searchEnteredAccount();
	  Assert.assertEquals(objFinance.checkEnteredAccountName(), Constants.ACCOUNT_NAME);
	 extentTest.get().log(Status.PASS, ExtentLogMessage.ACCOUNT_DETAILS);
	extentTest.get().assignCategory("smoke");

}
  @Test(priority=25,description="verify the  account balance is listed",groups= {"smoke"})
  public void verifyFixedAccountBalance()  {
	  objFinance=new FinancePage(driver);
	  objFinance.searchAccount(Constants.ACCOUNT_SEARCH);
	  Assert.assertTrue(objFinance.searchBalanceListed());
		extentTest.get().log(Status.PASS, ExtentLogMessage.BALANCEAMOUNT_DETAILS);
		extentTest.get().assignCategory("smoke");

  }
  
  @Test(priority=26,description="verify newly added payee is listed")
  public void verifyAddedPayeeDetails()  {
	  objFinance=new FinancePage(driver);
	  objFinance.Scroll();
	  objFinance.addPayeeDetails(Constants.PAYEE_NAME);
	  objFinance.clickSave();
	  Assert.assertEquals(objFinance.checkPayeeName(),Constants.PAYEE_NAME);
		extentTest.get().log(Status.PASS, ExtentLogMessage.PAYEE_DETAILS);

  }
  @Test(priority=27,description="verify the added payer details are deleted")
  public void verifyPayerDetails()  {
	  objFinance=new FinancePage(driver);
	  objFinance.Scroll();
	  objFinance.addpayerDetails();
	  Assert.assertEquals(objFinance.deleteAddedPayerDetails(),Constants.DELETE_MESSAGE);
		extentTest.get().log(Status.PASS, ExtentLogMessage.PAYER_DETAILS);

  }
 
}