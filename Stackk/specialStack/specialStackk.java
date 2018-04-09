package Stackk.specialStack;

public class specialStackk<T> {
	 T[] data;
	 T[] auxMin;
	 int tos;
	 int tosAux;

	public specialStackk() {
		this(10);
	}

	public specialStackk(int cap) {
		data = (T[]) new Object[cap];
		auxMin = (T[]) new Object[cap];
		tos = -1;
	}

//	public <T extends Comparable<T>> void push(T item) throws Exception {
//		if (data.length == tos) {
//			throw new Exception("Stack full");
//		}
//
//		this.tos++;
//		this.data[this.tos] = item;
//
//		if (auxMin.length == 0) {
//			this.tosAux++;
//			this.auxMin[tosAux] = item;
//		} else {
//			if (this.auxMin[this.tosAux]) {
//
//			}
//		}
//	}

	public T pop() throws Exception {
		if (this.tos == -1) {
			throw new Exception("Stack empty");
		}
		T rv = this.data[this.tos];
		this.tos--;
		return rv;

	}

	public T top() throws Exception {
		if (this.tos == -1) {
			throw new Exception("Stack empty");
		}
		T rv = this.data[this.tos];
		return rv;

	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		if (this.tos == -1) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.println(this.data[i]);
		}
		System.out.println("END");

	}

}
