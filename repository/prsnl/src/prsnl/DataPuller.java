package prsnl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DataPuller {

	

	public StockDeets write() {
		Map<String, List<StockDeets>> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String sector = sc.nextLine();
		double price = sc.nextDouble();
		StockDeets stock = new StockDeets(name, sector, price);
		/*if(!map.containsKey(sector)) {
			List<StockDeets> list = new ArrayList<>();
			list.add(stock);
			map.put(sector, list);
		}
		else {
			List<StockDeets> list = map.get(sector);
			list.add(stock);
			map.put(sector, list);
		}*/
		return stock;
		
		
	}

}
