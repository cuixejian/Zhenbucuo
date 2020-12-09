package com.pageoject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import www.util.Log;


/**
 * author:zhangjing
 
 */
public class WebDriverEngine {

	WebDriver driver = null;
	ElementFinder finder = null;
	Actions action  =null;

	public WebDriverEngine(WebDriver driver) {
		
		this.driver = driver;
		driver.manage().window().maximize();
		finder = new ElementFinder(driver);
		action = new Actions(driver);
	}
	public String[] getAllWindowTitles() {
		// TODO Auto-generated method stub
	    String current = driver.getWindowHandle();

	    List<String> attributes = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	      driver.switchTo().window(handle);
	      attributes.add(driver.getTitle());
	    }

	    driver.switchTo().window(current);

	    return attributes.toArray(new String[attributes.size()]);
	}



	public void enterFrame(String frameID) {//根据frameID进入frame
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}
	
	public void enterFrame1(String locator) {//根据frame位置进入frame
		WebElement element = finder.findElement(locator);
		this.pause(3000);
		driver.switchTo().frame(element);
		Log.info("Entered iframe " + element);
	}


	public void leaveFrame() {//返回到上一层表单
		driver.switchTo().defaultContent();
		Log.info("Left the iframe");
	}

	public void open(String url) {

		try {
			driver.get(url);
			pause(5000);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Log.info("Opened url " + url);
	}

	public String getTitle() {//获取当前标签页的标题
		return driver.getTitle();
	}

	private void pause(int time) {//暂停脚本执行
		if (time <= 0) {
			return;
		}
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isTextPresent(String pattern) {//验证页面上面是否存在你输入的文本内容

		String text = driver.getPageSource();
		text = text.trim();
		if (text.contains(pattern)) {
			return true;
		}
		return false;
	}
	public void enter() {//键盘输入enter
		action.sendKeys(Keys.ENTER);
	}

	public void typeAndClear(String locator, String value) {//清理输入
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.clear();
			element.sendKeys(value);

		}
	}

	public void type(String locator, String value) {//输入
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.sendKeys(value);
		}
	}

	public boolean isChecked(String locator) {//判断元素是否选中
		WebElement element = finder.findElement(locator);
		return element.isSelected();
	}

	public void click(String locator) {

		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.click();
			this.pause(3000);
		}
	}

	public void clickLonger(String locator) {//通过滑动实现长按

		WebElement element = finder.findElement(locator);
		if (element != null) {
			runJs("window.scrollTo(0," + element.getLocation().x + ")");
			element.click();
			this.pause(3000);
		}
	}

	public void doubleClick(String locator) throws InterruptedException {//对按钮进行双击
		WebElement element = finder.findElement(locator);
	
		action.doubleClick(element).build().perform();
	}

	public boolean isDisplayed(String locator) {//判断某个元素是否存在页面上

		WebElement element = finder.findElement(locator);
		if (element != null) {
			return element.isDisplayed();
		}
		return false;
	}

	public String getText(String locator) {//获取当前driver对象的text值

		return finder.findElement(locator).getText().trim();
	}

	public boolean isElementPresent(String locator) {//判断元素是否存在

		WebElement element = null;
		try {
			element = finder.findElement(locator);
		} catch (Exception e) {

			Log.info(e.getMessage());
		}
		if (element != null) {
			return true;
		}
		{
			return false;
		}
	}

	public String getValue(String locator) {//获取value属性值

		return finder.findElement(locator).getAttribute("value");
	}

	public String getUrl() {//获取当前网页地址
		return driver.getCurrentUrl();
	}

	public void goBack() {//后退
		driver.navigate().back();
	}

	public void goForward() {//前进

		driver.navigate().forward();
	}

	public Alert getAlert() {//定位弹出对话框切换到alert弹出框上
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	public String getAlertTest() {//获取alert对话框内容

		return getAlert().getText();
	}

	public void alertAccept() {//alert确定

		getAlert().accept();
		}

	public Select getSelect(String locator) {//选择下拉框中的元素
		Select inputSelect = new Select(finder.findElement(locator));
		return inputSelect;
	}

	public void selectByValue(String locator, String value) {//下拉框通过匹配到标签里的value
		getSelect(locator).selectByValue(value);
		this.pause(5000);
	}

	public void selectByVisibleText(String locator, String value) {//下拉框通过匹配到的可见字符
		getSelect(locator).selectByVisibleText(value);
	}

	public void selectByIndex(String locator, int index) {//下拉框通过index
		getSelect(locator).selectByIndex(index);
	}

	

	public String getHtmlSource() {//当前页面的源代码是

		return driver.getPageSource();
	}

	public void runJs(String js) {//下滑
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(js);
	}


	public void mouseToElement(String locator) throws InterruptedException {//鼠标滑动
		action.moveToElement(finder.findElement(locator)).perform();
	}

	public void mouseToElementandClick(String locator) throws InterruptedException {//鼠标滑动点击
		action.moveToElement(finder.findElement(locator)).click().perform();
	}
	
	public void switchWidow(int i){//网页句柄
	    List<String> windows = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	    
	    	windows.add(handle);
	    }
	    driver.switchTo().window(windows.get(i));
	}
	//右键
	public void rightClickMouse(String locator) throws InterruptedException {
		action.contextClick(finder.findElement(locator)).perform();
		}
	//Tab键
	public void tapClick(){
	
		action.sendKeys(Keys.TAB).perform();
	}
	
	//DOWN键
	public void downClick(){
		action.sendKeys(Keys.DOWN).perform();
	}
	
	
	public void tapType(String content){//通过content移动富文本
		
			action.sendKeys(content).perform();
		}
	
	public void getWindow(int i){
		List<String> windows = new ArrayList<String>();
		for (String handle : driver.getWindowHandles())
		{
			//System.out.println(handle);  
			windows.add(handle);
		}
		driver.switchTo().window(windows.get(i));
	}

}
