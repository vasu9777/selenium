package com.selenium.poi.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteDataToExcelByIndex {
	public FileInputStream fi;
	public FileOutputStream fo;
	public Workbook workbook;
	public Sheet sheet;
	public Row row;
	public Cell cell;
  @Test
  public void f() throws Exception {
	  fi=new FileInputStream("D:\\Library\\Live_Project\\Excel_files\\Logindata.xlsx");
	  fo=null;
	  workbook=new XSSFWorkbook(fi);
	  sheet=workbook.getSheet("Sheet1");
	  row=null;
	  cell=null;
	  row=sheet.getRow(9);
	  if(row==null)
		row=sheet.createRow(9);
	cell=row.getCell(2);
	if(cell==null)
		cell=row.createCell(2);
	cell.setCellValue("FAILED");
	fo=new FileOutputStream("D:\\Library\\Live_Project\\Excel_files\\Logindata.xlsx");
	workbook.write(fo);
	fo.close();
	  
  }
}
