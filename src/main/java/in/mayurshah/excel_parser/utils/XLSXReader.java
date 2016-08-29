package in.mayurshah.excel_parser.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.mayurshah.excel_parser.ExcelFile;
import in.mayurshah.excel_parser.intf.ExcelFileIntf;

public class XLSXReader implements ExcelFileIntf {
	private ExcelFile file;

	public XLSXReader(ExcelFile file) {
		this.file = file;
	}

	public List<HashMap<String, String>> getData() {
		List<HashMap<String, String>> data = new ArrayList<HashMap<String,String>>();
		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheetAt(0);
			data = SheetIterator.getData(sheet.iterator());
			book.close();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}

		return data;
	}

	public HashMap<String, List<String>> getDataNew() throws IOException {
		HashMap<String, List<String>> data = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheetAt(0);
			data = SheetIterator.getDataNew(sheet.iterator());
			book.close();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}

		return data;
	}

}
