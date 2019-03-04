package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindElementThatAppearsOnceSortedArray {

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
				int prev = arr[0];
				int count = 1;
				int i = 0;
				for (i = 1; i < n; i++) {
					if (prev == arr[i])
						count++;
					else {
						if (count == 1) {
							System.out.println(prev);
							break;
						}
						prev = arr[i];
						count = 1;
					}
				}
				if (count == 1 && i == n)
					System.out.println(arr[n - 1]);

			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
