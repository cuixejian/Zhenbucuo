package www.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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
//	 //ָ��Ҫ������excel�ļ���·����sheet����
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
//	 //��ȡexcel�ļ�ָ����Ԫ������(�˷���ֻ���.xlsx��꡵�Excel�ļ�)
//	 public static String getCellData(int rowNum,int colNum) throws Exception{
//		 try {
//			//��ȡָ����Ԫ�����
//			 cell = excelWSheet.getRow(rowNum).getCell(colNum);
//	        //��ȡ��Ԫ�������
//	        //���Ϊ�ַ������ͣ�ʹ��getStringCellValue()������ȡ��Ԫ�����ݣ����Ϊ�������ͣ�����getNumericCellValue()��ȡ��Ԫ������
//	         String cellData = cell.getStringCellValue();
//	         return cellData;    
//	         } catch (Exception e) {
//	        	 return "";
//	        	 }
//		 }
//	 //��EXCEL��ִ�е�Ԫ����д������(�˷���ֻ���.xlsx��꡵�Excel�ļ�) rowNum �кţ�colNum �к�
//	 public static void setCellData(int rowNum,int colNum,String Result) throws Exception{
//		 try {
//			 //��ȡ�ж���
//	         row = excelWSheet.getRow(rowNum);
//	         //�����Ԫ��Ϊ�գ��򷵻�null
//	         cell = row.getCell(colNum);
//	         if(cell == null){
//	        	 cell=row.createCell(colNum);
//	             cell.setCellValue(Result);
//	             }else{
//	            	 cell.setCellValue(Result);
//	            }
//	         FileOutputStream out = new FileOutputStream("f:\\QQ����Ĳ�������.xlsx");
//	         //������д��excel��
//	         excelWBook.write(out);
//	         out.flush();
//	         out.close();
//	         } catch (Exception e) {
//	        	 e.printStackTrace();
//	        }
//		 }
	
	 //��EXCEL�ļ��л�ȡ��������
	 public static Object[][] getTestData(String excelFilePath,String sheetName) throws IOException{
		//����һ��file�ļ�����
		 File file = new File(excelFilePath);
		//����һ��������
		 FileInputStream fileInputStream = new FileInputStream(file);
		//����workbook����
		 Workbook workbook = null;
		//�ж��ļ���չ��
		 String fileExtensionName = excelFilePath.substring(excelFilePath.indexOf("."));
		 System.out.println(fileExtensionName);
		 if (fileExtensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(fileInputStream);
		}else if (fileExtensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(fileInputStream);
		}
		 
		 //��ȡsheet����	
		 Sheet sheet = workbook.getSheet(sheetName);
		 //��ȡsheet�����ݵ�����,�кŴ�0ʼ
		 int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		// ��ȡ��ǰsheet�������кź��кŶ��Ǵ�0��ʼ
		 List<Object[]> records = new ArrayList<Object[]>();
		 //��ȡ���ݣ�ʡ�Ե�һ�б�ͷ��
		 for(int i=1; i<rowCount+1; i++){
			 //��ȡ�ж���
			 Row row = sheet.getRow(i);
			 System.out.println(">>>>>>>>>>> "+ row.getLastCellNum());
			 //����һ�������ÿ�еĲ�������,excel������в��贫ֵ
			 String[] fields = new String[row.getLastCellNum()-2];
			 //excel�����ڶ���ΪY����ʾ������Ҫ�����Խű�ִ�У�����ִ��
			 if(row.getCell(row.getLastCellNum()-2).getStringCellValue().equals("Y")){
				 for(int j=0; j<row.getLastCellNum()-2; j++){
					 //�жϵ�Ԫ�����������ֻ����ַ�
					 fields[j] = row.getCell(j).getCellType() == CellType.STRING ? row.getCell(j).getStringCellValue() : ""+row.getCell(j).getNumericCellValue(); 
					 }
				 records.add(fields);
				 }
			 }
		 //��listתΪObject��ά����
	     Object[][] results = new Object[records.size()][];
	     //���ö�ά����ÿ�е�ֵ��ÿ����һ��object����
	     for(int i=0; i<records.size(); i++){
	    	 results[i]=records.get(i);
	    	 }
	     return results;
	     }
}
