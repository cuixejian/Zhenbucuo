package com.webtest.demo;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.JavaMailTestListener;
import com.webtest.utils.ReadProperties;
@Listeners(JavaMailTestListener.class)
public class test01 extends BaseTest{
	
	@Test
	public void add1() throws InterruptedException {
		
		Thread.sleep(2000);
	}
//	@Test
//	public void add2() throws InterruptedException {
//		webtest.open("http://127.0.0.1:60/index.php/Home/Goods/goodsList/id/30");
//		Thread.sleep(2000);
//		webtest.click("class=dx_choice");
//		Thread.sleep(2000);
//	}
//	@Test
//	public void add3() throws InterruptedException {
//		webtest.open("http://127.0.0.1:60/index.php/Home/Goods/goodsList/id/30");
//		Thread.sleep(2000);
//		webtest.click("class=dx_choice");
//		Thread.sleep(2000);
//	}
//	@Test
//	public void add4() throws InterruptedException {
//		webtest.open("http://127.0.0.1:60/index.php/Home/Goods/goodsList/id/30");
//		Thread.sleep(2000);
//		webtest.click("class=dx_choice");
//		Thread.sleep(2000);
//	}
//	@Test
//	public void add5() throws InterruptedException {
//		webtest.open("http://127.0.0.1:60/index.php/Home/Goods/goodsList/id/30");
//		Thread.sleep(2000);
//		webtest.click("class=dx_choice");
//		Thread.sleep(2000);
//	}
//	
	
}
