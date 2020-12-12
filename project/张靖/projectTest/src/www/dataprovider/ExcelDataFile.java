package www.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * author:zhangjing
 
 */

public class ExcelDataFile {
//	 private static XSSFSheet excelWSheet;
//	 private static XSSFWorkbook excelWBook;
//	 private static XSSFCell cell;
//	 private static XSSFRow row;
//	 
//	 //指定要操作的excel文件的路径及sheet名称
//	 public static void setExcelFile(String path,String sheetName) throws Exception{
//		 FileInputStream excelFile;
//		 try {
//			 excelFile = new FileInputStream(path);
//	         excelWBook = new XSSFWorkbook(excelFile);
//	         excelWSheet = excelWBook.getSheet(sheetName);
//	         }catch (Exception e) {
//	        	 e.printStackTrace();
//	        	 }
//		 }
//	 //读取excel文件指定单元格数据(此方法只针对.xlsx后辍的Excel文件)
//	 public static String getCellData(int rowNum,int colNum) throws Exception{
//		 try {
//			//获取指定单元格对象
//			 cell = excelWSheet.getRow(rowNum).getCell(colNum);
//	        //获取单元格的内容
//	        //如果为字符串类型，使用getStringCellValue()方法获取单元格内容，如果为数字类型，则用getNumericCellValue()获取单元格内容
//	         String cellData = cell.getStringCellValue();
//	         return cellData;    
//	         } catch (Exception e) {
//	        	 return "";
//	        	 }
//		 }
//	 //在EXCEL的执行单元格中写入数据(此方法只针对.xlsx后辍的Excel文件) rowNum 行号，colNum 列号
//	 public static void setCellData(int rowNum,int colNum,String Result) throws Exception{
//		 try {
//			 //获取行对象
//	         row = excelWSheet.getRow(rowNum);
//	         //如果单元格为空，则返回null
//	         cell = row.getCell(colNum);
//	         if(cell == null){
//	        	 cell=row.createCell(colNum);
//	             cell.setCellValue(Result);
//	             }else{
//	            	 cell.setCellValue(Result);
//	            }
//	         FileOutputStream out = new FileOutputStream("f:\\QQ邮箱的测试数据.xlsx");
//	         //将内容写入excel中
//	         excelWBook.write(out);
//	         out.flush();
//	         out.close();
//	         } catch (Exception e) {
//	        	 e.printStackTrace();
//	        }
//		 }
	
	 //从EXCEL文件中获取测试数据
	 public Object[][] getTestData(String excelFilePath,String sheetName) throws IOException{
		//声明一个file文件对象
		 File file = new File(excelFilePath);
		//创建一个输入流
		 FileInputStream fileInputStream = new FileInputStream(file);
		//声明workbook对象
		 Workbook workbook = null;
		//判断文件扩展名
		 String fileExtensionName = excelFilePath.substring(excelFilePath.indexOf("."));
		 System.out.println(fileExtensionName);
		 if (fileExtensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(fileInputStream);
		}else if (fileExtensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(fileInputStream);
		}
		 
		 //获取sheet对象	
		 Sheet sheet = workbook.getSheet(sheetName);	 
		 //获取sheet中数据的行数,行号从0始
		 int rowCount = sheet.getLastRowNum() -sheet.getFirstRowNum();
		 System.out.println(rowCount);
		// 获取当前sheet行数，行号和列号都是从0开始
		 List<Object[]> records = new ArrayList<Object[]>();
		 //读取数据（省略第一行表头）
		 for(int i=1; i<rowCount+1; i++){
			 //获取行对象
			 Row row = sheet.getRow(i);
			 System.out.println(">>>>>>>>>>> "+ row.getLastCellNum());
			 //声明一个数组存每行的测试数据,excel最后两列不需传值
			 String[] fields = new String[row.getLastCellNum()-2];
			 //excel倒数第二列为Y，表示数据行要被测试脚本执行，否则不执行
			 if(row.getCell(row.getLastCellNum()-2).getStringCellValue().equals("Y")){
				 for(int j=0; j<row.getLastCellNum()-2; j++){
					 //判断单元格数据是数字还是字符
//					 fields[j] = row.getCell(j).getCellType() == CellType.STRING ? row.getCell(j).getStringCellValue() : ""+row.getCell(j).getNumericCellValue();
					 XSSFCell cell = (XSSFCell) row.getCell(j);
					 cell.setCellType(CellType.STRING);
					 fields[j] = cell.getStringCellValue();
				 }
				 records.add(fields);
				 }
			 }
		 //将list转为Object二维数据
	     Object[][] results = new Object[records.size()][];
	     //设置二维数据每行的值，每行是一个object对象
	     for(int i=0; i<records.size(); i++){
	    	 results[i]=records.get(i);
	    	 }
	     return results;
	     }
}
