package com.HRMS.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMS.Constants.Constants;
import com.HRMS.Utilities.PageUtilities;
import com.HRMS.Utilities.WaitUtilities;

public class FinancePage {
	public WebDriver driver;

	@FindBy(xpath="//span[text()='Finance']")
	private WebElement finance;
	@FindBy(xpath="//a[text()=' Accounts List ']")
	private WebElement accountList;
	@FindBy(xpath="//h3[text()=' Add New Account ']")
	private WebElement addNewaccount;
	@FindBy(name="account_name")
	private WebElement accountName;
	@FindBy(name="account_balance")
	private WebElement accountBalance;
	@FindBy(name="account_number")
	private WebElement accountNumber;
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement save;
	@FindBy(xpath="//td[text()='Savings']")
	private WebElement accountNameEntered;
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;
	@FindBy(xpath="//td[text()='$5,000.00']")
	private WebElement balanceListed;;
	@FindBy(xpath="//a[text()=' Payees ']")
	private WebElement payees;
	@FindBy(name="payee_name")
	private WebElement payeeName;
	@FindBy(xpath="//td[text()='Anna']")
	private WebElement payee;
	@FindBy(xpath="//a[text()=' Payers ']")
	private WebElement payers;
	@FindBy(name="payer_name")
	private WebElement payerName;
	@FindBy(xpath="//span[@class='fa fa-trash']")
	private WebElement delete;
	@FindBy(xpath="//button[text()=' Confirm']")
	private WebElement confirm;;
	@FindBy(xpath="//td[text()='No data available in table']")
	private WebElement deleteMsg;


	public FinancePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void Scroll() {
		PageUtilities.scrollWindow(driver,finance);

	}
	public void clickFinanceButton() {
		WaitUtilities.waitForElementToBeClickable(driver, finance);
		finance.click();
		accountList.click();
	}
	public void addAccountDetails() {
		accountName.sendKeys(Constants.ACCOUNT_NAME);
		accountBalance.sendKeys(String.valueOf(Constants.ACCOUNT_BALANCE));
		accountNumber.sendKeys(String.valueOf(Constants.ACCOUNT_NUMBER));
	}
	public void clickSave() {
		WaitUtilities.waitForElementToBeVisible(driver, save);
		save.click();
	}
	public void searchEnteredAccount() {
		search.sendKeys(Constants.ACCOUNT_NAME);
	}
	public String checkEnteredAccountName() {
		WaitUtilities.waitForElementToBeVisible(driver,accountNameEntered );
		String accName=accountNameEntered.getText();
		return accName;
	}
	
	public void searchAccount(String accountSearch) {
		search.clear();
		search.sendKeys(accountSearch);
	}
	public boolean searchBalanceListed() {
		return(balanceListed.isDisplayed());
	}
	public void  addPayeeDetails(String payeename) {
		payees.click();
		payeeName.sendKeys(payeename);
	}
	public String checkPayeeName() {
		return(payee.getText());
	}
	public void addpayerDetails() {
		payers.click();
		payerName.sendKeys(Constants.PAYER_NAME);
		save.click();
	}
	public String deleteAddedPayerDetails() {
		delete.click();
		confirm.click();
		return(deleteMsg.getText());
	}
}

