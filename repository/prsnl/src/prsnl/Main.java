package prsnl;

import java.io.IOException;

//public static File FILE_LOC = "C:\\Users\\tmajumdar\\workspace\\prsnl\\resource\\Stock_AF.xlsx";

public class Main {
	public static void main(String[] args) throws IOException {
		Driver driver = new Driver();
		extracted(driver);
		
	}

	private static void extracted(Driver driver) throws IOException {
		driver.drive();
	}

}
