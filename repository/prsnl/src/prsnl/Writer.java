package prsnl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writer {

	public void write(StockDeets stock, XSSFSheet mySheet, File myFile, XSSFWorkbook myWorkBook) throws IOException {
		
		int rownum = mySheet.getLastRowNum();
		System.out.println("the number of rows in the file are" + rownum);
		Row row = mySheet.createRow(rownum++);
		int cellnum = 0;
		Cell cell = row.createCell(cellnum++);
		cell.setCellValue(stock.Name);
		cell = row.createCell(cellnum++);
		cell.setCellValue(stock.Sector);
		cell = row.createCell(cellnum++);
		cell.setCellValue(stock.Price);
		cell = row.createCell(cellnum++);
		cell.setCellValue(stock.investedPercentage);
		FileOutputStream os = new FileOutputStream(myFile);
		myWorkBook.write(os);
		System.out.println("Writing on XLSX file Finished ...");
		os.close();
		
	}

}
