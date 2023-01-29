package My_Learning.maths;

public class PartitionIntoDeciBinaryElementLeetcode1689 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minPartitions(String n) {
		int res = 0;
		for (int i = 0; i < n.length(); ++i)
			res = Math.max(res, n.charAt(i) - '0');
		return res;
	}

}
