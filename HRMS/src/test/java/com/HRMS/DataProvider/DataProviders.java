package com.HRMS.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRMS.Constants.Constants;
import com.HRMS.Utilities.ExcelUtilities;

public class DataProviders {
	String loginTestdataSheet=Constants.Sheet1;
	String OrganizationSheet=Constants.Sheet2;

	@DataProvider(name="ValidUserInvalidPassword")
	  public Object[][] verifyLoginValidUserInvalidPassword() {
		  Object[][] data=new Object[1][2];
		  data[0][0]=ExcelUtilities.getCellStringData(0, 0,loginTestdataSheet);
		  data[0][1]=ExcelUtilities.getCellNumericData(0, 1,loginTestdataSheet);
		  return data;
	  }
	  
	  @DataProvider(name="InvalidUserValidPassword")
	  public Object[][] verifyLoginInvalidUserValidPassword() {
		  Object[][] data=new Object[1][2];
		  data[0][0]=ExcelUtilities.getCellStringData(1, 0,loginTestdataSheet);
		  data[0][1]=ExcelUtilities.getCellNumericData(1, 1,loginTestdataSheet);
		  return data;
	  }
	  
	  @DataProvider(name="InvalidUserInvalidPassword")
	  public Object[][] verifyLoginInvalidUserInvalidPassword() {
		  Object[][] data=new Object[1][2];
		  data[0][0]=ExcelUtilities.getCellStringData(2, 0,loginTestdataSheet);
		  data[0][1]=ExcelUtilities.getCellNumericData(2, 1,loginTestdataSheet);
		  return data;
	  }
	  	  @DataProvider(name="ValidUserValidPassword")
	  public Object[][] verifyLoginValidUserValidPassword() {
		  Object[][] data=new Object[1][2];
		  data[0][0]=ExcelUtilities.getCellStringData(3, 0,loginTestdataSheet);
		  data[0][1]=ExcelUtilities.getCellNumericData(3, 1,loginTestdataSheet);
		  return data;
	  }
	 @DataProvider(name="CompanyType")
	  public Object[][] verifyCompanyType() {
		  Object[][] data=new Object[1][8];
		  data[0][0]=ExcelUtilities.getCellStringData(0, 0,OrganizationSheet);
		  data[0][1]=ExcelUtilities.getCellNumericData(0, 1,OrganizationSheet);
		  data[0][2]=ExcelUtilities.getCellNumericData(0, 2,OrganizationSheet);
		  data[0][3]=ExcelUtilities.getCellStringData(0, 3,OrganizationSheet);
		  data[0][4]=ExcelUtilities.getCellStringData(0, 4,OrganizationSheet);
		  data[0][5]=ExcelUtilities.getCellStringData(0, 5,OrganizationSheet);
		  data[0][6]=ExcelUtilities.getCellStringData(0, 6,OrganizationSheet);
		  data[0][7]=ExcelUtilities.getCellNumericData(0, 7,OrganizationSheet);
		  return data;

	  }
	
}







