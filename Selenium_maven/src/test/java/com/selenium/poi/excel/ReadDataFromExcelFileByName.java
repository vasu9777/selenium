package com.selenium.poi.excel;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcelFileByName {
	public FileInputStream fi;
	public Workbook w;
	public Sheet sheet;
	public Row row;
	public Cell cell;
  @Test
  public void f() throws Exception {
	  fi=new FileInputStream("D:\\Library\\Live_Project\\Excel_files\\Logindata.xlsx");
	  w=new XSSFWorkbook(fi);
	  sheet=w.getSheet("Sheet1");
	  row=sheet.getRow(0);
	  cell=null;
	  int colNum=1;
	  for (int i = 0; i < row.getLastCellNum(); i++) {
		  System.out.println(row.getCell(i).getStringCellValue());
		  if (row.getCell(i).getStringCellValue().equals("pass_word")) {
			colNum=i;
			System.out.println(colNum);
		}
		
	}
	  row=sheet.getRow(6);
	  cell=row.getCell(colNum);
	  
  }
  
}
