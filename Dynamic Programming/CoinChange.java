package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChange {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int m = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int arr[] = new int[m];
				int n = Integer.parseInt(br.readLine());
				for (int i = 0; i < m; i++)
					arr[i] = Integer.parseInt(str[i]);

				System.out.println(dp2d(arr, m, n));
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static int dp1d(int[] arr, int m, int n) {

		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = arr[i]; j <= n; j++)
				dp[j] = dp[j] + dp[j - arr[i]];
		}
		return dp[n];
	}

	static int dp2d(int[] arr, int m, int n) {

		int dp[][] = new int[m][n + 1];
		for (int i = 0; i < m; i++)
			dp[i][0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j <= n; j++) {
				int x = (j - arr[i]) >= 0 ? dp[i][j - arr[i]] : 0;
				int y = i > 0 ? dp[i - 1][j] : 0;
				dp[i][j] = x + y;
			}
		}
		return dp[m - 1][n];
	}
}
