package www.test;

import org.testng.annotations.Test;
import com.pageoject.BaseTest;


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
	
	
	@Test(priority=21)
	public void Backadvertisement21() throws InterruptedException {
		BackLogin();
		FindElement();
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,500)");
		Thread.sleep(2000);
		webtest.runJs("window.scrollTo(0,500)");
		Thread.sleep(2000);
		webtest.leaveFrame();
	}
	
	@Test(priority=22)
	public void Backadvertisement22() throws InterruptedException {
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
		webtest.leaveFrame();
	}
	
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
		webtest.leaveFrame();
	}
	
	@Test(priority=24)
	public void Backadvertisement24() throws InterruptedException {
		//BackLogin();
		webtest.click("link=广告列表");
//		FindElement();
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='手机首页']");
		webtest.runJs("window.scrollTo(0,1500)");
		webtest.leaveFrame();
	}
	
	@Test(priority=25)
	public void Backadvertisement25() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='手机分类页']");
		webtest.runJs("window.scrollTo(0,1000)");
		webtest.leaveFrame();
	}
	
	
	@Test(priority=26)
	public void Backadvertisement26() throws InterruptedException {
		BackLogin();
		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='批量删除']");
		Thread.sleep(2000);
		System.out.println(webtest.isDisplayed("link=至少选择一项"));
		Thread.sleep(1000);
		webtest.leaveFrame();
	}
	
	@Test(priority=27)
	public void Backadvertisement27() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");    
		webtest.enterFrame("workspace");                                                  
		webtest.click("xpath=//input[@value='搜索']");
		webtest.click("xpath=//select[@name='pid']");
		webtest.selectByValue("xpath=//select[@name='pid']", "9");
		webtest.click("xpath=//input[@value='搜索']");
		webtest.click("xpath=//input[@value='搜索']");
		webtest.leaveFrame();
	}
	
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
		webtest.leaveFrame();
	}
	
	@Test(priority=29)
	public void Backadvertisement29() throws InterruptedException{
		//BackLogin();
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
	
	@Test(priority=30)
	public void Backadvertisement30() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("class=ico-check");
		Thread.sleep(1000);
		webtest.click("class=ico-check");
		webtest.leaveFrame();
	}
	
	@Test(priority=31)
	public void Backadvertisement31() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("class=fa-ban");
		Thread.sleep(1000);
		webtest.click("class=fa-check-circle");
		webtest.leaveFrame();
	}
	
	@Test(priority=32)
	public void Backadvertisement32() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("class=fa-check-circle");
		Thread.sleep(1000);
		webtest.click("class=fa-ban");
		webtest.leaveFrame();
	}
	
	@Test(priority=33)
	public void Backadvertisement33() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@value='50']", "100");
		webtest.tapClick();
		webtest.leaveFrame();
	}
	
	@Test(priority=34)
	public void Backadvertisement34() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='登录页']");
		Thread.sleep(1000);
		webtest.click("class=advertisement");
		webtest.typeAndClear("xpath=//input[@class='input-txt']", "自定义图片");
		webtest.click("link=确认提交");
		webtest.leaveFrame();
	}
	
	@Test(priority=35)
	public void Backadvertisement35() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='登录页']");
		Thread.sleep(1000);
		webtest.click("class=advertisement");
		webtest.click("xpath=//input[@id='start_time']");
		webtest.click("xpath=//span[@class='laydate-btns-now']");
		Thread.sleep(1000);
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("xpath=//span[@class='laydate-btns-now']");
		Thread.sleep(1000);
		webtest.click("class=ncap-btn-big");
		webtest.leaveFrame();
	}
	
	@Test(priority=36)
	public void Backadvertisement36() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.type("xpath=//input[@class='qsbox']", "自定义图片");
		Thread.sleep(1000);
		webtest.click("xpath=//input[@value='搜索']");
		webtest.leaveFrame();
	}
	
	@Test(priority=37)
	public void Backadvertisement37() throws InterruptedException {
		//BackLogin();
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
		webtest.click("class=ncap-btn-big");
		Thread.sleep(4000);
		webtest.leaveFrame();
	}
	
	@Test(priority=38)
	public void Backadvertisement38() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='手机首页']");
		webtest.click("xpath=//a[@href='/index.php/mobile/Goods/categoryList.html']");
	}
	
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
		webtest.leaveFrame();
	}
	
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
		webtest.leaveFrame();
	}
	
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
		webtest.leaveFrame();
	}
	
	@Test(priority=42)
	public void Backadvertisement42() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("link=删除");
		Thread.sleep(1000);
		webtest.click("link=确定");
		webtest.leaveFrame();
	}
	
	@Test(priority=43)
	public void Backadvertisement43() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=广告列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='bDiv']/div/table/tbody/tr[1]/td[1]/div/i");
		webtest.click("link=删除");
		Thread.sleep(1000);
		webtest.click("link=确定");
		webtest.leaveFrame();
	}
	
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
		webtest.click("link=确定");
		webtest.leaveFrame();
	}
}
