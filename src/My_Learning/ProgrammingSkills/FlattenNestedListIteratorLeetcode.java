package My_Learning.ProgrammingSkills;

import java.util.ArrayList;
import java.util.List;

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class FlattenNestedListIteratorLeetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private List<Integer> integerList = new ArrayList<>();
	private int index = 0;

	public FlattenNestedListIteratorLeetcode(List<NestedInteger> nestedList) {
		for (NestedInteger nestedInteger : nestedList) {
			flatten(nestedInteger);
		}
	}

	private void flatten(NestedInteger nested) {
		if (nested.isInteger())
			integerList.add(nested.getInteger());
		else
			for (NestedInteger nestedFromList : nested.getList()) {
				flatten(nestedFromList);
			}
	}

	public boolean hasNext() {
		return index < integerList.size();
	}

	public Integer next() {
		return integerList.get(index++);
	}

}
