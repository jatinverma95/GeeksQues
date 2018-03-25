package Stackk;

public class Stackkk {
	protected int[] data;
	protected int tos;

	public Stackkk() {
		this(10);
	}

	public Stackkk(int cap) {
		data = new int[cap];
		tos = -1;
	}

	public void push(int item) throws Exception {
		if (data.length == tos - 1) {
			throw new Exception("Stack full");
		}

		this.tos++;
		this.data[this.tos] = item;

	}

	public int pop() throws Exception {
		if (this.tos == -1) {
			throw new Exception("Stack empty");
		}
		int rv = this.data[this.tos];
		this.tos--;
		return rv;

	}

	public int top() throws Exception {
		if (this.tos == -1) {
			throw new Exception("Stack empty");
		}
		int rv = this.data[this.tos];
		return rv;

	}

	public int size() {
		return ++this.tos;
	}

	public boolean isEmpty() {
		if (this.tos == -1) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		for (int i = 0; i <= this.tos; i++) {
			System.out.println(this.data[i]);
		}
		System.out.println("END");

	}

}
