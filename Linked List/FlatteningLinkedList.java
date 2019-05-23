package linkedList;

import java.util.Scanner;

class Flatttening_A_LinkedList {
	static class Node {
		int data;
		Node next;
		Node bottom;

		Node(int d) {
			data = d;
			next = null;
			bottom = null;
		}
	}

	Node head;

	void printList(Node node) {
		// Node temp = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.bottom;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while (t > 0) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;
			int flag = 1;
			int flag1 = 1;
			for (int i = 0; i < N; i++) {
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if (flag == 1) {
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				} else {
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}

				for (int j = 0; j < m; j++) {
					int a = sc.nextInt();
					tempB = new Node(a);
					if (flag1 == 1) {
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					} else {
						preB.bottom = tempB;
						preB = tempB;
					}
				}

			}
			// list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);

			t--;
		}
	}

	/*
	 * Node class used in the program class Node { int data; Node next; Node
	 * bottom;
	 * 
	 * Node(int d) { data = d; next = null; bottom = null; } }
	 */
	/*
	 * Function which returns the root of the flattened linked list.
	 */
	static class GfG {

		Node flattenRec(Node root) {
			if (root == null || root.next == null)
				return root;

			root.next = flatten(root.next);

			root = merge(root, root.next);

			return root;
		}

		private Node merge(Node a, Node b) {

			if (a == null)
				return b;
			if (b == null)
				return a;
			Node result;
			if (a.data < b.data) {
				result = a;
				a.bottom = merge(a.bottom, b);
			} else {
				result = b;
				b.bottom = merge(a, b.bottom);
			}

			return result;
		}

		Node flatten(Node root) {
			if (root == null || root.next == null)
				return root;
			Node right = root.next, down1, down2, prev = null;
			while (right != null) {
				down1 = root;
				down2 = right;
				boolean flag = true;
				while (down1 != null && down2 != null) {
					if (down1.data < down2.data) {
						if (flag) {
							flag = false;
							root = down1;
						} else
							prev.bottom = down1;
						prev = down1;
						down1 = down1.bottom;
					} else {
						if (flag) {
							flag = false;
							root = down2;
						} else
							prev.bottom = down2;
						prev = down2;
						down2 = down2.bottom;
					}
				}
				if (down1 != null)
					prev.bottom = down1;
				if (down2 != null)
					prev.bottom = down2;
				right = right.next;
			}

			return root;
		}
	}
}

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

