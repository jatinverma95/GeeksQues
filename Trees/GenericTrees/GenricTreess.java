package Trees.GenericTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import linkedList.LinkedListt;

public class GenricTreess {

	private class Node {
		int data;
		ArrayList<Node> children;

		public Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	Node root;
	int size;

	public GenricTreess() {
		this.size = 0;
		Scanner scn = new Scanner(System.in);

		this.root = takeInput(scn, null, 0);
	}

	private Node takeInput(Scanner scn, Node parent, int i) {
		if (parent == null) {
			System.out.println("Enter root data");
		} else {
			System.out.println("Enter data for" + parent.data + "'s " + i + "th child");
		}

		int data = scn.nextInt();

		Node child = new Node(data);

		this.size++;

		System.out.println("Enter no. of children for" + child.data);
		int numGC = scn.nextInt();

		for (int j = 0; j < numGC; j++) {
			child.children.add(takeInput(scn, child, j));
		}

		return child;

	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.getSize() == 0;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		System.out.print(node.data + "->");

		for (int i = 0; i < node.children.size(); i++) {
			System.out.print(node.children.get(i).data + ",");
		}
		System.out.println("END");

		for (int i = 0; i < node.children.size(); i++) {
			this.display(node.children.get(i));
		}
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		int count = 0;

		count += 1;

		for (Node children : node.children) {
			count += size2(children);
		}

		return count;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		int max = Integer.MIN_VALUE;

		max = node.data;

		for (Node children : node.children) {
			int rv = max(children);
			if (max < rv) {
				max = rv;
			}
		}

		return max;
	}

	public int height() {
		return this.height(this.root) - 1;
	}

	private int height(Node node) {
		int height = 1;
		int maxHeight = 0;
		for (int i = 0; i < node.children.size(); i++) {
			int childHt = this.height(node.children.get(i));
			if (childHt > maxHeight) {
				maxHeight = childHt;
			}
		}

		height += maxHeight;
		return height;
	}

	public void linearize() {
		this.linearize(this.root);
	}

	private void linearize(Node node) {

		for (int i = 0; i < node.children.size(); i++) {
			this.linearize(node.children.get(i));
		}

		while (node.children.size() > 1) {
			Node tailNode = this.getTail(node);
			tailNode.children.add(node.children.remove(1));

		}

	}

	private Node getTail(Node node) {
		while (node.children.size() > 0) {
			node = node.children.get(0);
		}

		return node;
	}

	public int justLarger(int data) {
		return this.justLarger(this.root, data);
	}

	private int justLarger(Node node, int data) {
		int jlData = Integer.MAX_VALUE;
		if (data < node.data && jlData > node.data) {
			jlData = node.data;
		}

		for (int i = 0; i < node.children.size(); i++) {
			int childJL = this.justLarger(node.children.get(i), data);
			if (data < childJL && jlData > childJL) {
				jlData = childJL;
			}
		}
		return jlData;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		for (int i = 0; i < node.children.size(); i++) {
			this.mirror(node.children.get(i));
		}

		for (int i = 0; i < node.children.size() / 2; i++) {
			Node temp = node.children.get(i);
			node.children.set(i, node.children.get(node.children.size() - i - 1));
			node.children.set(node.children.size() - 1 - i, temp);
		}
	}

	public boolean isIsomorphic(GenricTreess gt) {
		return this.isIsomorphic(this.root, gt.root);
	}

	private boolean isIsomorphic(Node root1, Node root2) {
		if (root1.children.size() != root2.children.size()) {
			return false;
		}

		for (int i = 0; i < root1.children.size(); i++) {
			boolean ansLocal = this.isIsomorphic(root1.children.get(i), root2.children.get(i));
			if (!ansLocal) {
				return false;
			}
		}

		return true;

	}

	public void removeLeaf() {
		this.removeLeaf(this.root, null);
	}

	private void removeLeaf(Node node, Node parent) {
		if (node.children.size() < 1) {
			parent.children.remove(node);
		}

		for (int i = 0; i < node.children.size(); i++) {
			this.removeLeaf(node.children.get(i), node);
		}

	}

	public void preOrder() {
		preOrder(this.root);
		System.out.println("END");
	}

	private void preOrder(Node node) {

		System.out.print(node.data + ",");

		for (Node child : node.children) {
			preOrder(child);
		}
	}

