package com.example.excel_parser;

import java.io.IOException;

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
        ExcelFile xlsxFile = new ExcelFile("d:\\file1.xlsx");
        ExcelFile xlsFile = new ExcelFile("d:\\file1.xls");
        ExcelFile csvFile = new ExcelFile("d:\\file1.csv");
        System.out.println("XLSX file");
        xlsxFile.getData();
        System.out.println("XLS file");
        xlsFile.getData();
        System.out.println("CSV file");
        csvFile.getData();
    }
}
