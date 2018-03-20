package linkedList.circularLinkedList;

import linkedList.LinkedListt.Node;

public class circularLinkedListt {
	public class Node {
		int data;
		Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

	}

	private Node tail;
	private int size;

	public circularLinkedListt() {
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
		Node firstNode = this.tail.next;
		System.out.print(firstNode.data + "->");
		for (Node node = firstNode.next; node != this.tail.next; node = node.next) {
			System.out.print(node.data + "->");
		}
		System.out.println("END");

	}

	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		return this.tail.next.data;
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
		Node node = this.tail.next;
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

		Node node = this.tail.next;
		while (index > 0) {
			node = node.next;
			index--;
		}

		return node;
	}

	public void addLast(int data) {
		Node newnode = new Node();
		newnode.data = data;
		if (this.size > 0) {
			newnode.next = this.tail.next;
			this.tail.next = newnode;
		} else {
			newnode.next = newnode;
		}
		this.tail = newnode;
		this.size++;

	}

	public void addFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (this.getSize() == 0) {
			this.tail = newNode;
			newNode.next = newNode;
		} else {
			newNode.next = this.tail.next;
			this.tail.next = newNode;
		}
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

		this.tail.next = this.tail.next.next;
		this.size--;
	}

	public void removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		Node secondLastNode = getNodeAt(this.getSize() - 2);
		secondLastNode.next = this.tail.next;
		this.tail = secondLastNode;
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

	public void splitCLL() {
		int midIdx = (this.getSize() - 1) / 2;

		Node firstNode = this.tail.next;

		int i = 0;
		Node node = firstNode;
		while (i != midIdx) {

			i++;
			node = node.next;
		}

		Node secondNode = node.next;
		this.tail.next = secondNode;
		node.next = firstNode;

		System.out.println("----firstLL------");
		System.out.print(firstNode.data + "->");
		Node fdNode = firstNode.next;
		while (fdNode != firstNode) {
			System.out.print(fdNode.data + "->");
			fdNode = fdNode.next;
		}
		System.out.println("START");

		System.out.println("----secondLL----");
		System.out.print(secondNode.data + "->");
		Node sdNode = secondNode.next;
		while (sdNode != secondNode) {
			System.out.print(sdNode.data + "->");
			sdNode = sdNode.next;
		}
		System.out.println("START");
	}

	public void insertSortedInCll(int newData) {
		Node firstNode = this.tail.next;

		if (firstNode.data > newData) {
			Node newNode = new Node();
			newNode.data = newData;
			newNode.next = this.tail.next;
			this.tail.next = newNode;
			this.size++;
			return;
		}
		Node tempNode = firstNode.next;
		Node prev = firstNode;
		while (tempNode != firstNode) {

			if (newData < tempNode.data) {
				Node newNode = new Node();
				newNode.data = newData;
				prev.next = newNode;
				newNode.next = tempNode;
				this.size++;
				return;
			}
			if (tempNode == this.tail) {
				Node newNode = new Node();
				newNode.data = newData;
				newNode.next = this.tail.next;
				this.tail.next = newNode;
				this.tail = newNode;
				this.size++;
				return;
			}
			prev = tempNode;
			tempNode = tempNode.next;

		}

	}

}
