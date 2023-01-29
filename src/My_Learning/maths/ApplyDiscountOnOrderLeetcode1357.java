package My_Learning.maths;

import java.util.HashMap;
import java.util.Map;

public class ApplyDiscountOnOrderLeetcode1357 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int count;
	Map<Integer, Integer> map;
	int d;
	int total_cus;

	public ApplyDiscountOnOrderLeetcode1357(int n, int discount, int[] products, int[] prices) {
        count = 0;
        this.d = discount;
        this.total_cus = n;
        map = new HashMap<>();
        
        for(int i=0; i<products.length; i++) {
            map.put(products[i], prices[i]);
        }
    }

	public double getBill(int[] product, int[] amount) {

		count++;
		double bill = 0;

		for (int i = 0; i < product.length; i++) {
			bill += map.get(product[i]) * amount[i];
		}

		if (count == total_cus) {
			count = 0;
			return (bill - (d * bill) / 100);
		} else {
			return bill;
		}
	}

}
