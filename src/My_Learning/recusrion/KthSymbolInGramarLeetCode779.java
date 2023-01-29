package My_Learning.recusrion;

public class KthSymbolInGramarLeetCode779 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = kthGrammar2(3, 3);
		System.out.println(ans);
	}

	public static int kthGrammar(int N, int K) {
		if (N == 1)
			return 0;
		if (K % 2 == 0) {
			if (kthGrammar(N - 1, K / 2) == 0)
				return 1;
			else
				return 0;
		} else {
			if (kthGrammar(N - 1, (K + 1) / 2) == 0)
				return 0;
			else
				return 1;
		}
	}

	// think of the problem like this
	/*
	 * 0 / \ 0 1 / \ / \ 0 1 1 0 / \ / \ / \ / \ 0 1 1 0 1 0 0 1
	 */

	
//	We don't need to actually generate the strings "0110..." (would be TLE error anyway)
//
//	row 1: 0
//	row 2: 01
//	row 3: 0110
//	row 4: 01101001
//	We see that, for any level N, the first half of the string is the same as the string in N-1, the next half is just complement of it. The total number of items in level N is 2^N. The half mark of the string is marked by [2^(N-1)]-th item. So, for any level N:
//
//	if K is in the first half, it is same as the Kth element in level N-1
//	if K is in the second half, it is the complement of the number in [K-2^(N-1)]-th position in level N-1
//	So, we run the recursion until the base condition (N=1)
	public static int kthGrammar2(int n, int k) {

		if (n == 1 && k == 1)
			return 0;
		
		// mapping with k and length
		// by obervation at nth row length = 2^n-1
		int mid = (int) Math.pow(2, n - 1) ;
		mid = mid / 2;

		if (k <= mid) {
			return kthGrammar2(n - 1, k);
		} else {
			int ans = kthGrammar2(n - 1, k - mid);
			return ans == 0 ? 1 : 0;
		}
	}

}
