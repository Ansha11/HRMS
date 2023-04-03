package com.HRMS.Base;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.HRMS.Constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop=null;


	public void testBase() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream(Constants.CONFIGPATH);
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void afterMethod(ITestResult r) throws IOException {
		if(ITestResult.SUCCESS==r.getStatus()) {
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File("/Users/Sanoob/Desktop/screenshot/\"+r.getName()+\".jpeg"));
		}
	}

	@BeforeTest(groups= {"smoke"})
	@Parameters({"browser"})
	public void beforeTest(String browser1) {
		testBase();

		if(browser1.equalsIgnoreCase("chrome")) {
			
			
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(co);
			
			
			
		}
		else if (browser1.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser1.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String baseurl=prop.getProperty("url");
		//driver = DriverFactory.testInitialization(browser1);
		driver.get(baseurl);
	}

	@AfterTest
	public void afterTest() {
	}

}


