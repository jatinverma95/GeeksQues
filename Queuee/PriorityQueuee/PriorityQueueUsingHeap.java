package Queuee.PriorityQueuee;

import java.util.ArrayList;
import java.util.HashMap;

public class PriorityQueueUsingHeap<T extends Comparable<T>> {
	private ArrayList<T> data;
	private HashMap<T, Integer> idxMap;

	public PriorityQueueUsingHeap() {
		this.data = new ArrayList<>();
		this.idxMap = new HashMap<>();
	}

	public PriorityQueueUsingHeap(T[] arr) {
		this.data = new ArrayList<>();
		this.idxMap = new HashMap<>();

		makeHeap(arr);
	}

	private void makeHeap(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			this.data.add(arr[i]);
			this.idxMap.put(arr[i], i);
		}

		for (int i = (this.data.size() / 2) - 1; i >= 0; i--) {
			downheapify(i);
		}
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public void display() {
		System.out.println(this.data);
	}

	public T getHP() {
		return this.data.get(0);
	}

	public void addHP(T item) {
		this.data.add(item);
		this.idxMap.put(item, this.size() - 1);

		upheapify(this.size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;

		if (isHP(ci, pi)) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	private boolean isHP(int ci, int pi) {
		T one = this.data.get(pi);
		T two = this.data.get(ci);

		if (one.compareTo(two) > 0) {
			return true;
		} else {
			return false;
		}
	}

	private void swap(int ci, int pi) {
		T one = this.data.get(ci);
		T two = this.data.get(pi);

		idxMap.put(one, pi);
		idxMap.put(two, ci);

		this.data.set(pi, one);
		this.data.set(ci, two);
	}

	public T removeHP() {
		T rv = this.data.get(0);
		this.swap(0, this.data.size() - 1);

		this.data.remove(this.data.size() - 1);
		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int maxi = pi;

		if (lci < this.size() && this.isHP(lci, maxi)) {
			maxi = lci;
		}

		if (rci < this.size() && this.isHP(rci, maxi)) {
			maxi = rci;
		}

		if (maxi != pi) {
			swap(maxi, pi);
			downheapify(maxi);
		}

	}

	public void updatePriority(T item) {
		int idx = this.idxMap.get(item);

		upheapify(idx);
		downheapify(idx);
	}

}
