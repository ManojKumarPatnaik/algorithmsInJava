package My_Learning.recusrion;

import java.util.*;

public class N_QueensTwoLeetCode52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//approach -1 using all solution and put in set and get unique one
	public int totalNQueensBruteForce(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(0, board, res);
        
        Set<List<String>> set = new HashSet<>(res);
        
        return set.size();
    }
    
    private boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col; 
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') return false; 
            row--;
            col--; 
        }
        
        row = duprow; 
        col = dupcol; 
        while(col >= 0) {
            if(board[row][col] == 'Q') return false; 
            col--; 
        }
        
        row = duprow; 
        col = dupcol; 
        while(col >= 0 && row < board.length) {
            if(board[row][col] == 'Q') return false; 
            col--;
            row++; 
        }
        return true; 
    }
    
    private void dfs(int col, char[][] board, List<List<String>> res) {
        if(col == board.length) {
            res.add(construct(board));
            return;
        }
        
        for(int row = 0; row < board.length; row++) {
            if(validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col+1, board, res);
                board[row][col] = '.';
            }
        }
    }
    
    
    
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
    //approach-2 here just need to count the valid solutions
    /**
     * don't need to actually place the queen,
     * instead, for each row, try to place without violation on
     * col/ diagonal1/ diagnol2.
     * trick: to detect whether 2 positions sit on the same diagnol:
     * if delta(col, row) equals, same diagnol1;
     * if sum(col, row) equals, same diagnal2.
     */
    private final Set<Integer> occupiedCols = new HashSet<Integer>();
    private final Set<Integer> occupiedDiag1s = new HashSet<Integer>();
    private final Set<Integer> occupiedDiag2s = new HashSet<Integer>();
    public int totalNQueens(int n) {
        return totalNQueensHelper(0, 0, n);
    }
    
    private int totalNQueensHelper(int row, int count, int n) {
        for (int col = 0; col < n; col++) {
            if (occupiedCols.contains(col))
                continue;
            int diag1 = row - col;
            if (occupiedDiag1s.contains(diag1))
                continue;
            int diag2 = row + col;
            if (occupiedDiag2s.contains(diag2))
                continue;
            // we can now place a queen here
            if (row == n-1)
                count++;
            else {
                occupiedCols.add(col);
                occupiedDiag1s.add(diag1);
                occupiedDiag2s.add(diag2);
                count = totalNQueensHelper(row+1, count, n);
                // recover
                occupiedCols.remove(col);
                occupiedDiag1s.remove(diag1);
                occupiedDiag2s.remove(diag2);
            }
        }
        
        return count;
    }

}
