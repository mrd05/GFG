package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfWaysToGetSumWithNnumberOfMFacedDices {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int m = Integer.parseInt(str[1]);
				int sum = Integer.parseInt(str[2]);
				int dp[][] = new int[n + 1][sum + 1];

				for (int i = 0; i <= n; i++)
					Arrays.fill(dp[i], -1);

				System.out.println(count(m, sum, n, dp));
				System.out.println(dp[n][sum]);
				t--;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static int count(int faces, int sum, int noThrows, int[][] dp) {
		if (sum == 0 && noThrows == 0)
			return 1;

		if (sum < 0 || noThrows == 0)
			return 0;

		if (dp[noThrows][sum] != -1)
			return dp[noThrows][sum];

		int n = 0;
		for (int i = 1; i <= faces; i++)
			n += count(faces, sum - i, noThrows - 1, dp);

		dp[noThrows][sum] = n;

		return dp[noThrows][sum];
	}

}
