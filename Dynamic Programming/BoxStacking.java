package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BoxStacking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		// sc.next();
		while (t-- > 0) {
			int n = sc.nextInt();

			int A[] = new int[1000];
			int B[] = new int[1000];
			int C[] = new int[1000];

			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();

				A[i] = a;
				B[i] = b;
				C[i] = c;
			}

			Geeks ob = new Geeks();
			System.out.println(ob.maxHeight(A, B, C, n));
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	// User function Template for Java
	static class Geeks {
		public static int maxHeight(int height[], int width[], int length[],
				int n) {

			Box arr[] = new Box[3 * height.length];
			for (int i = 0; i < height.length; i++) {
				arr[3 * i] = new Box(height[i], Math.min(width[i], length[i]),
						Math.max(width[i], length[i]));
				arr[3 * i + 1] = new Box(width[i], Math.min(height[i],
						length[i]), Math.max(height[i], length[i]));
				arr[3 * i + 2] = new Box(length[i], Math.min(height[i],
						width[i]), Math.max(height[i], width[i]));
			}
			Arrays.sort(arr);

			int dp[] = new int[3 * height.length];
			dp[0] = arr[0].h;
			int max = dp[0];
			for (int i = 1; i < 3 * height.length; i++) {
				dp[i] = arr[i].h;
				for (int j = 0; j < i; j++) {
					if (arr[j].w > arr[i].w && arr[j].d > arr[i].d)
						dp[i] = Math.max(dp[i], dp[j] + arr[i].h);
				}
				max = Math.max(max, dp[i]);
			}
			return max;
		}

		static class Box implements Comparable<Box> {
			int h, w, d, area;

			Box(int h, int w, int d) {
				this.h = h;
				this.w = w;
				this.d = d;
				this.area = w * d;
			}

			public int compareTo(Box obj) {
				return obj.area - this.area;
			}
		}
	}

}
