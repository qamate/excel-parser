package in.mayurshah.excel_parser.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class SheetIterator {
	public static List<HashMap<String, String>> getData(Iterator<Row> itr){
		List<HashMap<String, String>> data = new ArrayList<HashMap<String,String>>();
		String[] headers = null;
		// Iterating over Excel file in Java
		while (itr.hasNext()) {
			Row row = itr.next();
			HashMap<String, String> hRow = null;
			if(headers == null)
				headers = new String[row.getPhysicalNumberOfCells()];
			else
				hRow = new HashMap<String, String>();
			int count =0;
			// Iterating over each column of Excel file
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = "";
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					cellValue += cell.getStringCellValue();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cellValue += cell.getStringCellValue();
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					cellValue += cell.getStringCellValue();
					break;
				default:
				}
				if(hRow == null)
					headers[count] = cellValue;
				else
					hRow.put(headers[count], cellValue);
				count++;
			}
			if(hRow != null)
				data.add(hRow);
		}
		return data;
	}
	
	public static HashMap<String, List<String>> getDataNew(Iterator<Row> itr){
		HashMap<String, List<String>> data = new HashMap<String, List<String>>();
		List<HashMap<String, String>> oldFormat = SheetIterator.getData(itr);
		{
			Set<String> keys = null;
			List<String> colData = null;
			if(oldFormat.size() > 0)
				keys = oldFormat.get(0).keySet();
			for(String key : keys){
				for(HashMap<String, String> row : oldFormat){
					colData = new ArrayList<String>();
					colData.add(row.get(key));
				}
				data.put(key, colData);
			}
		}
		return data;
	}
}
