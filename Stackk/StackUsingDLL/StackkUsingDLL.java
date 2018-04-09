package Stackk.StackUsingDLL;

import linkedList.doublyLinkedList.doublyLinkedListt;

public class StackkUsingDLL {

	doublyLinkedListt dll;
	doublyLinkedListt.Node mid;

	public StackkUsingDLL() {
		dll = new doublyLinkedListt();
		mid = dll.new Node();
	}

	public void push(int item) {
		if (!dll.isEmpty()) {
			dll.addLast(item);

			if (dll.getSize() % 2 != 0)
				mid = mid.next;

		} else {
			dll.addLast(item);
			mid = dll.head;
		}
	}

	public int pop() throws Exception {
		int rv = dll.getLast();
		dll.removeLast();
		if (!dll.isEmpty()) {
			if (dll.getSize() % 2 == 0)
				mid = mid.prev;

		} else {
			mid = null;
		}

		return rv;
	}

	public int findMiddle() throws Exception {
		if (mid == null) {
			throw new Exception("empty stack");
		}
		return this.mid.data;
	}

	public void deleteMiddle() throws Exception {
		if (mid == null) {
			throw new Exception("empty stack");
		}

		mid.prev.next = mid.next;
		mid.next.prev = mid.prev;
		dll.size--;

		if (dll.getSize() % 2 == 0)
			mid = mid.prev;

	}

}
