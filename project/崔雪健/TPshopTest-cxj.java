package com.webtest.demo;
/**
 * author:cuixuejian
 * 后台营销
 */
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.demo.JavaMailTestListener;
import com.webtest.demo.MailUtil2;



public class CxjTest extends BaseTest {	
	//数据驱动
	@DataProvider(name = "front_login")
	public Object[][] data() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("C:\\zhenbucuo\\project\\崔雪健\\TPshopcxj\\data\\data1.xlsx", "Sheet1");
	}
	@BeforeSuite
	public void addListener(ITestContext context) {
		System.out.println("添加监听器");
		TestRunner runner = (TestRunner)context;
		runner.addListener(new JavaMailTestListener());
	}
//	@Test(priority = 1)
//	public void test1() throws InterruptedException {
////		成功登陆
//		webtest.open("http://localhost:82/index.php/Admin/Admin/login");
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "123456");
//		webtest.type("name=vertify", "yzm");
//		webtest.click("name=submit");
//		webtest.click("xpath=//a[@class='novice-guide-close']");
//		webtest.click("link=营销");
//		assertTrue(webtest.isTextPresent("抢购管理"));
//	}
//    @AfterSuite
//    public void testdemo() throws IOException, AddressException, MessagingException{
//    	MailUtil2 sMai = new MailUtil2();
//    }
//	
//	登陆后台，点击营销，点击抢购/秒杀，点击添加活动，	
	@Test(dataProvider = "front_login")
	public void test1(String u_ame,String p_word) throws InterruptedException {
		System.out.println(u_ame+" " +p_word);
//		成功登陆
		webtest.open("http://localhost:82/index.php/Admin/Admin/login");
		webtest.type("name=username", u_ame);
		webtest.type("name=password", p_word);
		webtest.type("name=vertify", "yzm");
		webtest.click("name=submit");
		webtest.click("xpath=//a[@class='novice-guide-close']");
		webtest.click("link=营销");
		assertTrue(webtest.isTextPresent("抢购管理"));
		webtest.click("link=抢购管理");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='添加活动']");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String titleString = df.format(new Date());// new Date()为获取当前系统时间
		webtest.type("name=title",titleString);	
		
		webtest.click("link=选择商品");
		webtest.enterFrame("layui-layer-iframe1");
//		webtest.click("xpath=//input[@data-id='317']");
		webtest.click("name=goods_id");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  //执行js语句
		webtest.click("xpath=//a[@onclick='select_goods();']");
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.type("name=price", "20");
		
		webtest.type("name=goods_num", "10");
		webtest.type("name=buy_limit", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		assertTrue(webtest.isTextPresent("确认提交"));
		webtest.click("link=确认提交");
	}	
	@Test(priority = 2)
//	使用搜索条件选择商品，限时抢购价格大于原先价格站内通知选择否，点击确认提交。
	public void test2() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=营销");
		webtest.click("link=抢购管理");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='添加活动']");
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String titleString = df.format(new Date());// new Date()为获取当前系统时间
		webtest.type("name=title",titleString);	
		
		webtest.click("link=选择商品");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("xpath=//input[@value='搜索']");
		webtest.click("name=goods_id");
		webtest.click("xpath=//a[@onclick='select_goods();']");

		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.type("name=price", "20");
		
		webtest.type("name=goods_num", "10");
		webtest.type("name=buy_limit", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		assertTrue(webtest.isTextPresent("确认提交"));
		webtest.click("link=确认提交");
		
	}	
	
	@Test(priority = 3)
//	使用搜索名称
	public void test3() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='添加活动']");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String titleString = df.format(new Date());// new Date()为获取当前系统时间
		webtest.type("name=title",titleString);	
		
		webtest.click("link=选择商品");
		webtest.enterFrame("layui-layer-iframe1");
//		webtest.selectByValue("name=intro", "is_new");
		webtest.click("name=goods_id");
		webtest.click("xpath=//a[@onclick='select_goods();']");

		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.type("name=price", "20");
		
		webtest.type("name=goods_num", "10");
		webtest.type("name=buy_limit", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		webtest.click("xpath=//label[@for='mmt_message_switch0']");
		assertTrue(webtest.isTextPresent("确认提交"));
		webtest.click("link=确认提交");
	}	
		
