package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeadersInAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split(" ");
				int arr[] = new int[n];
				int test[] = new int[n];
				int max[] = new int[n];
				for (int j = 0; j < n; j++) {
					arr[j] = Integer.parseInt(str[j]);
					test[j] = 1;
					max[j] = arr[j];
				}
				for (int j = n - 1; j > 0; j--) {
					if (arr[j - 1] < max[j]) {
						test[j - 1] = 0;
						max[j - 1] = max[j];
					}
				}
				for (int j = 0; j < n; j++) {
					if (test[j] == 1)
						System.out.print(arr[j] + " ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
