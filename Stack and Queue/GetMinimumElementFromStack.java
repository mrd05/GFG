package stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

class Get_Min_From_Stack {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int q = sc.nextInt();
			GfG g = new GfG();
			while (q > 0) {
				int qt = sc.nextInt();

				if (qt == 1) {
					int att = sc.nextInt();
					g.push(att);
					// System.out.println(att);
				} else if (qt == 2) {
					System.out.print(g.pop() + " ");
				} else if (qt == 3) {
					System.out.print(g.getMin() + " ");
				}

				q--;
			}
			System.out.println();
			T--;
		}

	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	static class GfG {
		int minEle;
		Stack<Integer> s = new Stack<>();

		/* returns min element from stack */
		int getMin() {
			if (s.isEmpty())
				return -1;
			return minEle;
		}

		/* returns poped element from stack */
		int pop() {
			if (s.isEmpty())
				return -1;
			int t = s.pop();
			if (t >= minEle)
				return t;
			else {
				int res = minEle;
				minEle = 2 * minEle - t;
				return res;
			}

		}

		/* push element x into the stack */
		void push(int x) {
			if (s.isEmpty()) {
				minEle = x;
				s.push(x);
				return;
			}
			if (x >= minEle)
				s.push(x);
			else {
				s.push(2 * x - minEle);
				minEle = x;
			}

		}
	}
}
