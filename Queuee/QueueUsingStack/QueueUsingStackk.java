package Queuee.QueueUsingStack;

import Stackk.Stackkk;

public class QueueUsingStackk {

	protected Stackkk<Integer> qust1;
	protected Stackkk<Integer> qust2;
	protected int size;

	public QueueUsingStackk() {
		this.qust1 = new Stackkk<>();
		this.qust2 = new Stackkk<>();
		this.size = 0;
	}

	public void enqueue(int item) throws Exception {
		this.qust1.push(item);
		this.size++;
	}

	public int dequeue() throws Exception {
		for (int i = 0; this.qust1.size() != 1; i++) {
			qust2.push(qust1.pop());
		}

		int rv = qust1.pop();

		for (int i = 0; this.qust2.size() != 0; i++) {
			qust1.push(qust2.pop());
		}
		this.size--;
		return rv;
	}

	public int front() throws Exception {
		for (int i = 0; this.qust1.size() != 1; i++) {
			qust2.push(qust1.pop());
		}

		int rv = qust1.top();

		for (int i = 0; this.qust2.size() != 0; i++) {
			qust1.push(qust2.pop());
		}

		return rv;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() throws Exception {

		for (int i = 0; this.qust1.size() != 0; i++) {
			qust2.push(qust1.pop());
		}

		while (!qust2.isEmpty()) {
			System.out.print(qust2.top() + ",");
			qust1.push(qust2.pop());
		}

		System.out.println("END");
	}
}
