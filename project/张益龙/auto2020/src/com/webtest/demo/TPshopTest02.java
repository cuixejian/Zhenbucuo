package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

public class TPshopTest02 extends BaseTest{
	@BeforeMethod
	public void loginFront() throws IOException, InterruptedException {
		//先登录
		String openFront=ReadProperties.getPropertyValue("frontUrl");
		//打开页面
		webtest.open(openFront);
		//文本框输入
		webtest.click("link=登录");
		webtest.type("name=username","13800138006");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "123");
		webtest.click("name=sbtbutton");
		Thread.sleep(2000);
		
	}
//	个人主页
//		最上方导航栏
		@Test
		public void testSkip1() throws IOException, InterruptedException {
			//页面跳转检测
			webtest.click("link=我的订单");
			assertTrue(webtest.isTextPresent("全部订单"));
			Thread.sleep(2000);	
		}
		@Test
		public void testSkip2() throws IOException, InterruptedException {
			//页面跳转检测
			webtest.click("link=我的浏览");
			Thread.sleep(2000);
			assertTrue(webtest.isTextPresent("我的足迹"));
			Thread.sleep(2000);	
		}
		@Test
		public void testSkip3() throws IOException, InterruptedException {
			//页面跳转检测
			webtest.click("link=网站导航");
			webtest.click("link=优惠活动");
			assertTrue(webtest.isTextPresent("促销"));
			Thread.sleep(2000);	
		}
		@Test
		public void testSkip4() throws IOException, InterruptedException {
			//页面跳转检测
			webtest.click("link=网站导航");
			webtest.click("link=兑换中心");
			assertTrue(webtest.isTextPresent("积分商城"));
			Thread.sleep(2000);	
		}
		@Test
		public void testSkip5() throws IOException, InterruptedException {
			//页面跳转检测
			webtest.click("link=首页");
			webtest.click("link=帮助中心");
			Thread.sleep(3000);
			webtest.isElementPresent("class=first-menu-cont");
			Thread.sleep(2000);	
		}
}
