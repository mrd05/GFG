package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiceThrow {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int m = Integer.parseInt(str[0]);
				int n = Integer.parseInt(str[1]);
				int s = Integer.parseInt(str[2]);

				long dp[][] = new long[n + 1][s + 1];

				for (int i = 0; i <= n; i++)
					Arrays.fill(dp[i], -1);
				System.out.println(count(m, n, s, dp));

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private static long count(int m, int n, int s, long[][] dp) {

		if (s == 0 && n == 0)
			return 1;
		if (s < 0 || n <= 0)
			return 0;

		if (dp[n][s] != -1)
			return dp[n][s];

		long ans = 0;
		for (int i = 1; i <= m; i++)
			ans += count(m, n - 1, s - i, dp);

		dp[n][s] = ans;

		return ans;
	}
}
