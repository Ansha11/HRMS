package com.HRMS.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMS.Utilities.WaitUtilities;
import com.HRMS.Utilities.PageUtilities;
public class LoginPage {

	public WebDriver driver;

	@FindBy(id="iusername")
	private WebElement user;
	@FindBy(id="ipassword")
	private WebElement pass;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	@FindBy(xpath="//h3[text()='Login to your account']")
	private WebElement loginAccount;
	@FindBy(xpath="//b[text()='Demo HRMS']")
	private WebElement demoHRMS;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void setUsername(String username) {
		user.sendKeys(username);
	}
	public void setPassword(int password) {
		pass.sendKeys(String.valueOf(password));
	}
	public void clearLoginFields() {
		user.clear();
		pass.clear();
	}
	public void clickLogin() {
		PageUtilities.clickElement(driver,login );
		
	}
	public String LoginAccountText() {
		return(loginAccount.getText());
	}
	public String DemoHRMSText() {
		return(demoHRMS.getText());
	}
}