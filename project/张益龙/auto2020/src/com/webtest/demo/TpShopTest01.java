package com.webtest.demo;
import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebListener;

import org.apache.poi.sl.draw.geom.Context;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Login;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.JavaMailTestListener;
import com.webtest.utils.ReadProperties;
import com.webtest.utils.createDayReportFiles;
@Listeners(JavaMailTestListener.class)
public class TpShopTest01 extends BaseTest {	
//登录模块	
		//数据驱动
		@DataProvider(name = "front_login")
		public Object[][] data1() throws IOException{
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
//注册模块
	//手机注册
	@DataProvider(name = "front_register")
	public Object[][] data2() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("D://lianxi//Java//auto2020//data//data1.xlsx", "Sheet2");
	}
	@Test(dataProvider = "front_register",description = "注册")
	public void testRegisterPhone(String u_phone,String p_wd1,String p_wd2,String r_phone) throws IOException, InterruptedException {
		System.out.println(u_phone);
		System.out.println(p_wd1);
		System.out.println(p_wd2);
		//属性文件读取网址
		String openFront=ReadProperties.getPropertyValue("registerUrl");
		//打开页面
		webtest.open(openFront);
		//文本框输入
		webtest.type("name=username", u_phone);
		webtest.type("name=verify_code", "123");
		webtest.type("id=password", p_wd1);
		webtest.type("id=password2", p_wd2);
		webtest.type("name=invite", r_phone);
		Thread.sleep(2000);
		webtest.click("link=同意协议并注册");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("安全退出"));
		Thread.sleep(1000);	
		webtest.click("link=安全退出");
		Thread.sleep(1000);	
	}
	//邮箱注册
	@DataProvider(name = "front_register1")
	public Object[][] data3() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("D://lianxi//Java//auto2020//data//data1.xlsx", "Sheet3");
	}
	@Test(dataProvider = "front_register1",description = "注册")
	public void testRegisterEmail(String u_eamil,String p_wd1,String p_wd2,String r_phone) throws IOException, InterruptedException {
		System.out.println(u_eamil);
		System.out.println(p_wd1);
		System.out.println(r_phone);
		//属性文件读取网址
		String openFront=ReadProperties.getPropertyValue("registerUrl");
		//打开页面
		webtest.open(openFront);
		webtest.click("link=邮箱注册");
		//文本框输入
		webtest.type("name=username", u_eamil);
		webtest.type("name=verify_code", "123");
		webtest.type("id=password", p_wd1);
		webtest.type("id=password2", p_wd2);
		webtest.type("name=invite", r_phone);
		Thread.sleep(2000);
		webtest.click("link=同意协议并注册");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("安全退出"));
		System.out.println(222222);
		Thread.sleep(1000);	
		webtest.click("link=安全退出");
		Thread.sleep(2000);	
	}	



	
	
	
}