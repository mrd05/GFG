package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArrayInGroups {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				String str[] = br.readLine().split(" ");
				int n = Integer.parseInt(str[0]);
				int k = Integer.parseInt(str[1]);
				long arr[] = new long[n];
				str = br.readLine().split(" ");
				for (int j = 0; j < n; j++)
					arr[j] = Long.parseLong(str[j]);
				for (int j = 0; j < n; j = j + k) {
					int l = j;
					int r = Math.min(j + k - 1, n - 1);
					while (l < r) {
						long temp = arr[l];
						arr[l] = arr[r];
						arr[r] = temp;
						l = l + 1;
						r = r - 1;
					}
				}
				for (int j = 0; j < n; j++)
					System.out.print(arr[j] + " ");
				System.out.println();
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
