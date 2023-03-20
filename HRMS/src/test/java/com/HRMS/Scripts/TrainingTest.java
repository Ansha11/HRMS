package com.HRMS.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Base.TestBase;
import com.HRMS.Constants.Constants;
import com.HRMS.Constants.ExtentLogMessage;
import com.HRMS.Listeners.TestListener;
import com.HRMS.Pages.StaffPage;
import com.HRMS.Pages.TrainingPage;
import com.HRMS.Utilities.ExcelUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TrainingTest extends TestBase{
	TrainingPage objTraining;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

  @Test(priority=1,description="check whether the Training button is enabled")
  public void checkTrainingButtonstatus() {
	  objTraining=new TrainingPage(driver);
	  objTraining.clickTrainingButton();
boolean typeStatus_Actual=objTraining.checkTraningButtonStatus();
Assert.assertTrue(typeStatus_Actual);
extentTest.get().log(Status.PASS, ExtentLogMessage.TRAINING_STATUS);

  }
  @Test(priority=2,description="verifying the selected training type is dispalyed in the list")
  public void setTrainingType() throws IOException {
	  objTraining=new TrainingPage(driver);
	  String type=Constants.TRAININGTYPE_EXPECTED;
objTraining.setTrainingType(type);
objTraining.clickSave();
String type_Actual=objTraining.checkTrainingType();
Assert.assertEquals(type_Actual,Constants.TRAININGTYPE_EXPECTED);
objTraining.clickTrainingButton();
extentTest.get().log(Status.PASS, ExtentLogMessage.TRAINING_TYPE);

  }
  @Test(priority=3,description="verifyning List All Trainers is displayed")
  public void listAllTrainersDisplayed() throws IOException {
	  objTraining=new TrainingPage(driver);
	  objTraining.clickTrainingButton();
objTraining.clicktrainersList();
String listAllText_Actual=objTraining.checkListAllTrainers();
Assert.assertEquals(listAllText_Actual,Constants.ListAllText_Expected);
extentTest.get().log(Status.PASS, ExtentLogMessage.LISTALL_TRAINERS_MESSAGE);

}}
