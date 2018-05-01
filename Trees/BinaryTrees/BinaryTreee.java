package Trees.BinaryTrees;

import java.util.Scanner;

public class BinaryTreee {

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	private int size;
	private Node root;

	public BinaryTreee() {
		this.size = 0;
		this.root = null;
		Scanner scn = new Scanner(System.in);

		this.root = this.takeInput(null, true, scn);

	}

	private Node takeInput(Node node, boolean isLeft, Scanner scn) {
		if (node == null) {
			System.out.println("Enter data for rootNode");
		} else if (isLeft) {
			System.out.println("Enter Data for left child of " + node.data);
		} else {
			System.out.println("Enter Data for right child of " + node.data);
		}

		int data = scn.nextInt();
		Node newNode = new Node(data);
		this.size++;

		System.out.println("Does" + newNode.data + " has a left child");
		boolean left = scn.nextBoolean();
		if (left) {
			newNode.left = this.takeInput(newNode, true, scn);
		}

		System.out.println("Does" + newNode.data + " has a right child");
		boolean right = scn.nextBoolean();
		if (right) {
			newNode.right = this.takeInput(newNode, false, scn);
		}

		return newNode;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += "END";
		}

		str += "=>" + node.data + "<=";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += "END";
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		int size = 0;

		size += 1;

		if (node.left != null) {
			size += this.size2(node.left);
		}

		if (node.right != null) {
			size += this.size2(node.right);
		}
		return size;
	}

	private class Heapmover {
		int max;
		int min;

		public Heapmover() {
			this.max = Integer.MIN_VALUE;
			this.min = Integer.MAX_VALUE;
		}
	}

	public int max() {
		return this.max(this.root, new Heapmover());
	}

	private int max(Node node, Heapmover mover) {
		if (node.data > mover.max) {
			mover.max = node.data;
		}
		if (node.left != null) {
			this.max(node.left, mover);
		}

		if (node.right != null) {
			this.max(node.right, mover);
		}

		return mover.max;

	}

	public int height() {

		return this.height(this.root) - 1;
	}

	private int height(Node node) {

		int retHeight = 0;

		if (node.left != null) {
			int lefth = this.height(node.left);
			if (lefth > retHeight) {
				retHeight = lefth;
			}

		}

		if (node.right != null) {
			int righth = this.height(node.right);
			if (righth > retHeight) {
				retHeight = righth;
			}
		}

		retHeight += 1;

		return retHeight;

	}

	public int diameter() {
		return this.diameter(this.root);
	}

	private int diameter(Node node) {
		int diameter = 0;
		int lHeight = 0;
		int lDiam = 0;
		int rHeight = 0;
		int rDiam = 0;

		if (node.left != null) {
			lHeight = this.height(node.left);
			lDiam = this.diameter(node.left);
		}

		if (node.right != null) {
			rHeight = this.height(node.right);
			rDiam = this.diameter(node.right);
		}

		diameter = Math.max(lDiam, Math.max(rDiam, rHeight + lHeight + 1));

		return diameter;
	}

}
