package Queuee.QueueUsingStack;

public class Client {

	public static void main(String[] args) throws Exception {
		QueueUsingStackk qust = new QueueUsingStackk();

		qust.enqueue(5);
		qust.enqueue(10);
		qust.enqueue(20);
		qust.enqueue(30);
		qust.enqueue(40);
		System.out.println(qust.front());
		
		System.out.println(qust.dequeue());
		qust.enqueue(50);

		qust.display();

		System.out.println(qust.size());

		System.out.println(qust.front());
	}

}
