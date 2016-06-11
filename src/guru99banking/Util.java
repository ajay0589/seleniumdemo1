package guru99banking;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;

/*import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;*/

public class Util {
	
    // You can change the information of your data file here
    public static final String FILE_PATH = "testData.xls"; // File Path
    public static final String SHEET_NAME = "Data"; // Sheet name
    public static final String TABLE_NAME = "testData"; // Name of data table

    public static final int WAIT_TIME = 30; // Delay time to wait the website
					    // launch completely
    public static final String BASE_URL = "http://www.demo.guru99.com/";

    // Expected output
    public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
    public static final String EXPECT_ERROR = "User or Password is not valid";

   //  You can change the Path of FireFox base on your environment here 
    public static final String FIREFOX_PATH = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
    
    private static HSSFSheet ExcelWSheet;
    
	private static HSSFWorkbook ExcelWBook;

	private static HSSFCell Cell;

	private static HSSFRow Row;

public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

   String[][] tabArray = null;

   try {

	   FileInputStream ExcelFile = new FileInputStream(FilePath);

	   // Access the required test data sheet

	   ExcelWBook = new HSSFWorkbook(ExcelFile);

	   ExcelWSheet = ExcelWBook.getSheet(SheetName);

	   int startRow = 1;

	   int startCol = 1;

	   int ci,cj;

	   int totalRows = ExcelWSheet.getLastRowNum();

	   // you can write a function as well to get Column count

	   int totalCols = 2;

	   tabArray=new String[totalRows][totalCols];

	   ci=0;

	   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

		  cj=0;

		   for (int j=startCol;j<=totalCols;j++, cj++){

			   tabArray[ci][cj]=getCellData(i,j);

			   System.out.println(tabArray[ci][cj]);  

				}
			}
		}
	catch (FileNotFoundException e){
		System.out.println("Could not read the Excel sheet");
		e.printStackTrace();
		}
	catch (IOException e){
		System.out.println("Could not read the Excel sheet");
		e.printStackTrace();
		}
	return(tabArray);
	}

public static String getCellData(int RowNum, int ColNum) throws Exception {

	try{

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		int dataType = Cell.getCellType();

		if  (dataType == 3)
		{

			return "";

		}
		else
		{

			String CellData = Cell.getStringCellValue();

			return CellData;
		}
	}
		catch (Exception e){

		System.out.println(e.getMessage());

		throw (e);

		}

	}

}


