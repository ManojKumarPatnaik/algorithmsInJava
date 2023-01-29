package My_Learning.queues;

public class DesignFrontMiddleBackQueueLeetcode1670 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ListNode dummyStart;
	ListNode dummyTail;
	ListNode mid;
	int size;

	// FrontMiddleBackQueue 
	public DesignFrontMiddleBackQueueLeetcode1670() {
        dummyStart = new ListNode(0);
        dummyTail = new ListNode(0);
        dummyStart.next = dummyTail;
        dummyTail.prev = dummyStart;
    }

	public void pushFront(int val) {
		ListNode newStart = new ListNode(val);
		newStart.next = dummyStart.next;
		newStart.prev = dummyStart;
		dummyStart.next.prev = newStart;
		dummyStart.next = newStart;
		size++;
		if (size == 1) {
			mid = newStart;
		} else {
			if (size % 2 == 0) {
				mid = mid.prev;
			}
		}
	}

	public void pushMiddle(int val) {
		if (size == 0) {
			ListNode newMid = new ListNode(val);
			newMid.prev = dummyStart;
			newMid.next = dummyTail;
			dummyStart.next = newMid;
			dummyTail.prev = newMid;
			mid = newMid;
			size++;
			return;
		}
		if (size % 2 == 0) {
			pushNext(val);
		} else {
			pushPrev(val);
		}
		size++;
	}

	private void pushPrev(int val) {
		ListNode newMid = new ListNode(val);
		newMid.next = mid;
		newMid.prev = mid.prev;
		newMid.prev.next = newMid;
		mid.prev = newMid;
		mid = newMid;
	}

	private void pushNext(int val) {
		ListNode newMid = new ListNode(val);
		newMid.next = mid.next;
		newMid.prev = mid;
		mid.next.prev = newMid;
		mid.next = newMid;
		mid = newMid;
	}

	public void pushBack(int val) {
		ListNode newEnd = new ListNode(val);
		newEnd.prev = dummyTail.prev;
		newEnd.next = dummyTail;
		dummyTail.prev.next = newEnd;
		dummyTail.prev = newEnd;
		size++;
		if (size == 1) {
			mid = newEnd;
		} else {
			if (size % 2 != 0) {
				mid = mid.next;
			}
		}
	}

	public int popFront() {
		if (size > 0) {
			ListNode next = dummyStart.next;
			removeNode(next);
			size--;
			if (size % 2 != 0) {
				mid = mid.next;
			}
			return next.val;
		}
		return -1;
	}

	private void removeNode(ListNode node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}

	public int popMiddle() {
		if (size > 0) {
			int val = mid.val;
			mid.next.prev = mid.prev;
			mid.prev.next = mid.next;
			if (size % 2 == 0) {
				mid = mid.next;
			} else {
				mid = mid.prev;
			}
			size--;
			return val;
		}
		return -1;
	}

	public int popBack() {
		if (size > 0) {
			ListNode prev = dummyTail.prev;
			removeNode(prev);
			size--;
			if (size % 2 == 0) {
				mid = mid.prev;
			}
			return prev.val;
		}
		return -1;
	}

	static class ListNode {
		int val;
		ListNode prev;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

	}

}
