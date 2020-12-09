package www.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageoject.BaseTest;

/**
 * author:zhangjing
 
 */

public class FrontLogin extends BaseTest{
	
	public void FrontLogin() {
		System.out.println("FrontLogin�Ĺ��췽��");	
		webtest.open("http://localhost:83/");
		webtest.click("link=��¼");
		webtest.type("name=username","13800138006");
		webtest.type("name=password","123456");
		webtest.type("name=verify_code", "aaaa");
		webtest.click("name=sbtbutton");
	}
	
	//��ת�Ҿӳ�
	public void FindElement() {
		webtest.open("http://localhost:83/");
		webtest.open("http://localhost:83/index.php/Home/Goods/goodsList/id/30");
	}
	
	//��תͼ���
	public void FindElement2() {
		webtest.open("http://localhost:83/");
		webtest.open("http://localhost:83/index.php/Home/Goods/goodsList/id/83");
	}
	
	//���̳�ǰ̨������Ҿӳǣ���������ߡ���ת�������ˮ�߾ƾߡ�
	@Test(priority=1)
	public void furnitureChoice1() throws InterruptedException {
		FrontLogin();
		Thread.sleep(1000);
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=����");
		webtest.click("link=ˮ�߾ƾ�");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@class='havedox']"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ���ɫ����������ѡ���������30cm 40cm 50cm�������ȷ��
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
	
