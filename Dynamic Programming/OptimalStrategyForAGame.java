package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptimalStrategyForAGame {

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

				int dp[][] = new int[n][n];

				for (int k = 0; k < n; k++) {
					for (int i = 0, j = k; j < n; i++, j++) {
						int x = i + 2 <= j ? dp[i + 2][j] : 0;
						int y = i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0;
						int z = i <= j - 2 ? dp[i][j - 2] : 0;
						dp[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j]
								+ Math.min(y, z));
					}
				}
				System.out.println(dp[0][n - 1]);
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
