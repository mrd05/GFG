package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CountELements {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			// int k = sc.nextInt();

			GfG g = new GfG();
			g.countDistinct(a, k, n);
			System.out.println();

			t--;
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	/* You are required to complete below method */
	static class GfG {
		void countDistinct(int A[], int k, int n) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < k; i++)
				map.put(A[i], map.getOrDefault(A[i], 0) + 1);
			System.out.print(map.keySet().size() + " ");
			for (int i = k; i < n; i++) {
				int a = map.get(A[i - k]);
				if (a == 1)
					map.remove(A[i - k]);
				else
					map.put(A[i - k], a - 1);
				map.put(A[i], map.getOrDefault(A[i], 0) + 1);
				System.out.print(map.keySet().size() + " ");
			}
		}
	}

}
