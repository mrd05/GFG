package linkedList;

import java.util.Scanner;

class Delete_Node {
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node head;

	void printList(Node head) {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.println();
	}

	void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	Node search_Node(Node head, int k) {
		Node current = head;
		while (current != null) {
			if (current.data == k)
				break;
			current = current.next;
		}
		return current;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			Delete_Node llist = new Delete_Node();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}

			int k = sc.nextInt();
			Node del = llist.search_Node(llist.head, k);

			GfG g = new GfG();
			if (del != null && del.next != null) {
				g.deleteNode(del);
			}
			llist.printList(llist.head);
			t--;
		}
	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	/*
	 * class Node { int data ; Node next; Node(int d) { data = d; next = null; }
	 * }
	 */
	// This function should delete node from linked list. The function
	// may assume that node exists in linked list and is not last node
	// node: reference to the node which is to be deleted
	static class GfG {
		static void deleteNode(Node node) {
			node.data = node.next.data;
			node.next = node.next.next;
		}
	}

}