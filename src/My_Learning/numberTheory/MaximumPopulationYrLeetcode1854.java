package My_Learning.numberTheory;

public class MaximumPopulationYrLeetcode1854 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximumPopulation(int[][] logs) {
		int recentMaxPopulation = 0;
		int alivePerson = 0;
		int previousYear = 0;
		for (int i = 0; i < logs.length; i++) {
			int[] log = logs[i];
			for (int j = 0; j < logs.length; j++) {
				int[] ints = logs[j];
				if (logs[i][0] >= logs[j][0] && logs[i][0] < logs[j][1])
					alivePerson++;
			}
			if (alivePerson > previousYear || (alivePerson == previousYear && log[0] < recentMaxPopulation)) {
				recentMaxPopulation = log[0];
				previousYear = alivePerson;
			}
			alivePerson = 0;
		}
		return recentMaxPopulation;
	}
}
