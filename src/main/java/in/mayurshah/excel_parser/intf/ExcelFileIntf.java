package in.mayurshah.excel_parser.intf;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface ExcelFileIntf {
	List<HashMap<String, String>> getData() throws IOException;

}
