package provarAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadFromExcel 
{
	WebDriver driver;
	public ReadFromExcel(WebDriver driver)
	{
		this.driver=driver;
	}
	public String read(WebDriver driver,String filePath, String fileName, String sheetName) throws Exception
	{
		 String id=null;
		 File file =    new File(filePath+"\\"+fileName);
		 FileInputStream inputStream = new FileInputStream(file);
		 Workbook wb = new XSSFWorkbook(inputStream);
		 Sheet sheet = wb.getSheet(sheetName);
		 Iterator<Row> rowIterator = sheet.iterator();
		 while(rowIterator.hasNext())
		 {
			 Row row = rowIterator.next();
			 int counter=0;
			 //For each row, iterate through each columns
			 Iterator<Cell> cellIterator = row.cellIterator();
			 while(cellIterator.hasNext())
			 {
				 Cell cell = cellIterator.next();
				 if (counter ==0)
				 {
					 id=cell.getStringCellValue();}
				 	 counter++;
				 }
			 }
		 wb.close();
		 return id;
	}
	
}
