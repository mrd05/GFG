package linkedList;

import java.util.Scanner;

public class NthNodeFromEndOfLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node head;

	/* Function to print linked list */
	void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Inserts a new Node at front of the list. */
	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			NthNodeFromEndOfLinkedList llist = new NthNodeFromEndOfLinkedList();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}

			// System.out.println(llist.head.data);
			GfG g = new GfG();
			// System.out.println(k);
			System.out.println(g.getNthFromLast(llist.head, k));

			t--;
		}
	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	/*
	 * Structure of node class Node { int data; Node next; Node(int d) {data =
	 * d; next = null; } }
	 */
	static class GfG {
		// Function to find the nth node from end in the linked list
		// head: head of the linked list
		// n: nth node from end to find
		int getNthFromLast(Node head, int n) {
			if (head == null)
				return -1;
			Node a = head, b = head;
			while (b != null && n > 0) {
				b = b.next;
				n--;
			}
			while (b != null) {
				b = b.next;
				a = a.next;
			}
			if (n == 0)
				return a.data;
			else
				return -1;
		}
	}

}
