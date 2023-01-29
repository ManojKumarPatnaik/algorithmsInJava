package My_Learning.numberTheory;

public class WaterJugProblemLeetcode365 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
		if (targetCapacity > (jug2Capacity + jug1Capacity)) // If target is more than combined sum capacity
			return false;

		if ((targetCapacity % gcd(jug1Capacity, jug2Capacity)) != 0) // If target%gcd(x, y) != 0
			return false;

		return true; // Else True for all cases
	}

	public int gcd(int a, int b) { // GCD function
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
