package XLUtiles;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_TestData {

//		public static FileInputStream file;
		//public static XSSFWorkbook wb;
		//public static XSSFSheet sheet;
		//public static XSSFRow row	;
		//public static XSSFCell cell;
		
		public static int getrow(String path,String xlsheet) throws IOException {
			 FileInputStream	 file=new FileInputStream(path);
			 XSSFWorkbook wb=new XSSFWorkbook(file);
			 XSSFSheet sheet=wb.getSheet(xlsheet);
			int rowcount=sheet.getLastRowNum();
			return rowcount;
			
		}
		public static int getcell(String path,String xlsheet,int rownum) throws IOException {
			 FileInputStream		 file=new FileInputStream(path);
			 XSSFWorkbook	 wb=new XSSFWorkbook(file);
			 XSSFSheet sheet=wb.getSheet(xlsheet);
			 XSSFRow row	=sheet.getRow(rownum);
			int cellnum=row.getLastCellNum();
			return cellnum;
		}
		public static String getcellvalue(String path,String xlsheet,int rownum,int column ) throws IOException {
			 FileInputStream		 file=new FileInputStream(path);
			 XSSFWorkbook wb=new XSSFWorkbook(file);
			 XSSFSheet sheet=wb.getSheet(xlsheet);
			 XSSFRow row=sheet.getRow(rownum);
			 XSSFCell  cell=row.getCell(column);
			DataFormatter formatter=new DataFormatter();
			String cellData =formatter.formatCellValue(cell);
			return cellData;
		
		}

}
