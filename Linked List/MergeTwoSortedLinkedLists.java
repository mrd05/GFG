package linkedList;

import java.util.Scanner;

class MergeLists {
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node head;

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

	/* Function to print linked list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			MergeLists llist1 = new MergeLists();
			MergeLists llist2 = new MergeLists();

			int a1 = sc.nextInt();
			Node head1 = new Node(a1);
			llist1.addToTheLast(head1);
			if (sc.hasNextInt())
				for (int i = 1; i < n1; i++) {
					// int a;

					int a = sc.nextInt();
					llist1.addToTheLast(new Node(a));
				}

			int b1 = sc.nextInt();
			Node head2 = new Node(b1);
			llist2.addToTheLast(head2);
			if (sc.hasNextInt())
				for (int i = 1; i < n2; i++) {
					// int b;

					int b = sc.nextInt();
					llist2.addToTheLast(new Node(b));
				}
			llist1.head = new LinkedList()
					.sortedMerge(llist1.head, llist2.head);
			llist1.printList();

			t--;

		}
	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	/*
	 * Merge two linked lists head pointer input could be NULL as well for empty
	 * list Node is defined as class Node { int data; Node next; Node(int d)
	 * {data = d; next = null; } }
	 */
	static class LinkedList {
		Node mergeTwoListsRec(Node l1, Node l2) {

			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;
			if (l1.data < l2.data) {
				l1.next = mergeTwoListsRec(l1.next, l2);
				return l1;
			} else {
				l2.next = mergeTwoListsRec(l1, l2.next);
				return l2;
			}

		}

		Node sortedMerge(Node headA, Node headB) {

			if (headA == null)
				return headB;
			if (headB == null)
				return headA;
			Node root = null, prev = null;
			boolean flag = true;
			while (headA != null && headB != null) {
				if (headA.data > headB.data) {
					if (flag) {
						flag = false;
						root = headB;
					} else
						prev.next = headB;
					prev = headB;
					headB = headB.next;
				} else {
					if (flag) {
						flag = false;
						root = headA;
					} else
						prev.next = headA;
					prev = headA;
					headA = headA.next;
				}
			}
			if (headA != null)
				prev.next = headA;
			if (headB != null)
				prev.next = headB;
			return root;

		}
	}

}
