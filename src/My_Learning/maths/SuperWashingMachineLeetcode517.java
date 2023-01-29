package My_Learning.maths;

public class SuperWashingMachineLeetcode517 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMinMoves(int[] machines) {
		int total = 0, target = 0, result = 0, n = machines.length;
		for (int d : machines)
			total += d;
		if (total == 0)
			return 0;
		if (total % n != 0)
			return -1;
		target = total / n;

		int[] move = new int[n];
		for (int i = 0; i < n - 1; i++) {
			if (machines[i] > target) {
				move[i] += machines[i] - target;
				machines[i + 1] += machines[i] - target;
				machines[i] = target;
				result = Math.max(result, move[i]);
			} else {
				move[i + 1] = target - machines[i];
				machines[i + 1] -= target - machines[i];
				machines[i] = target;
				result = Math.max(result, move[i + 1]);
			}
		}

		return result;
	}
}
