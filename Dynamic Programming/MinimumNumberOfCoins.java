package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumNumberOfCoins {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

				// System.out.println(dp1d(coins, n));

				int arr[][] = new int[coins.length][n + 1];
				int path[][] = new int[coins.length][n + 1];
				// -1 left & 1 top

				for (int j = 0; j < coins.length; j++) {
					for (int i = 0; i <= n; i++)
						arr[j][i] = n + 1;
				}
				for (int i = 0; i < coins.length; i++)
					arr[i][0] = 0;
				for (int j = 0; j < coins.length; j++) {
					for (int i = 1; i <= n; i++) {
						if (j == 0) {
							if (i % coins[j] == 0) {
								arr[j][i] = i / coins[j];
								path[j][i] = -1;
							}
						} else {
							if (i < coins[j]) {
								arr[j][i] = arr[j - 1][i];
								path[j][i] = 1;
							} else {
								if (arr[j - 1][i] < 1 + arr[j][i - coins[j]]) {
									arr[j][i] = arr[j - 1][i];
									path[j][i] = 1;
								} else {
									arr[j][i] = 1 + arr[j][i - coins[j]];
									path[j][i] = -1;
								}
							}

						}
					}
				}
				/*for (int i = 0; i < coins.length; i++) {
					for (int j = 0; j <= n; j++)
						System.out.print(arr[i][j] + "-->" + path[i][j] + " ");
					System.out.println();
				}*/
				int i = coins.length - 1, j = n;
				while (i >= 0 && j >= 0) {
					if (path[i][j] == 0)
						break;
					else if (path[i][j] == 1)
						i--;
					else {
						System.out.print(coins[i] + " ");
						j = j - coins[i];
					}
				}
				System.out.println();
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// only gives min no. of coins
	static int dp1d(int coins[], int amount) {

		if (amount == 0)
			return 0;
		if (coins.length == 0)
			return -1;

		int arr[] = new int[amount + 1];

		Arrays.fill(arr, amount + 1);
		arr[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j])
					arr[i] = Math.min(arr[i], 1 + arr[i - coins[j]]);
			}
		}
		return arr[amount] > amount ? -1 : arr[amount];
	}

	static int dp2d(int coins[], int n) {
		int arr[][] = new int[coins.length][n + 1];

		for (int j = 0; j < coins.length; j++) {
			for (int i = 0; i <= n; i++)
				arr[j][i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < coins.length; i++)
			arr[i][0] = 0;
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i <= n; i++) {
				if (j == 0) {
					if (i % coins[j] == 0)
						arr[j][i] = i / coins[j];
				} else {
					if (i < coins[j])
						arr[j][i] = arr[j - 1][i];
					else
						arr[j][i] = Math.min(arr[j - 1][i], 1 + arr[j][i
								- coins[j]]);
				}
			}
		}
		return arr[coins.length - 1][n];
	}
}
