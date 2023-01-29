package My_Learning.graph;

public class NumberOfEnclaveLeetcode1020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numEnclaves(int[][] arr) {
//      first of all we will remove zeros from the corners of the matrix
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i == 0 || j == 0 || i == arr.length - 1 || j == arr[0].length - 1) {
					DFS(arr, i, j);
				}
			}
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					count++;
				}
			}
		}

		return count;
	}

	public void DFS(int[][] arr, int i, int j) {
		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0) {
			return;
		}

		arr[i][j] = 0;
		DFS(arr, i - 1, j);// up
		DFS(arr, i, j + 1);// right
		DFS(arr, i + 1, j);// down
		DFS(arr, i, j - 1);// left
	}

}
