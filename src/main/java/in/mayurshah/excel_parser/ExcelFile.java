/**
 * 
 */
package in.mayurshah.excel_parser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import in.mayurshah.excel_parser.intf.ExcelFileIntf;
import in.mayurshah.excel_parser.utils.CSVReader;
import in.mayurshah.excel_parser.utils.ExcelFileTypes;
import in.mayurshah.excel_parser.utils.XLSReader;
import in.mayurshah.excel_parser.utils.XLSXReader;

/**
 * This file extends java.io.File. Pass your file location and call getData(). It will return data in form of
 * List<HashMap<String,String>>. First row is taken as key for each hashmap and following rows are values.
 * 
 * Size of List = # of rows - 1
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