//	点击删除
	@Test(priority = 4)
	public void test4() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			webtest.leaveFrame();
			webtest.enterFrame("workspace");  //11-20	
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		assertTrue(webtest.isTextPresent("添加活动"));
	}	
	
//	点击编辑
	@Test(priority = 5)
	public void test5() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");  //11-20	
		webtest.click("link=编辑");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
//		webtest.click("link=确认提交");
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("抢购管理"));
		webtest.click("link=抢购管理");
	}	
	@Test(priority = 6)
//	点击添加活动，点击营销菜单再次点击抢购
	public void test6() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='添加活动']");
		webtest.leaveFrame();
		webtest.click("link=营销");
	assertTrue(webtest.isTextPresent("抢购管理"));
		webtest.click("link=抢购管理");	
	}	
	@Test(priority = 7)
//	点击添加活动，点击抢购
	public void test7() throws InterruptedException {

		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='添加活动']");
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("抢购管理"));
		webtest.click("link=抢购管理");	
	}	
	@Test(priority = 8)
//	选择商品  关闭
	public void test8() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='添加活动']");		
		webtest.click("link=选择商品");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("name=goods_id");
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-close layui-layer-close1']");
		
		webtest.click("link=选择商品");		
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-close layui-layer-close1']");
		assertTrue(webtest.isTextPresent("选择商品"));
	}	
	@Test(priority = 9)
//	选择商品  关闭
	public void test9() throws InterruptedException {	
		
		webtest.click("link=选择商品");		
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-close layui-layer-close1']");
		assertTrue(webtest.isTextPresent("选择商品"));
	}
//	点击收起操作提示
	@Test(priority = 10)
	public void test10() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=抢购管理");
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//h4[@title='提示相关设置操作时应注意的要点']");
		webtest.click("xpath=//h4[@title='提示相关设置操作时应注意的要点']");
		webtest.click("xpath=//h4[@title='提示相关设置操作时应注意的要点']");
		webtest.click("xpath=//h4[@title='提示相关设置操作时应注意的要点']");
		assertTrue(webtest.isTextPresent("添加活动"));
	}
//	点击收起操作提示转意点击
	@Test(priority = 11)
	public void test11() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");  //11-20	
		webtest.click("xpath=//h4[@title='提示相关设置操作时应注意的要点']");
		webtest.leaveFrame();
	assertTrue(webtest.isTextPresent("抢购管理"));
		webtest.click("link=抢购管理");
	}
//	点击收起操作提示
	@Test(priority = 12)
	public void test12() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");  //11-20	
		webtest.click("xpath=//h4[@title='提示相关设置操作时应注意的要点']");
	assertTrue(webtest.isTextPresent("提示相关设置操作时应注意的要点"));
	}
//	点击打开操作提示
	@Test(priority = 13)
	public void test13() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");  //11-20	
		webtest.click("xpath=//h4[@title='提示相关设置操作时应注意的要点']");
	assertTrue(webtest.isTextPresent("提示相关设置操作时应注意的要点"));
	}	
//	点击下一页
	@Test(priority = 14)
	public void test14() {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
	assertTrue(webtest.isTextPresent("下一页"));
		webtest.click("link=下一页");
	}
//	点击第三页
	@Test(priority = 15)
	public void test15() {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
	assertTrue(webtest.isTextPresent("3"));
		webtest.click("link=3");
	}
//	点击上一页
	@Test(priority = 16)
	public void test16() {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
	assertTrue(webtest.isTextPresent("上一页"));
		webtest.click("link=上一页");
	}
//	点击第三页
	@Test(priority = 17)
	public void test17() {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
	assertTrue(webtest.isTextPresent("3"));
		webtest.click("link=3");
	}
