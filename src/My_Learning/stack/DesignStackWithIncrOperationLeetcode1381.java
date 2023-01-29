package My_Learning.stack;

public class DesignStackWithIncrOperationLeetcode1381 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private final int size;
	private final int[] stack;
	private int pointer;

	public DesignStackWithIncrOperationLeetcode1381(int maxSize) {
		size = maxSize;
		stack = new int[size];
	}

	public void push(int x) {
		if (pointer <= size - 1) {
			stack[pointer++] = x;
		}
	}

	public int pop() {
		if (pointer == 0)
			return -1;
		int result = stack[Math.max(pointer - 1, 0)];
		stack[Math.max(pointer - 1, 0)] = 0;
		pointer = Math.max(pointer - 1, 0);
		return result;
	}

	public void increment(int k, int val) {
		int range = Math.min(k, size);
		for (int x = 0; x < range; x++) {
			stack[x] = stack[x] + val;
		}
	}
}
