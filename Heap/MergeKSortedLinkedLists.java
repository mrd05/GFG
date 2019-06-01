package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(int key) {
		data = key;
		next = null;
	}
}

class MergeLL {
	static Node head;

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
		if (node == null)
			return;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t-- > 0) {
			int N = sc.nextInt();
			Node[] a = new Node[N];
			for (int i = 0; i < N; i++) {
				int n = sc.nextInt();
				int p = sc.nextInt();
				Node start = null, cur = null;
				Node head = new Node(p);
				start = head;
				cur = head;
				for (int j = 1; j < n; j++) {
					int a1 = sc.nextInt();
					Node ptr = new Node(a1);
					cur.next = ptr;
					cur = ptr;
				}
				a[i] = start;
			}
			Node start = a[0];
			Merge g = new Merge();

			Node res = g.mergeKList(a, N);
			if (res != null)
				printList(res);
			System.out.println();

		}

	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	/*
	 * class Node { int data; Node next;
	 * 
	 * Node(int key) { data = key; next = null; } }
	 */
	/*
	 * a is an array of Nodes of the heads of linked lists and N is size of
	 * array a
	 */

	// merge 2 lists at a time
	static class Merge2 {
		Node merge(Node a, Node b) {
			if (a == null)
				return b;
			if (b == null)
				return a;
			if (a.data <= b.data) {
				a.next = merge(a.next, b);
				return a;
			} else {
				b.next = merge(a, b.next);
				return b;
			}
		}

		Node mergeKList(Node[] a, int N) {
			if (a.length == 0)
				return null;

			int last = a.length - 1;
			while (last != 0) {
				int i = 0, j = last;
				while (i < j) {
					a[i] = merge(a[i], a[j]);
					i++;
					j--;
					if (i >= j)
						last = j;
				}
			}

			return a[0];

		}
	}

	// Using heap i.e. priority queue
	static class Merge {
		static class NodeComp implements Comparator<Node> {
			public int compare(Node n1, Node n2) {
				return n1.data - n2.data;
			}
		}

		Node mergeKList(Node[] a, int N) {
			if (a.length == 0)
				return null;

			PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComp());
			for (Node n : a) {
				if (n != null)
					pq.add(n);
			}

			Node head = null, last = null, t = null;
			while (!pq.isEmpty()) {
				t = pq.poll();
				if (head == null) {
					head = t;
					last = t;
				} else {
					last.next = t;
					last = last.next;
				}
				if (t.next != null)
					pq.add(t.next);
			}
			if (last != null)
				last.next = null;
			return head;

		}
	}

}
