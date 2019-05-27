package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackUsingQueues {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			GfG g = new GfG();

			int q = sc.nextInt();
			while (q > 0) {
				int QueryType = sc.nextInt();
				if (QueryType == 1) {
					int a = sc.nextInt();
					g.push(a);
				} else if (QueryType == 2)
					System.out.print(g.pop() + " ");
				q--;
			}
			System.out.println();

			t--;
		}
	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	static class GfG {
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();

		/* The method pop which return the element poped out of the stack */
		int pop() {
			if (q1.size() == 0)
				return -1;
			while (q1.size() > 1)
				q2.add(q1.remove());
			int res = q1.remove();
			Queue<Integer> q = q1;
			q1 = q2;
			q2 = q;
			return res;
		}

		/* The method push to push element into the stack */
		void push(int a) {
			q1.add(a);
		}
	}
}
