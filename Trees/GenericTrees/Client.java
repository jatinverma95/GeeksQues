package Trees.GenericTrees;

public class Client {

	public static void main(String[] args) {
		// 1 3 2 2 5 0 6 0 3 1 7 0 4 0
		GenricTreess gt = new GenricTreess();

		gt.display();

		System.out.println(gt.getSize());
		System.out.println(gt.size2());

		System.out.println(gt.max());
	}

}
