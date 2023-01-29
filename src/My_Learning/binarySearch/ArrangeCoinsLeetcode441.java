package My_Learning.binarySearch;

public class ArrangeCoinsLeetcode441 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int arrangeCoins(int n) {
		int i = 1;
		int res = 0;
		while (n >= i) {
			n -= i;
			res++;
			i++;
		}
		return res;
	}

}
