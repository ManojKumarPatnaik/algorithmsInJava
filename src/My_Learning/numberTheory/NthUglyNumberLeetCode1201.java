package My_Learning.numberTheory;

public class NthUglyNumberLeetCode1201 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * An ugly number is a positive integer that is divisible by a, b, or c.
		 * 
		 * Given four integers n, a, b, and c, return the nth ugly number.
		 */
		
//		Formula
//		Calculate how many numbers from 1 to num are divisible by either a, b or c by using below formula:
//		num/a + num/b + num/c � num/lcm(a, b) � num/lcm(b, c) � num/lcm(a, c) + num/lcm(a, b, c)
	}
	
	int MAX_ANS = (int) 2e9; // 2*10^9
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 0, right = MAX_ANS, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (count(mid, a, b, c) >= n) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    int count(long num, long a, long b, long c) {
        return (int) (num / a + num / b + num / c
                - num / lcm(a, b)
                - num / lcm(b, c)
                - num / lcm(a, c)
                + num / (lcm(a, lcm(b, c))));
    }
    long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

}
