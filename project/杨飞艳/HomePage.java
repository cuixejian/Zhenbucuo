
package www.test;
/**
  *   anthor:yangfeiyan
  *
  */


import org.testng.annotations.Test;

import com.pageoject.BaseTest;

public class HomePage extends BaseTest{
	public void Login() {
		webtest.open("http://localhost:83/Home/User/login.html");
		//webtest.click("link=登录");
		webtest.type("name=username","13800138006");
		webtest.type("name=password","123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("name=sbtbutton");
		webtest.click("link=首页");
	}
	
	@Test(priority=1)
	public void HomePage1() throws InterruptedException {
		Login();
		webtest.open("http://localhost:83/");
		webtest.mouseToElement("xpath=//div[@class='item'][1]");
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//div[@class='item'][2]");
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//div[@class='item'][3]");
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//div[@class='item'][4]");
		Thread.sleep(2000);
	}
	
	
	@Test(priority=2)
	public void HomePage2() throws InterruptedException{
		webtest.open("http://localhost:83/");
		webtest.click("xpath=//div[@class='pagination']/span[3]");
		Thread.sleep(1000);
		webtest.click("xpath=//div[@class='pagination']/span[2]");
		Thread.sleep(1000);
		webtest.click("xpath=//div[@class='pagination']/span[1]");
		Thread.sleep(1000);
		webtest.click("xpath=//div[@class='pagination']/span[5]");
		Thread.sleep(1000);
		webtest.click("xpath=//div[@class='pagination']/span[4]");
		Thread.sleep(1000);
	}

	
	@Test(priority=3)
	public void HomePage3() throws InterruptedException{
		webtest.open("http://localhost:83/");
		webtest.click("xpath=//a[@data-slide='prev']");
		webtest.click("xpath=//a[@data-slide='prev']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=4)
	public void HomePage4() throws InterruptedException{
		webtest.open("http://localhost:83/");
		webtest.runJs("window.scrollTo(0,300)");
		webtest.click("xpath=//a[@class='bx-prev']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='bx-next']");
		Thread.sleep(3000);
	}

	
	@Test(priority=5)
	public void HomePage5() throws InterruptedException{
		webtest.open("http://localhost:83/");
		webtest.click("class=store-selector");
		webtest.click("link=西城区");
		Thread.sleep(3000);
	}

	
	@Test(priority=6)
	public void HomePage6() throws InterruptedException{
		webtest.open("http://localhost:83/");
		webtest.mouseToElement("class=nav-dh");
		webtest.click("link=优惠活动");
		Thread.sleep(3000);
	}

	
	@Test(priority=7)
	public void HomePage7() throws InterruptedException{
		Login();
		webtest.open("http://localhost:83/");
		webtest.click("link=服饰");
		webtest.click("link=评论");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=8)
	public void HomePage8() throws InterruptedException{
		webtest.open("http://localhost:83/");
		webtest.click("link=电脑");
		webtest.click("link=价格");	
		Thread.sleep(3000);
		webtest.click("link=价格");
		Thread.sleep(3000);	
	}
	
	
	@Test(priority=9)
	public void HomePage9() throws InterruptedException{
		webtest.open("http://localhost:83/");
		webtest.click("link=电脑");
		webtest.click("link=全白色");
		webtest.click("link=销量");
		webtest.click("link=清空筛选条件");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=10)
	public void HomePage10() throws InterruptedException{
		webtest.open("http://localhost:83/");
		webtest.click("link=电脑");
		webtest.click("link=更多选项");
		webtest.click("class=ico ico-nav-1");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=11)
	public void HomePage11() throws InterruptedException{
		webtest.open("http://localhost:83/");
		webtest.click("id=hd-my-cart");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=12)
	public void HomePage12() throws InterruptedException{
		webtest.open("http://localhost:83/");	
		webtest.click("xpath=//a[@class='key-item'][1]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[@class='key-item'][2]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[@class='key-item'][3]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[@class='key-item'][4]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[@class='key-item'][5]");
		Thread.sleep(3000);
		webtest.click("xpath=//a[@class='key-item'][6]");
		Thread.sleep(3000);
	}
}

	














