package sale_report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import store.*;

public class SaleUtil {
	/**
	 * sort by item name 
	 * @param ls list of item
	 * @return sorted list
	 */
	public static List<LineItem> sortByDescript(List<LineItem> ls){
		List<LineItem> lscopy = new ArrayList(ls);
		CompareBydescription compareBydescription = new CompareBydescription();
		Collections.sort(lscopy,compareBydescription);
		return lscopy;
	}
}

class CompareBydescription implements Comparator<LineItem>{
	@Override
	/**
	 * name Comparator
	 */
	public int compare(LineItem o1, LineItem o2) {
		return o1.getDescription().compareToIgnoreCase(o2.getDescription());
		
	}
}
