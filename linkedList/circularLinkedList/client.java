package linkedList.circularLinkedList;

public class client {

	public static void main(String[] args) throws Exception {

		circularLinkedListt cll = new circularLinkedListt();
		cll.addLast(10);
		cll.addLast(20);
		cll.addLast(30);
		cll.addLast(40);
		cll.addLast(50);
		cll.addLast(60);
		cll.addFirst(5);
		cll.addAt(15, 2);
		cll.addAt(45, 6);
		System.out.println(cll.getSize());
		cll.display();

		System.out.println(cll.getFirst());
		System.out.println(cll.getLast());
		System.out.println(cll.getAt(6));

		cll.removeAt(6);
		cll.removeFirst();
		// cll.removeLast();
		cll.display();
		System.out.println(cll.getSize());

		// cll.splitCLL();

		cll.insertSortedInCll(25);
		cll.display();

	}

}
