package linkedList;

public class Client {

	public static void main(String[] args) throws Exception {

		LinkedListt ll = new LinkedListt();
		ll.addFirst(30);
		ll.addFirst(20);
		ll.addFirst(10);
		ll.addLast(40);
		ll.addAt(25, 2);
		ll.addFirst(0);
		ll.addLast(50);
		ll.addAt(35, 5);

		ll.display();

		System.out.println(ll.getFirst());
		System.out.println(ll.getLast());
		System.out.println(ll.getAt(3));

		ll.display();
		System.out.println(ll.getSize());

		ll.removeFirst();
		System.out.println(ll.getSize());
		ll.display();
		ll.removeLast();
		System.out.println(ll.getSize());
		ll.display();
		ll.removeAt(2);
		System.out.println(ll.getSize());
		ll.display();
		System.out.println("**********");
		ll.addLast(50);
		ll.display();

		ll.reverseDI();
		ll.display();

		ll.reversePI();
		ll.display();
		ll.displayRev();

		ll.reversePR();
		ll.display();

		ll.reverseDR();
		ll.display();
	}

}
