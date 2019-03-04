package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrappingRainWater {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split(" ");
				int arr[] = new int[n];
				for (int j = 0; j < n; j++)
					arr[j] = Integer.parseInt(str[j]);
				int j = 0;
				int sum = 0;
				while (j < n - 1) {
					int k = j + 1;
					int max = k;
					while (k < n) {
						if (arr[j] > arr[k]) {
							if (arr[k] >= arr[max])
								max = k;
							k++;
						} else {
							max = k;
							break;
						}
					}

					int min = Math.min(arr[j], arr[max]);
					for (int x = j + 1; x <= max - 1; x++) {
						sum = sum + min - arr[x];
					}
					j = max;
				}
				System.out.println(sum);

			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void test() {

	}

}
