package Trees.GenericTrees;

import java.util.ArrayList;
import java.util.Scanner;

public class GenricTreess<T> {

	private class Node {
		T data;
		ArrayList<Node> children;

		public Node(T data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	Node root;
	int size;

	public GenricTreess() {
		this.size = 0;

	}

	private Node takeInput(Scanner scn, Node parent, int data) {

	}

}
