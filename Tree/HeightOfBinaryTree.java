package tree;

import java.util.HashMap;
import java.util.Scanner;

public class HeightOfBinaryTree {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class Tree_Height {
		// driver function to test the above functions
		public static void main(String args[]) {

			// Input the number of test cases you want to run
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			// Node root=null;
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

				System.out.println(g.height(root));
				t--;

			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	/*
	 * A Binary Tree node class Node { int data; Node left, right; Node(int
	 * item) { data = item; left = right = null; } }
	 */
	static class Tree {
		int height(Node node) {
			if (node == null)
				return 0;

			int leftHt = 1 + height(node.left);
			int rightHt = 1 + height(node.right);

			return Math.max(leftHt, rightHt);
		}
	}

}