	public void postOrder() {
		postOrder(this.root);
		System.out.println("END");
	}

	private void postOrder(Node node) {

		for (Node child : node.children) {
			postOrder(child);
		}

		System.out.print(node.data + ",");
	}

	public void levelOrder() {

	}

	private void levelOrder(Node node) {
		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(node);

		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();

			System.out.print(temp.data + " ,");

			for (Node child : temp.children) {
				queue.addLast(child);

			}

		}
	}

	public void levelOrderLineWise() throws Exception {
		levelOrderLineWise(this.root);
	}

	private void levelOrderLineWise(Node node) throws Exception {
		LinkedList<Node> parent = new LinkedList<>();
		LinkedList<Node> child = new LinkedList<>();

		Node temp = node;

		parent.addLast(temp);
		while (!parent.isEmpty()) {
			while (!parent.isEmpty()) {
				Node tempL = parent.removeFirst();
				System.out.print(tempL.data + ",");
				int i = 0;
				while (i < tempL.children.size()) {
					child.addLast(tempL.children.get(i));
					i++;
				}
			}
			System.out.println();

			parent = child;
			child = new LinkedList<>();
		}

	}

	public void levelOrderZigZag() {
		this.levelOrderZigZag(this.root);
	}

	private void levelOrderZigZag(Node node) {
		LinkedList<Node> parent = new LinkedList<>();
		LinkedList<Node> child = new LinkedList<>();

		Node temp = node;

		parent.addFirst(temp);
		while (!parent.isEmpty()) {
			while (!parent.isEmpty()) {
				Node tempL = parent.removeFirst();
				System.out.print(tempL.data + ",");
				int i = 0;
				while (i < tempL.children.size()) {
					child.addFirst(tempL.children.get(tempL.children.size() - i - 1));
					i++;
				}
			}
			System.out.println();

			parent = child;
			child = new LinkedList<>();
		}

	}

	public boolean mirrorCheck(GenricTreess gt2) {
		return this.mirrorCheck(this.root, gt2.root);
	}

	private boolean mirrorCheck(Node one, Node two) {

		if (one.data != two.data || one.children.size() != two.children.size()) {
			return false;
		}

		for (int i = 0; i < one.children.size(); i++) {
			boolean oneB = this.mirrorCheck(one.children.get(i), two.children.get(one.children.size() - i - 1));
			boolean twoB = this.mirrorCheck(one.children.get(one.children.size() - i - 1), two.children.get(i));

			if (!oneB || !twoB) {
				return false;
			}
		}

		return true;

	}

	public String serialize() {
		return this.serialize(this.root);
	}

	private String serialize(Node node) {
		if (node.children.size() == 0) {
			return node.data + "," + ")" + ",";
		}
		String rv = "";
		rv += node.data + ",";

		int i = 0;
		while (i < node.children.size()) {
			rv += serialize(node.children.get(i));
			i++;
		}

		return rv + ")" + ",";
	}

	public void deserialize(String ques) {
		GenricTreess gt2 = new GenricTreess();
		StringChar sc = removeTillBrack(ques);

		Node newRoot = new Node(Integer.parseInt(sc.ch));
		gt2.root = newRoot;

		deserialize(gt2.root, sc.resStr);

		gt2.display();

	}

	private String deserialize(Node node, String ques) {
		String rv = "";
		StringChar sc = removeTillBrack(ques);

		if (sc.ch != ")") {
			Node newNode = new Node(Integer.parseInt(sc.ch));
			node.children.add(newNode);
			String str = deserialize(newNode, sc.resStr);
			if (str == ")") {
				StringChar rStr1 = removeTillBrack(sc.resStr);
				StringChar rStr2 = removeTillBrack(rStr1.resStr);
				
				StringChar sc2 = removeTillBrack(rStr2.resStr);
				
				Node newNode2 = new Node(Integer.parseInt(sc2.ch));
				node.children.add(newNode2);

				deserialize(newNode2, sc2.resStr);
			}
		} else {
			return ")";
		}

		return rv;
	}

	private class StringChar {
		String ch;
		String resStr;
	}

	private StringChar removeTillBrack(String str) {
		int i = 0;
		StringChar sc = new StringChar();
		while (str.charAt(i) != ',') {
			i++;
		}

		sc.ch = str.substring(0, i);
		sc.resStr = str.substring(i + 1);

		return sc;
	}

}
