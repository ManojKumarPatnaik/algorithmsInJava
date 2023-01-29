package My_Learning.stack;

import java.util.LinkedList;

public class OnlineStockSpanLeetcode901 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	LinkedList<Integer> prices;
	LinkedList<Integer> spans;

	// method to fetch span
	public OnlineStockSpanLeetcode901() {
        prices = new LinkedList<>();
        spans = new LinkedList<>();
    }

	public int next(int price) {
		int span = 1;
		int index = prices.size() - 1;
		while (index >= 0 && price >= prices.get(index)) {
			span += spans.get(index);
			index -= spans.get(index);
		}
		spans.add(span);
		prices.add(price);
		return span;
	}

}
