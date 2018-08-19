package com.selenium.poi.excel;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
/**
 * to read data from excel files using apache poi xssf formats
 * @author vasu
 *
 */

public class Read_Data {
  @Test
  public void f() throws Exception {
	  FileInputStream fi=new FileInputStream("D:\\Library\\Live_Project\\Excel_files\\Logindata.xlsx");
	  XSSFWorkbook w=new XSSFWorkbook(fi);
	  XSSFSheet s=w.getSheet("Sheet1");
	  XSSFRow row=s.getRow(1);
	  XSSFCell c=row.getCell(1);
	  System.out.println(c.getStringCellValue());
	  w.close();
  }
}