//点击团购
	@Test(priority = 18)
	public void test18() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=团购管理");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='添加团购']");
							
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String titleString = df.format(new Date());// new Date()为获取当前系统时间
		webtest.type("name=title",titleString);	
	
		webtest.click("link=选择商品");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("name=goods_id");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  //执行js语句
		webtest.click("xpath=//a[@onclick='select_goods();']");
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.type("name=price", "1");
		
		webtest.type("name=goods_num", "1");
		webtest.type("name=virtual_num", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		assertTrue(webtest.isTextPresent("确认提交"));
		webtest.click("link=确认提交");
	}	
//	点击删除
	@Test(priority = 19)
	public void test19() throws InterruptedException {
		webtest.click("link=删除");
	assertTrue(webtest.isTextPresent("确定"));
		webtest.click("link=确定");
	}	
	
//	点击编辑
	@Test(priority = 20)
	public void test20() throws InterruptedException {
//		webtest.enterFrame("workspace");  //11-20	
		webtest.click("link=编辑");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("团购管理"));
		webtest.click("link=团购管理");	
	}	
	
	@Test(priority = 21)
//	点击添加活动，点击营销菜单再次点击团购
	public void test21() throws InterruptedException {
		
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='添加团购']");
		webtest.leaveFrame();
		webtest.click("link=营销");
		assertTrue(webtest.isTextPresent("团购管理"));
		webtest.click("link=团购管理");	
	}	
	@Test(priority = 22)
//	点击添加活动，点击营销菜单再次点击团购
	public void test22() throws InterruptedException {
	
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='添加团购']");
		webtest.leaveFrame();
	assertTrue(webtest.isTextPresent("团购管理"));
		webtest.click("link=团购管理");	
	}	
	
//	点击收起操作提示
	@Test(priority = 23)
	public void test23() throws InterruptedException {
		webtest.enterFrame("workspace");  //11-20	
		webtest.click("xpath=//h4[@title='提示相关设置操作时应注意的要点']");
	assertTrue(webtest.isTextPresent("提示相关设置操作时应注意的要点"));
	}
//	点击打开操作提示
	@Test(priority = 24)
	public void test24() throws InterruptedException {
	
		webtest.click("xpath=//h4[@title='提示相关设置操作时应注意的要点']");
	assertTrue(webtest.isTextPresent("提示相关设置操作时应注意的要点"));
	}	
//	优惠促销查看商品
	@Test(priority = 25)
	public void test25() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=优惠促销");
		webtest.enterFrame("workspace");  //11-20
//		webtest.click("");
		webtest.click("link=查看商品");
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-close layui-layer-close1']");
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("优惠促销"));
	}	
	
//	优惠促销添加
	@Test(priority = 26)
	public void test26() throws InterruptedException {
			
		webtest.click("link=优惠促销");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='添加活动']");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String titleString = df.format(new Date());// new Date()为获取当前系统时间
		webtest.type("name=title",titleString);	
		webtest.type("name=expression","100");
		webtest.type("name=buy_limit", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  //执行js语句
		webtest.click("xpath=//input[@title='点击前方预览图可查看大图，点击按钮选择文件并提交表单后上传生效']");
		
		webtest.enterFrame1("xpath=//*[@allowtransparency='true']");
		webtest.click("xpath=//li[@id='manage_tab']");
		webtest.click("xpath=//span[@class='icon']");
		webtest.click("xpath=//li[@class='btn sure checked']");
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.click("link=选择商品");
		webtest.enterFrame1("xpath=//*[@allowtransparency='true']");
		webtest.click("name=goods_id[]");	
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("xpath=//a[@onclick='select_goods();']");
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
	assertTrue(webtest.isTextPresent("确认提交"));
		webtest.click("link=确认提交");
		
	}	
	
