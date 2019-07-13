package tree;

import java.util.HashMap;
import java.util.Scanner;

public class CheckForBalancedTree {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	static class Height_Balanced_Tree {
		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while (t > 0) {
				HashMap<Integer, Node> m = new HashMap<Integer, Node>();
				int n = sc.nextInt();
				Node root = null;
				while (n > 0) {

					int n1 = sc.nextInt();
					int n2 = sc.nextInt();
					char lr = sc.next().charAt(0);

					// cout << n1 << " " << n2 << " " << (char)lr << endl;
					Node parent = m.get(n1);
					if (parent == null) {
						parent = new Node(n1);
						m.put(n1, parent);
						if (root == null)
							root = parent;
					}
					Node child = new Node(n2);
					if (lr == 'L')
						parent.left = child;
					else
						parent.right = child;
					m.put(n2, child);
					n--;
				}

				Tree g = new Tree();

				if (g.isBalanced(root) == true)
					System.out.println(1);
				else
					System.out.println(0);
				t--;
			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	/*
	 * A binary tree node class class Node { int data; Node left,right;
	 * 
	 * Node(int d) { data = d; left = right = null; } }
	 */
	static class Tree {
		static class Height {
			int h;
		}

		/*
		 * This function should return tree if passed tree is balanced, else
		 * false.
		 */

		// with extra space
		boolean isBalanced(Node root) {
			if (root == null)
				return true;

			Height h = new Height();
			return checkBalance(root, h);
		}

		static boolean checkBalance(Node n, Height h) {
			if (n == null) {
				h.h = 0;
				return true;
			}

			Height lh = new Height();
			Height rh = new Height();
			boolean left = checkBalance(n.left, lh);
			boolean right = checkBalance(n.right, rh);

			int l = lh.h;
			int r = rh.h;

			h.h = Math.max(l, r) + 1;

			if (Math.abs(l - r) <= 1 && left && right)
				return true;

			return false;
		}

	}

	// without extra space
	public static class Solution2 {

		public boolean isBalanced(Node root) {
			return getH(root) != -1;
		}

		private int getH(Node root) {
			if (root == null) {
				return 0;
			}
			int leftH = getH(root.left);
			if (leftH == -1) {
				return -1;
			}
			int rightH = getH(root.right);
			if (rightH == -1) {
				return -1;
			}
			if (Math.abs(leftH - rightH) > 1) {
				return -1;
			}
			return Math.max(leftH, rightH) + 1;
		}
	}

}
