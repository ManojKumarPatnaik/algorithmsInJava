package My_Learning.LeetCodeQuestions;

public class SetMatrixZerosLeetCode73 {

	public static void main(String[] args) {

		// Taking 2D Matrix input
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }; // hard coded test case
		
		printMatrix(matrix);
		setZeros(matrix);
		setZeros2(matrix);
		System.out.println("After setting it to zeros :: ");
		printMatrix(matrix);

	}
	
	// Advanced approach Added Leetcode daily solution
	private static void setZeros2(int[][] matrix) {
		
		int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
  
	}
	
	
	// Brute force approach
	private static void setZeros(int[][] matrix) {
		
		int rowCount = matrix.length;
		int colCount = (matrix[0]).length;
		
		System.out.println("RowCount :: "+rowCount+" "+"colCount :: "+colCount);
		
		for(int row = 0; row < rowCount; row++) {
			for(int column = 0; column < colCount; column++) {
				if(matrix[row][column] == 0) {
					
					//setting current row + column to marked element
					setRowColumntoZeros(matrix, row, column, rowCount, colCount);
					
				}
			}
		}
		
		// filling up all the -1 to zeros
		for(int row = 0; row < rowCount; row++) {
			for(int column = 0; column < colCount; column++) {
				if(matrix[row][column] == -1) {
					matrix[row][column] = 0;
				}
			}
		}
		
	}

	private static void setRowColumntoZeros(int[][] matrix, int row, int column, int rowCount, int colCount) {
		// picking up rows first ------->
		for(int i = 0; i < colCount; i++) {
			if(matrix[row][i]!= -1 && matrix[row][i]!= 0) {
				matrix[row][i] = -1;
			}
		}
		
		//picking up column |
		for(int i = 0 ; i < rowCount ; i++) {
			if(matrix[i][column]!= -1 && matrix[i][column]!= 0) {
				matrix[i][column] = -1;
			}
		}
		
	}

	private static void printMatrix(int[][] matrix) {
		
		for(int[] eleArray : matrix) {
			for(int element: eleArray) {
				System.out.print(element+" ");
			}
			System.out.println();
		}
		
	}

}
