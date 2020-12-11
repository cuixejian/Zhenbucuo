package com.webtest.demo;
/**
 * author:cuixuejian
 * ��̨Ӫ��
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
	//��������
	@DataProvider(name = "front_login")
	public Object[][] data() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("C:\\zhenbucuo\\project\\��ѩ��\\TPshopcxj\\data\\data1.xlsx", "Sheet1");
	}
	@BeforeSuite
	public void addListener(ITestContext context) {
		System.out.println("��Ӽ�����");
		TestRunner runner = (TestRunner)context;
		runner.addListener(new JavaMailTestListener());
	}
//	@Test(priority = 1)
//	public void test1() throws InterruptedException {
////		�ɹ���½
//		webtest.open("http://localhost:82/index.php/Admin/Admin/login");
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "123456");
//		webtest.type("name=vertify", "yzm");
//		webtest.click("name=submit");
//		webtest.click("xpath=//a[@class='novice-guide-close']");
//		webtest.click("link=Ӫ��");
//		assertTrue(webtest.isTextPresent("��������"));
//	}
//    @AfterSuite
//    public void testdemo() throws IOException, AddressException, MessagingException{
//    	MailUtil2 sMai = new MailUtil2();
//    }
//	
//	��½��̨�����Ӫ�����������/��ɱ�������ӻ��	
	@Test(dataProvider = "front_login")
	public void test1(String u_ame,String p_word) throws InterruptedException {
		System.out.println(u_ame+" " +p_word);
//		�ɹ���½
		webtest.open("http://localhost:82/index.php/Admin/Admin/login");
		webtest.type("name=username", u_ame);
		webtest.type("name=password", p_word);
		webtest.type("name=vertify", "yzm");
		webtest.click("name=submit");
		webtest.click("xpath=//a[@class='novice-guide-close']");
		webtest.click("link=Ӫ��");
		assertTrue(webtest.isTextPresent("��������"));
		webtest.click("link=��������");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='��ӻ']");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        String titleString = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		webtest.type("name=title",titleString);	
		
		webtest.click("link=ѡ����Ʒ");
		webtest.enterFrame("layui-layer-iframe1");
//		webtest.click("xpath=//input[@data-id='317']");
		webtest.click("name=goods_id");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  //ִ��js���
		webtest.click("xpath=//a[@onclick='select_goods();']");
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.type("name=price", "20");
		
		webtest.type("name=goods_num", "10");
		webtest.type("name=buy_limit", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		assertTrue(webtest.isTextPresent("ȷ���ύ"));
		webtest.click("link=ȷ���ύ");
	}	
	@Test(priority = 2)
//	ʹ����������ѡ����Ʒ����ʱ�����۸����ԭ�ȼ۸�վ��֪ͨѡ��񣬵��ȷ���ύ��
	public void test2() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=Ӫ��");
		webtest.click("link=��������");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='��ӻ']");
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        String titleString = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		webtest.type("name=title",titleString);	
		
		webtest.click("link=ѡ����Ʒ");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("xpath=//input[@value='����']");
		webtest.click("name=goods_id");
		webtest.click("xpath=//a[@onclick='select_goods();']");

		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.type("name=price", "20");
		
		webtest.type("name=goods_num", "10");
		webtest.type("name=buy_limit", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		assertTrue(webtest.isTextPresent("ȷ���ύ"));
		webtest.click("link=ȷ���ύ");
		
	}	
	
	@Test(priority = 3)
//	ʹ����������
	public void test3() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='��ӻ']");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        String titleString = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		webtest.type("name=title",titleString);	
		
		webtest.click("link=ѡ����Ʒ");
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
		assertTrue(webtest.isTextPresent("ȷ���ύ"));
		webtest.click("link=ȷ���ύ");
	}	
		
//	���ɾ��
	@Test(priority = 4)
	public void test4() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			webtest.leaveFrame();
			webtest.enterFrame("workspace");  //11-20	
			webtest.click("link=ɾ��");
			webtest.click("link=ȷ��");
		}
		assertTrue(webtest.isTextPresent("��ӻ"));
	}	
	
//	����༭
	@Test(priority = 5)
	public void test5() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");  //11-20	
		webtest.click("link=�༭");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
//		webtest.click("link=ȷ���ύ");
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("��������"));
		webtest.click("link=��������");
	}	
	@Test(priority = 6)
//	�����ӻ�����Ӫ���˵��ٴε������
	public void test6() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='��ӻ']");
		webtest.leaveFrame();
		webtest.click("link=Ӫ��");
	assertTrue(webtest.isTextPresent("��������"));
		webtest.click("link=��������");	
	}	
	@Test(priority = 7)
//	�����ӻ���������
	public void test7() throws InterruptedException {

		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='��ӻ']");
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("��������"));
		webtest.click("link=��������");	
	}	
	@Test(priority = 8)
//	ѡ����Ʒ  �ر�
	public void test8() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='��ӻ']");		
		webtest.click("link=ѡ����Ʒ");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("name=goods_id");
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-close layui-layer-close1']");
		
		webtest.click("link=ѡ����Ʒ");		
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-close layui-layer-close1']");
		assertTrue(webtest.isTextPresent("ѡ����Ʒ"));
	}	
	@Test(priority = 9)
//	ѡ����Ʒ  �ر�
	public void test9() throws InterruptedException {	
		
		webtest.click("link=ѡ����Ʒ");		
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-close layui-layer-close1']");
		assertTrue(webtest.isTextPresent("ѡ����Ʒ"));
	}
//	������������ʾ
	@Test(priority = 10)
	public void test10() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=��������");
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//h4[@title='��ʾ������ò���ʱӦע���Ҫ��']");
		webtest.click("xpath=//h4[@title='��ʾ������ò���ʱӦע���Ҫ��']");
		webtest.click("xpath=//h4[@title='��ʾ������ò���ʱӦע���Ҫ��']");
		webtest.click("xpath=//h4[@title='��ʾ������ò���ʱӦע���Ҫ��']");
		assertTrue(webtest.isTextPresent("��ӻ"));
	}
//	������������ʾת����
	@Test(priority = 11)
	public void test11() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");  //11-20	
		webtest.click("xpath=//h4[@title='��ʾ������ò���ʱӦע���Ҫ��']");
		webtest.leaveFrame();
	assertTrue(webtest.isTextPresent("��������"));
		webtest.click("link=��������");
	}
//	������������ʾ
	@Test(priority = 12)
	public void test12() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");  //11-20	
		webtest.click("xpath=//h4[@title='��ʾ������ò���ʱӦע���Ҫ��']");
	assertTrue(webtest.isTextPresent("��ʾ������ò���ʱӦע���Ҫ��"));
	}
//	����򿪲�����ʾ
	@Test(priority = 13)
	public void test13() throws InterruptedException {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");  //11-20	
		webtest.click("xpath=//h4[@title='��ʾ������ò���ʱӦע���Ҫ��']");
	assertTrue(webtest.isTextPresent("��ʾ������ò���ʱӦע���Ҫ��"));
	}	
//	�����һҳ
	@Test(priority = 14)
	public void test14() {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
	assertTrue(webtest.isTextPresent("��һҳ"));
		webtest.click("link=��һҳ");
	}
//	�������ҳ
	@Test(priority = 15)
	public void test15() {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
	assertTrue(webtest.isTextPresent("3"));
		webtest.click("link=3");
	}
//	�����һҳ
	@Test(priority = 16)
	public void test16() {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
	assertTrue(webtest.isTextPresent("��һҳ"));
		webtest.click("link=��һҳ");
	}
//	�������ҳ
	@Test(priority = 17)
	public void test17() {
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
	assertTrue(webtest.isTextPresent("3"));
		webtest.click("link=3");
	}
//����Ź�
	@Test(priority = 18)
	public void test18() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=�Ź�����");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='����Ź�']");
							
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        String titleString = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		webtest.type("name=title",titleString);	
	
		webtest.click("link=ѡ����Ʒ");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("name=goods_id");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  //ִ��js���
		webtest.click("xpath=//a[@onclick='select_goods();']");
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.type("name=price", "1");
		
		webtest.type("name=goods_num", "1");
		webtest.type("name=virtual_num", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		assertTrue(webtest.isTextPresent("ȷ���ύ"));
		webtest.click("link=ȷ���ύ");
	}	
//	���ɾ��
	@Test(priority = 19)
	public void test19() throws InterruptedException {
		webtest.click("link=ɾ��");
	assertTrue(webtest.isTextPresent("ȷ��"));
		webtest.click("link=ȷ��");
	}	
	
//	����༭
	@Test(priority = 20)
	public void test20() throws InterruptedException {
//		webtest.enterFrame("workspace");  //11-20	
		webtest.click("link=�༭");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("�Ź�����"));
		webtest.click("link=�Ź�����");	
	}	
	
	@Test(priority = 21)
//	�����ӻ�����Ӫ���˵��ٴε���Ź�
	public void test21() throws InterruptedException {
		
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='����Ź�']");
		webtest.leaveFrame();
		webtest.click("link=Ӫ��");
		assertTrue(webtest.isTextPresent("�Ź�����"));
		webtest.click("link=�Ź�����");	
	}	
	@Test(priority = 22)
//	�����ӻ�����Ӫ���˵��ٴε���Ź�
	public void test22() throws InterruptedException {
	
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
		webtest.click("xpath=//div[@title='����Ź�']");
		webtest.leaveFrame();
	assertTrue(webtest.isTextPresent("�Ź�����"));
		webtest.click("link=�Ź�����");	
	}	
	
//	������������ʾ
	@Test(priority = 23)
	public void test23() throws InterruptedException {
		webtest.enterFrame("workspace");  //11-20	
		webtest.click("xpath=//h4[@title='��ʾ������ò���ʱӦע���Ҫ��']");
	assertTrue(webtest.isTextPresent("��ʾ������ò���ʱӦע���Ҫ��"));
	}
//	����򿪲�����ʾ
	@Test(priority = 24)
	public void test24() throws InterruptedException {
	
		webtest.click("xpath=//h4[@title='��ʾ������ò���ʱӦע���Ҫ��']");
	assertTrue(webtest.isTextPresent("��ʾ������ò���ʱӦע���Ҫ��"));
	}	
//	�Żݴ����鿴��Ʒ
	@Test(priority = 25)
	public void test25() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=�Żݴ���");
		webtest.enterFrame("workspace");  //11-20
//		webtest.click("");
		webtest.click("link=�鿴��Ʒ");
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-close layui-layer-close1']");
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("�Żݴ���"));
	}	
	
//	�Żݴ������
	@Test(priority = 26)
	public void test26() throws InterruptedException {
			
		webtest.click("link=�Żݴ���");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='��ӻ']");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        String titleString = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		webtest.type("name=title",titleString);	
		webtest.type("name=expression","100");
		webtest.type("name=buy_limit", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  //ִ��js���
		webtest.click("xpath=//input[@title='���ǰ��Ԥ��ͼ�ɲ鿴��ͼ�������ťѡ���ļ����ύ�����ϴ���Ч']");
		
		webtest.enterFrame1("xpath=//*[@allowtransparency='true']");
		webtest.click("xpath=//li[@id='manage_tab']");
		webtest.click("xpath=//span[@class='icon']");
		webtest.click("xpath=//li[@class='btn sure checked']");
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.click("link=ѡ����Ʒ");
		webtest.enterFrame1("xpath=//*[@allowtransparency='true']");
		webtest.click("name=goods_id[]");	
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("xpath=//a[@onclick='select_goods();']");
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
	assertTrue(webtest.isTextPresent("ȷ���ύ"));
		webtest.click("link=ȷ���ύ");
		
	}	
	
//	�Żݴ������ϴ�ͼƬ
	@Test(priority = 27)
	public void test27() throws InterruptedException {

//		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='��ӻ']");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        String titleString = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		webtest.type("name=title",titleString);	
		webtest.type("name=expression","100");
		webtest.type("name=buy_limit", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  //ִ��js���
		
		webtest.click("xpath=//input[@title='���ǰ��Ԥ��ͼ�ɲ鿴��ͼ�������ťѡ���ļ����ύ�����ϴ���Ч']");
//		webtest.enterFrame1("xpath=//*[@allowtransparency='true']");
////		�ϴ�ͼƬ��ַ
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
		webtest.click("link=ѡ����Ʒ");
		webtest.enterFrame1("xpath=//*[@allowtransparency='true']");
		webtest.click("name=goods_id[]");	
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("xpath=//a[@onclick='select_goods();']");
		webtest.leaveFrame();
		webtest.enterFrame("workspace"); 
	assertTrue(webtest.isTextPresent("ȷ���ύ"));
		webtest.click("link=ȷ���ύ");
		
	}	
//	ɾ���Żݴ���
	@Test(priority = 28)
	public void test28() {
		for (int i = 0; i < 2; i++) {
			webtest.click("link=ɾ��");
		}
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("�Żݴ���"));
	}
//	�Żݴ�����ֱ����С����
	@Test(priority = 29)
	public void test29() throws InterruptedException {
//		webtest.open("http://localhost:82/index.php/Admin/Admin/login");
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "123456");
//		webtest.type("name=vertify", "yzm");
//		webtest.click("name=submit");
//		webtest.click("xpath=//a[@class='novice-guide-close']");
//		webtest.click("link=Ӫ��");
		
		webtest.click("link=�Żݴ���");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='��ӻ']");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        String titleString = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		webtest.type("name=title",titleString);	
		webtest.type("name=expression","100");
		webtest.type("name=buy_limit", "1");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  //ִ��js���
		webtest.leaveFrame();
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//input[@title='���ǰ��Ԥ��ͼ�ɲ鿴��ͼ�������ťѡ���ļ����ύ�����ϴ���Ч']");
		webtest.click("xpath=//a[@class='layui-layer-min']");	//��С	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("ѡ����Ʒ"));
	}	
	
//	�Żݴ�����Ŵ󴰿�
	@Test(priority = 30)
	public void test30() throws InterruptedException {//�Ŵ�
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-max layui-layer-maxmin']");
		Thread.sleep(2000);
	assertTrue(webtest.isTextPresent("ѡ����Ʒ"));
	}
	
	@Test(priority = 31)
	public void test31() throws InterruptedException {	
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-max']");
		Thread.sleep(2000);
	assertTrue(webtest.isTextPresent("ѡ����Ʒ"));

	}
//	�Żݴ�����Ŵ󴰿�
	@Test(priority = 32)
	public void test32() throws InterruptedException {
		webtest.click("xpath=//a[@class='layui-layer-ico layui-layer-max layui-layer-maxmin']");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("ѡ����Ʒ"));
	}
//	�Żݴ�����ֱ�ӹرմ���
	@Test(priority = 33)
	public void test33() throws InterruptedException {
		webtest.click("xpath=//*[@class='layui-layer-ico layui-layer-close layui-layer-close1']");	
		Thread.sleep(2000);
	assertTrue(webtest.isTextPresent("ѡ����Ʒ"));
	}	
//	�����������
	@Test(priority = 34)
	public void test34() throws InterruptedException {	
		webtest.leaveFrame();
		webtest.click("link=��������");
		webtest.enterFrame("workspace");  //11-20
		webtest.click("xpath=//div[@title='��ӻ']");
//		ʲôҲ��д  ֱ��ȷ���ύ
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("link=ȷ���ύ");
		webtest.leaveFrame();
	assertTrue(webtest.isTextPresent("��������"));
	}
	@Test(priority = 35)
	public void test35() throws InterruptedException {
		
//		�������
		webtest.click("link=��������");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='��ӻ']");	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	    String titleString = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		webtest.type("name=name",titleString);	
		webtest.type("name=money","1");
		webtest.type("name=expression", "1");
	
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("link=ȷ���ύ");
		assertTrue(webtest.isTextPresent("ɾ��"));
	}
	@Test(priority = 36)
	public void test36() throws InterruptedException {
//		ɾ��
		webtest.click("link=ɾ��");
		webtest.click("link=ȷ��");
		assertTrue(webtest.isTextPresent("�༭"));
	}
	@Test(priority = 37)
	public void test37() throws InterruptedException {
//		�༭		
		webtest.click("link=�༭");
		webtest.leaveFrame();
		webtest.click("link=��������");	
		webtest.enterFrame("workspace");
		assertTrue(webtest.isTextPresent("��ӻ"));
	}
	@Test(priority = 38)
	public void test38() throws InterruptedException {
		webtest.click("xpath=//div[@title='��ӻ']");	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	    String titleString = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		webtest.type("name=name",titleString);	
		webtest.type("name=money","100");
		webtest.type("name=expression", "10000");//�ۿ۴���100
		
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("link=ȷ���ύ");
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("Ӫ��"));
	}
//	����Ż�ȯ
	@Test(priority = 39)
	public void test39() throws InterruptedException {

		
		webtest.click("link=Ӫ��");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//img[@src='/public/static/images/coupons.png']");
//		����Ż�ȯ
		webtest.click("xpath=//div[@title='����Ż�ȯ']");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	    String titleString = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		webtest.type("name=name",titleString);	
		webtest.type("name=money","1");
		webtest.type("name=condition", "1");
		webtest.type("name=createnum", "12");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");  
		webtest.click("link=ȷ���ύ");
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		assertTrue(webtest.isTextPresent("ɾ��"));
	}
	@Test(priority = 40)
	public void test40() throws InterruptedException {
//		ɾ���Ż�ȯ
		webtest.click("link=ɾ��");
		webtest.click("link=ȷ��");
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		assertTrue(webtest.isTextPresent("ɾ��"));
	}
	@Test(priority = 41)
	public void test41() throws InterruptedException {
//		ɾ��ȡ���Ż�ȯ
		webtest.click("link=ɾ��");
		webtest.click("link=ȡ��");
	assertTrue(webtest.isTextPresent("�鿴"));
	}
	@Test(priority = 42)
	public void test42() throws InterruptedException {
//		ɾ���Ż�ȯ
		webtest.click("link=�鿴");
		webtest.click("link=ɾ��");
	assertTrue(webtest.isTextPresent("ɾ��"));
	}
	@Test(priority = 43)
	public void test43() throws InterruptedException {
//	�鿴������ʾ���������
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.click("xpath=//h4[@title='��ʾ������ò���ʱӦע���Ҫ��']");
		webtest.click("xpath=//h4[@title='��ʾ������ò���ʱӦע���Ҫ��']");
		webtest.click("xpath=//i[@class='fa fa-arrow-circle-o-left']");
		
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("������ʾ"));
	}
//	�����Ż�ȯ
	@Test(priority = 44)
	public void test44() throws InterruptedException {
		
		webtest.leaveFrame();
		webtest.click("link=Ӫ��");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//img[@src='/public/static/images/coupons.png']");
		webtest.click("link=����");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("����"));
	}
//	�鿴���ż�¼
	@Test(priority = 45)
	public void test45() throws InterruptedException {
		webtest.leaveFrame();
		webtest.click("link=Ӫ��");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//img[@src='/public/static/images/record.png']");
		Thread.sleep(2000);
	assertTrue(webtest.isTextPresent("�Ż�ȯ���ż�¼"));
	}
	@Test(priority = 46)
	public void test46() throws InterruptedException {
//		�������ż�¼
//		ѡ������
		webtest.click("id=start_time");
		webtest.click("xpath=//i[@class='layui-icon laydate-icon laydate-prev-y']");
		webtest.click("xpath=//i[@class='layui-icon laydate-icon laydate-prev-y']");
		webtest.click("class=laydate-btns-confirm");
//		webtest.type("name=uid", "123");
		webtest.click("xpath=//input[@class='btn']");
		assertTrue(webtest.isTextPresent("�鿴"));
	}
	@Test(priority = 47)
	public void test47() throws InterruptedException {
//		�鿴
		
		webtest.click("link=�鿴");
		assertTrue(webtest.isTextPresent("ɾ��"));
	}
	@Test(priority = 48)
	public void test48() throws InterruptedException {
//		�鿴ɾ��
		webtest.click("link=ɾ��");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("����"));
	}
	@Test(priority = 49)
	public void test49() throws InterruptedException {
		
		webtest.click("xpath=//div[@title='����Ż�ȯ']");
		webtest.click("xpath=//a[@title='�����б�']");
		assertTrue(webtest.isTextPresent("����"));
	}
	@Test(priority = 50)
	public void test50() throws InterruptedException {
//		�������
		webtest.click("xpath=//div[@title='����']");
		assertTrue(webtest.isTextPresent("����"));
	}

}
