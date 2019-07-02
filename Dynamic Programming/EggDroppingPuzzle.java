package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EggDroppingPuzzle {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int k = Integer.parseInt(str[1]);

				int dp[][] = new int[n + 1][k + 1];
				for (int i = 1; i <= n; i++) {
					dp[i][1] = 1;
					dp[i][0] = 0;
				}

				for (int i = 1; i <= k; i++)
					dp[1][i] = i;

				for (int i = 2; i <= n; i++) {
					for (int j = 2; j <= k; j++) {
						dp[i][j] = Integer.MAX_VALUE;
						for (int x = 1; x <= j; x++) {
							int res = 1 + Math.max(dp[i - 1][x - 1], dp[i][j
									- x]);
							dp[i][j] = Math.min(dp[i][j], res);
						}
					}
				}
				System.out.println(dp[n][k]);
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
