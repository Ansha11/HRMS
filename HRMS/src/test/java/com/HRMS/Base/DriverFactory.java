package com.HRMS.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private DriverFactory() {}
	
	private static DriverFactory instance=new DriverFactory();
	public static DriverFactory getInstance() {
		return instance;
	}
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public void setDriver(String browser){ //used to initialize the thread-local for the given browser
       
		if(browser.equalsIgnoreCase("chrome")){	
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver.set(new ChromeDriver(co));
		}
        
		else if(browser.equalsIgnoreCase("safari")){

			driver.set(new SafariDriver());
		}
		else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			EdgeOptions co=new EdgeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver.set(new EdgeDriver(co));
		
        }
		else{
            throw new RuntimeException("Invalid browser");
        }
      //  getDriver().manage().deleteAllCookies();
      //  getDriver().manage().window().maximize();
      //  return getDriver();
	}
	
	public  WebDriver getDriver() { //used to get driver with thread-local
        return driver.get();
    }
	
	public  void closeBrowser() {
		getDriver().close();
		driver.remove();
	}
}
