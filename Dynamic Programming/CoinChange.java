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

				int dp[] = new int[n + 1];
				dp[0] = 1;
				for (int i = 0; i < m; i++) {
					for (int j = arr[i]; j <= n; j++)
						dp[j] = dp[j] + dp[j - arr[i]];
				}
				System.out.println(dp[n]);
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
