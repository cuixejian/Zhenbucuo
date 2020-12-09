package www.test;

/**
  *   anthor:yangfeiyan
  *
  */

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.pageoject.BaseTest;


public class Back extends BaseTest{
	public void Login() {
		webtest.open("http://localhost:83/index.php/Admin/Admin/login#");
		webtest.type("name=username","admin");
		webtest.type("name=password","123456");
		webtest.type("name=vertify", "1234");
		webtest.click("xpath=//input[@value='登录']");
	}
	

	@Test(priority=1)
	public void Back1() throws InterruptedException {
		Login();
		webtest.click("link=数据");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='搜索']");	
		Thread.sleep(3000);
	}

	
	@Test(priority=2)
	public void Back2() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=数据");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//td[@class='sign'][1]");
		webtest.click("link=查看订单列表");
		Thread.sleep(3000);
}

	
	@Test(priority=3)
	public void Back3() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=数据");
		webtest.click("link=销售排行");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='搜索']");
		Thread.sleep(3000);
	}

	
	@Test(priority=4)
	public void Back4() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=数据");
		webtest.click("link=销售明细");
		webtest.enterFrame("workspace");
		webtest.click("class=select");
		webtest.selectByValue("class=select", "108");
		webtest.click("id=brand_id");
		webtest.selectByValue("id=brand_id", "9");
		webtest.click("xpath=//input[@value='搜索']");
		Thread.sleep(3000);
	}

	
	@Test(priority=5)
	public void Back5() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=数据");
		webtest.click("link=会员排行");
		webtest.enterFrame("workspace");
		webtest.type("name=mobile", "123456789");
		webtest.type("name=email", "1111@163.com");
		webtest.click("xpath=//input[@value='搜索']");
		Thread.sleep(3000);
	}

	
	@Test(priority=6)
	public void Back6() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=数据");
		webtest.click("link=会员统计");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='搜索']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=7)
	public void Back7() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=数据");
		webtest.click("link=登录分析");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='搜索']");
		Thread.sleep(3000);
	}
	
	@Test(priority=8)
	public void Back8() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=数据");
		webtest.click("link=登录分析");
		webtest.enterFrame("workspace");
		webtest.click("class=pReload");  //刷新数据
		Thread.sleep(3000);
	}
	
	
	@Test(priority=9)
	public void Back9() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=数据");
		webtest.click("link=运营概览");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='搜索']");
		Thread.sleep(3000);
		}
	
	
	@Test(priority=10)
	public void Back10() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=数据");
		webtest.click("link=运营概览");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//td[@class='sign'][1]");
		webtest.click("link=查看详细列表");
		Thread.sleep(3000);
	}

	
	@Test(priority=11)
	public void Back11() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=数据");
		webtest.click("link=平台支出记录");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='搜索']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority =12)
	public void Back12() throws InterruptedException{
		webtest.leaveFrame();
		webtest.click("link=商城");
		webtest.click("link=商品列表");
		webtest.enterFrame("workspace");
		webtest.click("id=suppliers_id");
		webtest.selectByValue("id=suppliers_id", "4");
		webtest.click("id=brand_id");
		webtest.selectByValue("id=cat_id", "354");
		webtest.click("xpath=//input[@value='搜索']");
		Thread.sleep(3000);
	}

	
	@Test(priority=13)
	public void Back13() throws InterruptedException{
		webtest.leaveFrame();
		webtest.click("link=商城");
		webtest.click("link=商品标签");
		webtest.enterFrame("workspace");
		webtest.click("class=fbutton");
		webtest.type("name=label_name", "手机");
		webtest.click("id=submitBtn");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=14)
	public void Back14() throws InterruptedException{
		webtest.leaveFrame();
		webtest.click("link=商城");
		webtest.click("link=品牌列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='add'][1]");
		webtest.type("id=brand_name", "耐克");
		webtest.click("id=parent_id_1");
		webtest.selectByValue("id=parent_id_1", "12");
		webtest.click("id=suppliers_id");
		webtest.selectByValue("id=parent_id_2", "28");
		webtest.click("id=submitBtn");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=15)
	public void Back15() throws InterruptedException{
		webtest.leaveFrame();
		webtest.click("link=商城");
		webtest.click("link=品牌列表");
		webtest.enterFrame("workspace");
		webtest.type("name=keyword", "耐克");
		webtest.click("xpath=//input[@value='搜索']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=16)
	public void Back16() throws InterruptedException{
		webtest.leaveFrame();
		webtest.click("link=商城");
		webtest.click("link=评论列表");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//th[@class='sign'][1]");
		webtest.click("xpath=//div[@class='fbutton'][3]");
		webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}

	
	@Test(priority=17)
	public void Back17() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=商城");
		webtest.click("link=库存日志");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-07");
		webtest.typeAndClear("xpath=//input[@id='end_time']","2020-12-01");
		webtest.click("id=status");
		webtest.selectByValue("id=status", "1");
		webtest.type("name=goodsname", "水果");
		webtest.click("xpath=//input[@value='搜索']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=18)
	public void Back18() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=公众号配置");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='w_token']","huohu123456");
		webtest.typeAndClear("xpath=//input[@name='wxname']","火狐科技1");
		webtest.typeAndClear("xpath=//input[@name='wxid']","123456");
		webtest.typeAndClear("xpath=//input[@name='weixin']","shop");
		webtest.typeAndClear("xpath=//input[@name='appid']","aaa123");
		webtest.typeAndClear("xpath=//input[@name='appsecret']","aaaaa123456");
		webtest.click("id=submitBtn");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=19)
	public void Back19() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=微信菜单管理");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("link=删除");
		webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}

	
	@Test(priority=20)
	public void Back20() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=微信菜单管理");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("link=删除");
		webtest.click("class=layui-layer-btn1");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=21)
	public void Back21() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=自动回复");
		webtest.enterFrame("workspace");
		webtest.click("link=消息自动回复");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=22)
	public void Back22() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=自动回复");
		webtest.enterFrame("workspace");
		webtest.click("link=消息自动回复");
		webtest.typeAndClear("class=tarea","你好！很高兴为你服务。");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=23)
	public void Back23() throws InterruptedException {
		webtest.leaveFrame();	
		webtest.click("link=微商城");
	    webtest.click("link=自动回复");
	    webtest.enterFrame("workspace");
		webtest.click("link=消息自动回复");
		webtest.typeAndClear("class=tarea","你好！很高兴为你服务。");		
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=24)
	public void Back24() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=自动回复");
		webtest.enterFrame("workspace");
		webtest.click("link=关注时自动回复");
		webtest.click("xpath=//input[@value='text']");
		webtest.type("class=tarea", "你好，很高兴为你服务");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
}
	@Test(priority=25)
	public void Back25() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=自动回复");
		webtest.enterFrame("workspace");
		webtest.click("link=关注时自动回复");
		webtest.click("xpath=//input[@value='news']");
		webtest.click("xpath=//div[@class='cover'][1]");
		webtest.click("link=确定");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");		
	}
	
	
	@Test(priority=26)
	public void Back26() throws InterruptedException {
	webtest.leaveFrame();
	webtest.click("link=微商城");
	webtest.click("link=自动回复");
	webtest.enterFrame("workspace");
	webtest.click("xpath=//div[@class='add'][1]");
	webtest.type("name=rule", "售后");
	webtest.type("name=keywords", "售后");
	webtest.type("class=tarea","ok");
	webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
	Thread.sleep(3000);
}

	
	@Test(priority=27)
	public void Back27() throws InterruptedException {
	webtest.leaveFrame();
	webtest.click("link=微商城");
	webtest.click("link=自动回复");
	webtest.enterFrame("workspace");
	webtest.click("xpath=//div[@class='add'][1]");
	webtest.type("name=rule", "换货1");
	webtest.type("name=keywords", "换货1");
	webtest.click("xpath=//input[@value='news']");
	webtest.click("xpath=//div[@class='cover'][1]");
	webtest.click("link=确定");
	webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
	Thread.sleep(3000);
}

	
	@Test(priority=28)
	public void Back28() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=自动回复");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("link=删除");
		webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}
	
		
	@Test(priority=29)
	public void Back29() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=自动回复");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("link=删除");
		webtest.click("class=layui-layer-btn1");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=30)
	public void Back30() throws InterruptedException{
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=自动回复");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("class=ico-check");
		webtest.click("xpath=//div[@class='fbutton'][2]");
		webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=31)
	public void Back31() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=模板消息");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("link=重置");
		webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=32)
	public void Back32() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=模板消息");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("class=ico-check");
		webtest.click("class=fa fa-refresh");   //刷新数据
		Thread.sleep(3000);
	}
	
	
	@Test(priority=33)
	public void Back33() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=素材管理");
		webtest.enterFrame("workspace");
		webtest.click("link=文本素材");
		webtest.runJs("window.scrollTo(0,200)");
	    webtest.click("link=删除");
	    webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=34)
	public void Back34() throws InterruptedException {	
		Login();
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=素材管理");
		webtest.enterFrame("workspace");
		webtest.click("class=ma-btn");
		webtest.type("class=input-txt", "文本");
		webtest.click("id=edui77_button_body");
		webtest.click("class=edui=default");
		webtest.click("class=type-file-file");
		webtest.click("link=在线管理");
		webtest.click("class=icon");
		webtest.click("class=btn sure checked");
		webtest.click("class=bot");
		Thread.sleep(3000);
	}

	
	@Test(priority=35)
	public void Back35() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=自动回复");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");		
		webtest.click("link=编辑");
		webtest.click("xpath=//input[@value='news']");
		webtest.click("xpath=//div[@class='ma-card'][1]");
		webtest.click("link=确定");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=36)
	public void Back36() throws InterruptedException {		
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=自动回复");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");	
		webtest.click("link=编辑");
		webtest.typeAndClear("xpath=//input[@name='rule']", "退货");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=37)
	public void Back37() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=素材管理");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='btn'][1]");		
		webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=38)
	public void Back38() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=微商城");
		webtest.click("link=素材管理");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='btn'][1]");
		webtest.click("class=layui-layer-btn1");
		Thread.sleep(3000);	
	}	
}
