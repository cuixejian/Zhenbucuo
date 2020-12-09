package com.pageoject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pageoject.WebDriverEngine;
import www.util.Log;
import www.util.ReadProperties;


//初始化浏览器
public class BaseTest{
	public  WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;


	private WebDriver newWebDriver(String driverType) throws IOException {
		WebDriver driver = null;
	 if (driverType.equalsIgnoreCase("firefox")) {
		    String firefox_driver =ReadProperties.getPropertyValue("gecko_driver");
			String firefox_path = ReadProperties.getPropertyValue("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();
	
			Log.info("Using Firefox");
		}  else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_path = ReadProperties.getPropertyValue("chrome_path");
			System.setProperty("webdriver.chrome.driver",chrome_path);
			driver = new ChromeDriver();
			Log.info("Using Chrome");
			
		}else{
			return null;
		}	
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


//	public BaseTest() {
//		System.out.println("BaseTest构造方法");
//	}
//	public  WebDriverEngine webtest;
//	protected WebDriver driver;
//	@BeforeClass
//	public void initBrower() {
//		try {
//			// 默认支持火狐浏览器，能够正常打开，若不能打开火狐，则把下面的火狐的驱动放开
//			System.setProperty("webdriver.gecko.driver", "D:\\Firefox\\geckodriver.exe");
//			System.setProperty("webdriver.firebox.bin", "D:\\Firefox\\geckodriver.exe");
//			driver = new FirefoxDriver();
//			System.out.println("成功打开火狐浏览器！");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("打开火狐浏览器时出错了"+e);
//		}
//	}
//	
//	@AfterClass
//	public void quitBrowser() {
//		System.out.println("quitBrowser()");
//		try {
//			Thread.sleep(2000);
//			driver.quit();
//			System.out.println("成功关闭浏览器！");
//			} catch (Exception e) {
//				System.out.println("关闭浏览器时出错了"+e);
//				}
//	}
}