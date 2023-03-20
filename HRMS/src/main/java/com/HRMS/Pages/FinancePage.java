package com.HRMS.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancePage {
public WebDriver driver;

@FindBy(xpath="//span[text()='Finance']")
WebElement finance;
@FindBy(xpath="//a[text()=' Accounts List ']")
WebElement accountList;

@FindBy(xpath="//h3[text()=' Add New Account ']")
WebElement addNewaccount;
@FindBy(name="account_name")
WebElement accountName;
@FindBy(name="account_balance")
WebElement accountBalance;
@FindBy(name="account_number")
WebElement accountNumber;
@FindBy(xpath="//button[text()=' Save ']")
WebElement save;
@FindBy(xpath="//td[text()='Savings']")
WebElement accountNameEntered;
public FinancePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public boolean addNewAccount() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView()",finance);
	finance.click();
	accountList.click();
	boolean displaySatatus=addNewaccount.isDisplayed();
	return displaySatatus;	
}
public void addAccountName(String name) {
	accountName.sendKeys(name);
}
public void addAccountBalance(int balance) {
	accountBalance.sendKeys(String.valueOf(balance));

}
public void addAccountNumber(int number) {
	accountNumber.sendKeys(String.valueOf(number));
}
public void clickSave() {
	save.click();
}
public String checkEnteredAccountName() {
	String accNameEntered=accountNameEntered.getText();
	return accNameEntered;
}
}
