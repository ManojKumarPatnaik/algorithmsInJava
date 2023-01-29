package My_Learning.LeetCodeQuestions;

public class CountingSetBitArrayLeetCode338 {
	
//		Example 1:
//
//		Input: n = 2
//		Output: [0,1,1]
//		Explanation:
//		0 --> 0
//		1 --> 1
//		2 --> 10
//		Example 2:
//
//		Input: n = 5
//		Output: [0,1,1,2,1,2]
//		Explanation:
//		0 --> 0
//		1 --> 1
//		2 --> 10
//		3 --> 11
//		4 --> 100
//		5 --> 101

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] countBits(int n) {
		int[] narray = new int[n + 1];

		// narray[0] = 0; //no need as it is initialized with 0
		for (int i = 1; i <= n; i++)
			narray[i] = countSetBit(i);

		return narray;
	}

	public int countSetBit(int n) {
		int setBit = 0;

		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1)
				setBit++;
			n = n >> 1;
		}

		return setBit;
	}
	
	//An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.

	public int[] countBits2(int num) {
	    int[] f = new int[num + 1];
	    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
	    return f;
	}
	
//	Very concise and insightful solution, and here I am gonna simply explain why this formula works.
//
//	When it comes to even numbers, i.e, 2,4,6,8, their binary should be like '10', '100', '110', '1000' so one notable difference is their unit digit is always 0, which means when you call >> 1- shift one bit rightwards and also means dividing by 2- would cause no change to the count of '1' in the binary string.
//
//	Vice versa, when you meet odd numbers, shifting one bit rightwards always eliminates one '1' digit from original binary string, that is why we should "compensate" one '1' character to the count.
//
//	To sum up, when you meet even number the count of '1's is always the same as its half number, on the other hand, remember to plus one to the odds' half number.

//		This is my understanding:
//
//		f[1] = (f[0]==0) + (1%1==1) = 1
//		f[11] = (f[1]==1) + (11%1==1)  = 2
//		f[110] = (f[11]==2) + (110%1==0) = 2
//		f[1101] = (f[110] ==2) + (1101%1==1) =3;
//		...
//		So in short f[i] = f[i/2] + i%2; very wonderful solution!!

}
