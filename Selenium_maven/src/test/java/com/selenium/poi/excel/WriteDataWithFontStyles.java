package com.selenium.poi.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteDataWithFontStyles {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFFont font;
	public XSSFCellStyle style;
  @Test
  public void f() throws Exception {
	  fi=new FileInputStream("D:\\Library\\Live_Project\\Excel_files\\Logindata.xlsx");
	  fo=null;
	  workbook=new XSSFWorkbook(fi);
	  sheet=workbook.getSheet("Sheet1");
	  row=null;
	  cell=null;
	  font=workbook.createFont();
	  style=workbook.createCellStyle();
	  row=sheet.getRow(4);
	  if(row==null)
		  row=sheet.createRow(4);
	  cell=row.createCell(2);
	  font.setFontName("Arial Black");
	 
	  font.setFontHeight(10.0);
	  font.setBold(true);
	  cell.setCellStyle(style);
	  cell.setCellValue("SKIPPED");
	  fo=new FileOutputStream("D:\\Library\\Live_Project\\Excel_files\\Logindata.xlsx");
	  workbook.write(fo);
	  fo.close();
  }
}
