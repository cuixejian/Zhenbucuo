package com.webtest.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.interactions.Pause;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.TxtDataProvider;
import com.webtest.utils.ReadProperties;
//登录模块
public class Admin_Login extends BaseTest {
	//数据驱动
	@DataProvider(name = "front_login")
	public Object[][] data() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("D://lianxi//Java//auto2020//data//data1.xlsx", "Sheet1");
	}
	@Test(dataProvider = "front_login",description = "登录")
	public void testLogin(String u_ame,String p_word) throws IOException, InterruptedException {
		System.out.println(u_ame);
		System.out.println(p_word);
		//属性文件读取网址
		String openFront=ReadProperties.getPropertyValue("frontUrl");
		//打开页面
		webtest.open(openFront);
		//文本框输入
		webtest.click("link=登录");
		webtest.type("name=username", u_ame);
		webtest.type("name=password", p_word);
		webtest.type("name=verify_code", "123");
		Thread.sleep(1000);
		webtest.click("name=sbtbutton");
		assertTrue(webtest.isTextPresent("安全退出"));
		Thread.sleep(1000);
		
	}
	
	
	
	
	
	
	
	
	
//	@Test(priority = 0)
//	public void testLoginA() throws InterruptedException, IOException {
////		 登录
//		webtest.open("http://127.0.0.1:60/index.php");
//		webtest.click("link=登录");
//		webtest.type("name=username", "13800138006");
//		webtest.type("name=password", "123456");
//		webtest.type("name=verify_code", "123");
//		Thread.sleep(1000);
//		webtest.click("name=sbtbutton");
//		Thread.sleep(1000);
//	}
//	@Test
//	public void testLoginB() throws InterruptedException, IOException {
////		 登录
//		webtest.open("http://127.0.0.1:60/index.php/Admin/Admin/login#");
//		webtest.click("link=登录");
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "123456");
//		webtest.type("name=verify_code", "123");
//		Thread.sleep(1000);
//		webtest.click("name=submit");
//		Thread.sleep(1000);
//	}


}
