package Stackk.StackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackkUsingQueue<T> {

	private Queue<T> q1;
	private Queue<T> q2;

	public StackkUsingQueue() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	public void push(T item) {
		q2.add(item);

		while (!q1.isEmpty()) {
			q2.add(q1.remove());
		}

		Queue<T> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	public T pop() {
		return q1.remove();
	}

	public void display() {
		for (T item : q1) {
			System.out.print(item + ",");
		}
		System.out.println("END");
	}

}
