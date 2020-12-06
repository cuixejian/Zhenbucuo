package www.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageoject.BaseTest;

public class FrontLogin extends BaseTest{
	
	public void FrontLogin() {
		System.out.println("FrontLogin的构造方法");	
		webtest.open("http://localhost:83/");
		webtest.click("link=登录");
		webtest.type("name=username","13800138006");
		webtest.type("name=password","123456");
		webtest.type("name=verify_code", "aaaa");
		webtest.click("name=sbtbutton");
	}
	
	public void FindElement() {
		webtest.open("http://localhost:83/");
		webtest.open("http://localhost:83/index.php/Home/Goods/goodsList/id/30");
	}
	
	public void FindElement2() {
		webtest.open("http://localhost:83/");
		webtest.open("http://localhost:83/index.php/Home/Goods/goodsList/id/83");
	}
	
	@Test(priority=1)
	public void furnitureChoice1() throws InterruptedException {
		FrontLogin();
		Thread.sleep(1000);
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=厨具");
		webtest.click("link=水具酒具");
		Thread.sleep(1000);
		
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@class='havedox']"));
	}
	
	@Test(priority=2)
	public void furnitureChoice2() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("class=dx_choice");
		webtest.click("link=30cm");
		webtest.click("link=40cm");
		webtest.click("class=u-confirm");
		Thread.sleep(1000);
		
		Assert.assertTrue(webtest.isElementPresent("xpath=//a[@class='u-av-label']"));
	}
	
	@Test(priority=3)
	public void furnitureChoice3() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("class=dx_choice");
		webtest.click("class=u-cancel");
		Thread.sleep(2000);	
		Assert.assertTrue(webtest.isElementPresent("class=dx_choice"));
	}
	
	@Test(priority=4)
	public void furnitureChoice4() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("class=dx_choice");
		webtest.click("link=30cm");
		webtest.click("link=40cm");
		webtest.click("class=u-cancel");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("class=dx_choice"));
	}
	
	@Test(priority=5)
	public void furnitureChoice5() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("xpath=//a[@href='/index.php/home/Goods/goodsList/id/30/spec/27_106']");
		webtest.click("xpath=//a[@href='/index.php/home/Goods/goodsList/id/30/spec/27_106/attr/21_%E7%94%B0%E5%9B%AD']");
		webtest.click("xpath=//a[@href='/index.php/home/Goods/goodsList/id/30/spec/27_106/attr/21_%E7%94%B0%E5%9B%AD%4019_%E6%89%8B%E5%B7%A5%E7%BB%87%E9%80%A0']");
		webtest.click("link=清空筛选条件");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("class=dx_choice"));
	}
	
	@Test(priority=6)
	public void furnitureChoice6() throws InterruptedException{
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=厨具");
		webtest.mouseToElement("link=清空筛选条件");
		Thread.sleep(1000);
		webtest.mouseToElement("class=disenk");
		Thread.sleep(1000);
		webtest.click("link=家纺");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("link=凉席"));
	} 
	
	@Test(priority=7)
	public void furnitureChoice7() throws InterruptedException{
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=厨具");
		webtest.click("link=全部结果");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//a[@href='/index.php/Home/Goods/goodsList/id/262.html']"));
		
	} 
	
	@Test(priority=8)
	public void furnitureChoice8() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("xpath=//a[@href='/index.php/home/Goods/goodsList/id/30/spec/27_106']");
		webtest.click("class=u-av-label");
		Thread.sleep(1000);
		
		Assert.assertTrue(webtest.isDisplayed("link=30cm"));
	}
	
	@Test(priority=9)
	public void furnitureButton9() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=更多选项");
		webtest.runJs("window.scrollTo(0,500)");
		Thread.sleep(2000);
		webtest.click("link=收起");
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(500,0)");
		Assert.assertTrue(webtest.isElementPresent("link=更多选项"));
	}
	
	@Test(priority=10)
	public void furnitureButton10() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=销量");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//li[@class='red']"));
	}
	
	@Test(priority=11)
	public void furnitureButton11() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=价格");
		Thread.sleep(2000);
		webtest.click("link=价格");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//li[@class='red']"));
	}
	
	@Test(priority=12)
	public void furnitureButton12() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=评论");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//li[@class='red']"));
	}
	
	@Test(priority=13)
	public void furnitureButton13() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=新品");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//li[@class='red']"));
	}
	
	@Test(priority=14)
	public void furnitureButton14() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=>");
		Thread.sleep(2000);
		webtest.click("link=<");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("class=z-cur"));
	}
	
	@Test(priority=15)
	public void furnitureButton15() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,300)");
		webtest.click("class=litt-zzyl1");
		webtest.click("class=p-btn");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("class=z-cur"));
	}
	
	@Test(priority=16)
	public void furnitureButton16() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,300)");
		webtest.click("class=lazy-list");
		webtest.switchWidow(1);
		Thread.sleep(3000);
		webtest.click("link=立即购买");
		Thread.sleep(4000);
		webtest.switchWidow(0);
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("link=家居城"));
	}
	
	@Test(priority=17)
	public void furnitureButton17() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,2000)");
		Thread.sleep(1000);
		webtest.click("class=next");
		Thread.sleep(4000);
		webtest.runJs("window.scrollTo(0,2000)");
		Thread.sleep(1000);
		webtest.click("class=prev");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("link=家居城"));
	}
	
	@Test(priority=18)
	public void furnitureButton18() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,2000)");
		Thread.sleep(1000);
		webtest.click("class=paginate_button");
		Thread.sleep(4000);
		webtest.runJs("window.scrollTo(0,2000)");
		Thread.sleep(1000);
		webtest.click("class=paginate_button");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("link=家居城"));
	}
	
	@Test(priority=19)
	public void furnitureButton19() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,2000)");
		Thread.sleep(2000);
		webtest.click("class=update_h");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.isDisplayed("class=pad"));
	}
	
	@Test(priority=20)
	public void furnitureButton20() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,300)");
		Thread.sleep(2000);
		webtest.click("class=lazy");
		Thread.sleep(3000);
		webtest.switchWidow(0);
		Assert.assertTrue(webtest.isDisplayed("link=家居城"));
	}
	
	@Test(priority=45)
	public void   Library45() throws InterruptedException{
		FindElement2();
		Thread.sleep(1000);
		webtest.click("link=福尔摩斯探案全集");
		webtest.click("link=福尔摩斯探案全集");
		webtest.click("link=9787510858673");
		webtest.click("link=是");
		webtest.click("link=九州出版社");
		webtest.click("link=[英]柯南·道尔");
		webtest.click("link=136-170元");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//a[@href='/index.php/Home/Goods/goodsInfo/id/317.html']"));
	}
	
	@Test(priority=46)
	public void Library46() throws InterruptedException {
		FindElement2();
		Thread.sleep(1000);
		webtest.click("class=dx_choice");
		webtest.click("link=畅销版");
		webtest.click("link=精装");
		webtest.click("class=u-confirm");
		webtest.click("link=24-36元");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//a[@href='/index.php/Home/Goods/goodsInfo/id/68.html']"));
	}
	
	@Test(priority=47)
	public void Library47() throws InterruptedException {
		FindElement2();
		Thread.sleep(1000);
		webtest.click("link=更多选项");
		webtest.runJs("window.scrollTo(0,1000)");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@id='start_price']", "50");
		webtest.type("xpath=//input[@id='end_price']", "200");
		webtest.click("xpath=//input[@value='确定']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//a[@href='/index.php/Home/Goods/goodsInfo/id/67.html']"));
	}
	
	@Test(priority=48)
	public void Library48() throws InterruptedException {
		FindElement2();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,400)");
		webtest.typeAndClear("xpath=//input[@id='number_12']", "10");
		Thread.sleep(1000);
		webtest.click("link=加入购物车");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("link=继续购物");
		webtest.leaveFrame();
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@id='number_22']", "10");
		Thread.sleep(1000);
		webtest.click("xpath=//div[@class='w1430']/div[2]/div[2]/ul/li[2]/div/div[5]/div[2]/a");
		Thread.sleep(1000);
		webtest.enterFrame("layui-layer-iframe2");
		webtest.click("link=去购物车结算");
		webtest.leaveFrame();
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//em[@id='goods_num']"));
	}
	
	@Test(priority=49)
	public void Library49() throws InterruptedException {
		String TBurl = "https://www.taobao.com/";
		FindElement2();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,2500)");
		webtest.click("link=淘宝网");
		Thread.sleep(2000);
		Assert.assertEquals(TBurl, webtest.getUrl());
		Thread.sleep(2000);
	}
	
	@Test(priority=50)
	public void Library50() throws InterruptedException {
		String TBurl = "https://www.taobao.com/";
		FindElement2();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,600)");
		Thread.sleep(1000);
		webtest.mouseToElement("xpath=//img[@data-original='/public/upload/goods/thumb/22/goods_sub_thumb_1331_236_236.png']");
		Thread.sleep(1000);
		webtest.mouseToElement("xpath=//img[@data-original='/public/upload/goods/thumb/22/goods_sub_thumb_1330_236_236.png']");
		Thread.sleep(1000);
		webtest.mouseToElement("xpath=//img[@data-original='/public/upload/goods/thumb/22/goods_sub_thumb_1332_236_236.png']");
		Thread.sleep(1000);
	}
}