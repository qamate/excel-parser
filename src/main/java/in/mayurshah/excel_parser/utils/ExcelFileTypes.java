package in.mayurshah.excel_parser.utils;

public enum ExcelFileTypes {
	XLSX,XLS,CSV;

	public static String[] list() {
		ExcelFileTypes[] fileTypes = values();
	    String[] strFileTypes = new String[fileTypes.length];

	    for (int i = 0; i < fileTypes.length; i++) {
	        strFileTypes[i] = fileTypes[i].name();
	    }

	    return strFileTypes;
	}
}
