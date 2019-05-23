package linkedList;

import java.util.Scanner;

class Swap {
	static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	static Node head;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				addToTheLast(new Node(a));
			}

			GfG gfg = new GfG();
			gfg.pairwiseSwap(head);
			printList(head);
			System.out.println();
		}
	}

	public static void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	/*
	 * node class of the linked list class Node { int data; Node next; Node(int
	 * key) { data = key; next = null; } }
	 */
	// complete the below function
	static class GfG {

		public static void pairwiseSwap(Node node) {
			if (node == null || node.next == null)
				return;
			Node cur = node;
			Node next = null;
			int d;
			while (cur != null && cur.next != null) {
				next = cur.next;
				d = cur.data;
				cur.data = next.data;
				next.data = d;
				cur = next.next;

			}
		}

		public static void pairwiseSwapLinks(Node node) {
			if (node == null || node.next == null)
				return;
			Node prev = node;
			Node cur = node.next.next;
			node = node.next;
			node.next = prev;

			while (cur != null && cur.next != null) {
				prev.next = cur.next;
				prev = cur;
				Node next = cur.next.next;
				cur.next.next = cur;
				cur = next;
			}
			prev.next = cur;
		}

	}
}
