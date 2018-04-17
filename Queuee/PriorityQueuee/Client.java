package Queuee.PriorityQueuee;

public class Client {

	public static void main(String[] args) {
		PriorityQueueUsingHeap<Integer> pq = new PriorityQueueUsingHeap<>();

		pq.addHP(10);
		pq.addHP(20);
		pq.addHP(60);
		pq.addHP(40);
		pq.addHP(15);
		pq.addHP(30);

		pq.display();

		System.out.println(pq.isEmpty());
		System.out.println(pq.size());

		pq.removeHP();
		System.out.println(pq.getHP());
		pq.addHP(5);

		pq.display();

		Integer[] arr = new Integer[] { 5, 1, 8, 2, 4 };

		PriorityQueueUsingHeap<Integer> pqr = new PriorityQueueUsingHeap<>(arr);

		pqr.display();
	}

}
