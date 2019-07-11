package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class PrintBinaryTreeInVerticalOrder {

	static class Node {
		int data, hd;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
			hd = Integer.MAX_VALUE;
		}
	}

	static class driver_class {
		public static void main(String[] args) throws IOException {
			// Scanner sc = new Scanner(System.in);
			// int t = sc.nextInt();
			BufferedReader read = new BufferedReader(new InputStreamReader(
					System.in));
			int t = Integer.parseInt(read.readLine());

			while (t-- > 0) {
				HashMap<Integer, Node> m = new HashMap<Integer, Node>();
				int n = Integer.parseInt(read.readLine());
				Node root = null;
				String str[] = read.readLine().replace("  ", " ").trim()
						.split(" ");
				int k = 0;
				while (n-- > 0) {
					int n1 = Integer.parseInt(str[k++]);
					int n2 = Integer.parseInt(str[k++]);
					char lr = str[k++].charAt(0);

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

				BinaryTree obj = new BinaryTree();
				obj.verticalOrder(root);
				System.out.println();
			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	// User function Template for Java
	/*
	 * class Node { int data; Node left, right;
	 * 
	 * Node(int key) { data = key; left = right = null; hd = Integer.MAX_VALUE;
	 * } }
	 */
	static class BinaryTree {
		static void verticalOrder(Node root) {
			if (root == null)
				return;

			Queue<Node> q = new LinkedList<>();
			Map<Integer, List<Integer>> map = new TreeMap<>();

			root.hd = 0;
			q.add(root);

			while (!q.isEmpty()) {
				Node n = q.poll();

				if (!map.containsKey(n.hd))
					map.put(n.hd, new ArrayList<Integer>());

				map.get(n.hd).add(n.data);

				if (n.left != null) {
					n.left.hd = n.hd - 1;
					q.add(n.left);
				}
				if (n.right != null) {
					n.right.hd = n.hd + 1;
					q.add(n.right);
				}
			}

			for (int i : map.keySet()) {
				for (int a : map.get(i))
					System.out.print(a + " ");
			}
		}
	}

}
