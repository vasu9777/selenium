package com.selenium.poi.excel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadAllDataFromExcelFile {
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
	  int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	  System.out.println(rowCount);
	  for (int i = 1; i < rowCount; i++) {
		  row=sheet.getRow(i);
		  for (int j = 0; j < row.getLastCellNum(); j++) {
			  System.out.println(row.getCell(i).getStringCellValue());
			
		}
	}
  }
}
