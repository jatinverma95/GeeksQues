package Queuee.Deque;

import Stackk.Stackkk;

public class Client {

	public static void main(String[] args) throws Exception {

		Dequee<Integer> dq = new Dequee<>(10);
		//
		dq.enqueueFront(20);
		dq.enqueueFront(10);
		dq.enqueueFront(5);
		dq.enqueueRear(25);
		dq.enqueueRear(30);

		dq.display();

		System.out.println(dq.dequeueFront());
		System.out.println(dq.dequeueRear());

		dq.display();

		System.out.println(dq.getFront());
		System.out.println(dq.getRear());

		slidingWindowMax(new int[] { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 }, 4);

		PetrolPumpHelper[] ph = new PetrolPumpHelper[] { new PetrolPumpHelper(6, 4), new PetrolPumpHelper(3, 6),
				new PetrolPumpHelper(7, 3) };
		circularPetrolVisit(ph);

	}

	public static void slidingWindowMax(int[] arr, int k) throws Exception {
		Dequee<Integer> dq = new Dequee<>(k);
		int max = Integer.MIN_VALUE;
		int[] maxArr = new int[arr.length - 2];

		for (int i = 0; i < k; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			dq.enqueueRear(arr[i]);
		}
		int j = 0;
		maxArr[j] = max;
		j++;

		int i = k;
		while (i < arr.length) {
			dq.dequeueFront();
			dq.enqueueRear(arr[i]);
			if (arr[i] > max) {
				max = arr[i];
			}

			maxArr[j] = max;
			j++;
			i++;
		}

		for (int item : maxArr) {
			System.out.print(item + ",");
		}
		System.out.println("END");

	}

	private static class PetrolPumpHelper {
		int petrolAmt;
		int nextDist;

		public PetrolPumpHelper(int p, int d) {
			this.petrolAmt = p;
			this.nextDist = d;
		}

	}

	public static void circularPetrolVisit(PetrolPumpHelper[] arr) throws Exception {

		int start = 0;
		int i = 1;

		Dequee<PetrolPumpHelper> dqPetrol = new Dequee<>(arr.length);
		dqPetrol.enqueueRear(arr[0]);
		int res = arr[0].petrolAmt;
		res -= arr[0].nextDist;
		while (i != start && i < arr.length) {
			while (!dqPetrol.isEmpty() && res < 0) {
				PetrolPumpHelper ph = dqPetrol.dequeueFront();
				res += ph.nextDist;
				res -= ph.petrolAmt;
				start++;

			}

			res -= arr[i].nextDist;
			res += arr[i].petrolAmt;

			dqPetrol.enqueueRear(arr[i]);
			i++;
		}

		System.out.println("start=" + start);

	}

}
