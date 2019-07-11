package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeftViewOfBinaryTree {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class Tree_Left_View {
		public static void main(String args[]) {
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
				g.leftView(root);
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
	 * A Binary Tree node class Node { int data; Node left, right; Node(int
	 * item) { data = item; left = right = null; } }
	 */
	static class Tree {
		static int max_level = 0;

		void leftView(Node root) {
			if (root == null)
				return;
			max_level = 0;
			// printLeft(root,1);

			// using queue;

			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			while (!q.isEmpty()) {
				if (q.peek() != null) {
					System.out.print(q.peek().data + " ");
					while (q.peek() != null) {
						Node n = q.poll();
						if (n.left != null)
							q.add(n.left);
						if (n.right != null)
							q.add(n.right);
					}
					q.add(null);
				}
				q.poll();
			}
		}

		static void printLeft(Node root, int h) {
			if (root == null)
				return;

			if (h > max_level) {
				max_level = h;
				System.out.print(root.data + " ");
			}

			printLeft(root.left, h + 1);
			printLeft(root.right, h + 1);
		}
	}

}
