package com.selenium.maps;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class MapWithDataProvider {
  @Test(dataProvider = "testdata")
  public void Test(Map<Object, Object>mapdata) {
	  System.out.println("------------test started------------");
	  System.out.println(mapdata.get("UserName"));
	  System.out.println(mapdata.get("PassWord"));
	  System.out.println(mapdata.get("DOB"));
	  System.out.println("-------------test ended--------------");
  }

  @DataProvider(name="testdata")
  public Object[][] ReExcelData() throws Exception {
	  String filepath="D:\\Library\\Live_Project\\Excel_files\\Logindata.xlsx";
	  File file=new File(filepath);
	  FileInputStream fi=new FileInputStream(file);
	  XSSFWorkbook wb=new XSSFWorkbook(fi);
	  XSSFSheet sheet=wb.getSheet("Sheet2");
	  wb.close();
	  int rowCount=sheet.getLastRowNum();
	  int columnCount=sheet.getRow(0).getLastCellNum();
	  Object[][] obj=new Object[rowCount][1];
	  for (int i = 0; i <rowCount; i++) {
		  HashMap<Object, Object> datamap=new HashMap<Object, Object>();
		  for (int j = 0; j <columnCount; j++) {
			datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
		}
		obj[i][0]=datamap;
	}
	  
    return obj;
      
    }
  }

