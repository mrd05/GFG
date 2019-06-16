package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int m = Integer.parseInt(str[1]);
				str = br.readLine().split("\\s+");
				char c1[] = str[0].toCharArray();
				char c2[] = str[1].toCharArray();

				int dp[][] = new int[n + 1][m + 1];

				for (int i = 0; i <= n; i++)
					dp[i][0] = i;
				for (int i = 0; i <= m; i++)
					dp[0][i] = i;

				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m; j++) {
						if (c1[i - 1] == c2[j - 1])
							dp[i][j] = dp[i - 1][j - 1];
						else
							dp[i][j] = 1 + Math.min(dp[i - 1][j],
									Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
					}
				}
				System.out.println(dp[n][m]);
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
