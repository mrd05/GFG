package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSumProblem {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				int arr[] = new int[n];
				String str[] = br.readLine().split("\\s+");
				int sum = 0;
				for (int i = 0; i < n; i++) {
					arr[i] = Integer.parseInt(str[i]);
					sum += arr[i];
				}
				if (sum % 2 == 0) {
					sum = sum / 2;
					boolean dp[][] = new boolean[n + 1][sum + 1];
					for (int i = 0; i <= n; i++)
						dp[i][0] = true;
					for (int i = 1; i <= sum; i++)
						dp[0][i] = false;
					for (int i = 1; i <= n; i++) {
						for (int j = 1; j <= sum; j++) {
							dp[i][j] = dp[i - 1][j];
							if (j >= arr[i - 1])
								dp[i][j] = dp[i][j]
										|| dp[i - 1][j - arr[i - 1]];
						}
					}
					if (dp[n][sum] == true)
						System.out.println("YES");
					else
						System.out.println("NO");
				} else
					System.out.println("NO");
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
