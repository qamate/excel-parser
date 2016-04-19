package in.mayurshah.excel_parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import in.mayurshah.excel_parser.ExcelFile;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    public void testApp() throws IOException
    {
        ExcelFile xlsxFile = new ExcelFile("test-resources\\file1.xlsx");
        ExcelFile xlsFile = new ExcelFile("test-resources\\file1.xls");
        ExcelFile csvFile = new ExcelFile("test-resources\\file1.csv");
        System.out.println("XLSX file");
        PrintData(xlsxFile.getData());
        System.out.println("XLS file");
        PrintData(xlsFile.getData());
        System.out.println("CSV file");
        PrintData(csvFile.getData());
    }
    private void PrintData(List<HashMap<String, String>> data){
    	if(data == null) return;
    	if(data.size() == 0) return;
    	HashMap<String, String> firstRow = data.get(0);
    	Set<String> keySet = firstRow.keySet();
    	for(String key : keySet)
    		System.out.print(key + "\t");
    	System.out.println("\n");
    	for(HashMap<String, String> row : data){
    		for(String key : keySet){
    			System.out.print(row.get(key) + "\t");
    		}
    		System.out.println("\n");
    	}
    }
}
