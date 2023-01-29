package My_Learning.Arrays3;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIteratorLeetcode341 implements Iterator<Integer> {
	NestedIteratorLeetcode341 nextInt;
    Stack<Iterator<NestedIteratorLeetcode341>> stack;

    public NestedIteratorLeetcode341(List<NestedIteratorLeetcode341> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextInt != null ? nextInt.next() : null; //Just in case
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) stack.pop();
            //else if ((nextInt = stack.peek().next()).isInteger()) return true;
            //else stack.push(nextInt.getList().iterator());
        }
        return false;
    }
}
