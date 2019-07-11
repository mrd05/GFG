package tree;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class LevelOrderTraversalInSpiralForm {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class Level_Order_Traversal {

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

				Spiral g = new Spiral();
				g.printSpiral(root);
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
	 * // A Binary Tree node class Node { int data; Node left, right; Node(int
	 * item) { data = item; left = right = null; } }
	 */
	static class Spiral {
		void printSpiral(Node node) {

			// we can use one queue and one stack
			// queue for normal BFS and use stack at even levels for printing

			// here we are using 2 stacks
			if (node == null)
				return;

			Stack<Node> s1 = new Stack<>();
			Stack<Node> s2 = new Stack<>();

			s1.add(node);

			while (!s1.isEmpty() || !s2.isEmpty()) {
				while (!s1.isEmpty()) {
					Node n = s1.pop();
					System.out.print(n.data + " ");

					if (n.right != null)
						s2.add(n.right);
					if (n.left != null)
						s2.add(n.left);
				}

				while (!s2.isEmpty()) {
					Node n = s2.pop();
					System.out.print(n.data + " ");

					if (n.left != null)
						s1.add(n.left);
					if (n.right != null)
						s1.add(n.right);
				}
			}
		}
	}

}
