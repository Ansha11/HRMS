package com.HRMS.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.HRMS.Constants.Constants;

public class ExcelUtilities {

	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet sh;
	public static String getCellStringData(int RowNum, int ColNum,String Sheet) throws IOException {
		
		f=new FileInputStream(Constants.CONFIGPATH_EXCELREADER);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(Sheet);
Row r=sh.getRow(RowNum)	;
Cell c=r.getCell(ColNum);
return c.getStringCellValue();

	}

	public static int getCellNumericData(int RowNum, int ColNum,String Sheet) throws IOException
	{
		f=new FileInputStream(Constants.CONFIGPATH_EXCELREADER);

		w= new XSSFWorkbook(f);
		sh=w.getSheet(Sheet);
		return (int) sh.getRow(RowNum).getCell(ColNum).getNumericCellValue();
		
	}
}
