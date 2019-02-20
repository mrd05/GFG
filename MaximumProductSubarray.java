package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumProductSubarray {

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

				long max = Long.MIN_VALUE;
				long poscur = 0;
				long negcur = 0;
				for (int j = 0; j < n; j++) {

					if (arr[j] == 0) {
						poscur = 0;
						negcur = 0;

					} else if (arr[j] > 0) {
						if (poscur == 0)
							poscur = 1;
						poscur = Math.max(arr[j], poscur * arr[j]);
						if (negcur == 0)
							negcur = 1;
						negcur = Math.min(arr[j], negcur * arr[j]);
					} else {
						if (negcur == 0)
							negcur = 1;
						if (poscur == 0)
							poscur = 1;
						long tem = poscur;
						poscur = Math.max(arr[j], negcur * arr[j]);
						negcur = Math.min(arr[j], tem * arr[j]);
					}

					max = Math.max(max, poscur);
				}
				System.out.println(max);
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
