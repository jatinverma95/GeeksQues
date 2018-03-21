package linkedList.doublyLinkedList;

public class Client {

	public static void main(String[] args) throws Exception {

		doublyLinkedListt dll = new doublyLinkedListt();

		dll.addFirst(10);
		dll.addLast(20);
		dll.addLast(30);
		dll.addLast(40);
		dll.addLast(50);
		dll.addAfter(60, 4);
		dll.addBefore(25, 2);
		dll.addBefore(55, 6);
		dll.addAfter(15, 0);

		dll.display();

		dll.removeFirst();
		System.out.println(dll.getFirst());
		System.out.println(dll.getLast());
		System.out.println(dll.getAt(3));
		dll.removeLast();
		dll.removeAt(2);
		dll.display();

		dll.reverseDLL();
		dll.display();

		dll.quickSortLastPivotInDll();
		dll.display();
	}

}
