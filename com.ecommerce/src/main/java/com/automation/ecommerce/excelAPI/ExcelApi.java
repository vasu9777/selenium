package com.automation.ecommerce.excelAPI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelApi {
	public FileInputStream fi=null;
	public FileOutputStream fo=null;
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	 String filepath;
	 
	 public ExcelApi(String filepath) throws Exception {
		 
		 this.filepath=filepath;
		 fi=new FileInputStream(filepath);
		 workbook=new XSSFWorkbook(fi);
		 fi.close();
	 }
	 // by using get row method
	 public int getRows(String sheetName) {
		 sheet=workbook.getSheet(sheetName);
		 int rowCount=sheet.getLastRowNum()+1;
		 return rowCount;
		 
	 }
	 //by using get columns method
	 public int getColumns(String sheetName) {
		 sheet=workbook.getSheet(sheetName);
		 row=sheet.getRow(0);
		 int columnCount=row.getLastCellNum();
		 return columnCount;
	 }
	 
	 //Reading Cell Data From Excel File By Using Column Number
	 public String getCellValue(String sheetname,int colNum,int rowNum) {
		 try {
		 sheet=workbook.getSheet(sheetname);
		 row=sheet.getRow(rowNum);
		 cell=row.getCell(colNum);
		 if(cell.getCellTypeEnum()==CellType.STRING)
			 return cell.getStringCellValue();
		 else if (cell.getCellTypeEnum()==CellType.NUMERIC) {
			 String cellValue=String.valueOf(cell.getNumericCellValue());
			 return cellValue;
		 }
			 else if (cell.getCellTypeEnum()==CellType.BLANK) {
				 return "";
			 }
				 else
					 return String.valueOf(cell.getBooleanCellValue());
			 }catch (Exception e) {
		}
			return "NO Matching Value" ;
			}
	//Reading Cell Data From Excel File By Using Column Name
		public String getCellValue(String sheetName,String colname,Integer rowNum) {
			try {
				int colNum=-1;
				sheet=workbook.getSheet(sheetName);
				row=sheet.getRow(0);
				for (int i = 0; i < row.getLastCellNum(); i++) {
					if(row.getCell(i).getStringCellValue().equals(colname))
						colNum=i;
				}
				row=sheet.getRow(rowNum);
				cell=row.getCell(colNum);
				if(cell.getCellTypeEnum()==CellType.STRING)
					 return cell.getStringCellValue();
				 else if (cell.getCellTypeEnum()==CellType.NUMERIC) {
					 String cellValue=String.valueOf(cell.getNumericCellValue());
					 return cellValue;
				 }
					 else if (cell.getCellTypeEnum()==CellType.BLANK) {
						 return "";
					 }
						 else
							 return String.valueOf(cell.getBooleanCellValue());
				
			} catch (Exception e) {
				
			}
			return "No Matching Value";
			
		}
		//writing Cell Data From Excel File By Using Column Number
		public Boolean setCellData(String sheetname,int colNum,int rowNum,String value) {
			try {
				sheet=workbook.getSheet(sheetname);
				row=sheet.getRow(rowNum);
				if(row==null)
					row=sheet.createRow(rowNum);
				cell=row.getCell(colNum);
				if(cell==null)
					cell=row.createCell(rowNum);
				cell.setCellValue(value);
				fo=new FileOutputStream(filepath);
				workbook.write(fo);
				fo.close();
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
			return true;
			}
		
		//writing Cell Data From Excel File By Using Column Name
		
		public Boolean setCellData(String sheetname,String colName,int rowNum,String value) {
			try {
				int colNum=-1;
				sheet=workbook.getSheet(sheetname);
				row=sheet.getRow(0);
				for (int i = 0; i < row.getLastCellNum(); i++) 
				{
					if(row.getCell(i).getStringCellValue().equals(colName));
					colNum=i;
				}
				row=sheet.getRow(rowNum);
				if(row==null)
					row=sheet.createRow(rowNum);
				cell=row.getCell(colNum);
						if(cell==null)
							cell.setCellValue(value);
						fo=new FileOutputStream(filepath);
						workbook.write(fo);
						fo.close();
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
			return false;
			
		}
	}
}
