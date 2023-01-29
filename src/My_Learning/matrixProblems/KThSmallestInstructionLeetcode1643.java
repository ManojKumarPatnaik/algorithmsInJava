package My_Learning.matrixProblems;

public class KThSmallestInstructionLeetcode1643 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String kthSmallestPath(int[] destination, int k) {
		StringBuilder sb = new StringBuilder();
		int v = destination[0]; // number of Vs left to find
		int n = v + destination[1]; // number of digits left to find
		while (true) {
			int range = choose(--n, v);
			if (k <= range)
				sb.append('H');
			else {
				sb.append('V');
				v--;
				k -= range;
			}

			// Check to see whether we are done
			if (v == 0) {
				// All remaining directions are H
				for (int i = 1; i <= n; i++)
					sb.append('H');
				break;
			} else if (v == n) {
				// All remaining directions are V
				for (int i = 1; i <= v; i++)
					sb.append('V');
				break;
			}
		}

		return sb.toString();
	}

	private int choose(int n, int k) {
		if (n - k < k)
			k = n - k;
		int answer = 1;
		for (int i = 1; i <= k; i++)
			answer = answer * (n + 1 - i) / i;
		return answer;
	}

}
