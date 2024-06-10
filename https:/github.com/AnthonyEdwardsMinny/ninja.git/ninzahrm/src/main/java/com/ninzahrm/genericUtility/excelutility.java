package com.ninzahrm.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelutility {
	public String getdatafromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./configdata/hrm1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();
	String data   =df.formatCellValue(	wb.getSheet(sheetname).getRow(rownum).getCell(cellnum));
		
		wb.close();
		
		return data;
		
	}
	public void setdataintoExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./configdata/hrm1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
	    	wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./configdata/hrm1.xlsx");
		wb.write(fos);
		wb.close();
		
		
		

}}