//	优惠促销里上传图片
	@Test(priority = 27)
	public void test27() throws InterruptedException {

//		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='添加活动']");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String titleString = df.format(new Date());// new Date()为获取当前系统时间
		webtest.type("name=title",titleString);	
		webtest.type("name=expression","100");
		webtest.type("name=buy_limit", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  //执行js语句
		
		webtest.click("xpath=//input[@title='点击前方预览图可查看大图，点击按钮选择文件并提交表单后上传生效']");
//		webtest.enterFrame1("xpath=//*[@allowtransparency='true']");
////		上传图片地址
//		String paString="C:\\Users\\lenovo\\Pictures\\Saved Pictures\\1.jpg";
//		webtest.type("name=file", paString);
//		Thread.sleep(3000);
//		webtest.click("xpath=//div[@class='saveBtn']");
		webtest.enterFrame1("xpath=//*[@allowtransparency='true']");
		webtest.click("xpath=//li[@id='manage_tab']");
		webtest.click("xpath=//span[@class='icon']");
		webtest.click("xpath=//li[@class='btn sure checked']");
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.click("link=选择商品");
		webtest.enterFrame1("xpath=//*[@allowtransparency='true']");
		webtest.click("name=goods_id[]");	
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("xpath=//a[@onclick='select_goods();']");
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
	assertTrue(webtest.isTextPresent("确认提交"));
		webtest.click("link=确认提交");
		
	}	
//	删除优惠促销
	@Test(priority = 28)
	public void test28() {
		for (int i = 0; i < 2; i++) {
			webtest.click("link=删除");
		}
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("优惠促销"));
	}
//	优惠促销里直接缩小窗口
	@Test(priority = 29)
	public void test29() throws InterruptedException {
//		webtest.open("http://localhost:82/index.php/Admin/Admin/login");
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "123456");
//		webtest.type("name=vertify", "yzm");
//		webtest.click("name=submit");
//		webtest.click("xpath=//a[@class='novice-guide-close']");
//		webtest.click("link=营销");
		
		webtest.click("link=优惠促销");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='添加活动']");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String titleString = df.format(new Date());// new Date()为获取当前系统时间
		webtest.type("name=title",titleString);	
		webtest.type("name=expression","100");
		webtest.type("name=buy_limit", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  //执行js语句
		webtest.leaveFrame();
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//input[@title='点击前方预览图可查看大图，点击按钮选择文件并提交表单后上传生效']");
		webtest.click("xpath=//a[@class='layui-layer-min']");	//缩小	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("选择商品"));
	}	
	
//	优惠促销里放大窗口
	@Test(priority = 30)
	public void test30() throws InterruptedException {//放大
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-max layui-layer-maxmin']");
		Thread.sleep(2000);
	assertTrue(webtest.isTextPresent("选择商品"));
	}
	
	@Test(priority = 31)
	public void test31() throws InterruptedException {	
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-max']");
		Thread.sleep(2000);
	assertTrue(webtest.isTextPresent("选择商品"));

	}
//	优惠促销里放大窗口
	@Test(priority = 32)
	public void test32() throws InterruptedException {
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-max layui-layer-maxmin']");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("选择商品"));
	}
//	优惠促销里直接关闭窗口
	@Test(priority = 33)
	public void test33() throws InterruptedException {
		webtest.click("xpath=//*[@class='layui-layer-ico layui-layer-close layui-layer-close1']");	
		Thread.sleep(2000);
	assertTrue(webtest.isTextPresent("选择商品"));
	}	
//	订单促销添加
	@Test(priority = 34)
	public void test34() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=订单促销");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='添加活动']");
//		什么也不写  直接确认提交
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("link=确认提交");
		webtest.leaveFrame();
	assertTrue(webtest.isTextPresent("订单促销"));
	}
	@Test(priority = 35)
	public void test35() throws InterruptedException {
		
//		添加内容
		webtest.click("link=订单促销");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='添加活动']");	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String titleString = df.format(new Date());// new Date()为获取当前系统时间
		webtest.type("name=name",titleString);	
		webtest.type("name=money","1");
		webtest.type("name=expression", "1");
	
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("link=确认提交");
		assertTrue(webtest.isTextPresent("删除"));
	}
	@Test(priority = 36)
	public void test36() throws InterruptedException {
//		删除
		webtest.click("link=删除");
		webtest.click("link=确定");
		assertTrue(webtest.isTextPresent("编辑"));
	}
	@Test(priority = 37)
	public void test37() throws InterruptedException {
//		编辑		
		webtest.click("link=编辑");
		webtest.leaveFrame();
		webtest.click("link=订单促销");	
		webtest.enterFrame("workspace");
		assertTrue(webtest.isTextPresent("添加活动"));
	}
	@Test(priority = 38)
	public void test38() throws InterruptedException {
		webtest.click("xpath=//div[@title='添加活动']");	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String titleString = df.format(new Date());// new Date()为获取当前系统时间
		webtest.type("name=name",titleString);	
		webtest.type("name=money","100");
		webtest.type("name=expression", "10000");//折扣大于100
		
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("link=确认提交");
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("营销"));
	}
