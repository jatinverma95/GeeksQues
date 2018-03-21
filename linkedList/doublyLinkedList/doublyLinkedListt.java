package linkedList.doublyLinkedList;

public class doublyLinkedListt {
	public class Node {
		int data;
		Node next;
		Node prev;

		public Node() {
			this.data = 0;
			this.next = null;
			this.prev = null;
		}

	}

	private Node head;
	private Node tail;
	private int size;

	public doublyLinkedListt() {
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
		newNode.prev = this.tail;
		this.tail = newNode;
		this.size++;
	}

	public void addFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = this.head;

		newNode.prev = null;

		if (size == 0) {
			this.tail = newNode;
		} else {
			this.head.prev = newNode;
		}
		this.head = newNode;
		this.size++;
	}

	public void addAfter(int data, int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		if (index > this.getSize() || index < 0) {
			throw new Exception("Invalid index");
		}

		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;

		if (index == this.size - 1) {
			this.addLast(data);
		} else {
			Node n = this.getNodeAt(index);
			newNode.next = n.next;
			newNode.prev = n;
			n.next = newNode;

			this.size++;
		}
	}

	public void addBefore(int data, int index) throws Exception {
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
		} else {
			Node n = this.getNodeAt(index);
			newNode.next = n;
			newNode.prev = n.prev;
			n.prev.next = newNode;
			n.prev = newNode;
			this.size++;
		}
	}

	public void removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}
		this.head = this.head.next;
		this.head.prev = null;
		this.size--;
	}

	public void removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("EmptyList");
		}

		this.tail = this.tail.prev;
		this.tail.next = null;

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
			Node node = this.getNodeAt(index);
			node.prev.next = node.next;
			node.next.prev = node.prev;
			this.size--;
		}
	}

	public void reverseDLL() {
		reverseDLL(this.head, this.head.next);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.head.prev = null;
		this.tail.next = null;
	}

	private void reverseDLL(Node one, Node two) {
		if (two == null) {
			return;
		}
		reverseDLL(one.next, two.next);
		two.next = one;
		one.prev = two;

	}

	public void quickSortLastPivotInDll() {
		quickSortLastPivotInDll(this.head, this.tail);
	}

	private void quickSortLastPivotInDll(Node l, Node h) {
		if (h != null && l != h && l.next != h) {
			Node p = partitionHelper(l, h);
			quickSortLastPivotInDll(this.head, p.prev);
			quickSortLastPivotInDll(p.next, this.tail);
		}
	}

	private Node partitionHelper(Node l, Node h) {
		Node pivot = h;

		Node i = l.prev;

		Node j = l.next;
		while (j != h) {
			if (pivot.data >= j.data) {
				i = i.next;
				swap(i, j);
			}
			j = j.next;
		}
		if (i == null) {
			swap(l, h);
			return this.head;
		} else {
			swap(i.next, h);
			return i.next;
		}

	}

	private void swap(Node i, Node j) {
		if (i.prev != null) {
			i.prev.next = j;
		}
		j.prev.next = i;

		i.next.prev = j;
		if (j.next != null) {
			j.next.prev = i;
		}

		Node temp = j.next;
		j.next = i.next;
		i.next = temp;

		Node temp2 = j.prev;
		j.prev = i.prev;
		i.prev = temp2;

		if (j.prev == null) {
			this.head = j;
		}
		if (i.next == null) {
			this.tail = i;
		}
	}

}
