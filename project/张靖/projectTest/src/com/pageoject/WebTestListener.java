package com.pageoject;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class WebTestListener extends TestListenerAdapter {
	
	
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
//		super.onFinish(testContext);
//		��ӡ���ܵĲ���������Ŀ
		ITestNGMethod[] methods = this.getAllTestMethods();
		System.out.println("һ��ִ���ˣ�"+methods.length);

//		�ɹ���/ʧ�ܵĲ����������ƺ���Ŀ
		List<ITestResult> failList=this.getFailedTests();
		int len=failList.size();
		System.out.println("ʧ�ܵĲ���������"+len);
		for(int i=0;i<len;i++) {
			ITestResult tr1=failList.get(i);
			System.out.println(tr1.getInstanceName()+":"+tr1.getName()+"ʧ����");
		}
		
		List<ITestResult> passList=this.getPassedTests();
		int len2=passList.size();
		System.out.println("�ɹ��Ĳ���������"+len2);
		for(int i=0;i<len2;i++) {
			ITestResult tr1=passList.get(i);
			System.out.println(tr1.getInstanceName()+":"+tr1.getName()+"�ɹ���");
		}
		
	}
	
//	@Override
//	public void onTestFailure(ITestResult tr) {
//		// TODO Auto-generated method stub
////		super.onTestFailure(tr);
////		ʧ�ܵĲ�����������
////		BaseTest tb=(BaseTest) tr.getInstance();
////		SeleniumScreenShot screenShot=new SeleniumScreenShot(tb.getDriver());
////		try {
////			screenShot.screenShot();
////			System.out.println("onTestFailure"+tr.getInstanceName()+":"+tr.getName()+"ʧ����");
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//
//	}

}
