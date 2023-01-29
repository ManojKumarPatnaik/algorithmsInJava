package My_Learning.maths;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class IntegerPower {
	int value, power;

	IntegerPower(int value, int power) {
		this.value = value;
		this.power = power;
	}
}

class PowerComparator implements Comparator<IntegerPower> {
	@Override
	public int compare(IntegerPower ip1, IntegerPower ip2) {
		if (ip1.power == ip2.power) {
			return ip1.value - ip2.value;
		} else {
			return ip1.power - ip2.power;
		}
	}
}

public class SortIntegerByPowerValueLeetcode1387 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, Integer> power = new HashMap<>();

	public int getKth(int lo, int hi, int k) {
		power.put(1, 0);
		PriorityQueue<IntegerPower> minHeap = new PriorityQueue<>(new PowerComparator());
		for (int i = lo; i <= hi; i++) {
			minHeap.offer(new IntegerPower(i, getPower(i)));
		}
		int answer = 0;
		for (int i = 0; i < k; i++) {
			answer = minHeap.poll().value;
		}
		return answer;
	}

	private int getPower(int x) {
		if (!power.containsKey(x)) {
			if (x % 2 == 0) {
				power.put(x, 1 + getPower(x / 2));
			} else {
				power.put(x, 1 + getPower(x * 3 + 1));
			}
		}
		return power.get(x);
	}

}
