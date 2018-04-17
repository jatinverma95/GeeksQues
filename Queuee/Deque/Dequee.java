package Queuee.Deque;

import java.util.ArrayList;

public class Dequee<T> {
	protected Object[] data;
	protected int front;
	protected int rear;
	protected int size;
	int cap;

	public Dequee(int cap) {
		this.data = (T[]) new Object[cap];
		this.front = -1;
		this.rear = 0;
		this.size = 0;
		this.cap = cap;
	}

	public void enqueueRear(T item) throws Exception {
		if (this.size == this.data.length) {
			throw new Exception("Queue Full");
		}

		if (this.front == -1) {
			this.front = 0;
			this.rear = 0;
		} else if (this.rear == cap - 1) {
			this.rear = 0;
		} else {
			this.rear++;
		}

		this.data[this.rear] = (item);
		this.size++;

	}

	public void enqueueFront(T item) throws Exception {
		if (this.size == this.data.length) {
			throw new Exception("Queue Full");
		}

		if (this.front == -1) {
			this.front = 0;
			this.rear = 0;
		} else if (this.front == 0) {
			this.front = cap - 1;
		} else {
			this.front--;
		}

		this.data[this.front] = item;
		this.size++;

	}

	public T dequeueFront() throws Exception {
		if (this.size == 0) {
			throw new Exception("Queue Empty");
		}

		T rv = (T) this.data[this.front];
		this.front++;
		if (this.front == this.data.length) {
			this.front = 0;
		}

		this.size--;

		return rv;
	}

	public T dequeueRear() throws Exception {
		if (this.size == 0) {
			throw new Exception("Queue Empty");
		}

		T rv = (T) this.data[this.rear];
		this.rear--;
		if (this.rear == -1) {
			this.rear = this.size - 1;
		}

		this.size--;

		return rv;
	}

	public T getFront() throws Exception {
		if (this.size == 0) {
			throw new Exception("Queue Empty");
		}

		return (T) this.data[this.front];
	}

	public T getRear() throws Exception {
		if (this.size == 0) {
			throw new Exception("Queue Empty");
		}

		return (T) this.data[this.rear];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		int i = this.front;
		while (i!= this.rear+1) {
			System.out.print(this.data[i] + ",");
			i++;
			if (i == this.data.length) {
				i = 0;
			}

		}

		System.out.println("END");
	}
}
