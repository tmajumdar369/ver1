package prsnl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Driver {
	

	public static void driven(File myFile) throws IOException {
		
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		System.out.println("the number of rows in the file areMS" + mySheet.getLastRowNum());
		Operator operator = new Operator();
		Map<String, List<StockDeets>> map = operator.Operate(mySheet);
		
		DataPuller dataPuller = new DataPuller();
		StockDeets stock = dataPuller.write();
		
		
		Writer writer = new Writer();
		writer.write(stock, mySheet,myFile,myWorkBook);
	}

	public static void drive() throws IOException {
		File myFile = new File("C:\\Users\\tmajumdar\\workspace\\prsnl\\resource\\Stock_AF.xlsx");
		driven(myFile);
	}
}
