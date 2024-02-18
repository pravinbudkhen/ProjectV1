package com.QAFox.qa.Utilites;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
public class ReadXLSData {
	static XSSFWorkbook  ExcelWorkbook;
	static XSSFSheet ExcelSheet;
	static Workbook wb;
	public static void main(String[] args) throws IOException {
		
		getData();
		
	}
	@DataProvider(name="getData")
	public static String[][] getData() throws IOException
	{
		
		/*
		File src=new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\Excel\\TestData.xlsx");
		FileInputStream XcelFile = new FileInputStream(src);
		
		ExcelWorkbook = new XSSFWorkbook(XcelFile);
		String SheetName = ExcelWorkbook.getSheetName(0);
		
		ExcelSheet=ExcelWorkbook.getSheet(SheetName);
		
		int rows = ExcelSheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		*/
		
		File src=new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\Excel\\TestData.xlsx");
		FileInputStream XcelFile = new FileInputStream(src);
		wb= WorkbookFactory.create(XcelFile);
		String excelSheetName=wb.getSheetName(0);
		Sheet sheetName=wb.getSheet(excelSheetName);
		int totalRow=sheetName.getLastRowNum();
		Row rowCels=sheetName.getRow(0);
		int totalCols=rowCels.getLastCellNum();
		System.out.println("Total Rows : "+totalRow);
		System.out.println("Total cols : "+totalCols);
		System.out.println("SheetName: "+excelSheetName);
		
		DataFormatter format=new DataFormatter();
		String testData[][]=new String[totalRow][totalCols];
		
		for(int i=1;i<=totalRow;i++)
		{
			for(int j=0;j<totalCols;j++)
			{
				testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				//System.out.println(testData[i-1][j]);
			}
		}
		
		return testData;
	}

}





