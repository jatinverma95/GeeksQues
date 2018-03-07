package linkedList;

import lecture1_LL.LinkedList.Node;

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
		
		this.tail.next = newNode;
		
	}

	public void addFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = this.head;

		if (size == 0) {
			this.tail = newNode;
		}
		this.head = newNode;
	}

	public void addAt(int index, int data) throws Exception {
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
	}

	public void removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}

		Node nm1Node = this.getNodeAt(this.getSize() - 1);
		nm1Node.next = null;

	}

	public void removeAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		if (index > this.getSize() || index < 0) {
			throw new Exception("Invalid index");
		}

		Node nm1Node = this.getNodeAt(index - 1);

	}

}
