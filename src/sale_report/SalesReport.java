package sale_report;

import java.util.Scanner;
import store.*;

public class SalesReport {
	/**
	 * main
	 * @param args
	 */
	public static void main(String[]args){
		Store store = Store.getInstance();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter id : ");
		long id = in.nextLong();
		Sale saletargetId = store.getSale(id);
		printItems(saletargetId);
		
		
		
//		while(store.iterator().hasNext()){
//			
//		}
	}
	/**
	 * print all item in sale with information eash item
	 * @param s sale
	 */
	public static void printItems(Sale s){
		for(LineItem x : s.getItems()){
			System.out.printf("%4d %-30.30s %10.2f\n",x.getQuantity(),x.getDescription(),x.getTotal());
		}
		System.out.printf("total : %10.2f\n",getTotal(s));
	}
	/**
	 * get total price of all item
	 * @param s sale
	 * @return sum is total
	 */
	public static double getTotal(Sale s ){
		double sum = 0;
		for(LineItem x : s.getItems()){
			sum = sum + x.getTotal();
		}
		return sum;
	}
}
