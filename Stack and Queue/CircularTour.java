package stackAndQueue;

import java.util.Scanner;

class First_Circular_tour {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j = 0;
			int k = 0;
			for (int i = 0; i < 2 * n; i++) {
				if (i % 2 == 0) {
					p[j] = Integer.parseInt(arr[i]);
					j++;
				} else {
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}

			System.out.println(new GfG().tour(p, d));
			t--;
		}
	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	// In java function tour() takes two arguments array of petrol
	// and array of distance
	static class GfG {
		int tour(int gas[], int cost[]) {
			if (gas.length == 1)
				return gas[0] >= cost[0] ? 0 : -1;

			int front = 0, rear = 1, pet = gas[0] - cost[0];
			boolean flag = false;
			while (front != rear) {
				while (pet < 0 && front != rear) {
					pet -= (gas[front] - cost[front]);
					front = (front + 1) % gas.length;
					if (front == 0) {
						flag = true;
						break;
					}
				}
				if (flag)
					break;
				pet += gas[rear] - cost[rear];
				rear = (rear + 1) % gas.length;

			}
			if (flag || pet < 0)
				return -1;
			else
				return front;

		}
	}
}