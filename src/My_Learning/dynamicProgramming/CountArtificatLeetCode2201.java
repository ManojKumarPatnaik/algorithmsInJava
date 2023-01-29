package My_Learning.dynamicProgramming;

import java.util.HashSet;

public class CountArtificatLeetCode2201 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

		boolean visit[][] = new boolean[n][n];
		for (int arr[] : dig) {
			visit[arr[0]][arr[1]] = true;
		}

		int ans = 0;
		for (int arr[] : artifacts) {

			boolean flag = true;
			for (int i = arr[0]; i <= arr[2]; i++) {
				for (int j = arr[1]; j <= arr[3]; j++) {
					if (!visit[i][j])
						flag = false;
				}
			}
			if (flag)
				ans++;
		}
		return ans;
	}

	public int digArtifacts2(int n, int[][] artifacts, int[][] dig) {
		HashSet<String> set = new HashSet<>();
		for (int d[] : dig)
			set.add(d[0] + " " + d[1]);
		int c = 0;
		for (int a[] : artifacts) {
			boolean done = true;
			for (int i = a[0]; i <= a[2]; i++) {
				for (int j = a[1]; j <= a[3]; j++) {
					if (!set.contains(i + " " + j))
						done = false;
				}
			}
			if (done)
				c++;
		}
		return c;
	}

}