	//���̳�ǰ̨������Ҿӳǣ���ɫ����������ѡ�������ȷ��
	@Test(priority=3)
	public void furnitureChoice3() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("class=dx_choice");
		webtest.click("class=u-cancel");
		Thread.sleep(2000);	
		Assert.assertTrue(webtest.isElementPresent("class=dx_choice"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ���ɫ����������ѡ���������30cm 40cm 50cm�������ȡ��
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
	
	//���̳�ǰ̨������Ҿӳǣ���ɫ����������ɫ��С�š���ת�����������԰�����ڼ����͵�����ֹ�֯�족�����ÿռ䡰��������������ɸѡ����
	@Test(priority=5)
	public void furnitureChoice5() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("xpath=//a[@href='/index.php/home/Goods/goodsList/id/30/spec/27_106']");
		webtest.click("xpath=//a[@href='/index.php/home/Goods/goodsList/id/30/spec/27_106/attr/21_%E7%94%B0%E5%9B%AD']");
		webtest.click("xpath=//a[@href='/index.php/home/Goods/goodsList/id/30/spec/27_106/attr/21_%E7%94%B0%E5%9B%AD%4019_%E6%89%8B%E5%B7%A5%E7%BB%87%E9%80%A0']");
		webtest.click("link=���ɸѡ����");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("class=dx_choice"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ���������ߡ���ת�����������ߡ���������ҷġ�
	@Test(priority=6)
	public void furnitureChoice6() throws InterruptedException{
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=����");
		webtest.mouseToElement("link=���ɸѡ����");
		Thread.sleep(1000);
		webtest.mouseToElement("class=disenk");
		Thread.sleep(1000);
		webtest.click("link=�ҷ�");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("link=��ϯ"));
	} 
	
	//���̳�ǰ̨������Ҿӳǣ���������ߡ���ת�������ȫ�������
	@Test(priority=7)
	public void furnitureChoice7() throws InterruptedException{
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=����");
		webtest.click("link=ȫ�����");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//a[@href='/index.php/Home/Goods/goodsList/id/262.html']"));
		
	} 
	
	//���̳�ǰ̨������Ҿӳǣ���ɫ����������ɫ��С�š���ת�������ȥ����ɫ���ࣺ��ɫ��С�š�
	@Test(priority=8)
	public void furnitureChoice8() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("xpath=//a[@href='/index.php/home/Goods/goodsList/id/30/spec/27_106']");
		webtest.click("class=u-av-label");
		Thread.sleep(1000);
		
		Assert.assertTrue(webtest.isDisplayed("link=30cm"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ����������ѡ�
	@Test(priority=9)
	public void furnitureButton9() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=����ѡ��");
		webtest.runJs("window.scrollTo(0,500)");
		Thread.sleep(2000);
		webtest.click("link=����");
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(500,0)");
		Assert.assertTrue(webtest.isElementPresent("link=����ѡ��"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ������������
	@Test(priority=10)
	public void furnitureButton10() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=����");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//li[@class='red']"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ�������۸񡱣��ٴε�����۸�
	@Test(priority=11)
	public void furnitureButton11() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=�۸�");
		Thread.sleep(2000);
		webtest.click("link=�۸�");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//li[@class='red']"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ���������ۡ�
	@Test(priority=12)
	public void furnitureButton12() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=����");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//li[@class='red']"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ��������Ʒ��
	@Test(priority=13)
	public void furnitureButton13() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.click("link=��Ʒ");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//li[@class='red']"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ������ɸѡ���ˡ��������ɸѡǰ����
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
	
	//���̳�ǰ̨������Ҿӳǣ�����ͼƬ���棬������������빺�ﳵ
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
	
	//���̳�ǰ̨������Ҿӳǣ�����ͼƬ���棬������ӣ���������
	@Test(priority=16)
	public void furnitureButton16() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,300)");
		webtest.click("class=lazy-list");
		webtest.switchWidow(1);
		Thread.sleep(3000);
		webtest.click("link=��������");
		Thread.sleep(4000);
		webtest.switchWidow(0);
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("link=�Ҿӳ�"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ����������棬�������һҳ�����������һҳ��
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
		Assert.assertTrue(webtest.isDisplayed("link=�Ҿӳ�"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ����������棬�����1���������2��
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
		Assert.assertTrue(webtest.isDisplayed("link=�Ҿӳ�"));
	}
	
	//���̳�ǰ̨������Ҿӳǣ����������棬�������һ����
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
	
	//���̳�ǰ̨������Ҿӳǣ�����Ƽ�������ͼƬ������
	@Test(priority=20)
	public void furnitureButton20() throws InterruptedException {
		FindElement();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,300)");
		Thread.sleep(2000);
		webtest.click("class=lazy");
		Thread.sleep(3000);
		webtest.switchWidow(0);
		Assert.assertTrue(webtest.isDisplayed("link=�Ҿӳ�"));
	}
	
	//���̳�ǰ̨ͼ��ݣ�ѡ��·���һ����в���
	@Test(priority=45)
	public void   Library45() throws InterruptedException{
		FindElement2();
		Thread.sleep(1000);
		webtest.click("link=����Ħ˹̽��ȫ��");
		webtest.click("link=����Ħ˹̽��ȫ��");
		webtest.click("link=9787510858673");
		webtest.click("link=��");
		webtest.click("link=���ݳ�����");
		webtest.click("link=[Ӣ]���ϡ�����");
		webtest.click("link=136-170Ԫ");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//a[@href='/index.php/Home/Goods/goodsInfo/id/317.html']"));
	}
	
	//���̳�ǰ̨ͼ��ݣ�����ѡ��ѡ��۸�ɸѡ
	@Test(priority=46)
	public void Library46() throws InterruptedException {
		FindElement2();
		Thread.sleep(1000);
		webtest.click("class=dx_choice");
		webtest.click("link=������");
		webtest.click("link=��װ");
		webtest.click("class=u-confirm");
		webtest.click("link=24-36Ԫ");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//a[@href='/index.php/Home/Goods/goodsInfo/id/68.html']"));
	}
	
	//���̳�ǰ̨ͼ��ݣ�����ѡ����ѡ�۸�ɸѡ
	@Test(priority=47)
	public void Library47() throws InterruptedException {
		FindElement2();
		Thread.sleep(1000);
		webtest.click("link=����ѡ��");
		webtest.runJs("window.scrollTo(0,1000)");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@id='start_price']", "50");
		webtest.type("xpath=//input[@id='end_price']", "200");
		webtest.click("xpath=//input[@value='ȷ��']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//a[@href='/index.php/Home/Goods/goodsInfo/id/67.html']"));
	}
	
	//���̳�ǰ̨ͼ��ݣ��������Ϊ10��������Ʒ��ӹ��ﳵ
	@Test(priority=48)
	public void Library48() throws InterruptedException {
		FindElement2();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,400)");
		webtest.typeAndClear("xpath=//input[@id='number_12']", "10");
		Thread.sleep(1000);
		webtest.click("link=���빺�ﳵ");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("link=��������");
		webtest.leaveFrame();
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@id='number_22']", "10");
		Thread.sleep(1000);
		webtest.click("xpath=//div[@class='w1430']/div[2]/div[2]/ul/li[2]/div/div[5]/div[2]/a");
		Thread.sleep(1000);
		webtest.enterFrame("layui-layer-iframe2");
		webtest.click("link=ȥ���ﳵ����");
		webtest.leaveFrame();
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//em[@id='goods_num']"));
	}
	
	//���̳�ǰ̨ͼ��ݣ���ҳ�ײ�������������
	@Test(priority=49)
	public void Library49() throws InterruptedException {
		String TBurl = "https://www.taobao.com/";
		FindElement2();
		Thread.sleep(1000);
		webtest.runJs("window.scrollTo(0,2500)");
		webtest.click("link=�Ա���");
		Thread.sleep(2000);
		Assert.assertEquals(TBurl, webtest.getUrl());
		Thread.sleep(2000);
	}
	
	//���̳�ǰ̨ͼ��ݣ���Ʒ����Сͼ�Ļ���
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