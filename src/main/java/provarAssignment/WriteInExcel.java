package provarAssignment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebDriver;


public class WriteInExcel 
{
	WebDriver driver;
	
	public WriteInExcel(WebDriver driver)
	{
		this.driver=driver;
	}
	public void write(String filePath, String fileName, HashMap<String,String> idName) throws IOException
	{
		String id,value;
		Workbook wb = new XSSFWorkbook();
		Sheet sheet=wb.createSheet();
		int rowCount =0;
		Iterator<Map.Entry<String, String>> it = idName.entrySet().iterator();
		while (it.hasNext())
		{
			int columnCount = 0;
		    Map.Entry<String,String> pair = it.next();
		    id= pair.getKey();
		    value= pair.getValue();
		   
            Row row = sheet.createRow(rowCount);
            rowCount++;
            Cell cell = row.createCell(columnCount);
            cell.setCellValue(id);
            columnCount++;
            Cell cell2 = row.createCell(columnCount);
            cell2.setCellValue(value);
		}
        FileOutputStream outputStream = new FileOutputStream(filePath+"\\"+fileName);
		wb.write(outputStream);
		wb.close();
		outputStream.close();
	}
}
