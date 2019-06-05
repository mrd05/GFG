package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MaxLenZeroSumSub {

	// Returns length of the maximum length subarray with 0 sum

	// Drive method
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();

			GfG g = new GfG();
			System.out.println(g.maxLen(arr, n));
			T--;
		}

	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	static class GfG {
		int maxLen(int arr[], int n) {

			Map<Integer, Integer> map = new HashMap<>();
			int max = 0, count = 0;
			map.put(0, -1);
			for (int i = 0; i < n; i++) {
				count += arr[i];
				if (arr[i] == 0 && max == 0)
					max = 1;
				if (map.containsKey(count)) {
					max = Math.max(max, i - map.get(count));
				} else
					map.put(count, i);
			}
			return max;

		}
	}
}