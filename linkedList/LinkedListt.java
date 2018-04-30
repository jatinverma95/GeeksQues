package linkedList;

import java.util.HashMap;

public class LinkedListt {

	public class Node {
		int data;
		Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

		public Node(int data) {
			this.data = data;
		}
	}

	public static class LoopNode {
		int data;
		LoopNode next;

		public LoopNode(int data) {
			this.data = data;
		}
	}

	public LoopNode LoopHead;
	public LoopNode LoopTail;
	public LoopNode LoopSize;

	private Node head;
	private Node tail;
	private int size;

	public LinkedListt() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		for (Node node = this.head; node != null; node = node.next) {
			System.out.print(node.data + "->");
		}
		System.out.println("END");
	}

	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		return this.tail.data;
	}

	public int getAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		if (index > this.getSize() || index < 0) {
			throw new Exception("Invalid index");
		}
		Node node = this.head;
		while (index > 0) {
			node = node.next;
			index--;
		}

		return node.data;

	}

	public Node getNodeAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		if (index > this.getSize() || index < 0) {
			throw new Exception("Invalid index");
		}
		Node node = this.head;
		while (index > 0) {
			node = node.next;
			index--;
		}

		return node;
	}

	public void addLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		if (this.tail == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
		}
		this.tail = newNode;
		this.size++;
	}

	public void addFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = this.head;

		if (size == 0) {
			this.tail = newNode;
		}
		this.head = newNode;
		this.size++;
	}

	public void addAt(int data, int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		if (index > this.getSize() || index < 0) {
			throw new Exception("Invalid index");
		}

		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;

		if (index == 0) {
			this.addFirst(data);
		} else if (index == this.size) {
			this.addLast(data);
		} else {
			Node nm1 = this.getNodeAt(index - 1);
			newNode.next = nm1.next;
			nm1.next = newNode;
			this.size++;
		}
	}

	public int removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		int data = this.head.data;
		this.head = this.head.next;
		this.size--;

		return data;
	}

	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}

		int data = this.tail.data;
		Node nm1Node = this.getNodeAt(this.getSize() - 2);
		nm1Node.next = null;
		this.tail = nm1Node;
		this.size--;

		return data;
	}

	public int removeAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		if (index > this.getSize() || index < 0) {
			throw new Exception("Invalid index");
		}

		if (index == 0) {
			return this.removeFirst();
		} else if (index == this.size - 1) {
			return this.removeLast();
		} else {
			Node nm1Node = this.getNodeAt(index - 1);
			int data = nm1Node.next.data;
			nm1Node.next = nm1Node.next.next;

			this.size--;
			return data;
		}
	}

	public void reverseDI() throws Exception {
		if (this.getSize() == 0) {
			throw new Exception("Empty List");
		}

		if (this.getSize() == 1) {
			return;
		}

		Node first = this.head;
		Node last = this.tail;
		int sizeLocal = this.getSize() - 1;

		int idx = 0;
		while (idx <= (this.getSize() - 1) / 2) {
			int tempData = first.data;
			first.data = last.data;
			last.data = tempData;
			first = first.next;
			Node nm1 = this.getNodeAt(sizeLocal - 1);
			sizeLocal--;
			last = nm1;
			idx++;
		}
	}

	public void reversePI() throws Exception {
		if (this.getSize() == 0) {
			throw new Exception("Empty List");
		}

		if (this.getSize() == 1) {
			return;
		}

		Node first = this.head;
		Node second = this.head.next;
		int idx = 0;
		while (second != null) {
			Node temp = second.next;
			second.next = first;

			first = second;
			second = temp;
		}
		this.tail = this.head;
		this.tail.next = null;
		this.head = first;

	}

	public void displayRev() {
		displayRev(this.head);
		System.out.println("END");
	}

	private void displayRev(Node node) {
		if (node == null) {
			return;
		}
		displayRev(node.next);

		System.out.print(node.data + "->");
	}

	public void reversePR() {
		reversePR(this.head, this.head.next);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePR(Node one, Node two) {
		if (two == null) {
			return;
		}
		reversePR(one.next, two.next);
		two.next = one;

	}

	public void reverseDR() {
		reverseDR(new RDRHelper(this.head), this.head, 0);
	}

	private class RDRHelper {
		Node oneNode;

		public RDRHelper(Node node) {
			this.oneNode = node;
		}
	}

	private void reverseDR(RDRHelper one, Node two, int indx) {
		if (two == null) {
			return;
		}
		reverseDR(one, two.next, indx + 1);
		if (indx >= this.getSize() / 2) {
			int temp = one.oneNode.data;
			one.oneNode.data = two.data;
			two.data = temp;

			one.oneNode = one.oneNode.next;
		}
	}

	public void swapNodes(int one, int two) {
		Node node = this.head;
		Node onePrev = null;
		Node twoPrev = null;
		Node prev = null;

		while (node != null) {

			if (node.data == one) {
				onePrev = prev;
			} else if (node.data == two) {
				twoPrev = prev;
			}
			prev = node;
			node = node.next;
		}

		if (onePrev != null && twoPrev != null) {
			Node twoNext = twoPrev.next.next;
			Node onee = onePrev.next;
			onePrev.next = twoPrev.next;
			if (onee.next == twoPrev.next || twoPrev.next.next == onee) {
				twoPrev.next.next = onee;
			} else {
				twoPrev.next.next = onee.next;
				twoPrev.next = onee;
			}
			onee.next = twoNext;
		} else {
			return;
		}
	}

	public LinkedListt mergeTwoSorted(LinkedListt one) {
		return mergeTwoSortedLL(this.head, one.head);
	}

	private LinkedListt mergeTwoSortedLL(Node one, Node two) {
		LinkedListt result = new LinkedListt();
		while (one != null && two != null) {
			if (one.data < two.data) {
				result.addLast(one.data);
				one = one.next;
			} else {
				result.addLast(two.data);

				two = two.next;
			}

		}

		while (one != null) {
			result.addLast(one.data);
			one = one.next;
		}

		while (two != null) {
			result.addLast(two.data);
			two = two.next;
		}

		return result;

	}

	public int getMidNodeData() {
		return getMidNode().data;
	}

	private Node getMidNode() {
		return this.getMidNode(this.head, this.head);
	}

	private Node getMidNode(Node node, Node two) {
		if (two.next == null || two.next.next == null) {
			return node;
		}

		return getMidNode(node.next, two.next.next);
	}

	public void mergeSort() {
		LinkedListt ll = mergeSort(this.head, this.tail);
		this.head = ll.head;
		this.tail = ll.tail;
	}

	private LinkedListt mergeSort(Node head, Node tail) {
		if (head == tail) {
			LinkedListt br = new LinkedListt();
			br.addFirst(head.data);
			return br;
		}
		Node midNode = this.getMidNode();
		Node midNext = midNode.next;

		LinkedListt one = new LinkedListt();
		one.head = head;
		one.tail = midNode;
		one.tail.next = null;
		one.size = (this.size + 1) / 2;

		LinkedListt two = new LinkedListt();
		two.head = midNext;
		two.tail = tail;
		two.tail.next = null;
		two.size = (this.size / 2);

		one.mergeSort();
		two.mergeSort();

		LinkedListt res = new LinkedListt();
		res = one.mergeTwoSorted(two);
		res.tail.next = null;
		res.size = one.size + two.size;

		return res;
	}

	public void reverseKLLGroup(int k) {
		Node retNode = reverseKLLGroup(this.head, k);
		this.head = retNode;
		Node node = this.head;
		while (node.next != null) {
			node = node.next;
		}

		this.tail = node;

	}

	public Node reverseKLLGroup(Node node, int k) {
		if (node == null) {
			return null;
		}
		int n = k;
		Node headNode = node;
		while (n > 1 && node.next != null) {
			node = node.next;
			n--;
		}
		Node nextNode = node.next;
		node.next = null;
		Node retNode = reverseKLLHepler(headNode, headNode.next);
		headNode.next = reverseKLLGroup(nextNode, k);

		return retNode;
	}

	private Node reverseKLLHepler(Node one, Node two) {
		if (two == null) {
			return one;
		}
		Node retNode = reverseKLLHepler(one.next, two.next);
		two.next = one;
		one.next = null;
		return retNode;
	}

	public boolean detectAndRemoveLoop() {
		return detectAndRemoveLoop(this.LoopHead);
	}

	private boolean detectAndRemoveLoop(LoopNode node) {
		HashMap<LoopNode, Boolean> hm = new HashMap<>();
		LoopNode prev = null;
		boolean breakLL = false;
		while (true) {
			if (node == null) {
				break;
			}
			if (hm.containsKey(node)) {
				breakLL = true;
				break;
			}
			hm.put(node, true);
			prev = node;
			node = node.next;
		}
		if (breakLL) {
			prev.next = null;
		}
		return breakLL;

	}

	public void LoopDisplay() {
		LoopNode node = this.LoopHead;
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println("END");
	}

	// https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
	public void removeLoopByFloydAlgoMethod3() {
		removeLoopByFloydAlgoMethod3(this.LoopHead, this.LoopHead);
	}

	private void removeLoopByFloydAlgoMethod3(LoopNode slow, LoopNode fast) {
		slow = slow.next;
		fast = fast.next.next;
		while (slow != fast) {

			slow = slow.next;
			fast = fast.next.next;
		}

		slow = this.LoopHead;
		LoopNode prev = null;
		while (slow != fast) {
			prev = fast;
			slow = slow.next;
			fast = fast.next;
		}

		prev.next = null;

	}

	public void addTwoNumbersLL(LinkedListt second) {
		addTwoNumbersLL(this.head, second.head);
	}

	private void addTwoNumbersLL(Node one, Node two) {
		LinkedListt resList = new LinkedListt();
		int carry = 0;

		while (one != null && two != null) {
			int sum = one.data + two.data + carry;

			carry = sum / 10;
			int num = sum % 10;

			resList.addLast(num);

			one = one.next;
			two = two.next;
		}

		while (one != null) {
			int sum = one.data + carry;
			carry = sum / 10;
			int num = sum % 10;

			resList.addLast(num);

			one = one.next;
		}

		while (two != null) {
			int sum = two.data + carry;
			carry = sum / 10;
			int num = sum % 10;

			resList.addLast(num);

			one = one.next;
			two = two.next;
		}

		resList.display();

	}

	public void rotateLL(int k) {
		rotateLL(this.head, k);
	}

	private void rotateLL(Node node, int k) {
		while (k > 1) {
			node = node.next;
			k--;
		}
		this.tail.next = this.head;
		this.tail = node;
		this.head = node.next;
		this.tail.next = null;
	}

}
