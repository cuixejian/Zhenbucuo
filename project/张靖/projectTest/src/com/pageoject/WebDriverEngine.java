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



	public void enterFrame(String frameID) {//����frameID����frame
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}
	
	public void enterFrame1(String locator) {//����frameλ�ý���frame
		WebElement element = finder.findElement(locator);
		this.pause(3000);
		driver.switchTo().frame(element);
		Log.info("Entered iframe " + element);
	}


	public void leaveFrame() {//���ص���һ���
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

	public String getTitle() {//��ȡ��ǰ��ǩҳ�ı���
		return driver.getTitle();
	}

	private void pause(int time) {//��ͣ�ű�ִ��
		if (time <= 0) {
			return;
		}
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isTextPresent(String pattern) {//��֤ҳ�������Ƿ������������ı�����

		String text = driver.getPageSource();
		text = text.trim();
		if (text.contains(pattern)) {
			return true;
		}
		return false;
	}
	public void enter() {//��������enter
		action.sendKeys(Keys.ENTER);
	}

	public void typeAndClear(String locator, String value) {//��������
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.clear();
			element.sendKeys(value);

		}
	}

	public void type(String locator, String value) {//����
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.sendKeys(value);
		}
	}

	public boolean isChecked(String locator) {//�ж�Ԫ���Ƿ�ѡ��
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

	public void clickLonger(String locator) {//ͨ������ʵ�ֳ���

		WebElement element = finder.findElement(locator);
		if (element != null) {
			runJs("window.scrollTo(0," + element.getLocation().x + ")");
			element.click();
			this.pause(3000);
		}
	}

	public void doubleClick(String locator) throws InterruptedException {//�԰�ť����˫��
		WebElement element = finder.findElement(locator);
	
		action.doubleClick(element).build().perform();
	}

	public boolean isDisplayed(String locator) {//�ж�ĳ��Ԫ���Ƿ����ҳ����

		WebElement element = finder.findElement(locator);
		if (element != null) {
			return element.isDisplayed();
		}
		return false;
	}

	public String getText(String locator) {//��ȡ��ǰdriver�����textֵ

		return finder.findElement(locator).getText().trim();
	}

	public boolean isElementPresent(String locator) {//�ж�Ԫ���Ƿ����

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

	public String getValue(String locator) {//��ȡvalue����ֵ

		return finder.findElement(locator).getAttribute("value");
	}

	public String getUrl() {//��ȡ��ǰ��ҳ��ַ
		return driver.getCurrentUrl();
	}

	public void goBack() {//����
		driver.navigate().back();
	}

	public void goForward() {//ǰ��

		driver.navigate().forward();
	}

	public Alert getAlert() {//��λ�����Ի����л���alert��������
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	public String getAlertTest() {//��ȡalert�Ի�������

		return getAlert().getText();
	}

	public void alertAccept() {//alertȷ��

		getAlert().accept();
		}

	public Select getSelect(String locator) {//ѡ���������е�Ԫ��
		Select inputSelect = new Select(finder.findElement(locator));
		return inputSelect;
	}

	public void selectByValue(String locator, String value) {//������ͨ��ƥ�䵽��ǩ���value
		getSelect(locator).selectByValue(value);
		this.pause(5000);
	}

	public void selectByVisibleText(String locator, String value) {//������ͨ��ƥ�䵽�Ŀɼ��ַ�
		getSelect(locator).selectByVisibleText(value);
	}

	public void selectByIndex(String locator, int index) {//������ͨ��index
		getSelect(locator).selectByIndex(index);
	}

	

	public String getHtmlSource() {//��ǰҳ���Դ������

		return driver.getPageSource();
	}

	public void runJs(String js) {//�»�
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(js);
	}


	public void mouseToElement(String locator) throws InterruptedException {//��껬��
		action.moveToElement(finder.findElement(locator)).perform();
	}

	public void mouseToElementandClick(String locator) throws InterruptedException {//��껬�����
		action.moveToElement(finder.findElement(locator)).click().perform();
	}
	
	public void switchWidow(int i){//��ҳ���
	    List<String> windows = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	    
	    	windows.add(handle);
	    }
	    driver.switchTo().window(windows.get(i));
	}
	//�Ҽ�
	public void rightClickMouse(String locator) throws InterruptedException {
		action.contextClick(finder.findElement(locator)).perform();
		}
	//Tab��
	public void tapClick(){
	
		action.sendKeys(Keys.TAB).perform();
	}
	
	//DOWN��
	public void downClick(){
		action.sendKeys(Keys.DOWN).perform();
	}
	
	
	public void tapType(String content){//ͨ��content�ƶ����ı�
		
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
