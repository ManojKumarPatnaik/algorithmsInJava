package My_Learning.numberTheory;

import java.util.ArrayList;
import java.util.List;

public class ProductofKLastNoLeetcode1352 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<Integer> prefix;
	int prefixProduct = 1;
	int lastZeroIndex = -1;

	public ProductofKLastNoLeetcode1352() {
	        prefix = new ArrayList<>();
	    }

	public void add(int num) {
		if (num == 0) {
			lastZeroIndex = prefix.size();
			prefix.add(1);
		} else {
			int size = prefix.size();
			if (size == 0) {
				prefix.add(num);
			} else {
				int now = prefix.get(size - 1) * num;
				prefix.add(now);
			}
		}
	}

	public int getProduct(int k) {
		int size = prefix.size();
		if (size - k <= lastZeroIndex)
			return 0;
		int total = prefix.get(size - 1);
		if (size - k - 1 >= 0) {
			int prev = prefix.get(size - k - 1);
			return total / prev;
		}
		return total;
	}

}
