package My_Learning.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class DesignDinnerPlateStackLeetcode1172 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<Stack<Integer>> stacks;
	TreeSet<Integer> openStacks;
	int capacity;

	public DesignDinnerPlateStackLeetcode1172(int capacity) {
		this.stacks = new ArrayList<>();
		this.openStacks = new TreeSet<>();
		this.capacity = capacity;
	}

	public void push(int val) {
		if (openStacks.isEmpty()) {
			stacks.add(new Stack<>());
			openStacks.add(stacks.size() - 1);
		}

		stacks.get(openStacks.first()).push(val);
		if (stacks.get(openStacks.first()).size() == capacity)
			openStacks.pollFirst();
	}

	public int pop() {
		return myPop(stacks.size() - 1);
	}

	public int popAtStack(int index) {
		return myPop(index);
	}

	private int myPop(int i) {
		if (i < 0 || i >= stacks.size() || stacks.get(i).isEmpty())
			return -1;
		int ret = stacks.get(i).pop();
		openStacks.add(i);
		while (stacks.size() > 0 && stacks.get(stacks.size() - 1).isEmpty())
			stacks.remove((int) openStacks.pollLast()); // Cast is necessary!
		return ret;
	}
}
