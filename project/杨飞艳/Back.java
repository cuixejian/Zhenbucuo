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
		webtest.click("xpath=//input[@value='��¼']");
	}
	

	@Test(priority=1)
	public void Back1() throws InterruptedException {
		Login();
		webtest.click("link=����");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='����']");	
		Thread.sleep(3000);
	}

	
	@Test(priority=2)
	public void Back2() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=����");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//td[@class='sign'][1]");
		webtest.click("link=�鿴�����б�");
		Thread.sleep(3000);
}

	
	@Test(priority=3)
	public void Back3() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=����");
		webtest.click("link=��������");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='����']");
		Thread.sleep(3000);
	}

	
	@Test(priority=4)
	public void Back4() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=����");
		webtest.click("link=������ϸ");
		webtest.enterFrame("workspace");
		webtest.click("class=select");
		webtest.selectByValue("class=select", "108");
		webtest.click("id=brand_id");
		webtest.selectByValue("id=brand_id", "9");
		webtest.click("xpath=//input[@value='����']");
		Thread.sleep(3000);
	}

	
	@Test(priority=5)
	public void Back5() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=����");
		webtest.click("link=��Ա����");
		webtest.enterFrame("workspace");
		webtest.type("name=mobile", "123456789");
		webtest.type("name=email", "1111@163.com");
		webtest.click("xpath=//input[@value='����']");
		Thread.sleep(3000);
	}

	
	@Test(priority=6)
	public void Back6() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=����");
		webtest.click("link=��Աͳ��");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='����']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=7)
	public void Back7() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=����");
		webtest.click("link=��¼����");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='����']");
		Thread.sleep(3000);
	}
	
	@Test(priority=8)
	public void Back8() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=����");
		webtest.click("link=��¼����");
		webtest.enterFrame("workspace");
		webtest.click("class=pReload");  //ˢ������
		Thread.sleep(3000);
	}
	
	
	@Test(priority=9)
	public void Back9() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=����");
		webtest.click("link=��Ӫ����");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='����']");
		Thread.sleep(3000);
		}
	
	
	@Test(priority=10)
	public void Back10() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=����");
		webtest.click("link=��Ӫ����");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//td[@class='sign'][1]");
		webtest.click("link=�鿴��ϸ�б�");
		Thread.sleep(3000);
	}

	
	@Test(priority=11)
	public void Back11() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=����");
		webtest.click("link=ƽ̨֧����¼");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-01");
		webtest.click("xpath=//input[@id='end_time']");
		webtest.click("class=laydate-btns-now");
		webtest.click("xpath=//input[@value='����']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority =12)
	public void Back12() throws InterruptedException{
		webtest.leaveFrame();
		webtest.click("link=�̳�");
		webtest.click("link=��Ʒ�б�");
		webtest.enterFrame("workspace");
		webtest.click("id=suppliers_id");
		webtest.selectByValue("id=suppliers_id", "4");
		webtest.click("id=brand_id");
		webtest.selectByValue("id=cat_id", "354");
		webtest.click("xpath=//input[@value='����']");
		Thread.sleep(3000);
	}

	
	@Test(priority=13)
	public void Back13() throws InterruptedException{
		webtest.leaveFrame();
		webtest.click("link=�̳�");
		webtest.click("link=��Ʒ��ǩ");
		webtest.enterFrame("workspace");
		webtest.click("class=fbutton");
		webtest.type("name=label_name", "�ֻ�");
		webtest.click("id=submitBtn");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=14)
	public void Back14() throws InterruptedException{
		webtest.leaveFrame();
		webtest.click("link=�̳�");
		webtest.click("link=Ʒ���б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='add'][1]");
		webtest.type("id=brand_name", "�Ϳ�");
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
		webtest.click("link=�̳�");
		webtest.click("link=Ʒ���б�");
		webtest.enterFrame("workspace");
		webtest.type("name=keyword", "�Ϳ�");
		webtest.click("xpath=//input[@value='����']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=16)
	public void Back16() throws InterruptedException{
		webtest.leaveFrame();
		webtest.click("link=�̳�");
		webtest.click("link=�����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//th[@class='sign'][1]");
		webtest.click("xpath=//div[@class='fbutton'][3]");
		webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}

	
	@Test(priority=17)
	public void Back17() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=�̳�");
		webtest.click("link=�����־");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='start_time']", "2020-09-07");
		webtest.typeAndClear("xpath=//input[@id='end_time']","2020-12-01");
		webtest.click("id=status");
		webtest.selectByValue("id=status", "1");
		webtest.type("name=goodsname", "ˮ��");
		webtest.click("xpath=//input[@value='����']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=18)
	public void Back18() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=���ں�����");
		webtest.enterFrame("workspace");
		webtest.typeAndClear("xpath=//input[@id='w_token']","huohu123456");
		webtest.typeAndClear("xpath=//input[@name='wxname']","����Ƽ�1");
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
		webtest.click("link=΢�̳�");
		webtest.click("link=΢�Ų˵�����");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("link=ɾ��");
		webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}

	
	@Test(priority=20)
	public void Back20() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=΢�Ų˵�����");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("link=ɾ��");
		webtest.click("class=layui-layer-btn1");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=21)
	public void Back21() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�Զ��ظ�");
		webtest.enterFrame("workspace");
		webtest.click("link=��Ϣ�Զ��ظ�");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=22)
	public void Back22() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�Զ��ظ�");
		webtest.enterFrame("workspace");
		webtest.click("link=��Ϣ�Զ��ظ�");
		webtest.typeAndClear("class=tarea","��ã��ܸ���Ϊ�����");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=23)
	public void Back23() throws InterruptedException {
		webtest.leaveFrame();	
		webtest.click("link=΢�̳�");
	    webtest.click("link=�Զ��ظ�");
	    webtest.enterFrame("workspace");
		webtest.click("link=��Ϣ�Զ��ظ�");
		webtest.typeAndClear("class=tarea","��ã��ܸ���Ϊ�����");		
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=24)
	public void Back24() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�Զ��ظ�");
		webtest.enterFrame("workspace");
		webtest.click("link=��עʱ�Զ��ظ�");
		webtest.click("xpath=//input[@value='text']");
		webtest.type("class=tarea", "��ã��ܸ���Ϊ�����");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
}
	@Test(priority=25)
	public void Back25() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�Զ��ظ�");
		webtest.enterFrame("workspace");
		webtest.click("link=��עʱ�Զ��ظ�");
		webtest.click("xpath=//input[@value='news']");
		webtest.click("xpath=//div[@class='cover'][1]");
		webtest.click("link=ȷ��");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");		
	}
	
	
	@Test(priority=26)
	public void Back26() throws InterruptedException {
	webtest.leaveFrame();
	webtest.click("link=΢�̳�");
	webtest.click("link=�Զ��ظ�");
	webtest.enterFrame("workspace");
	webtest.click("xpath=//div[@class='add'][1]");
	webtest.type("name=rule", "�ۺ�");
	webtest.type("name=keywords", "�ۺ�");
	webtest.type("class=tarea","ok");
	webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
	Thread.sleep(3000);
}

	
	@Test(priority=27)
	public void Back27() throws InterruptedException {
	webtest.leaveFrame();
	webtest.click("link=΢�̳�");
	webtest.click("link=�Զ��ظ�");
	webtest.enterFrame("workspace");
	webtest.click("xpath=//div[@class='add'][1]");
	webtest.type("name=rule", "����1");
	webtest.type("name=keywords", "����1");
	webtest.click("xpath=//input[@value='news']");
	webtest.click("xpath=//div[@class='cover'][1]");
	webtest.click("link=ȷ��");
	webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
	Thread.sleep(3000);
}

	
	@Test(priority=28)
	public void Back28() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�Զ��ظ�");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("link=ɾ��");
		webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}
	
		
	@Test(priority=29)
	public void Back29() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�Զ��ظ�");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("link=ɾ��");
		webtest.click("class=layui-layer-btn1");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=30)
	public void Back30() throws InterruptedException{
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�Զ��ظ�");
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
		webtest.click("link=΢�̳�");
		webtest.click("link=ģ����Ϣ");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("link=����");
		webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=32)
	public void Back32() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=ģ����Ϣ");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");
		webtest.click("class=ico-check");
		webtest.click("class=fa fa-refresh");   //ˢ������
		Thread.sleep(3000);
	}
	
	
	@Test(priority=33)
	public void Back33() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�زĹ���");
		webtest.enterFrame("workspace");
		webtest.click("link=�ı��ز�");
		webtest.runJs("window.scrollTo(0,200)");
	    webtest.click("link=ɾ��");
	    webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=34)
	public void Back34() throws InterruptedException {	
		Login();
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�زĹ���");
		webtest.enterFrame("workspace");
		webtest.click("class=ma-btn");
		webtest.type("class=input-txt", "�ı�");
		webtest.click("id=edui77_button_body");
		webtest.click("class=edui=default");
		webtest.click("class=type-file-file");
		webtest.click("link=���߹���");
		webtest.click("class=icon");
		webtest.click("class=btn sure checked");
		webtest.click("class=bot");
		Thread.sleep(3000);
	}

	
	@Test(priority=35)
	public void Back35() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�Զ��ظ�");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");		
		webtest.click("link=�༭");
		webtest.click("xpath=//input[@value='news']");
		webtest.click("xpath=//div[@class='ma-card'][1]");
		webtest.click("link=ȷ��");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=36)
	public void Back36() throws InterruptedException {		
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�Զ��ظ�");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,200)");	
		webtest.click("link=�༭");
		webtest.typeAndClear("xpath=//input[@name='rule']", "�˻�");
		webtest.click("xpath=//a[@class='ncap-btn-big ncap-btn-green']");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=37)
	public void Back37() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�زĹ���");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='btn'][1]");		
		webtest.click("class=layui-layer-btn0");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=38)
	public void Back38() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=΢�̳�");
		webtest.click("link=�زĹ���");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='btn'][1]");
		webtest.click("class=layui-layer-btn1");
		Thread.sleep(3000);	
	}	
}
