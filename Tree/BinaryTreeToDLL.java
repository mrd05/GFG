package tree;

import java.util.HashMap;
import java.util.Scanner;

public class BinaryTreeToDLL {

	static class Node {
		Node left, right;
		int data;

		Node(int d) {
			data = d;
			left = right = null;
		}

	}

	static class BT_To_DLL {
		void inorder(Node node) {
			if (node == null)
				return;
			else
				inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}

		void printList(Node head) {
			Node prev = head;
			while (head != null) {
				System.out.print(head.data + " ");
				prev = head;
				head = head.right;
			}

			System.out.println();
			while (prev != null) {
				System.out.print(prev.data + " ");
				prev = prev.left;
			}
		}

		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			BT_To_DLL obj = new BT_To_DLL();
			// DLL d = new DLL();
			int t = sc.nextInt();
			while (t > 0) {
				HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
				int n = sc.nextInt();

				Node root = null;

				while (n > 0) {
					int n1 = sc.nextInt();
					int n2 = sc.nextInt();
					char lr = sc.next().charAt(0);

					Node parent = hm.get(n1);
					if (parent == null) {
						parent = new Node(n1);
						hm.put(n1, parent);
						if (root == null) {
							root = parent;
							// d.head = root;
						}

					}

					Node child = new Node(n2);
					if (lr == 'L')
						parent.left = child;
					else
						parent.right = child;

					hm.put(n2, child);
					n--;
				}

				GfG g = new GfG();
				Node node = g.bToDLL(root);
				obj.printList(node);
				t--;
				System.out.println();
			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	/*
	 * class Node class Node { Node left, right; int data;
	 * 
	 * Node(int d) { data = d; left = right = null; }
	 * 
	 * }
	 */
	// This function should convert a given Binary tree to Doubly
	// Linked List
	static class GfG {
		static Node head;

		static Node prev;

		Node bToDLL(Node root) {
			prev = null;
			convert(root);
			return head;
		}

		static void convert(Node node) {
			if (node == null)
				return;

			convert(node.left);

			if (prev != null) {
				prev.right = node;
				node.left = prev;
			} else
				head = node;
			prev = node;

			convert(node.right);
		}
	}

}
