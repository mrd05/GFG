package tree;

import java.util.Scanner;

public class LowestCommonAncestorInBST {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class BST_Lowest_Common_Ancestor {
		Node root;

		void insert(Node root, int key) {
			if (key < root.data) {
				if (root.left != null)
					insert(root.left, key);
				else {
					root.left = new Node(key);
				}
			} else if (key > root.data) {
				if (root.right != null)
					insert(root.right, key);
				else {
					root.right = new Node(key);
				}
			}
		}

		public static void main(String args[]) {

			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();

			while (t > 0) {
				int n = sc.nextInt();
				BST_Lowest_Common_Ancestor tree = new BST_Lowest_Common_Ancestor();
				int a1 = sc.nextInt();
				Node root = new Node(a1);

				for (int i = 1; i < n; i++) {
					int a = sc.nextInt();
					tree.insert(root, a);
				}

				int n1 = sc.nextInt();
				int n2 = sc.nextInt();

				BST g = new BST();
				Node s = g.LCA(root, n1, n2);
				System.out.println(s.data);

				t--;
			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	/* A Binary Search Tree node */
	/*
	 * class Node { int data; Node left, right; Node(int item) { data = item;
	 * left = right = null; } }
	 */
	static class BST {
		Node LCA(Node node, int n1, int n2) {
			if (node == null)
				return null;

			while (node != null) {
				if (n1 < node.data && n2 < node.data)
					node = node.left;
				else if (n1 > node.data && n2 > node.data)
					node = node.right;
				else
					break;
			}

			return node;
		}

	}

}
