package My_Learning.Arrays3;

public class CanPlaceFlowerLeetcode605 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 1;
		int result = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0) {
				count++;
			} else {
				result += (count - 1) / 2;
				count = 0;
			}
		}
		if (count != 0)
			result += count / 2;
		return result >= n;
	}

}
