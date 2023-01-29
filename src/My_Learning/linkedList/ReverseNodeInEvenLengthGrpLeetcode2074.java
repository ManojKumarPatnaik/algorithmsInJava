package My_Learning.linkedList;

import java.util.Stack;

public class ReverseNodeInEvenLengthGrpLeetcode2074 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// group denotes groupsize that is[1,2,3,4,........].
	// start denotes start of a group.
	// temp denotes end of a group.
	// all elements of a group are pushed in a stack and are popped out to add in
	// reverse order in the original list(if count%2==0)
	public ListNode reverseEvenLengthGroups(ListNode head) {
		ListNode temp = head;
		int group = 1;
		while (temp != null) {
			int count = 0;
			ListNode start = temp;
			Stack<Integer> st = new Stack<>();
			while (count != group && temp != null) {
				st.push(temp.val);
				temp = temp.next;
				count++;
			}
			if (count % 2 == 0) {
				while (st.size() > 0) {
					start.val = st.pop();
					start = start.next;
				}
			}
			group++;
		}
		return head;
	}

}
