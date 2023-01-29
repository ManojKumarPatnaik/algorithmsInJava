package My_Learning.recusrion;

public class ValidSquareNumberLeetCode367 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPerfectSquare(int num) {
	     int i = 1;
	     while (num > 0) {
	         num -= i;
	         i += 2;
	     }
	     return num == 0;
	 }
	
	//method-2
	public boolean isPerfectSquare2(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
	
	//method-3
	public boolean isPerfectSquare3(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}
