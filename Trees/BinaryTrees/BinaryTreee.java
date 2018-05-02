package Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

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

	public void preOrder() {
		preOrder(this.root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + ",");

		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder() {
		postOrder(this.root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);

		System.out.print(node.data + ",");
	}

	public void inOrder() {
		inOrder(this.root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + ",");
		inOrder(node.right);
	}

	public void levelOrder() {
		levelOrder(this.root);
		System.out.print("END");
	}

	private void levelOrder(Node node) {
		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(node);

		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();

			System.out.print(temp.data + ",");
			if (temp.left != null) {
				queue.addLast(temp.left);

			}
			if (temp.right != null) {
				queue.addLast(temp.right);
			}

		}
	}

	private class OrderPair {
		Node node;

		boolean isLeftDone;
		boolean isRightDone;
		boolean isSelfDone;

		public OrderPair(Node data) {
			node = (data);

		}

	}

	public void postOrderI() {
		Stack<OrderPair> st = new Stack<>();

		st.push(new OrderPair(this.root));

		while (!st.isEmpty()) {
			OrderPair temp = st.lastElement();
			if (!temp.isLeftDone) {
				if (temp.node.left != null) {
					st.push(new OrderPair(temp.node.left));
				}
				temp.isLeftDone = true;
			} else if (!temp.isRightDone) {
				if (temp.node.right != null) {
					st.push(new OrderPair(temp.node.right));
				}
				temp.isRightDone = true;
			} else if (!temp.isSelfDone) {
				System.out.print(temp.node.data + ",");
				temp.isSelfDone = true;
			} else {
				st.pop();
			}

		}

	}

	private class BSTPair {
		boolean isBST;
		int min;
		int max;
	}

	public boolean isBST() {
		return this.isBST(this.root).isBST;
	}

	private BSTPair isBST(Node node) {
		if (node.left == null && node.right == null) {
			BSTPair bp = new BSTPair();
			bp.max = node.data;
			bp.min = node.data;
			bp.isBST = true;
			return bp;
		}
		BSTPair lp = this.isBST(node.left);
		BSTPair rp = this.isBST(node.right);

		BSTPair mp = new BSTPair();
		if (lp.max < node.data && rp.min > node.data && lp.isBST && rp.isBST) {
			mp.isBST = true;
			mp.min = lp.min;
			mp.max = rp.max;

		} else {
			mp.isBST = false;
		}

		return mp;
	}

	private class diapair {
		int height;
		int diameter;
	}

	public int diameter2() {
		return this.diameter2(this.root).diameter;
	}

	private diapair diameter2(Node node) {
		if (node == null) {
			diapair bp = new diapair();
			bp.diameter = 0;
			bp.height = 0;
			return bp;
		}

		diapair lp = this.diameter2(node.left);
		diapair rp = this.diameter2(node.right);

		diapair mp = new diapair();

		mp.height = Math.max(lp.height, rp.height) + 1;
		mp.diameter = Math.max(lp.height + rp.height + 1, Math.max(lp.diameter, rp.diameter));

		return mp;
	}

	public void removeLeaves() {
		this.removeLeaves(this.root, null, true);
	}

	private void removeLeaves(Node node, Node parent, boolean isLeft) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (isLeft) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}

		this.removeLeaves(node.left, node, true);
		this.removeLeaves(node.right, node, false);

	}

	public void inOrderWORec() {
		this.inOrderWORec(this.root);
	}

	private void inOrderWORec(Node node) {
		Stack<Node> st = new Stack<>();
		
		
	}

}
