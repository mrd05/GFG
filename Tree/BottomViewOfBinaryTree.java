package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

	static class Node {
		int data; // data of the node
		int hd; // horizontal distance of the node
		Node left, right; // left and right references

		// Constructor of tree node
		public Node(int key) {
			data = key;
			hd = Integer.MAX_VALUE;
			left = right = null;
		}
	}

	static class BottomView {
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

				// g.leftView(root);
				g.bottomView(root);

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
	 * Tree node class class Node { int data; //data of the node int hd;
	 * //horizontal distance of the node Node left, right; //left and right
	 * references public Node(int key) { data = key; hd = Integer.MAX_VALUE;
	 * left = right = null; } }
	 */
	static class Tree {

		// Should print bottom view of tree with given root
		public void bottomView(Node root) {
			if (root == null)
				return;

			Queue<Node> q = new LinkedList<>();
			Map<Integer, Integer> map = new TreeMap<>();

			root.hd = 0;
			q.add(root);

			while (!q.isEmpty()) {
				Node n = q.poll();

				map.put(n.hd, n.data);

				if (n.left != null) {
					n.left.hd = n.hd - 1;
					q.add(n.left);
				}
				if (n.right != null) {
					n.right.hd = n.hd + 1;
					q.add(n.right);
				}
			}
			for (int i : map.keySet())
				System.out.print(map.get(i) + " ");
			System.out.println();

		}
	}

}
