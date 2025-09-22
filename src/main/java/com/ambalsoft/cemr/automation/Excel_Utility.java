package com.ambalsoft.cemr.automation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author ASITEMP128
 */
public class Excel_Utility {

	/**
	 * This Method is used to fetch the single Data From given Excel Sheet
	 * @param Row
	 * @param Column
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String fetchExcelSingle_Data(String ExcelFile,String SheetName,int Row,int Column) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(ExcelFile);
		Workbook w = WorkbookFactory.create(fis);
		Sheet s = w.getSheet(SheetName);
		Row R = s.getRow(Row);
		Cell c = R.getCell(Column);
		String data = c.toString();
		return data;
	}
	/**
	 * This Method is used to Fetch all the Data present in the Excel sheet
	 * @param SheetName
	 * @return 
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public  String[][] fetchExcelAll_Data(String ExcelFile,String SheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(ExcelFile);
		Workbook w = WorkbookFactory.create(fis);
		Sheet s = w.getSheet(SheetName);
		 int rowsize = s.getPhysicalNumberOfRows();
		 int cellsize = s.getRow(0).getPhysicalNumberOfCells();
		String[][] data = new String[rowsize][cellsize];
		for(int i=0;i<rowsize;i++) {

			for(int j=0;j<cellsize;j++) {

				data[i][j] =  s.getRow(i).getCell(j).toString();
			}
		}

		return data;
	}
    
	/**
	 * This Method is used to fetch the row size of the given Excel sheet
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int fetchRowSize(String file,String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(file);
		Workbook w = WorkbookFactory.create(fis);
		Sheet s = w.getSheet(SheetName);
		int rowsize = s.getPhysicalNumberOfRows();
		return rowsize;
	}
	
	/**
	 * This Method is used to fetch the column size of the given Excel sheet
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int fetchCellSize(String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(Iconstant.CommanData);
		Workbook w = WorkbookFactory.create(fis);
		Sheet s = w.getSheet(SheetName);
		int cellsize = s.getRow(0).getPhysicalNumberOfCells();
		return cellsize;
	}
	
	
	
}
