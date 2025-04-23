package POI;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class DataWriter {
	public static void write(String path,String[][] data) throws Exception {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("sheet1");
		for(int i=0;i<data.length;i++) {
			XSSFRow row = sheet.createRow(i);
			XSSFCell cell1 = row.createCell(0);
			XSSFCell cell2 = row.createCell(1);
			cell1.setCellValue(data[i][0]);
			cell2.setCellValue(data[i][1]);
		}
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
		wb.close();
	}
}
