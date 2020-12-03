package com.webtest.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.beust.jcommander.internal.Lists;
import com.webtest.demo.Test1;


import freemarker.template.TemplateException;

public class JavaMailTestListener extends TestListenerAdapter {
	@Override
	public void onFinish(ITestContext testContext) {
		 ArrayList<Test1> tests=new ArrayList<Test1>();
		//统计失败与成功用例的个数
	
		List<ITestResult> failedList=this.getFailedTests();
		List<ITestResult> passedList=this.getPassedTests();
		Map  classMap = new HashMap();
		ITestNGMethod method[]=this.getAllTestMethods();
		List failedList1=new ArrayList();
		List passedList1=new ArrayList();
		int len=this.getAllTestMethods().length;
			int len1 =this.getPassedTests().size();
			int len2 =this.getFailedTests().size();
			System.out.println("所有的测试用例："+len);
			System.out.println("成功的测试用例："+len1);
			System.out.println("失败的测试用例："+len2);
			String result="本次运行了"+len+"个测试用例,成功了"+len1+"个失败了"+len2+"个";
			System.out.println(result);
			for(int j=0;j<failedList.size();j++)
			{
				ITestResult tr=(ITestResult) failedList.get(j);
				for(int i=0;i<method.length;i++)
				{
					if(tr.getMethod().getMethodName().equals(method[i].getMethodName()))
					{
						if(method[i].getDescription()!=null)
						{
							tr.setAttribute("name", method[i].getDescription());
						}
						else
						{
							tr.setAttribute("name", "fail");
							
						}
						break;
					}
				}
				failedList1.add(tr);
			}
			for(int j=0;j<passedList.size();j++)
			{
				ITestResult tr=(ITestResult) passedList.get(j);
				for(int i=0;i<method.length;i++)
				{
					if(tr.getMethod().getMethodName().equals(method[i].getMethodName()))
					{
						if(method[i].getDescription()!=null)
						{
							tr.setAttribute("name", method[i].getDescription());
						}
						else
						{
							tr.setAttribute("name", "pass");
						}
						break;
					}
				}
				passedList1.add(tr);
			}
		BufferedReader bReader = null;
		try {
			bReader = new BufferedReader(new FileReader("D:\\lianxi\\Java\\auto2020\\data\\test.html"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
        classMap.put("title", result);
        classMap.put("failedlist",failedList1);
        classMap.put("passedlist",passedList1);
       
        try {
//			createDayReportFiles.createDayReportFile(classMap,tests,"test.html","D:\\lianxi\\Java\\auto2020\\data","test.ftl");
			createDayReportFiles.createDayReportFile(classMap,"D:\\lianxi\\Java\\auto2020\\data\\test.html","D:\\lianxi\\Java\\auto2020\\data","test.ftl");
		} catch (TemplateException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
		String html="";
		String content="";
		try {
			content = bReader.readLine();
			while (content != null) {
				content = bReader.readLine();
				html=html+content;
			}
			System.out.println(html);
			
			MailUtil.mail(html);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

 catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
