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
//		打印出总的测试用例数目
		ITestNGMethod[] methods = this.getAllTestMethods();
		System.out.println("一共执行了："+methods.length);
		
//		成功的/失败的测试用例名称和数目
		List<ITestResult> passList=this.getPassedTests();
		int len=passList.size();
		System.out.println("成功的测试用例："+len);
		for(int i=0;i<len;i++) {
			ITestResult tr=passList.get(i);
			System.out.println(tr.getInstanceName()+":"+tr.getName()+"成功了");
		}

		List<ITestResult> failList=this.getFailedTests();
		len=failList.size();
		System.out.println("失败的测试用例："+len);
		for(int i=0;i<len;i++) {
			ITestResult tr=failList.get(i);
			System.out.println(tr.getInstanceName()+":"+tr.getName()+"失败了");	
			if(aString ==null)
				aString=tr.getInstanceName()+":"+tr.getName()+" ";
			else
				aString+=tr.getInstanceName()+":"+tr.getName()+" ";

		}

	}
}
