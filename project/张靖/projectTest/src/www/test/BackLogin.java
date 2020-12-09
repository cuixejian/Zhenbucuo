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
		webtest.click("xpath=//input[@value='��¼']");

	}
	
	public void FindElement() throws InterruptedException {
		Thread.sleep(1000);
		webtest.click("link=ҳ��");
		Thread.sleep(1000);
		webtest.downClick();
		Thread.sleep(1000);
		webtest.click("link=����б�");
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б���������
	@Test(priority=21)
	public void Backadvertisement21() throws InterruptedException {
		BackLogin();
		FindElement();
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,1000)");
		Thread.sleep(2000);
		webtest.runJs("window.scrollTo(0,0)");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@title='��¼ҳ']"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б������¼ҳ���������ʱ��
	@Test(priority=22)
	public void Backadvertisement22() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='��¼ҳ']");
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
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б����pc��ҳ
	@Test(priority=23)
	public void Backadvertisement23() throws InterruptedException {
//		BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='��ҳ']");
		webtest.click("link=�Ҿӳ�");
		Thread.sleep(1000);
		webtest.switchWidow(0);
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("link=�Ҿӳ�"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б�����ֻ���ҳ
	@Test(priority=24)
	public void Backadvertisement24() throws InterruptedException {
//		BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='�ֻ���ҳ']");
		webtest.click("class=search_text");
		webtest.type("xpath=//input[@id='q']", "�ֻ�");
		webtest.enter();
		Assert.assertTrue(webtest.isElementPresent("class=maleri30"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б�����ֻ�����ҳ
	@Test(priority=25)
	public void Backadvertisement25() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='�ֻ�����ҳ']");
		Assert.assertTrue(webtest.isElementPresent("class=br"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б����ɾ������ȡ�ж�
	@Test(priority=26)
	public void Backadvertisement26() throws InterruptedException {
//		BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='����ɾ��']");
		Thread.sleep(2000);	
		Assert.assertTrue(webtest.getHtmlSource().contains("<div class=\"layui-layer-move\"></div>"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б��������
	@Test(priority=27)
	public void Backadvertisement27() throws InterruptedException{
//		BackLogin();
//		FindElement();
		String string;
		webtest.click("link=����б�");    
		webtest.enterFrame("workspace");                                                  
		webtest.click("xpath=//input[@value='����']");
		webtest.click("xpath=//select[@name='pid']");
		webtest.selectByValue("xpath=//select[@name='pid']", "9");
		webtest.click("xpath=//input[@value='����']");
		string = webtest.getText("xpath=//div[@class='bDiv']/div/table/tbody/tr[1]/td[3]/div");
		Assert.assertEquals("Indexҳ���Զ����ӹ��λ 9",string);
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б�����鿴���У��鿴9��ˢ��
	@Test(priority=28)
	public void Backadvertisement28() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//select[@name='pid']");
		webtest.selectByValue("xpath=//select[@name='pid']", "9");
		webtest.click("xpath=//input[@value='����']");
		webtest.click("xpath=//a[@class='refresh-date']");
		Assert.assertTrue(webtest.isElementPresent("xpath=//select[@name='pid']"));
		webtest.leaveFrame();

	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б�����鿴���У����ε��
	@Test(priority=29)
	public void Backadvertisement29() throws InterruptedException{
//		BackLogin();
//		FindElement();
		webtest.click("link=����б�");
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
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б����ȫѡ
	@Test(priority=30)
	public void Backadvertisement30() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("class=ico-check");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("class=trSelected"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б����һ���´���
	@Test(priority=31)
	public void Backadvertisement31() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("class=fa-ban");
		Thread.sleep(1000);
		webtest.click("class=fa-check-circle");
		Assert.assertTrue(webtest.isElementPresent("class=no"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б����һ����ʾ
	@Test(priority=32)
	public void Backadvertisement32() throws InterruptedException{
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("class=fa-check-circle");
		Thread.sleep(1000);
		webtest.click("class=fa-ban");
		Assert.assertTrue(webtest.isElementPresent("class=yes"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б�����������
	@Test(priority=33)
	public void Backadvertisement33() throws InterruptedException{
//		BackLogin();
//		FindElement();
		webtest.click("link=����б�");
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
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б������¼ҳ�������棬������Ϣ
	@Test(priority=34)
	public void Backadvertisement34() throws InterruptedException {
		BackLogin();
		FindElement();
//		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='��¼ҳ']");
		Thread.sleep(1000);
		webtest.click("class=advertisement");
		webtest.typeAndClear("xpath=//input[@class='input-txt']", "�Զ���ͼƬ");
		Assert.assertTrue(webtest.isElementPresent("link=ȷ���ύ"));
		webtest.click("link=ȷ���ύ");
		Thread.sleep(3000);
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б������¼ҳ
	@Test(priority=35)
	public void Backadvertisement35() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='��¼ҳ']");
		Thread.sleep(1000);
		webtest.type("name=username","13800138006");
		webtest.type("name=password","123456");
		webtest.type("name=verify_code", "aaaa");
		webtest.click("name=sbtbutton");
		Assert.assertTrue(webtest.isElementPresent("link=��ҳ"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б���������������ƣ�����
	@Test(priority=36)
	public void Backadvertisement36() throws InterruptedException {
//		BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.type("xpath=//input[@class='qsbox']", "�Զ���ͼƬ");
		Thread.sleep(1000);
		webtest.click("xpath=//input[@value='����']");
		Assert.assertEquals(webtest.getText("xpath=//div[@class='bDiv']/div/table/tbody/tr/td[4]/div"),"�Զ���ͼƬ");
		Thread.sleep(2000);
		webtest.leaveFrame();
	}
	
//	//��¼�̳Ǻ�̨�����ҳ�棬�������б�����ֻ���ҳ���ϴ�����ͼ
//	@Test(priority=37)
//	public void Backadvertisement37() throws InterruptedException {
//		BackLogin();
//		FindElement();
////		webtest.click("link=����б�");
//		webtest.enterFrame("workspace");
//		webtest.click("xpath=//div[@title='�ֻ���ҳ']");
//		webtest.click("class=banner");
//		webtest.click("xpath=//input[@class='type-file-file']");
//		Thread.sleep(1000);
//		webtest.enterFrame("layui-layer-iframe1");
//		webtest.click("xpath=//li[@id='manage_tab']");
//		webtest.click("class=img");
//		webtest.click("class=btn");
//		Thread.sleep(2000);
//		webtest.click("xpath=//a[@id='submitBtn']");	
//		Thread.sleep(2000);
//		webtest.leaveFrame();
//	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б�����ֻ���ҳ������ײ���ť
	@Test(priority=38)
	public void Backadvertisement38() throws InterruptedException {
//		BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='�ֻ���ҳ']");
		webtest.click("xpath=//div[@class='footer']/ul/li[2]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='footer']/ul/li[3]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='footer']/ul/li[4]/a");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("class=yello"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б�����ֻ�����ҳ������ֻ���
	@Test(priority=39)
	public void Backadvertisement39() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='�ֻ�����ҳ']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@data-id='1']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@data-id='2']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@data-id='3']");
		Assert.assertTrue(webtest.isElementPresent("class=red"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б������һҳ����һҳ
	@Test(priority=40)
	public void Backadvertisement40() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.runJs("window.scrollTo(0,1500)");
		webtest.click("xpath=//a[@class='next']");
		webtest.runJs("window.scrollTo(0,1500)");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='prev']");
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@title='��¼ҳ']"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б����1 2
	@Test(priority=41)
	public void Backadvertisement41() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
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
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@title='��¼ҳ']"));
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б�ɾ��
	@Test(priority=42)
	public void Backadvertisement42() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("link=ɾ��");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("link=ȷ��"));
		webtest.click("link=ȷ��");
		webtest.leaveFrame();	
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б�ֱ��ɾ��
	@Test(priority=43)
	public void Backadvertisement43() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='bDiv']/div/table/tbody/tr[1]/td[1]/div/i");
		webtest.click("link=ɾ��");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("link=ȷ��"));
		webtest.click("link=ȷ��");
		webtest.leaveFrame();
	}
	
	//��¼�̳Ǻ�̨�����ҳ�棬�������б���������ɾ��
	@Test(priority=44)
	public void Backadvertisement44() throws InterruptedException {
		//BackLogin();
//		FindElement();
		webtest.click("link=����б�");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='bDiv']/div/table/tbody/tr[1]/td[1]/div/i");
		webtest.click("xpath=//div[@class='bDiv']/div/table/tbody/tr[2]/td[1]/div/i");
		webtest.click("xpath=//div[@class='bDiv']/div/table/tbody/tr[3]/td[1]/div/i");
		Thread.sleep(1000);
		webtest.click("xpath=//div[@title='����ɾ��']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("link=ȷ��"));
		webtest.click("link=ȷ��");
		webtest.leaveFrame();
	}
}
