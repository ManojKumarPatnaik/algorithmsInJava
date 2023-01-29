package My_Learning.LeetCodeQuestions;

import java.util.*;

public class CourseSchedule2LeetCode201 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//my solution
    public int[] findOrderMySol(int numCourses, int[][] prerequisites) {
    	
        // create the array lists to represent the courses
        ArrayList<ArrayList<Integer>> courses = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }

        // create the dependency graph
        for(int row = 0; row<prerequisites.length; row++) {
            courses.get(prerequisites[row][1]).add(prerequisites[row][0]);
        } 
        
        return getOrder(numCourses, courses);
    }
    
    public int[] getOrder(int N, ArrayList<ArrayList<Integer>> adj) {
            int topo[] = new int[N]; 
            int indegree[] = new int[N]; 
            for(int i = 0;i<N;i++) {
                for(Integer it: adj.get(i)) {
                    indegree[it]++; 
                }
            }

            Queue<Integer> q = new LinkedList<Integer>(); 
            for(int i = 0;i<N;i++) {
                if(indegree[i] == 0) {
                    q.add(i); 
                }
            }
        
            int cnt = 0;
            while(!q.isEmpty()) {
                Integer node = q.poll(); 
                topo[cnt++] = node; 
                for(Integer it: adj.get(node)) {
                    indegree[it]--; 
                    if(indegree[it] == 0) {
                        q.add(it); 
                    }
                }
            }
            
            return N == cnt ? topo : (new int[0]);
    }
	
	//method - 1
	public int[] findOrder(int numCourses, int[][] prerequisites) {
	    int[] inDegree = new int[numCourses];
	    List<List<Integer>> adjs = new ArrayList<>(numCourses);
	    initialiseGraph(inDegree, adjs, prerequisites);
	    return solveByBFS(inDegree, adjs);
	    //return solveByDFS(adjs);
	}
	
	private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites){
	    int n = incLinkCounts.length;
	    while (n-- > 0) adjs.add(new ArrayList<>());
	    for (int[] edge : prerequisites) {
	        incLinkCounts[edge[0]]++;
	        adjs.get(edge[1]).add(edge[0]);
	    }
	}
	
	public static int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs){
	    int[] order = new int[incLinkCounts.length];
	    Queue<Integer> toVisit = new ArrayDeque<>();
	    for (int i = 0; i < incLinkCounts.length; i++) {
	        if (incLinkCounts[i] == 0) toVisit.offer(i);
	    }
	    int visited = 0;
	    while (!toVisit.isEmpty()) {
	        int from = toVisit.poll();
	        order[visited++] = from;
	        for (int to : adjs.get(from)) {
	            incLinkCounts[to]--;
	            if (incLinkCounts[to] == 0) toVisit.offer(to);
	        }
	    }
	    return visited == incLinkCounts.length ? order : new int[0]; 
	}
	
	public int[] solveByDFS(List<List<Integer>> adjs) {
	    BitSet hasCycle = new BitSet(1);
	    BitSet visited = new BitSet(adjs.size());
	    BitSet onStack = new BitSet(adjs.size());
	    Deque<Integer> order = new ArrayDeque<>();
	    for (int i = adjs.size() - 1; i >= 0; i--) {
	        if (visited.get(i) == false && hasOrder(i, adjs, visited, onStack, order) == false) return new int[0];
	    }
	    int[] orderArray = new int[adjs.size()];
	    for (int i = 0; !order.isEmpty(); i++) orderArray[i] = order.pop();
	    return orderArray;
	}

	private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
	    visited.set(from);
	    onStack.set(from);
	    for (int to : adjs.get(from)) {
	        if (visited.get(to) == false) {
	            if (hasOrder(to, adjs, visited, onStack, order) == false) return false;
	        } else if (onStack.get(to) == true) {
	            return false;
	        }
	    }
	    onStack.clear(from);
	    order.push(from);
	    return true;
	}

}
