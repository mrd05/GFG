package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertArrayIntoZigZagFashion {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				int n = Integer.parseInt(br.readLine());
				int arr[] = new int[n];
				String str[] = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);
				if (n == 0)
					System.out.println();
				if (n == 1)
					System.out.println(arr[0]);
				else {
					int k;
					for (int i = 0; i < n - 1; i++) {
						if (i % 2 == 0) {
							if (arr[i] > arr[i + 1]) {
								k = arr[i];
								arr[i] = arr[i + 1];
								arr[i + 1] = k;
							}
						} else {
							if (arr[i] < arr[i + 1]) {
								k = arr[i];
								arr[i] = arr[i + 1];
								arr[i + 1] = k;
							}
						}
					}
					for (int i = 0; i < n; i++)
						System.out.print(arr[i] + " ");
					System.out.println();
				}
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
