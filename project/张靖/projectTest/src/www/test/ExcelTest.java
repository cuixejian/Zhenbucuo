package www.test;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageoject.BaseTest;
import www.dataprovider.ExcelDataFile;
import www.util.JavaMailTest;

/**
 * author:zhangjing
 
 */

public class ExcelTest extends BaseTest {
	//��������
	@DataProvider(name = "back_login")
	public Object[][] data() throws IOException{
		ExcelDataFile excel=new ExcelDataFile();
		return excel.getTestData("F:\\woow\\ant\\test\\projectTest\\ExcelTest\\ExcelTest1.xlsx", "SheetTest1");
//		return excel.getTestData("C:\\zhenbucuo\\project\\�ž�\\projectTest\\ExcelTest\\ExcelTest1.xlsx", "SheetTest1");
	}
	
	@BeforeSuite
	public void addListener(ITestContext context) {
		System.out.println("��Ӽ�����");
		TestRunner runner = (TestRunner)context;
		runner.addListener(new JavaMailTest());
	}
	
	@Test(dataProvider="back_login")
	public void backLogin(String username,String password) throws InterruptedException {
		System.out.println(username+""+password);
		webtest.open("http://localhost:83/index.php/Admin/Admin/login#");
		webtest.type("name=username","usename");
		webtest.type("name=password","password");
		webtest.type("name=vertify", "aaaa");
		webtest.click("xpath=//input[@value='��¼']");
		
		Thread.sleep(1000);
		webtest.click("link=ҳ��");
		Thread.sleep(1000);
		webtest.downClick();
		Thread.sleep(1000);
		webtest.click("link=����б�");
		
		
	}
}
