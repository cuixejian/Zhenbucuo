package www.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageoject.BaseTest;

/**
 * author:zhangjing
 
 */

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
	
	//跳转家居城
	public void FindElement() {
		webtest.open("http://localhost:83/");
		webtest.open("http://localhost:83/index.php/Home/Goods/goodsList/id/30");
	}
	
	//跳转图书馆
	public void FindElement2() {
		webtest.open("http://localhost:83/");
		webtest.open("http://localhost:83/index.php/Home/Goods/goodsList/id/83");
	}
	
	//打开商城前台，点击家居城，点击“厨具”跳转，点击“水具酒具”
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
	
	//打开商城前台，点击家居城，颜色分类点击“多选”，点击“30cm 40cm 50cm”，点击确定
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
	
	//打开商城前台，点击家居城，颜色分类点击“多选”，点击确定
	@Test(priority=3)
	public void furnitureChoice3() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("class=dx_choice");
		webtest.click("class=u-cancel");
		Thread.sleep(2000);	
		Assert.assertTrue(webtest.isElementPresent("class=dx_choice"));
	}
	
	//打开商城前台，点击家居城，颜色分类点击“多选”，点击“30cm 40cm 50cm”，点击取消
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
	
	//打开商城前台，点击家居城，颜色分类点击“黑色框小号”跳转，风格点击“田园”，摆件类型点击“手工织造”，适用空间“客厅”，点击清空筛选条件
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
	
	//打开商城前台，点击家居城，点击“厨具”跳转，滑到“厨具”，点击“家纺”
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
	
	//打开商城前台，点击家居城，点击“厨具”跳转，点击“全部结果”
	@Test(priority=7)
	public void furnitureChoice7() throws InterruptedException{
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=厨具");
		webtest.click("link=全部结果");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//a[@href='/index.php/Home/Goods/goodsList/id/262.html']"));
		
	} 
	
	//打开商城前台，点击家居城，颜色分类点击“黑色框小号”跳转，点击除去“颜色分类：黑色框小号”
	@Test(priority=8)
	public void furnitureChoice8() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("xpath=//a[@href='/index.php/home/Goods/goodsList/id/30/spec/27_106']");
		webtest.click("class=u-av-label");
		Thread.sleep(1000);
		
		Assert.assertTrue(webtest.isDisplayed("link=30cm"));
	}
	
	//打开商城前台，点击家居城，点击“更多选项”
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
	
	//打开商城前台，点击家居城，点击“销量”
	@Test(priority=10)
	public void furnitureButton10() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=销量");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//li[@class='red']"));
	}
	
	//打开商城前台，点击家居城，点击“价格”，再次点击“价格”
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
	
	//打开商城前台，点击家居城，点击“评论”
	@Test(priority=12)
	public void furnitureButton12() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=评论");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//li[@class='red']"));
	}
	
	//打开商城前台，点击家居城，点击“新品”
	@Test(priority=13)
	public void furnitureButton13() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=新品");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//li[@class='red']"));
	}
	
	//打开商城前台，点击家居城，点击“筛选后退”，点击“筛选前进”
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
	
	//打开商城前台，点击家居城，滑到图片下面，添加数量，加入购物车
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
	
	//打开商城前台，点击家居城，滑到图片下面，点击链接，立即购买
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
	
	//打开商城前台，点击家居城，滑动到下面，点击“下一页”，点击“上一页”
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
	
	//打开商城前台，点击家居城，滑动到下面，点击“1”，点击“2”
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
	
	//打开商城前台，点击家居城，滑动到下面，点击“换一换”
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
	
	//打开商城前台，点击家居城，点击推荐热卖，图片超链接
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
	
	//打开商城前台图书馆，选择路径最长一项进行测试
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
	
	//打开商城前台图书馆，更多选项选择价格筛选
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
	
	//打开商城前台图书馆，更多选项填选价格筛选
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
	
	//打开商城前台图书馆，添加数量为10的两个商品添加购物车
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
	
	//打开商城前台图书馆，网页底部文字友情链接
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
	
	//打开商城前台图书馆，商品下列小图的滑动
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