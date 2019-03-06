package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChocolateDistributionProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				int arr[] = new int[n];
				String str[] = br.readLine().split(" ");
				int m = Integer.parseInt(br.readLine());
				for (int j = 0; j < n; j++)
					arr[j] = Integer.parseInt(str[j]);
				Arrays.sort(arr);

				//qwertyuiop[asdfghjkl
				int min = Integer.MAX_VALUE;
				for (int j = 0; j <= n - m; j++) {
					if ((arr[j + m - 1] - arr[j]) < min) {
						min = arr[j + m - 1] - arr[j];
					}
				}
				//qwertyuifghjk
				System.out.println(min);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
