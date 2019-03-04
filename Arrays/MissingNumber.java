package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 1; i <= t; i++) {
				int n = Integer.parseInt(br.readLine());
				int arr[] = new int[n];
				String str[] = br.readLine().split(" ");
				for (int j = 0; j < str.length; j++)
					arr[j] = Integer.parseInt(str[j]);
				int j = 0;
				int x = 0;
				for (j = 0; j < n; j++) {
					x = x ^ j ^ arr[j];
				}
				System.out.println(x ^ j);
			}

		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
