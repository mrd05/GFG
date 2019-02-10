package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StockBuyAndSell {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				int arr[] = new int[n];
				String str[] = br.readLine().split(" ");
				for (int j = 0; j < n; j++)
					arr[j] = Integer.parseInt(str[j]);
				int j = 0;
				int low = 0, high = 0;
				int sum = 0;
				while (j < n - 1) {
					while (j < n - 1 && arr[j] >= arr[j + 1])
						j++;
					low = j;
					while (j < n - 1 && arr[j] < arr[j + 1])
						j++;
					high = j;
					sum = sum + arr[high] - arr[low];
					j++;
					if (low != high)
						System.out.print("(" + low + " " + high + ") ");
				}
				if (sum == 0)
					System.out.println("No Profit");
				else
					System.out.println();
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
