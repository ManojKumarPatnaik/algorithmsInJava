package My_Learning.recusrion;

public class MinMovesToReachTargetLeetcode2139 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minMoves(int target, int maxDoubles) {
		if (maxDoubles == 0)
			return target - 1;
		return find(target, 0, maxDoubles);
	}

	public static int find(int num, int ops, int doubles) {
		if (num == 1)
			return 0;
		if (num == 2)
			return ops + 1;
		if (doubles == 0)
			return ops + num - 1;
		if (num % 2 == 0 && doubles > 0) {
			return find(num / 2, ops + 1, doubles - 1);
		} else
			return find(num - 1, ops + 1, doubles);
	}

}
