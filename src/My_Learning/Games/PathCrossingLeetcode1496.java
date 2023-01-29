package My_Learning.Games;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathCrossingLeetcode1496 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPathCrossing(String path) {
		Set<Integer> set = new HashSet<>();
		int i = 0, j = 0, base = 10001;
		set.add(0);
		Map<Character, int[]> map = new HashMap<>();
		map.put('N', new int[] { -1, 0 });
		map.put('S', new int[] { 1, 0 });
		map.put('E', new int[] { 0, -1 });
		map.put('W', new int[] { 0, 1 });
		
		for (char p : path.toCharArray()) {
			i += map.get(p)[0];
			j += map.get(p)[1];
			if (!set.add(i * base + j))
				return true;
		}
		return false;
	}

}
