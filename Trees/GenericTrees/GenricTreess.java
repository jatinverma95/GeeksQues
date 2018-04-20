package Trees.GenericTrees;

import java.util.ArrayList;
import java.util.Scanner;

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
		return this.height(this.root);
	}

	private int height(Node node) {

	}

}
