package www.dataprovider;
/**
 * author:zhangjing
 
 */
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NSDataProvider {

	
	@DataProvider(name="zl_shop")
	public  Object[][] getTxtData() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/user.txt");
	}
	@DataProvider(name="tsshop")
	public  Object[][] getMovieData() throws IOException{
		return new  ExcelDataFile().getTestData("data/testshop.xlxs","Sheet1");
	}
	@Test(dataProvider="txt")
	public void getData(String a,String b) {
		System.out.println(a+" "+b);
		
	}

	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataFile().getTestData("data/user.xlsx","Sheet1");
	}
	
	@DataProvider(name="tsshop")
	public Object[][] getMysqlDada() throws IOException{
		return new MysqlDataProvider().getTestDataByMysql("SELECT filmname, petname\r\n" + 
				"FROM `root` ");
	}
	
	@Test(dataProvider="tsshop")
	public void testDB(String a,String b) {
		System.out.println(a+" "+b);
	}
	
}
