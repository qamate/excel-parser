package com.example.excel_parser.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import com.example.excel_parser.ExcelFile;
import com.example.excel_parser.intf.ExcelFileIntf;

public class CSVReader implements ExcelFileIntf {
	
	private ExcelFile file;
	
	public CSVReader(ExcelFile file){
		this.file = file;
	}

	public List<HashMap<String, String>> getData() throws IOException {
		Reader reader = new FileReader(file);
		au.com.bytecode.opencsv.CSVReader csvReader = new au.com.bytecode.opencsv.CSVReader(reader);
		String[] row = null;
		int i =0;
		while((row = csvReader.readNext()) != null) {
		    System.out.println(row[0]
		              + " # " + row[1]
		              + " #  " + row[2]);
		}
		//...
		csvReader.close();
		return null;
	}

}
