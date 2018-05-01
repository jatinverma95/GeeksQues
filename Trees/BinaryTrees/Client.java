package Trees.BinaryTrees;

public class Client {

	public static void main(String[] args) {

		BinaryTreee bt = new BinaryTreee();
		// 50 true 25 true 12 false false true 37 false false true 75 true 62
		// true 60 false false true 70 false false true 87 false false
		bt.display();
		System.out.println(bt.size());
		System.out.println(bt.isEmpty());

		System.out.println(bt.size2());
		System.out.println(bt.max());

		System.out.println(bt.height());

		System.out.println(bt.diameter());

		bt.levelOrder();

		System.out.println();
		System.out.println("****PRE*******");
		bt.preOrder();

		System.out.println();
		System.out.println("****POST*******");
		bt.postOrder();
		System.out.println();
		bt.postOrderI();
	}

}
