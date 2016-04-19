package in.mayurshah.excel_parser.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.mayurshah.excel_parser.ExcelFile;
import in.mayurshah.excel_parser.intf.ExcelFileIntf;

public class CSVReader implements ExcelFileIntf {
	
	private ExcelFile file;
	
	public CSVReader(ExcelFile file){
		this.file = file;
	}

	public List<HashMap<String, String>> getData() throws IOException {
		Reader reader = new FileReader(file);
		List<HashMap<String, String>> data = new ArrayList<HashMap<String,String>>();
		au.com.bytecode.opencsv.CSVReader csvReader = new au.com.bytecode.opencsv.CSVReader(reader);
		String[] row = null;
		String[] headers = null;
		while((row = csvReader.readNext()) != null) {
			if(headers == null){
				headers = row;
				continue;
			}
		    HashMap<String, String> hRow = new HashMap<String, String>();
		    for(int i=0; i< row.length ; i++)
		    	hRow.put(headers[i], row[i]);
		    data.add(hRow);
		    
		}
		//...
		csvReader.close();
		return data;
	}

}
