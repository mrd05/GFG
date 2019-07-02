package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumSumPartition {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				int arr[] = new int[n];
				String str[] = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);

				int sum = 0;
				for (int a : arr)
					sum += a;
				boolean dp[][] = new boolean[n + 1][sum + 1];

				for (int i = 0; i <= n; i++)
					dp[i][0] = true;

				for (int i = 1; i <= sum; i++)
					dp[0][i] = false;

				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= sum; j++) {
						dp[i][j] = dp[i - 1][j];
						if (j >= arr[i - 1])
							dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
					}
				}

				int diff = 0;
				for (int j = sum / 2; j >= 0; j--) {
					if (dp[n][j] == true) {
						diff = sum - j * 2;
						break;
					}
				}
				System.out.println(diff);
				t--;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
