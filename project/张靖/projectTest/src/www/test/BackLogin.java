package www.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pageoject.BaseTest;

/**
 * author:zhangjing
 
 */
public class BackLogin extends BaseTest {
	
	public void BackLogin() {
		webtest.open("http://localhost:83/index.php/Admin/Admin/login#");
		webtest.type("name=username","admin");
		webtest.type("name=password","123456");
		webtest.type("name=vertify", "aaaa");
		webtest.click("xpath=//input[@value='登录']");

	}
	
	public void FindElement() throws InterruptedException {
		Thread.sleep(1000);
		webtest.click("link=页面");
		Thread.sleep(1000);
		webtest.downClick();
		Thread.sleep(1000);
		webtest.click("link=广告列表");
	}
	
	//登录商城后台，点击页面，点击广告列表，下拉滑动
	@Test(priority=21)
	public void Backadvertisement21() throws InterruptedException {
		BackLogin();
		FindElement();
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,1000)");
		Thread.sleep(2000);
		webtest.runJs("window.scrollTo(0,0)");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@title='登录页']"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击登录页，广告现在时间
	@Test(priority=22)
	public void Backadvertisement22() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='登录页']");
		Thread.sleep(1000);
		webtest.click("class=advertisement");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("class=laydate-btns-confirm");
		Thread.sleep(1000);
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("xpath=//span[@class='laydate-btns-now']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("class=ncap-btn-big"));
		webtest.click("class=ncap-btn-big");
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击pc首页
	@Test(priority=23)
	public void Backadvertisement23() throws InterruptedException {
//		BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='首页']");
		webtest.click("link=家居城");
		Thread.sleep(1000);
		webtest.switchWidow(0);
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("link=家居城"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击手机分页
	@Test(priority=24)
	public void Backadvertisement24() throws InterruptedException {
//		BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='手机首页']");
		webtest.click("class=search_text");
		webtest.type("xpath=//input[@id='q']", "手机");
		webtest.enter();
		Assert.assertTrue(webtest.isElementPresent("class=maleri30"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击手机分类页
	@Test(priority=25)
	public void Backadvertisement25() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='手机分类页']");
		Assert.assertTrue(webtest.isElementPresent("class=br"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击删除，获取判定
	@Test(priority=26)
	public void Backadvertisement26() throws InterruptedException {
//		BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='批量删除']");
		Thread.sleep(2000);	
		Assert.assertTrue(webtest.getHtmlSource().contains("<div class=\"layui-layer-move\"></div>"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击搜索
	@Test(priority=27)
	public void Backadvertisement27() throws InterruptedException{
//		BackLogin();
//		FindElement();
		String string;
		webtest.click("link=广告列表");    
		webtest.enterFrame("workspace");                                                  
		webtest.click("xpath=//input[@value='搜索']");
		webtest.click("xpath=//select[@name='pid']");
		webtest.selectByValue("xpath=//select[@name='pid']", "9");
		webtest.click("xpath=//input[@value='搜索']");
		string = webtest.getText("xpath=//div[@class='bDiv']/div/table/tbody/tr[1]/td[3]/div");
		Assert.assertEquals("Index页面自动增加广告位 9",string);
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击查看所有，查看9，刷新
	@Test(priority=28)
	public void Backadvertisement28() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//select[@name='pid']");
		webtest.selectByValue("xpath=//select[@name='pid']", "9");
		webtest.click("xpath=//input[@value='搜索']");
		webtest.click("xpath=//a[@class='refresh-date']");
		Assert.assertTrue(webtest.isElementPresent("xpath=//select[@name='pid']"));
		webtest.leaveFrame();

	}
	
	//登录商城后台，点击页面，点击广告列表，点击查看所有，依次点击
	@Test(priority=29)
	public void Backadvertisement29() throws InterruptedException{
//		BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");	
		for (int i = 0; i < 5; i++) {
			webtest.click("xpath=//select[@name='pid']");
			Thread.sleep(1000);
			webtest.selectByIndex("xpath=//select[@name='pid']", i);
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击全选
	@Test(priority=30)
	public void Backadvertisement30() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("class=ico-check");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("class=trSelected"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击一次新窗口
	@Test(priority=31)
	public void Backadvertisement31() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("class=fa-ban");
		Thread.sleep(1000);
		webtest.click("class=fa-check-circle");
		Assert.assertTrue(webtest.isElementPresent("class=no"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击一次显示
	@Test(priority=32)
	public void Backadvertisement32() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("class=fa-check-circle");
		Thread.sleep(1000);
		webtest.click("class=fa-ban");
		Assert.assertTrue(webtest.isElementPresent("class=yes"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击排序更改
	@Test(priority=33)
	public void Backadvertisement33() throws InterruptedException{
//		BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		Thread.sleep(1000);
		webtest.typeAndClear("xpath=//div[@class='bDiv']/div/table/tbody/tr[1]/td[8]/div/input","0");
//		Thread.sleep(2000);
		webtest.click("class=refresh-date");
		Thread.sleep(2000);	
		Assert.assertEquals(webtest.getValue("xpath=//div[@class='bDiv']/div/table/tbody/tr[1]/td[8]/div/input"),"0");
		Thread.sleep(3000);
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击登录页，点击广告，更改信息
	@Test(priority=34)
	public void Backadvertisement34() throws InterruptedException {
//		BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='登录页']");
		Thread.sleep(1000);
		webtest.click("class=advertisement");
		webtest.typeAndClear("xpath=//input[@class='input-txt']", "自定义图片");
		Assert.assertTrue(webtest.isElementPresent("link=确认提交"));
		webtest.click("link=确认提交");
		Thread.sleep(3000);
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击登录页
	@Test(priority=35)
	public void Backadvertisement35() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='登录页']");
		Thread.sleep(1000);
		webtest.type("name=username","13800138006");
		webtest.type("name=password","123456");
		webtest.type("name=verify_code", "aaaa");
		webtest.click("name=sbtbutton");
		Assert.assertTrue(webtest.isElementPresent("link=首页"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击搜索输入名称，搜索
	@Test(priority=36)
	public void Backadvertisement36() throws InterruptedException {
//		BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.type("xpath=//input[@class='qsbox']", "自定义图片");
		Thread.sleep(1000);
		webtest.click("xpath=//input[@value='搜索']");
		Assert.assertEquals(webtest.getText("xpath=//div[@class='bDiv']/div/table/tbody/tr/td[4]/div"),"自定义图片");
		Thread.sleep(2000);
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击手机首页，上传背景图
	@Test(priority=37)
	public void Backadvertisement37() throws InterruptedException {
//		BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='手机首页']");
		webtest.click("class=banner");
		webtest.click("xpath=//input[@class='type-file-file']");
		Thread.sleep(1000);
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("xpath=//li[@id='manage_tab']");
		webtest.click("class=img");
		webtest.click("class=btn");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@id='submitBtn']");	
		Thread.sleep(2000);
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击手机首页，点击底部按钮
	@Test(priority=38)
	public void Backadvertisement38() throws InterruptedException {
		BackLogin();
		Thread.sleep(4000);
		FindElement();
//		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='手机首页']");
		webtest.click("xpath=//div[@class='footer']/ul/li[2]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='footer']/ul/li[3]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='footer']/ul/li[4]/a");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("class=yello"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击手机分类页，点击手机等
	@Test(priority=39)
	public void Backadvertisement39() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='手机分类页']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@data-id='1']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@data-id='2']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@data-id='3']");
		Assert.assertTrue(webtest.isElementPresent("class=red"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击下一页，上一页
	@Test(priority=40)
	public void Backadvertisement40() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,1500)");
		webtest.click("xpath=//a[@class='next']");
		webtest.runJs("window.scrollTo(0,1500)");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='prev']");
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@title='登录页']"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，点击1 2
	@Test(priority=41)
	public void Backadvertisement41() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,1500)");
		webtest.click("xpath=//a[@href='/index.php/admin/Ad/adList/m/Admin/c/Ad/a/adList/p/2']");
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,1500)");
		webtest.click("xpath=//a[@href='/index.php/admin/Ad/adList/m/Admin/c/Ad/a/adList/p/3']");
		webtest.runJs("window.scrollTo(0,1500)");
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,1500)");
		webtest.click("xpath=//a[@href='/index.php/admin/Ad/adList/m/Admin/c/Ad/a/adList/p/1']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@title='登录页']"));
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，删除
	@Test(priority=42)
	public void Backadvertisement42() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("link=删除");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("link=确定"));
		webtest.click("link=确定");
		webtest.leaveFrame();	
	}
	
	//登录商城后台，点击页面，点击广告列表，直接删除
	@Test(priority=43)
	public void Backadvertisement43() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='bDiv']/div/table/tbody/tr[1]/td[1]/div/i");
		webtest.click("link=删除");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("link=确定"));
		webtest.click("link=确定");
		webtest.leaveFrame();
	}
	
	//登录商城后台，点击页面，点击广告列表，三个批量删除
	@Test(priority=44)
	public void Backadvertisement44() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='bDiv']/div/table/tbody/tr[1]/td[1]/div/i");
		webtest.click("xpath=//div[@class='bDiv']/div/table/tbody/tr[2]/td[1]/div/i");
		webtest.click("xpath=//div[@class='bDiv']/div/table/tbody/tr[3]/td[1]/div/i");
		Thread.sleep(1000);
		webtest.click("xpath=//div[@title='批量删除']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("link=确定"));
		webtest.click("link=确定");
		webtest.leaveFrame();
	}
}
