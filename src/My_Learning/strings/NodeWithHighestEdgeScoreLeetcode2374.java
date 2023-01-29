package My_Learning.strings;

import java.util.HashMap;
import java.util.Map;

public class NodeWithHighestEdgeScoreLeetcode2374 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int edgeScore(int[] edges) {
		Map<Integer, Integer> scores = new HashMap<>();
		int highestScoreNode = 0;
		for (int i = 0; i < edges.length; i++) {
			scores.put(edges[i], scores.getOrDefault(edges[i], 0) + i);
			int lastScore = scores.get(edges[i]), highestScore = scores.getOrDefault(highestScoreNode, 0);
			if (lastScore > highestScore)
				highestScoreNode = edges[i];
			else if (lastScore == highestScore)
				highestScoreNode = Math.min(edges[i], highestScoreNode);
		}
		return highestScoreNode;
	}

}
