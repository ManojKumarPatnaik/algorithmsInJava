package My_Learning.numberTheory;

public class NumberOfWaysToBuyPencilLeetcode2240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long waysToBuyPensPencils(int t, int c1, int c2) {
		if (t < c1 && t < c2)
			return 1;
		long s = 0;
		for (int i = 0;; i++) {
			int p = t - (i * c1);
			if (p < 0)
				break;
			s = s + (long) ((long) p / (long) c2) + 1;
		}
		return s;
	}

}
