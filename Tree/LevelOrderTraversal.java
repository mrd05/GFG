package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class Drivercode {

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

				Level_order_traversal g = new Level_order_traversal();
				g.levelOrder(root);
				System.out.println();
				t--;

			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	/*
	 * class Node { int data; Node left, right; Node(int item) { data = item;
	 * left = right = null; } }
	 */
	static class Level_order_traversal {
		// You are required to complete this method
		static void levelOrder(Node node) {

			/*int h = height(node);
			for (int i = 1; i <= h; i++)
				printLevel(node, i);*/

			// using queue
			Queue<Node> q = new LinkedList<>();
			if (node == null)
				return;

			q.add(node);
			while (!q.isEmpty()) {
				Node n = q.poll();
				System.out.print(n.data + " ");
				if (n.left != null)
					q.add(n.left);
				if (n.right != null)
					q.add(n.right);
			}

		}

		static void printLevel(Node node, int h) {
			if (node == null)
				return;
			if (h == 1) {
				System.out.print(node.data + " ");
				return;
			}

			printLevel(node.left, h - 1);
			printLevel(node.right, h - 1);
		}

		static int height(Node node) {
			if (node == null)
				return 0;

			int leftH = height(node.left) + 1;
			int rightH = height(node.right) + 1;

			return Math.max(leftH, rightH);
		}
	}

}
