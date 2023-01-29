package My_Learning.maths;

public class MinimumNumberOfOperationLeetcode2224 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int convertTime(String current, String correct) {
		int cur = Integer.valueOf(current.substring(0, 2)) * 60 + Integer.valueOf(current.substring(3, 5));
		int cor = Integer.valueOf(correct.substring(0, 2)) * 60 + Integer.valueOf(correct.substring(3, 5));
		int diff = Math.abs(cur - cor);
		int res = 0;
		if (diff / 60 > 0) {
			res += diff / 60;
			diff -= diff / 60 * 60;
		}
		if (diff / 15 > 0) {
			res += diff / 15;
			diff -= diff / 15 * 15;
		}
		if (diff / 5 > 0) {
			res += diff / 5;
			diff -= diff / 5 * 5;
		}
		if (diff / 1 > 0) {
			res += diff / 1;
		}
		return res;
	}

}
