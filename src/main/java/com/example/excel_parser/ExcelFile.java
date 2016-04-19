/**
 * 
 */
package com.example.excel_parser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.example.excel_parser.intf.ExcelFileIntf;
import com.example.excel_parser.utils.CSVReader;
import com.example.excel_parser.utils.ExcelFileTypes;
import com.example.excel_parser.utils.XLSReader;
import com.example.excel_parser.utils.XLSXReader;

/**
 * @author mayurb
 *
 */
public class ExcelFile extends File {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1630327088622878596L;

	public ExcelFile(File parent, String child) {
		super(parent, child);
		// TODO Auto-generated constructor stub
	}
	public ExcelFile(String fileName) {
		super(fileName);
	}
	@Override
	public String toString(){
		return this.getName();
	}
	public List<HashMap<String, String>> getData() throws IOException{
		String[] fileNameSplit = this.toString().split("\\.");
		ExcelFileIntf excelFileIntf = null;
		switch(ExcelFileTypes.valueOf(fileNameSplit[1].toUpperCase())){
		case XLSX:
			excelFileIntf = new XLSXReader(this);
			break;
		case XLS:
			excelFileIntf = new XLSReader(this);
			break;
		case CSV:
			excelFileIntf = new CSVReader(this);
			break;
		default:
			break;
		}
		return excelFileIntf.getData();
	}
	

}
