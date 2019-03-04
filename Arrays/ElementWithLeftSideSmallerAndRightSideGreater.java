package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ElementWithLeftSideSmallerAndRightSideGreater {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				int n = Integer.parseInt(br.readLine());
				int arr[] = new int[n];
				String str[] = br.readLine().split("\\s+");
				if (n == 0)
					System.out.println(-1);
				else {
					for (int i = 0; i < n; i++) {
						arr[i] = Integer.parseInt(str[i]);
					}
					int max[] = new int[n];
					int min[] = new int[n];
					max[0] = arr[0];
					for (int i = 1; i < n; i++)
						max[i] = Math.max(max[i - 1], arr[i - 1]);

					min[n - 1] = arr[n - 1];
					for (int i = n - 2; i >= 0; i--)
						min[i] = Math.min(min[i + 1], arr[i + 1]);

					int i;
					for (i = 1; i < n - 1; i++) {
						if (max[i] <= arr[i] && arr[i] <= min[i]) {
							System.out.println(arr[i]);
							break;
						}
					}
					if (i == n - 1)
						System.out.println(-1);

				}
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
