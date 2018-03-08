package linkedList;

public class LinkedListt {

	private class Node {
		int data;
		Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}
	}

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

	public void removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		this.head = this.head.next;
		this.size--;
	}

	public void removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}

		Node nm1Node = this.getNodeAt(this.getSize() - 2);
		nm1Node.next = null;
		this.tail = nm1Node;
		this.size--;
	}

	public void removeAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		if (index > this.getSize() || index < 0) {
			throw new Exception("Invalid index");
		}

		if (index == 0) {
			this.removeFirst();
		} else if (index == this.size - 1) {
			this.removeLast();
		} else {
			Node nm1Node = this.getNodeAt(index - 1);
			nm1Node.next = nm1Node.next.next;
			this.size--;
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
		if (indx > this.getSize() / 2) {
			int temp = one.oneNode.data;
			one.oneNode.data = two.data;
			two.data = temp;

			one.oneNode = one.oneNode.next;
		}
	}
}
