package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArrayWithGivenSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 1; i <= t; i++) {
				String str[] = br.readLine().split(" ");
				int n = Integer.parseInt(str[0]);
				int s = Integer.parseInt(str[1]);
				str = br.readLine().split(" ");
				int arr[] = new int[n];
				for (int j = 0; j < n; j++)
					arr[j] = Integer.parseInt(str[j]);

				int x = 0;
				int sum = arr[0];
				int y;
				for (y = 1; y <= n; y++) {
					while (sum > s && x < y - 1) {
						sum = sum - arr[x];
						x++;
					}
					if (sum == s) {
						System.out.println((x + 1) + " " + y);
						break;
					}
					if (y < n)
						sum = sum + arr[y];
				}
				if (y > n)
					System.out.println(-1);

			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
