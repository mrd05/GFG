package linkedList;

import java.util.Scanner;

class ImplementStackUsingLinkedList {

	static class StackNode {
		int data;
		StackNode next;

		StackNode(int a) {
			data = a;
			next = null;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			MyStack obj = new MyStack();
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
	 * The structure of the node of the stack is class StackNode { int data;
	 * StackNode next; StackNode(int a) { data = a; next = null; } }
	 */
	static class MyStack {
		// Note that top is by default null
		// in Java
		StackNode top;

		void push(int a) {
			StackNode s = new StackNode(a);
			s.next = top;
			top = s;
		}

		int pop() {
			if (top == null)
				return -1;
			int d = top.data;
			top = top.next;
			return d;
		}
	}
}