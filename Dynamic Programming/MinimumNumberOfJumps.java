package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumberOfJumps {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int arr[] = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);

				System.out.println(dpN1(arr, n));

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static int dpN1(int arr[], int n) {

		if (arr.length == 0 || arr[0] == 0)
			return -1;

		int maxReach = arr[0];
		int step = arr[0];
		int jump = 1;
		for (int i = 1; i < n; i++) {
			if (i == n - 1)
				return jump;

			maxReach = Math.max(maxReach, i + arr[i]);

			step--;

			if (step == 0) {
				jump++;

				if (i >= maxReach)
					return -1;

				step = maxReach - i;
			}
		}
		return -1;
	}

	static int dpN2(int arr[], int n) {
		int jump[] = new int[n];
		jump[0] = 0;
		for (int i = 1; i < n; i++) {
			jump[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (jump[j] != Integer.MAX_VALUE && i <= j + arr[j]) {
					jump[i] = Math.min(jump[i], 1 + jump[j]);
					break;
				}
			}
		}
		return jump[n - 1];
	}
}
