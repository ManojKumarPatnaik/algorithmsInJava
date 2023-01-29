package My_Learning.strings;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder2Leetcode126 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();

		Set<String> hs = new HashSet<>();

		for (String word : wordList) {
			hs.add(word);
		}

		Queue<List<String>> queue = new LinkedList<>();
		List<String> temp = new ArrayList<>();
		temp.add(beginWord);
		queue.offer(temp);

		while (!queue.isEmpty()) {
			int size = queue.size();
			Set<String> eligibleToRemove = new HashSet<>();

			for (int i = 0; i < size; i++) {
				List<String> currList = queue.poll();
				String currWord = currList.get(currList.size() - 1);

				if (currWord.equals(endWord)) {
					result.add(new ArrayList<>(currList));
				}

				List<String> neighbours = findAllNeighbours(currWord, hs);
				for (String neighbour : neighbours) {
					currList.add(neighbour);
					queue.offer(new ArrayList<>(currList));
					currList.remove(currList.size() - 1);
					eligibleToRemove.add(neighbour);
				}
			}

			for (String word : eligibleToRemove) {
				hs.remove(word);
			}
		}

		return result;
	}

	private List<String> findAllNeighbours(String word, Set<String> hs) {

		char[] wordChar = word.toCharArray();
		List<String> neighbours = new ArrayList<>();

		for (int i = 0; i < wordChar.length; i++) {
			char ch = wordChar[i];

			for (char character = 'a'; character <= 'z'; character++) {
				wordChar[i] = character;
				String eligibleNeighbour = new String(wordChar);
				if (hs.contains(eligibleNeighbour) && character != ch)
					neighbours.add(eligibleNeighbour);
			}

			wordChar[i] = ch;
		}

		return neighbours;
	}
	
	
	public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
	    List<List<String>> solution = new ArrayList<>();

	    Map<String, GraphNode> graph = new HashMap<>();
	    for (String word : wordList) {
	        graph.put(word, new GraphNode(word, Integer.MAX_VALUE,
	                getAdjList(word, wordList)));
	    }

	    if (!graph.containsKey(endWord)) {
	        return solution;
	    }

	    graph.put(beginWord, new GraphNode(beginWord, 0,
	            getAdjList(beginWord, wordList)));

	    Queue<GraphNode> queue = new LinkedList<>();
	    queue.add(graph.get(beginWord));

	    Set<String> used = new HashSet<>();

	    while (!queue.isEmpty()) {
	        GraphNode currNode = queue.poll();

	        if (currNode.word.equals(endWord)) {
	            break;
	        }

	        used.add(currNode.word);

	        for (String adjWord : currNode.adjList) {
	            if (used.contains(adjWord)) {
	                continue;
	            }

	            GraphNode adjNode = graph.get(adjWord);

	            int newDis = currNode.dis + 1;

	            if (adjNode.dis > newDis) {
	                adjNode.parent.add(currNode);
	                adjNode.dis = currNode.dis + 1;

	                queue.add(adjNode);
	            } else if (adjNode.dis == newDis) {
	                adjNode.parent.add(currNode);
	            }
	        }
	    }

	    GraphNode endNode = graph.get(endWord);

	    if (!endNode.parent.isEmpty()) {
	        int len = endNode.dis + 1;
	        dfs(endNode, len - 1, new String[len], solution);
	    }

	    return solution;
	}

	private void dfs(GraphNode node, int i, String[] list, List<List<String>> solution) {
	    list[i] = node.word;

	    if (i == 0) {
	        solution.add(Arrays.stream(list)
	                .collect(Collectors.toList()));

	        return;
	    }

	    for (GraphNode adj : node.parent) {
	        dfs(adj, i - 1, list, solution);
	    }
	}

	private List<String> getAdjList(String word, List<String> wordList) {
	    List<String> adjList = new ArrayList<>();

	    for (String adjWord : wordList) {
	        int i = 0, diff = 0;

	        while (i < word.length() && diff <= 1) {
	            if (word.charAt(i) != adjWord.charAt(i)) {
	                ++diff;
	            }

	            i++;
	        }

	        if (diff == 1) {
	            adjList.add(adjWord);
	        }
	    }

	    return adjList;
	}

	private static class GraphNode {
	    String word;
	    int dis;
	    List<GraphNode> parent = new ArrayList<>();
	    List<String> adjList;

	    GraphNode(String word, int dis, List<String> adjList) {
	        this.word = word;
	        this.dis = dis;
	        this.adjList = adjList;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        GraphNode graphNode = (GraphNode) o;
	        return Objects.equals(word, graphNode.word);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(word);
	    }
	}

}
