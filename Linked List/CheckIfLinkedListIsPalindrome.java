package linkedList;

import java.util.Scanner;

class Is_LinkedList_Palindrom {

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

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			// int k = sc.nextInt();
			Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}

			Palindrome g = new Palindrome();
			if (g.isPalindrome(llist.head) == true)
				System.out.println(1);
			else
				System.out.println(0);
			t--;
		}

	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	/*
	 * Structure of class Node is class Node { int data; Node next;
	 * 
	 * Node(int d) { data = d; next = null; } }
	 */
	static class Palindrome {
		// Function to check if linked list is palindrome
		static boolean isPalindrome(Node head) {
			if (head == null || head.next == null)
				return true;
			Node slow = head, fast = head, prev = null;
			while (fast != null && fast.next != null) {
				prev = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			Node cur = null, next = null;
			prev.next = null;
			if (fast == null)
				cur = slow;
			else
				cur = slow.next;
			prev = null;
			while (cur != null) {
				next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}
			while (head != null && prev != null && head.data == prev.data) {
				head = head.next;
				prev = prev.next;
			}
			if (head == null && prev == null)
				return true;
			else
				return false;
		}
	}
}