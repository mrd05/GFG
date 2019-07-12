package tree;

import java.util.Scanner;

public class MaximumPathSum {

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	static class PathSum {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();

			while (t-- > 0) {
				int n = sc.nextInt();
				if (n == 0) {
					System.out.println(0);
					continue;
				}
				Node root = null;
				for (int i = 0; i < n; i++) {
					int a = sc.nextInt();
					int a1 = sc.nextInt();
					char lr = sc.next().charAt(0);
					if (i == 0) {
						root = new Node(a);

						switch (lr) {
						case 'L':
							root.left = new Node(a1);

							break;
						case 'R':
							root.right = new Node(a1);

							break;
						}
					} else {
						insert(root, a, a1, lr);
					}
				}
				GfG gfg = new GfG();
				System.out.println(gfg.maxPathSum(root));
			}
		}

		public static void insert(Node root, int a, int a1, char lr) {
			if (root == null) {
				return;
			}
			if (root.data == a) {
				switch (lr) {
				case 'L':
					root.left = new Node(a1);
					break;
				case 'R':
					root.right = new Node(a1);
					break;
				}
				return;
			}
			insert(root.left, a, a1, lr);
			insert(root.right, a, a1, lr);
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	static class GfG {
		static int max = Integer.MIN_VALUE;

		public static int maxPathSum(Node root) {
			if (root == null)
				return 0;

			max = Integer.MIN_VALUE;
			findMaxPathSum(root);
			return max;
		}

		static int findMaxPathSum(Node node) {
			if (node == null)
				return 0;

			if (node.left == null && node.right == null)
				return node.data;

			int l = findMaxPathSum(node.left);
			int r = findMaxPathSum(node.right);

			if (node.left != null && node.right != null) {
				max = Math.max(max, l + r + node.data);
				return Math.max(l, r) + node.data;
			}

			return (node.left == null) ? r + node.data : l + node.data;

		}
	}

}
