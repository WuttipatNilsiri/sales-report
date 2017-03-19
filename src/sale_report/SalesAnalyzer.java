package sale_report;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Iterator;

import store.*;

public class SalesAnalyzer {
	/**
	 * analyzer input store
	 * @param store
	 */
	public static void Analyz(Store store){
		Map<Long,LineItem> mapAna = new HashMap<Long,LineItem>();
		Iterator<Sale> a = store.iterator();
		while(a.hasNext()){
			List<LineItem> listItem = a.next().getItems();
			for(LineItem x : listItem){
				if (mapAna.containsKey(x.getProductId())){
					mapAna.put(x.getProductId(), new LineItem( x.getProductId() , x.getDescription() , x.getUnitPrice() , x.getQuantity() + mapAna.get(x.getProductId()).getQuantity() ) );
				}
				else
					mapAna.put(x.getProductId(), new LineItem( x.getProductId() , x.getDescription() , x.getUnitPrice() , x.getQuantity() ) );
			}
		}
		List<LineItem> summary =  new ArrayList(mapAna.values());
		List<LineItem> summarysort = SaleUtil.sortByDescript(summary);
		System.out.println("ID // Description // total Quatity ");
		for (LineItem item : summarysort){
			System.out.println(item.getProductId()+" "+item.getDescription()+" "+item.getQuantity());
		}
	}
	/**
	 * runnnnnnnnn !!
	 * @param args
	 */
	public static void main(String[]args){
		Store store = Store.getInstance();
		Analyz(store);
		
	}

}
