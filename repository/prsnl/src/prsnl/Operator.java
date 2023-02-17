package prsnl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Operator {
	static int c=0;
	public static Map<String, List<StockDeets>> Operate(XSSFSheet mySheet) {
		String Name = null;
		String Sector = null;
		double Price = 0;
		
		Iterator<Row> rowIterator = mySheet.iterator();
		Map<String, List<StockDeets>> map = new HashMap<>();
		
		while (rowIterator.hasNext()) { 
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if(c > 3) {
					if(c % 4 == 0 ) {
						Name = cell.getStringCellValue();
					}
					else if(c % 4 == 1 ) {
						Sector = cell.getStringCellValue();
					}
					else if(c % 4 == 2 ) {
						Price  = cell.getNumericCellValue();
					}
					
				}c++;
				
			}
			if(Sector != null && Sector != "TOTAL") {
				if(!map.containsKey(Sector) ) {
					List<StockDeets> list = new ArrayList<>();
					list.add(new StockDeets(Name, Sector, Price));
					map.put(Sector,list);
				}
				else {
					List<StockDeets> list = map.get(Sector);
					list.add(new StockDeets(Name, Sector, Price));
					map.put(Sector, list);
				}
			}
		}
		for (Entry<String, List<StockDeets>> me :
            map.entrySet()) {
			List<StockDeets> arr = me.getValue();
           System.out.print(me.getKey() + ":");
           for(StockDeets s: arr) {
        	   System.out.print(s.getName()+" ");
        	   System.out.print(s.Sector+" ");
        	   System.out.print(s.Price+" ");
        	   System.out.print(s.investedPercentage+" ");
        	   System.out.println();
           }
           System.out.println();
       }
		return map;
		
		
	}
}
