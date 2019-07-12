package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectNodesAtSameLevel {

	static class Node {
		int data;
		Node left, right, nextRight;

		Node(int item) {
			data = item;
			left = right = nextRight = null;

		}
	}

	static class BT_Connect_Adjacent_Node {
		void inorder(Node node) {
			if (node == null)
				return;
			else
				inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);

		}

		void printSpecial(Node root) {
			if (root == null)
				return;
			Node node = root;
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.nextRight;
			}
			if (root.left != null)
				printSpecial(root.left);
			else
				printSpecial(root.right);

		}

		// driver function to test the above functions
		public static void main(String args[]) {

			// Input the number of test cases you want to run
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			BT_Connect_Adjacent_Node can = new BT_Connect_Adjacent_Node();
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

				GfG g = new GfG();

				g.connect(root);
				can.printSpecial(root);
				System.out.println();
				can.inorder(root);
				System.out.println();
				t--;

			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	// A Binary Tree node
	/*
	 * class Node { int data; Node left, right, nextRight; Node(int item) { data
	 * = item; left = right = nextRight = null;
	 * 
	 * } }
	 */
	static class GfG {
		// Function to connect nodes at same level

		// using recursion
		void connect(Node root) {
			Node head = null;
			Node prev = null;
			Node cur = root;
			while (cur != null) {
				while (cur != null) {
					if (cur.left != null) {
						if (prev != null)
							prev.nextRight = cur.left;
						else
							head = cur.left;
						prev = cur.left;
					}

					if (cur.right != null) {
						if (prev != null)
							prev.nextRight = cur.right;
						else
							head = cur.right;
						prev = cur.right;
					}
					cur = cur.nextRight;
				}
				cur = head;
				head = null;
				prev = null;
			}
		}

		// using queue
		void connect1(Node root) {
			if (root == null)
				return;

			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			while (!q.isEmpty()) {
				if (q.peek() != null) {
					while (q.peek() != null) {
						Node n = q.poll();
						n.nextRight = q.peek();

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
	}

}
