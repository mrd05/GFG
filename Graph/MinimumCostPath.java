package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumCostPath {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());

				int arr[][] = new int[n][n];
				String str[] = br.readLine().split("\\s+");

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++)
						arr[i][j] = Integer.parseInt(str[i * n + j]);
				}

				// recursion
				// System.out.println(recur(n - 1, n - 1, arr, n));

				int dp[][] = new int[n][n];

				dp[0][0] = arr[0][0];

				for (int i = 1; i < n; i++)
					dp[i][0] = arr[i][0] + dp[i - 1][0];

				for (int i = 1; i < n; i++)
					dp[0][i] = arr[0][i] + dp[0][i - 1];

				for (int i = 1; i < n; i++) {
					for (int j = 1; j < n; j++)
						dp[i][j] = arr[i][j]
								+ Math.min(dp[i - 1][j], dp[i][j - 1]);
				}

				System.out.println(dp[n - 1][n - 1]);

				t--;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static int recur(int i, int j, int arr[][], int n) {
		if (i < 0 || j < 0 || i >= n || j >= n)
			return Integer.MAX_VALUE;

		if (i == 0 && j == 0)
			return arr[i][j];

		return arr[i][j]
				+ Math.min(recur(i - 1, j, arr, n), recur(i, j - 1, arr, n));
	}
}
