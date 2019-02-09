package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PythagoreanTriplet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {

			int t = Integer.parseInt(br.readLine());
			for (int i = 1; i <= t; i++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split(" ");
				int arr[] = new int[n];
				for (int j = 0; j < n; j++)
					arr[j] = Integer.parseInt(str[j]);
				for (int j = 0; j < n; j++)
					arr[j] = arr[j] * arr[j];
				Arrays.sort(arr);

				int r = arr.length - 1;
				while (r > 0) {
					int l = 0, m = r - 1;
					while (l < m) {
						if (arr[l] + arr[m] == arr[r])
							break;
						else if (arr[l] + arr[m] < arr[r])
							l++;
						else
							m--;
					}
					if (arr[l] + arr[m] == arr[r]) {
						System.out.println("Yes ");
						break;
					}
					r--;
				}
				if (r == 0)
					System.out.println("No");
			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
