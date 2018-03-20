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

		System.out.println("***********reversePR*******");
		ll.reversePR();
		ll.display();

		ll.reverseDR();
		ll.display();

		ll.swapNodes(20, 30);
		ll.display();

		System.out.println("***********merge************");
		LinkedListt one = new LinkedListt();
		one.addLast(5);
		one.addLast(15);
		one.addLast(25);
		one.addLast(37);
		one.addLast(45);
		one.addLast(55);
		one.addLast(65);
		one.display();
		System.out.println("!!!!!!!!!");
		ll.display();
		LinkedListt res = one.mergeTwoSorted(ll);
		System.out.println("*********mergeResult***********");
		res.display();

		ll.display();
		System.out.println(ll.getMidNodeData());

		System.out.println("*******mergeSort*********");

		System.out.println("=========Before========");
		res.reversePR();
		res.display();
		res.mergeSort();
		System.out.println("=========After========");
		res.display();

		System.out.println("---------ReverseKLL-------");
		ll.swapNodes(30, 20);
		ll.addLast(60);
		ll.addLast(70);
		ll.display();

		// ll.reverseKLLGroup(3);
		ll.display();

		LinkedListt llLoop = new LinkedListt();

		llLoop.LoopHead = new LinkedListt.LoopNode(10);
		llLoop.LoopHead.next = new LinkedListt.LoopNode(20);
		llLoop.LoopHead.next.next = new LinkedListt.LoopNode(30);
		llLoop.LoopHead.next.next.next = new LinkedListt.LoopNode(40);
		llLoop.LoopHead.next.next.next.next = new LinkedListt.LoopNode(50);
		llLoop.LoopHead.next.next.next.next.next = new LinkedListt.LoopNode(60);
		llLoop.LoopHead.next.next.next.next.next.next = llLoop.LoopHead.next.next;

		//// llLoop.LoopDisplay();
		// llLoop.detectAndRemoveLoop();
		llLoop.removeLoopByFloydAlgoMethod3();
		llLoop.LoopDisplay();

		LinkedListt oneAdd = new LinkedListt();
		oneAdd.addLast(7);
		oneAdd.addLast(5);
		oneAdd.addLast(9);
		oneAdd.addLast(4);
		oneAdd.addLast(6);

		LinkedListt twoAdd = new LinkedListt();
		twoAdd.addLast(8);
		twoAdd.addLast(4);

		oneAdd.addTwoNumbersLL(twoAdd);

		System.out.println("-----------llRotation---------");
		ll.display();
		ll.rotateLL(4);
		ll.display();

	}

}
