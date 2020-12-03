package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.compress.archivers.sevenz.CLI;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

public class TPshopTest03 extends BaseTest{
	@BeforeMethod
	public void loginBehind() throws IOException, InterruptedException {
//		先登录
		String openBehind=ReadProperties.getPropertyValue("behindUrl");
		//打开页面
		webtest.open(openBehind);
		//文本框输入
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.type("name=vertify","1111");
		webtest.click("name=submit");
		Thread.sleep(2000);
	}
//后端
//商品管理
	
//	//左侧基本导航栏跳转
//	@DataProvider(name = "comManage")
//	public Object[][] data5() throws IOException{
//		ExcelDataProvider excel=new ExcelDataProvider();
//		return excel.getTestDataByExcel("D://lianxi//Java//auto2020//data//data1.xlsx", "Sheet4");
//	}
//	@Test(dataProvider = "comManage")
//	public void testSkip1(String openPage,String testSuccessMes) throws IOException, InterruptedException	{
//		System.out.println(openPage);
//		System.out.println(testSuccessMes);
//		Thread.sleep(3000);
//		webtest.click("link=首页");
//		webtest.enterFrame("workspace");
//		webtest.click("link=商品管理");
//		webtest.leaveFrame();
//		Thread.sleep(3000);
//		webtest.click("link="+openPage);
//		webtest.enterFrame("workspace");
//		assertTrue(webtest.isTextPresent(testSuccessMes));
//	}
	
	//针对商品列表的数据驱动操作
		//实物商品
//	@DataProvider(name = "add1")
//	public Object[][] data6() throws IOException{
//		ExcelDataProvider excel=new ExcelDataProvider();
//		return excel.getTestDataByExcel("D://lianxi//Java//auto2020//data//data1.xlsx", "Sheet5");
//	}
//	@Test(dataProvider = "add1")
//	public void testAdd1(String goodsName,String goodsType1,String goodsType2,String goodsType3,String shopNumber,String shopPrice,String marketPrice,String model) throws InterruptedException {
//		webtest.click("link=首页");
//		webtest.enterFrame("workspace");
//		webtest.click("link=商品管理");
//		webtest.leaveFrame();
//		Thread.sleep(3000);
//		webtest.click("link=商品列表");
//		webtest.enterFrame("workspace");
//		Thread.sleep(2000);
//		webtest.click("class=fbutton");
//		Thread.sleep(2000);
//		webtest.type("name=goods_name",goodsName);
//		webtest.click("id=cat_id");
//		Thread.sleep(2000);
//		webtest.selectByVisibleText("id=cat_id", goodsType1);
//		webtest.click("id=cat_id_2");
//		Thread.sleep(2000);
//		webtest.selectByVisibleText("id=cat_id_2", goodsType2);
//		Thread.sleep(2000);
//		webtest.click("id=cat_id_3");
//		webtest.selectByVisibleText("id=cat_id_3", goodsType3);
//		webtest.type("name=goods_sn", shopNumber);
//		webtest.type("name=shop_price",shopPrice);
//		webtest.type("name=market_price", marketPrice);
//		if (model.length()<2) {
//			webtest.click("id=is_free_shipping_label_1");
//		}else {
//			webtest.click("id=template_id");
//			webtest.selectByVisibleText("id=template_id", model);
//		}
//		Thread.sleep(2000);
//		webtest.click("id=submit");
//		assertTrue(webtest.isTextPresent("商品列表"));
//		Thread.sleep(2000);
//	}
		//电子卡券+预约商品
	
//	商品标签添加
	
//	@DataProvider(name = "add2")
//	public Object[][] data6() throws IOException{
//		ExcelDataProvider excel=new ExcelDataProvider();
//		return excel.getTestDataByExcel("D://lianxi//Java//auto2020//data//data1.xlsx", "Sheet6");
//	}
//	@Test(dataProvider = "add2")
//	public void add2(String lableName) throws InterruptedException {
//		webtest.click("link=首页");
//		webtest.enterFrame("workspace");
//		webtest.click("link=商品管理");
//		webtest.leaveFrame();
//		Thread.sleep(2000);
//		webtest.click("link=商品标签");
//		webtest.enterFrame("workspace");
//		Thread.sleep(2000);
//		webtest.click("class=add");
//		Thread.sleep(2000);
//		webtest.type("name=label_name", lableName);
//		webtest.click("id=submitBtn");
//		assertTrue(webtest.isTextPresent("商品标签列表"));
//	}
//	
	@DataProvider(name = "add3")
	public Object[][] data6() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("D://lianxi//Java//auto2020//data//data1.xlsx", "Sheet7");
	}
	@Test(dataProvider = "add3")
	public void add2(String brandName,String url,String option1,String option2,String sort ) throws InterruptedException {
		webtest.click("link=首页");
		webtest.enterFrame("workspace");
		webtest.click("link=商品管理");
		webtest.leaveFrame();
		Thread.sleep(2000);
		webtest.click("link=品牌列表");
		webtest.enterFrame("workspace");
		Thread.sleep(2000);
		webtest.click("class=add");
		Thread.sleep(2000);
		webtest.type("id=brand_name", brandName);
		webtest.type("id=url", url);
		webtest.click("id=parent_id_1");
		webtest.selectByVisibleText("id=parent_id_1", option1);
		webtest.click("id=parent_id_2");
		webtest.selectByVisibleText("id=parent_id_2", option2);
		webtest.type("name=sort", sort);
		Thread.sleep(2000);
		webtest.click("id=submitBtn");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("品牌列表"));
	}
	
	
//	@Test
//	public void add1() {
//		System.out.println("11111");
//	}
	
	
	
	
	
	
	//订单管理
//	@DataProvider(name = "comManage")
//	public Object[][] data6() throws IOException{
//		ExcelDataProvider excel=new ExcelDataProvider();
//		return excel.getTestDataByExcel("D://lianxi//Java//auto2020//data//data1.xlsx", "Sheet6");
//	}
//	@Test(dataProvider = "comManage")
//	public void testSkip3(String openPage,String testSuccessMes) throws IOException, InterruptedException	{
//		//先登录
//		String openBehind=ReadProperties.getPropertyValue("behindUrl");
//		//打开页面
//		webtest.open(openBehind);
//		//文本框输入
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "123456");
//		webtest.type("name=vertify","1111");
//		webtest.click("name=submit");
//		Thread.sleep(2000);
//		webtest.click("link=首页");
//		Thread.sleep(2000);
//		webtest.click("link=订单管理");
//		webtest.click(""+openPage);
//		assertTrue(webtest.isTextPresent(testSuccessMes));
//	}
}