//	添加优惠券
	@Test(priority = 39)
	public void test39() throws InterruptedException {

		
		webtest.click("link=营销");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//img[@src='/public/static/images/coupons.png']");
//		添加优惠券
		webtest.click("xpath=//div[@title='添加优惠券']");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String titleString = df.format(new Date());// new Date()为获取当前系统时间
		webtest.type("name=name",titleString);	
		webtest.type("name=money","1");
		webtest.type("name=condition", "1");
		webtest.type("name=createnum", "12");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("link=确认提交");
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		assertTrue(webtest.isTextPresent("删除"));
	}
	@Test(priority = 40)
	public void test40() throws InterruptedException {
//		删除优惠券
		webtest.click("link=删除");
		webtest.click("link=确定");
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		assertTrue(webtest.isTextPresent("删除"));
	}
	@Test(priority = 41)
	public void test41() throws InterruptedException {
//		删除取消优惠券
		webtest.click("link=删除");
		webtest.click("link=取消");
	assertTrue(webtest.isTextPresent("查看"));
	}
	@Test(priority = 42)
	public void test42() throws InterruptedException {
//		删除优惠券
		webtest.click("link=查看");
		webtest.click("link=删除");
	assertTrue(webtest.isTextPresent("删除"));
	}
	@Test(priority = 43)
	public void test43() throws InterruptedException {
//	查看操作提示，点击返回
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.click("xpath=//h4[@title='提示相关设置操作时应注意的要点']");
		webtest.click("xpath=//h4[@title='提示相关设置操作时应注意的要点']");
		webtest.click("xpath=//i[@class='fa fa-arrow-circle-o-left']");
		
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("操作提示"));
	}
//	发放优惠券
	@Test(priority = 44)
	public void test44() throws InterruptedException {
		
		webtest.leaveFrame();
		webtest.click("link=营销");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//img[@src='/public/static/images/coupons.png']");
		webtest.click("link=发放");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("发放"));
	}
//	查看发放记录
	@Test(priority = 45)
	public void test45() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=营销");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//img[@src='/public/static/images/record.png']");
		Thread.sleep(2000);
	assertTrue(webtest.isTextPresent("优惠券发放记录"));
	}
	@Test(priority = 46)
	public void test46() throws InterruptedException {
//		搜索发放记录
//		选择日期
		webtest.click("id=start_time");
		webtest.click("xpath=//i[@class='layui-icon laydate-icon laydate-prev-y']");
		webtest.click("xpath=//i[@class='layui-icon laydate-icon laydate-prev-y']");
		webtest.click("class=laydate-btns-confirm");
//		webtest.type("name=uid", "123");
		webtest.click("xpath=//input[@class='btn']");
		assertTrue(webtest.isTextPresent("查看"));
	}
	@Test(priority = 47)
	public void test47() throws InterruptedException {
//		查看
		
		webtest.click("link=查看");
		assertTrue(webtest.isTextPresent("删除"));
	}
	@Test(priority = 48)
	public void test48() throws InterruptedException {
//		查看删除
		webtest.click("link=删除");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("帮助"));
	}
	@Test(priority = 49)
	public void test49() throws InterruptedException {
		
		webtest.click("xpath=//div[@title='添加优惠券']");
		webtest.click("xpath=//a[@title='返回列表']");
		assertTrue(webtest.isTextPresent("帮助"));
	}
	@Test(priority = 50)
	public void test50() throws InterruptedException {
//		点击帮助
		webtest.click("xpath=//div[@title='帮助']");
		assertTrue(webtest.isTextPresent("帮助"));
	}

}
