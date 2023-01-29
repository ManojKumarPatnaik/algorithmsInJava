package My_Learning.graph;

import java.util.List;

public class KeyAndRoomsLeetcode841 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean visited[] = new boolean[rooms.size()];
		dfs(rooms.get(0), 0, rooms, visited);

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	private void dfs(List<Integer> keysInRoom, int room, List<List<Integer>> rooms, boolean[] visited) {
		visited[room] = true;

		for (Integer i : keysInRoom) {
			if (!visited[i]) {
				dfs(rooms.get(i), i, rooms, visited);
			}
		}
	}
}
