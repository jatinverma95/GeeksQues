package Trees.GenericTrees;

public class Client {

	public static void main(String[] args) throws Exception {
		// 10 3 20 2 50 0 60 0 30 1 70 0 40 0
		// 10 3 20 2 50 0 60 1 110 0 30 1 70 0 40 3 80 0 90 0 100 0 :
		// MIRRORcHECK
		GenricTreess gt = new GenricTreess();

		gt.display();

		System.out.println(gt.getSize());
		System.out.println(gt.size2());

		System.out.println(gt.max());

		System.out.println(gt.height());

		// gt.linearize();

		gt.display();

		System.out.println(gt.justLarger(75));

		// gt.mirror();
		gt.display();

		// GenricTreess gt2 = new GenricTreess();
		// 10 2 20 2 50 0 60 0 30 1 70 0
		// 10 3 40 3 100 0 90 0 80 0 30 1 70 0 20 2 60 0 50 0 :MIRRORcHECK

		// System.out.println(gt.isIsomorphic(gt2));

		// gt.removeLeaf();
		gt.display();

		System.out.println("*******LevelWiseDIsp********");

		gt.levelOrderLineWise();

		System.out.println("*******LevelWiseZigZagDIsp********");

		gt.levelOrderZigZag();

		// System.out.println(gt.mirrorCheck(gt2));

		System.out.println(gt.serialize());
		gt.deserialize("10,20,50,),60,110,),),),30,70,),),40,80,),90,),100,),),),");

	}

}
