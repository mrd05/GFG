package tree;

import java.util.HashMap;
import java.util.Scanner;

public class SymmetricTree {

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right;
		}
	}

	static class Symmetric_Tree {
		public static void inorder(Node root) {
			if (root == null)
				return;

			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Node child;
			int t = sc.nextInt();

			while (t-- > 0) {
				int N1 = sc.nextInt();
				int N2 = sc.nextInt();
				Node root1 = null;
				Node root2 = null;
				Node root = null;

				HashMap<Integer, Node> hm = new HashMap<Integer, Node>();

				for (int i = 0; i < N1; i++) {
					Node parent = null;
					int n1 = sc.nextInt();
					int n2 = sc.nextInt();
					char c = sc.next().charAt(0);
					if (hm.containsKey(n1) == false) {
						parent = new Node(n1);
						hm.put(n1, parent);
						if (root1 == null)
							root1 = parent;
					} else
						parent = hm.get(n1);
					child = new Node(n2);
					if (c == 'L')
						parent.left = child;
					else
						parent.right = child;
					hm.put(n2, child);
				}
				hm.clear();

				for (int i = 0; i < N2; i++) {
					Node parent = null;
					int n1 = sc.nextInt();
					int n2 = sc.nextInt();
					char c = sc.next().charAt(0);
					if (hm.containsKey(n1) == false) {
						parent = new Node(n1);
						hm.put(n1, parent);
						if (root2 == null)
							root2 = parent;
					} else
						parent = hm.get(n1);
					child = new Node(n2);
					if (c == 'L')
						parent.left = child;
					else
						parent.right = child;
					hm.put(n2, child);
				}
				int N = sc.nextInt();
				root = new Node(N);
				root.left = root1;
				root.right = root2;

				GfG gfg = new GfG();
				if (gfg.isSymmetric(root) == true)
					System.out.println("True");
				else
					System.out.println("False");
			}
		}

	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */

	/*
	 * class of the node of the tree is as class Node { int key; Node left,
	 * right;
	 * 
	 * Node(int data) { key = data; left = right = null } }
	 */
	// complete this function
	// return true/false if the is Symmetric or not
	static class GfG {
		public static boolean isSymmetric(Node root) {
			if (root == null)
				return true;
			return checkMirror(root.left, root.right);
		}

		static boolean checkMirror(Node l, Node r) {
			if (l == null && r == null)
				return true;
			if (l == null || r == null)
				return false;

			if (l.data == r.data) {
				return checkMirror(l.left, r.right)
						&& checkMirror(l.right, r.left);
			}
			return false;
		}
	}

}
