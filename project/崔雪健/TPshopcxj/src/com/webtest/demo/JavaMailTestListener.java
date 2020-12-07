package com.webtest.demo;
/**
 * author:cuixuejian
 
 */
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class JavaMailTestListener extends TestListenerAdapter{
	static String aString ;
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
//		super.onFinish(testContext);
//		��ӡ���ܵĲ���������Ŀ
		ITestNGMethod[] methods = this.getAllTestMethods();
		System.out.println("һ��ִ���ˣ�"+methods.length);
		
//		�ɹ���/ʧ�ܵĲ����������ƺ���Ŀ
		List<ITestResult> passList=this.getPassedTests();
		int len=passList.size();
		System.out.println("�ɹ��Ĳ���������"+len);
		for(int i=0;i<len;i++) {
			ITestResult tr=passList.get(i);
			System.out.println(tr.getInstanceName()+":"+tr.getName()+"�ɹ���");
		}

		List<ITestResult> failList=this.getFailedTests();
		len=failList.size();
		System.out.println("ʧ�ܵĲ���������"+len);
		for(int i=0;i<len;i++) {
			ITestResult tr=failList.get(i);
			System.out.println(tr.getInstanceName()+":"+tr.getName()+"ʧ����");	
			if(aString ==null)
				aString=tr.getInstanceName()+":"+tr.getName()+" ";
			else
				aString+=tr.getInstanceName()+":"+tr.getName()+" ";

		}

	}
}
