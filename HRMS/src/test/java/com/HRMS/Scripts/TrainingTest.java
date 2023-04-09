package com.HRMS.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Base.TestBase;
import com.HRMS.Constants.Constants;
import com.HRMS.Constants.ExtentLogMessage;
import com.HRMS.Listeners.TestListener;
import com.HRMS.Pages.PageFunctions;
import com.HRMS.Pages.StaffPage;
import com.HRMS.Pages.TrainingPage;
import com.HRMS.Utilities.ExcelUtilities;
import com.HRMS.Utilities.RandomUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TrainingTest extends TestBase{
	TrainingPage objTraining;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	@Test(priority=17,description="check whether the Training button is enabled",groups= {"smoke"})
	public void verifyTrainingButtonstatus() {
		objTraining=new TrainingPage(driver);
		objTraining.clickTrainingButton();
		boolean typeStatus_Actual=objTraining.checkTraningButtonStatus();
		Assert.assertTrue(typeStatus_Actual);
		extentTest.get().log(Status.PASS, ExtentLogMessage.TRAINING_STATUS);
		extentTest.get().assignCategory("smoke");
	}

	@Test(priority=18,description="verifying the selected training type is displayed in the list")
	public void verifyTrainingTypeSelected() {
		objTraining=new TrainingPage(driver);
		objTraining.setTrainingType(Constants.TRAININGTYPE_EXPECTED);
		objTraining.clickSave();
		objTraining.searchTrainingType(Constants.TRAININGTYPE_EXPECTED);
		String type_Actual=objTraining.checkTrainingType();
		Assert.assertEquals(type_Actual,Constants.TRAININGTYPE_EXPECTED);
		extentTest.get().log(Status.PASS, ExtentLogMessage.TRAINING_TYPE);
	}
	
	@Test(priority=19,description="verifying the training type is updated")
	public void verifyTrainingTypeUpdated() {
		objTraining=new TrainingPage(driver);
		objTraining.editTrainingType(Constants.TRAINING_TYPE_UPDATED);
		Assert.assertTrue(objTraining.checkUpdatedTrainingType());
		extentTest.get().log(Status.PASS, ExtentLogMessage.TRAINING_TYPE_UPDATE);
	}
	@Test(priority=20,description="verify the given contact number is added")
	public void verifyContactNumberVisibility()  {
		objTraining=new TrainingPage(driver);
		objTraining.clicktrainersList();
		PageFunctions obj=new PageFunctions();
		obj.setTrainerDetails(driver);
		objTraining.clickTrainingButton();
		Assert.assertTrue(objTraining.contactNumberDisplayed());
		extentTest.get().log(Status.PASS, ExtentLogMessage.CONTACT_NUMBER_MESSAGE);

	}}
