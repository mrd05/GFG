package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack01Problem {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				int W = Integer.parseInt(br.readLine());
				int wt[] = new int[n];
				int v[] = new int[n];
				String str[] = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++)
					v[i] = Integer.parseInt(str[i]);
				str = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++)
					wt[i] = Integer.parseInt(str[i]);

				int arr[][] = new int[n + 1][W + 1];

				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= W; j++) {
						if (j >= wt[i - 1])
							arr[i][j] = Math.max(v[i - 1]
									+ arr[i - 1][j - wt[i - 1]], arr[i - 1][j]);
						else
							arr[i][j] = arr[i - 1][j];
					}
				}
				System.out.println(arr[n][W]);
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
