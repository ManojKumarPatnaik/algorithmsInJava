package My_Learning.numberTheory;

public class IsUglyNumberLeetCode263 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
//
//	Given an integer n, return true if n is an ugly number.
	
	public boolean isUgly(int num) {
        for (int i=2; i<6 && num>0; i++){
             while (num % i == 0)
                num /= i;
        }
   
        return num == 1;
    }
}
