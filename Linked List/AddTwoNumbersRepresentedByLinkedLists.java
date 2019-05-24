package linkedList;

import java.util.Scanner;

class Add_LinkedList {

	static class Node {
		int data;
		Node next;

		Node() {
		}

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node head;

	void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		// System.out.println("");
	}

	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);
		/* 3. Make next of new Node as head */
		new_node.next = head;
		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int n1 = sc.nextInt();
			Add_LinkedList list1 = new Add_LinkedList();
			for (int i = 1; i <= n1; i++) {
				int a = sc.nextInt();
				list1.push(a);
			}
			int n2 = sc.nextInt();
			Add_LinkedList list2 = new Add_LinkedList();
			for (int i = 0; i < n2; i++) {
				int b = sc.nextInt();
				list2.push(b);
			}
			Add_LinkedList list3 = new Add_LinkedList();
			Add g = new Add();
			Node rs = g.addTwoLists(list1.head, list2.head);
			list3.printList(rs);
			System.out.println();
			T--;
		}
	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	/*
	 * The Node is defined as class Node { int data; Node next; Node(int d)
	 * {data = d; next = null; } Node(){} }
	 */
	static class Add {

		// This function will add the numbers represented by two linked lists
		static Node addTwoLists(Node first, Node second) {
			Node res = null, t = null;
			if (first == null)
				return second;
			if (second == null)
				return first;

			int d = 0;
			while (first != null && second != null) {
				d = d + first.data + second.data;
				if (res == null) {
					res = new Node(d % 10);
					t = res;
				} else {
					t.next = new Node(d % 10);
					t = t.next;
				}
				d = (d >= 10) ? 1 : 0;
				first = first.next;
				second = second.next;
			}
			while (first != null) {
				t.next = new Node();
				t = t.next;
				if (d == 0)
					t.data = first.data;
				else {
					d = d + first.data;
					t.data = d % 10;
					d = (d >= 10) ? 1 : 0;
				}

				first = first.next;
			}
			while (second != null) {
				t.next = new Node();
				t = t.next;
				if (d == 0)
					t.data = second.data;
				else {
					d = d + second.data;
					t.data = d % 10;
					d = (d >= 10) ? 1 : 0;
				}

				second = second.next;
			}
			if (d == 1)
				t.next = new Node(d);
			return res;
		}
	}
}
