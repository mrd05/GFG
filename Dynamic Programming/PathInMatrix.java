package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PathInMatrix {

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

				int dp[][] = new int[n][n];
				for (int i = 0; i < n; i++)
					Arrays.fill(dp[i], -1);

				int max = Integer.MIN_VALUE;

				/*for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						count(arr, i, j, dp);
						max = Math.max(max, dp[i][j]);
					}
				}*/

				for (int i = 0; i < n; i++) {
					dp[n - 1][i] = arr[n - 1][i];
					max = Math.max(max, dp[n - 1][i]);
				}

				for (int i = n - 2; i >= 0; i--) {
					for (int j = 0; j < n; j++) {
						int m = Integer.MIN_VALUE;
						if (j - 1 >= 0)
							m = Math.max(m, dp[i + 1][j - 1]);

						m = Math.max(m, dp[i + 1][j]);

						if (j + 1 < n)
							m = Math.max(m, dp[i + 1][j + 1]);

						dp[i][j] = arr[i][j] + m;
						max = Math.max(max, dp[i][j]);
					}
				}

				System.out.println(max);

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static int count(int arr[][], int i, int j, int dp[][]) {
		if (i < 0 || i >= arr.length || j < 0 || j >= arr.length)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		int max = arr[i][j];
		max = Math.max(max, arr[i][j] + count(arr, i + 1, j, dp));
		max = Math.max(max, arr[i][j] + count(arr, i + 1, j - 1, dp));
		max = Math.max(max, arr[i][j] + count(arr, i + 1, j + 1, dp));
		dp[i][j] = max;
		return dp[i][j];
	}
}
