package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountNumberOfHops {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				int n = Integer.parseInt(br.readLine());

				if (n == 0 || n == 1) {
					System.out.println(1);
					continue;
				}
				if (n == 2) {
					System.out.println(2);
					continue;
				}
				int dp[] = new int[n + 1];
				dp[0] = 1;
				dp[1] = 1;
				dp[2] = 2;
				for (int i = 3; i <= n; i++) {
					dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
				}
				System.out.println(dp[n]);
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static int count(int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;

		return count(n - 1) + count(n - 2) + count(n - 3);
	}
}
