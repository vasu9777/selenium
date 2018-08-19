package com.selenium.poi.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
/**
 * To Add a column to the excel file by using apache poi using xssf format
 * @author vasu
 *
 */

public class AddColumn {
  @Test
  public void f() throws Exception {
	  FileInputStream fi=new FileInputStream("D:\\Library\\Live_Project\\Excel_files\\Logindata.xlsx");
	  XSSFWorkbook w=new XSSFWorkbook(fi);
	  XSSFSheet s=w.getSheet("Sheet1");
	  XSSFRow row=s.getRow(1);
	  XSSFCell cell=row.getCell(1);
	  System.out.println(cell.getStringCellValue());
	   FileOutputStream fo = new FileOutputStream("D:\\Library\\Live_Project\\Excel_files\\Logindata.xlsx");
	  cell.setCellValue("Results");
	  w.write(fo);
	  fo.close();
	  w.close();
  }
}
