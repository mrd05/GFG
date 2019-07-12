package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DiameterOfBinaryTree {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class Binary_Tree_Diameter {
		// driver function to test the above functions
		public static void main(String args[]) throws IOException {
			// Input the number of test cases you want to run
			// Scanner sc = new Scanner(System.in);
			// int t = sc.nextInt();
			BufferedReader read = new BufferedReader(new InputStreamReader(
					System.in));
			int t = Integer.parseInt(read.readLine());
			while (t > 0) {
				HashMap<Integer, Node> m = new HashMap<Integer, Node>();
				int n = Integer.parseInt(read.readLine());
				Node root = null;
				int k = 0;
				String str[] = read.readLine().trim().replace("  ", " ")
						.split(" ");
				for (k = 0; k < n * 3;) {
					int n1 = Integer.parseInt(str[k++]);
					int n2 = Integer.parseInt(str[k++]);
					char lr = str[k++].charAt(0);
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

				}
				Tree g = new Tree();
				System.out.println(g.diameter(root));
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
		static int max = 0;

		/* Complete the function to get diameter of a binary tree */
		int diameter(Node node) {
			if (node == null)
				return 0;

			max = 0;
			calc(node);
			return max;
		}

		static int calc(Node node) {

			if (node == null)
				return 0;

			int l = calc(node.left);
			int r = calc(node.right);

			if (node.left != null && node.right != null) {
				max = Math.max(max, l + r + 1);
				return Math.max(l, r) + 1;
			}

			return node.left == null ? r + 1 : l + 1;
		}
	}

}
