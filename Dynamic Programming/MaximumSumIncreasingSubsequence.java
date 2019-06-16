package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int arr[] = new int[n];

				int sum[] = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = Integer.parseInt(str[i]);
					sum[i] = arr[i];
				}

				int max = arr[0];
				for (int i = 1; i < n; i++) {
					for (int j = 0; j < i; j++) {
						if (arr[i] > arr[j]) {

							sum[i] = Math.max(sum[i], arr[i] + sum[j]);
						}
					}
					max = Math.max(max, sum[i]);
				}
				System.out.println(max);

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
