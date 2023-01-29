package My_Learning.Arrays3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class CarInfo {
	int pos, speed;

	public CarInfo(int p, int s) {
		pos = p;
		speed = s;
	}
}

public class RaceCarLeetcode818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int racecar(int target) {
		Set<String> visited = new HashSet<>();
		String begin = 0 + "/" + 1;
		visited.add(begin);
		Queue<CarInfo> queue = new LinkedList<>();
		queue.add(new CarInfo(0, 1));
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				CarInfo cur = queue.poll();
				if (cur.pos == target)
					return level;
				String s1 = (cur.pos + cur.speed) + "/" + (cur.speed * 2);
				String s2 = cur.pos + "/" + (cur.speed > 0 ? -1 : 1);
				if (Math.abs(cur.pos + cur.speed - target) < target && !visited.contains(s1)) {
					visited.add(s1);
					queue.add(new CarInfo(cur.pos + cur.speed, cur.speed * 2));
				}
				if (Math.abs(cur.pos - target) < target && !visited.contains(s2)) {
					visited.add(s2);
					queue.add(new CarInfo(cur.pos, cur.speed > 0 ? -1 : 1));
				}
			}

			level++;
		}
		return -1;
	}
}
