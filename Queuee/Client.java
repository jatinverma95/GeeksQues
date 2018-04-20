package Queuee;

public class Client {

	public static void main(String[] args) throws Exception {
		Queueee q = new Queueee(10);
		q.enqueue(0);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);

		System.out.println(q.dequeue());

		System.out.println(q.front());
		q.enqueue(70);

		System.out.println(q.size());
		System.out.println(q.isEmpty());

		q.display();

		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();

		q.display();
		
		generateBinaryNosWithQueue(10);
	}

	public static void generateBinaryNosWithQueue(int n) throws Exception {
		Queueee<String> q = new Queueee<>(100);

		q.enqueue("1");
		int idx = 0;
		while (idx < n) {
			String rv = q.dequeue();
			String nextZero = rv + "0";
			String nextOne = rv + "1";

			q.enqueue(nextZero);
			q.enqueue(nextOne);

			idx++;
			System.out.println(rv + ",");
		}

		while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}

	}

}
