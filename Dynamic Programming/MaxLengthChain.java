package dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Pair {
	int x;
	int y;

	public Pair(int a, int b) {
		x = a;
		y = b;
	}
}

class Chainlength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			Pair pr[] = new Pair[n];
			int arr[] = new int[2 * n];
			for (int i = 0; i < 2 * n; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0, j = 0; i < 2 * n - 1 && j < n; i = i + 2, j++) {
				pr[j] = new Pair(arr[i], arr[i + 1]);
			}
			GfG g = new GfG();
			System.out.println(g.maxChainLength(pr, n));
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */

	static class CompareByFirst implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return a.x - b.x;
		}
	}

	static class GfG {
		int maxChainLength(Pair arr[], int n) {
			if (arr.length == 0)
				return 0;
			if (arr.length == 1)
				return 1;

			Arrays.sort(arr, new CompareByFirst());

			int dp[] = new int[n];
			Arrays.fill(dp, 1);
			int max = 0;
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[i].x > arr[j].y)
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				max = Math.max(max, dp[i]);
			}

			return max;
		}
	}
}