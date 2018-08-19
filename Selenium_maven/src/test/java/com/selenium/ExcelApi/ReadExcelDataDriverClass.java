package com.selenium.ExcelApi;

import org.testng.annotations.Test;

public class ReadExcelDataDriverClass {
	
  @Test
  public void f() throws Exception {
	  ExcelApi e=new ExcelApi("D:\\Library\\Live_Project\\Excel_files\\Logindata.xlsx");
	  System.out.println("-----Read excel data by using column Number-----");
	  System.out.println(e.getCellValue("Sheet2", 0, 1));
	  System.out.println(e.getCellValue("Sheet2", 1, 1));
	  System.out.println(e.getCellValue("Sheet2", 2, 1));
	  System.out.println("****************************************");
	  System.out.println("-----Read excel data by using column Name");
	  System.out.println(e.getCellValue("Sheet2", "UserName", 1));
	  System.out.println(e.getCellValue("Sheet2", "PassWord", 1));
	  System.out.println(e.getCellValue("Sheet2", "Results", 1));
	  System.out.println("-----Write excel data by using column Number");
	 // e.setCellData("Sheet2", 2, 3, "PASSED");
	  System.out.println("-----Write excel data by using column Name");
	  e.setCellData("Sheet2", "Results", 5, "SKIPPED");
	 
  }
}
