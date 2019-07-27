package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinimumSwapsToSort {

	static class MinSwaps {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while (t-- > 0) {
				int n = sc.nextInt();
				int[] a = new int[n];
				for (int i = 0; i < n; i++) {
					a[i] = sc.nextInt();
				}
				GfG g = new GfG();
				System.out.println(g.minSwaps(a, n));
			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	/* Complete the function */
	static class GfG {
		public static int minSwaps(int[] A, int N) {
			boolean vis[] = new boolean[N];
			Arrays.fill(vis, false);
			int swaps = 0;

			List<P> list = new ArrayList<>();
			for (int i = 0; i < N; i++)
				list.add(new P(A[i], i));

			Collections.sort(list);

			for (int i = 0; i < N; i++) {
				if (vis[i] == false) {
					vis[i] = true;
					int connected = 1;
					int x = list.get(i).index;
					while (vis[x] == false) {
						vis[x] = true;
						x = list.get(x).index;
						connected++;
					}
					swaps += connected - 1;
				}
			}
			return swaps;
		}

		static class P implements Comparable<P> {
			int val;
			int index;

			P(int v, int i) {
				val = v;
				index = i;
			}

			@Override
			public int compareTo(P p) {
				return this.val - p.val;
			}
		}
	}

}
