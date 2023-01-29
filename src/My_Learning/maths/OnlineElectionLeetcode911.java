package My_Learning.maths;

import java.util.HashMap;
import java.util.TreeMap;

public class OnlineElectionLeetcode911 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	TreeMap<Integer, Integer> votesmap = new TreeMap<>();

	public OnlineElectionLeetcode911(int[] person, int[] times) {
	        HashMap<Integer, Integer> map = new HashMap<>(); 
	        int max = 0;
	        int can = -1;
	            
	        for(int i = 0; i < times.length; i++){
	            int votes = map.getOrDefault(person[i], 0) + 1;
	            map.put(person[i], votes);
	            if(votes >= max){
	                can = person[i];
	                votesmap.put(times[i], person[i]);
	                max = Math.max(max, votes);
	            } else {
	                votesmap.put(times[i], can);
	            }
	        }
	    }

	public int q(int t) {
		int key = votesmap.floorKey(t);
		int can = votesmap.get(key);
		return can;
	}

}
