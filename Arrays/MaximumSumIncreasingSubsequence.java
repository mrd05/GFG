package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSumIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				int arr[] = new int[n];
				String str[] = br.readLine().split(" ");
				int sum[] = new int[n];
				int len[] = new int[n];
				for (int j = 0; j < n; j++) {

					arr[j] = Integer.parseInt(str[j]);
					len[j] = 1;
					sum[j] = arr[j];
				}
				int maxSum = arr[0];
				for (int x = 1; x < n; x++) {
					for (int y = 0; y < x; y++) {
						if (arr[y] < arr[x]) {
							len[x] = Math.max(len[x], len[y] + 1);
							sum[x] = Math.max(sum[x], sum[y] + arr[x]);
						}
					}
					maxSum = Math.max(maxSum, sum[x]);
				}
				System.out.println(maxSum);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
