package My_Learning.dynamicProgramming;

public class JumpGameLeetCode55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canJump(int[] array) {
		int reach = 0;
		for (int i = 0; i <= reach; i++) {
			reach = Math.max(reach, i + array[i]);
			if (reach >= array.length - 1) {
				return true;
			}
		}
		return false;
	}

}
