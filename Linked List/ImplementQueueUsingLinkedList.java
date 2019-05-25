package linkedList;

import java.util.Scanner;

class ImplementQueueUsingLinkedList {

	static class QueueNode {
		int data;
		QueueNode next;

		QueueNode(int a) {
			data = a;
			next = null;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while (Q > 0) {
				int QueryType = 0;
				QueryType = sc.nextInt();
				if (QueryType == 1) {
					int a = sc.nextInt();

					obj.push(a);

				} else if (QueryType == 2) {
					System.out.print(obj.pop() + " ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		}
	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	/*
	 * The structure of the node of the queue is class QueueNode { int data;
	 * QueueNode next; QueueNode(int a) { data = a; next = null; } }
	 */
	static class MyQueue {
		QueueNode front, rear;

		// This function should add an item at
		// rear
		void push(int a) {
			if (front == null) {
				front = new QueueNode(a);
				rear = front;
			} else {
				rear.next = new QueueNode(a);
				rear = rear.next;
			}
		}

		// This function should remove front
		// item from queue and should return
		// the removed item.
		int pop() {
			if (front == null)
				return -1;
			int d = front.data;
			front = front.next;
			if (front == null)
				rear = null;
			return d;
		}
	}
}
