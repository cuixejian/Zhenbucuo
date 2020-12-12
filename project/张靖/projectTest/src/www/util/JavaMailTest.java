package www.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import www.dataprovider.MailUtil;

public class JavaMailTest extends TestListenerAdapter{
	@Override
	public void onFinish(ITestContext testContext) {
//		super.onFinish(testContext);
		
		//打印出测试用例名称和数目
		ITestNGMethod[] methods = this.getAllTestMethods();
		System.out.println("一共执行了："+methods.length);
		
		//成功/失败
		String string= new String();
		List<ITestResult> failList=this.getFailedTests();
		System.out.println("失败的测试用例"+failList.size());
		for (int i = 0; i < failList.size(); i++) {
			ITestResult tResult=failList.get(i);
			string+=tResult.getInstanceName()+":"+tResult.getName()+"失败了"+"\r\n";
			System.out.println(tResult.getInstanceName()+":"+tResult.getName()+"失败了");	
		}
		
		List<ITestResult> passList=this.getPassedTests();
		System.out.println("成功的测试用例"+passList.size());
		for (int i = 0; i < passList.size(); i++) {
			ITestResult testResult=passList.get(i);
			System.out.println(testResult.getInstanceName()+":"+testResult.getName()+"成功了");
			
		}
		
		try {
			MailUtil.send(string);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}catch (AddressException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
