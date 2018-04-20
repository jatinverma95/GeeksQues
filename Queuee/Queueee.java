package Queuee;

public class Queueee<T> {
	protected Object[] data;
	protected int front;
	protected int size;

	public Queueee(int cap) {
		this.data = (T[]) new Object[cap];
		this.front = 0;
		this.size = 0;
	}

	public void enqueue(T item) throws Exception {
		if (this.size == this.data.length) {
			throw new Exception("Queue Full");
		}

		int rear = (this.front + this.size) % this.data.length;

		this.data[rear] = item;
		this.size++;
	}

	public T dequeue() throws Exception {
		if (this.size == 0) {
			throw new Exception("Queue Empty");
		}

		T rv = (T) this.data[this.front];
		this.front = (this.front + 1) % this.data.length;
		this.size--;

		return rv;
	}

	public T front() throws Exception {
		if (this.size == 0) {
			throw new Exception("Queue Empty");
		}

		return (T) this.data[this.front];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		int idx = this.front;
		while (idx != this.size + this.front) {
			System.out.print(this.data[idx] + ",");
			idx++;
		}

		System.out.println("END");
	}
}
