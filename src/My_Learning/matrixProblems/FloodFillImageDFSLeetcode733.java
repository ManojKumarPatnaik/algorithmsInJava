package My_Learning.matrixProblems;

public class FloodFillImageDFSLeetcode733 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startColor = image[sr][sc];
        // don't need to do anything here
        if (startColor == newColor) return image;
        
        dfs(image, sr, sc, startColor, newColor);
        
        return image;
    }
    
    public void dfs(int[][]image, int x, int y, int startColor, int newColor) {
        // bounds check
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        // visited check
        if (image[x][y] != startColor) {
            return;
        }
        
        // set new color
        image[x][y] = newColor;
        
        // dfs
        dfs(image, x + 1, y, startColor, newColor);
        dfs(image, x - 1, y, startColor, newColor);
        dfs(image, x, y + 1, startColor, newColor);
        dfs(image, x, y - 1, startColor, newColor);
    }

}
