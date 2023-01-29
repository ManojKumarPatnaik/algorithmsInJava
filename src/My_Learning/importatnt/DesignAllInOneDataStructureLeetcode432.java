package My_Learning.importatnt;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DesignAllInOneDataStructureLeetcode432 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Node {
		Node prev;
		Node next;
		String key;
		int count;

		Node(String key, int count) {
			this.key = key;
			this.count = count;
		}

		Node() {
		}
	}

	class DoubleLinkedList {
		Node head;
		Node tail;

		DoubleLinkedList() {
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;
		}

		void addNode(Node node) {
			Node next = head.next;
			head.next = node;
			node.prev = head;
			node.next = next;
			next.prev = node;
		}

		void removeNode(Node node) {
			Node prev = node.prev;
			Node next = node.next;
			prev.next = next;
			next.prev = prev;
			node.prev = null;
			node.next = null;
		}

		boolean isEmpty() {
			return head.next == tail;
		}
	}

	TreeMap<Integer, DoubleLinkedList> counts;
	Map<String, Node> keyNodes;

	public DesignAllInOneDataStructureLeetcode432() {
        counts = new TreeMap<>();
        keyNodes = new HashMap<>();
    }

	public void inc(String key) {
		if (!keyNodes.containsKey(key)) {
			Node node = new Node(key, 1);
			keyNodes.put(key, node);
			counts.computeIfAbsent(1, one -> new DoubleLinkedList()).addNode(node);
		} else {
			Node existingNode = keyNodes.get(key);
			DoubleLinkedList list = counts.get(existingNode.count);
			list.removeNode(existingNode);
			if (list.isEmpty()) {
				counts.remove(existingNode.count);
			}

			counts.computeIfAbsent(existingNode.count + 1, c -> new DoubleLinkedList()).addNode(existingNode);
			existingNode.count += 1;
		}
	}

	public void dec(String key) {
		if (!keyNodes.containsKey(key)) {
			return;
		} else {
			Node existingNode = keyNodes.get(key);
			int count = existingNode.count;
			DoubleLinkedList list = counts.get(count);
			list.removeNode(existingNode);
			if (list.isEmpty()) {
				counts.remove(count);
			}

			if (count - 1 > 0) {
				counts.computeIfAbsent(count - 1, c -> new DoubleLinkedList()).addNode(existingNode);
				existingNode.count = count - 1;
			} else {
				keyNodes.remove(key);
			}
		}
	}

	public String getMaxKey() {
		if (counts.isEmpty())
			return "";
		return counts.lastEntry().getValue().head.next.key;
	}

	public String getMinKey() {
		if (counts.isEmpty())
			return "";
		return counts.firstEntry().getValue().head.next.key;
	}

}
