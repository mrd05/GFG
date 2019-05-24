package linkedList;

//Initial Template for Java
import java.util.Scanner;

class Driverclass {
	static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			Node head = new Node(sc.nextInt());
			Node tail = head;
			while (n-- > 1) {
				tail.next = new Node(sc.nextInt());
				tail = tail.next;
			}

			head = new LinkedList().segregate(head);
			printList(head);
			System.out.println();
		}
	}

	public static void printList(Node head) {
		if (head == null)
			return;

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	// User function Template for Java
	/*
	 * class Node { int data; Node next; Node(int data) { this.data = data; next
	 * = null; } }
	 */
	static class LinkedList {
		static Node segregate(Node head) {
			if (head == null)
				return head;
			Node z = new Node(0), o = new Node(0), t = new Node(0), cur = head;
			Node zh = z, oh = o, th = t;
			while (cur != null) {
				if (cur.data == 0) {
					z.next = cur;
					z = z.next;
				} else if (cur.data == 1) {
					o.next = cur;
					o = o.next;
				} else {
					t.next = cur;
					t = t.next;

				}
				cur = cur.next;
			}
			z.next = (oh.next != null) ? oh.next : th.next;
			o.next = th.next;
			t.next = null;
			return zh.next;

		}
	}

}