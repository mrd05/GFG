package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

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

				int len[] = new int[n];
				Arrays.fill(len, 1);
				int max = 0;
				for (int i = 1; i < n; i++) {
					for (int j = 0; j < i; j++) {
						if (arr[i] > arr[j])
							len[i] = Math.max(len[i], len[j] + 1);
					}
					max = Math.max(max, len[i]);
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
