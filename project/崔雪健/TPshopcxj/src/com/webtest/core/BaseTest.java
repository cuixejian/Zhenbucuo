package com.webtest.core;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;

/**
 * author:cuixuejian
 *
 */


public class BaseTest {

	public  WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;

	private WebDriver newWebDriver(String driverType) throws IOException, InterruptedException {
		WebDriver driver = null;

	    String firefox_driver =ReadProperties.getPropertyValue("gecko_driver");
		String firefox_path = ReadProperties.getPropertyValue("firefox_path");
		System.setProperty("webdriver.gecko.driver", firefox_driver);
		System.setProperty("webdriver.firefox.bin", firefox_path);
		driver = new FirefoxDriver();
//		driver.get("");
		Thread.sleep(3000);
		Log.info("Using Firefox");
		
		return driver;

	
	}
	@BeforeClass
	public void doBeforeClass() throws Exception {

		driverType=ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);	
	}


	@AfterClass
	public void doAfterMethod() {
		if(this.driver != null){
			this.driver.quit();
			}
		Log.info("Quitted Browser");
	}
	


	
	
	public WebDriver getDriver() {
        return driver;
    }

	@BeforeSuite
	public void addListener(ITestContext context) {
		System.out.println("¼àÌýÆ÷");
		TestRunner runner = (TestRunner)context;
		runner.addListener(new WebTestListener());
	}
	

}
