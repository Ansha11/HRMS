package com.HRMS.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainingPage {
public WebDriver driver;
	@FindBy(xpath="//span[text()='Training']")
	WebElement training;
	@FindBy(xpath="//a[text()=' Training Type ']")
	WebElement trainingType;
	@FindBy(xpath="//input[@name='type_name']")
	WebElement addType;
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement save;
	@FindBy(xpath="//td[text()='java']")
	WebElement type;
	@FindBy(xpath="//a[text()=' Trainers List ']")
	WebElement trainersList;
	@FindBy(xpath="//h3[text()=' List All Trainers ']")
	WebElement allList;
	
	public TrainingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTrainingButton() {
		training.click();
	}
	public boolean checkTraningButtonStatus() {
		boolean typeStatus=training.isEnabled();
		return typeStatus;
	}
	public void setTrainingType(String type) {
		trainingType.click();
		addType.sendKeys(type);
	}
	public void clickSave() {
		save.click();
	}
	public String checkTrainingType() {
		String trainingtype=type.getText();
		return trainingtype;
		
	}
	public void clicktrainersList() {
		trainersList.click();
	}
	public String checkListAllTrainers() {
		String listAll=allList.getText();
		return listAll;
	}
}
