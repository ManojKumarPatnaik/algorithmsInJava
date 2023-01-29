package My_Learning.Arrays2;

public class NumberOfProvinessLeetcode547 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int findCircleNum(int[][] isConnected) {
	        if(isConnected == null || isConnected.length == 0)
	            return 0;
	        int n = isConnected.length;
	        UnionFind uf = new UnionFind(n);
	        for(int i = 0; i < n; i++) {
	            for(int j = 0; j < n; j++) {
	                if(i != j && isConnected[i][j] == 1) {
	                    uf.union(i, j);
	                }                
	            }
	        }
	        return uf.getCount();
	    }
	}

	class UnionFind {
	    int[] rank;
	    int[] root;
	    int count;
	    
	    public UnionFind(int size) {
	        rank = new int[size];
	        root = new int[size];
	        count = size;
	        for(int i = 0; i < size; i++) {
	            rank[i] = 1;
	            root[i] = i;
	        }
	    }
	    
	    public boolean isConnected(int x, int y) {
	        return find(x) == find(y);
	    }
	    
	    public void union(int x, int y) {
	        int rootX = find(x);
	        int rootY = find(y);
	        if(rootX != rootY) {
	            if(rank[rootX] > rank[rootY]) {
	                root[rootY] = rootX;
	            }
	            else if(rank[rootY] > rank[rootX]) {
	                root[rootX] = rootY;
	            }
	            else {
	                root[rootY] = rootX;
	                rank[rootX] += 1;
	            }
	            count--;
	        }
	    }
	    
	    public int find(int x) {
	        if(x == root[x])
	            return x;
	        return root[x] = find(root[x]);
	    }
	    
	    public int getCount() {
	        return count;
	    }

}
