package com.example.excel_parser.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.example.excel_parser.ExcelFile;
import com.example.excel_parser.intf.ExcelFileIntf;

public class XLSReader implements ExcelFileIntf {
	private ExcelFile file;
	
	public XLSReader(ExcelFile file){
		this.file = file;
	}

	public List<HashMap<String, String>> getData() { 
		
		try {
			FileInputStream fis = new FileInputStream(file);
			HSSFWorkbook book = new HSSFWorkbook(fis);
			HSSFSheet sheet = book.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			// Iterating over Excel file in Java
			while (itr.hasNext()) {
				Row row = itr.next();
				// Iterating over each column of Excel file
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						System.out.print(String.valueOf(cell.getStringCellValue()) + "\t");
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t");
						break;
					default:
					}
				}
				System.out.println("");
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}

		return null;
	}

}
