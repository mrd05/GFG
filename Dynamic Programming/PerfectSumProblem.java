package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectSumProblem {

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

				int sum = Integer.parseInt(br.readLine());

				// rucursion
				System.out.print(count(n, sum, arr) + " ");

				// dp
				System.out.print(countDP(n, sum, arr) + "\n");

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static int count(int n, int sum, int arr[]) {
		if (sum == 0)
			return 1;

		if (sum < 0 || n <= 0)
			return 0;

		if (arr[n - 1] > sum)
			return count(n - 1, sum, arr);

		return count(n - 1, sum, arr) + count(n - 1, sum - arr[n - 1], arr);

	}

	static int countDP(int n, int sum, int arr[]) {
		int dp[][] = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= sum; i++)
			dp[0][i] = 0;

		for (int i = 1; i <= n; i++) {
			for (int s = 1; s <= sum; s++) {
				if (arr[i - 1] > s)
					dp[i][s] = dp[i - 1][s];
				else
					dp[i][s] = dp[i - 1][s] + dp[i - 1][s - arr[i - 1]];
			}
		}

		/*int count = 0;
		for (int i = 1; i <= n; i++) {
			if (dp[i][sum] == true)
				count++;
		}*/
		return dp[n][sum];
	}
}
