package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquilibriumPoint1 {

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
				for (int j = 0; j < n; j++)
					arr[j] = Integer.parseInt(str[j]);
				System.out.println(pivotIndex(arr));
			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int pivotIndex(int[] nums) {
		if (nums.length == 0)
			return -1;
		int total = 0;
		for (int i = 0; i < nums.length; i++)
			total = total + nums[i];

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (total - nums[i] == sum * 2)
				return i;
			sum = sum + nums[i];
		}

		return -1;
	}
}
