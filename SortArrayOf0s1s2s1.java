package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortArrayOf0s1s2s1 {

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
				sortColors(arr);
				System.out.println();
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void sortColors(int[] nums) {
		int a = 0, b = nums.length - 1;
		for (int i = 0; i <= b;) {
			if (nums[i] == 0 && a < i) {
				int t = nums[i];
				nums[i] = nums[a];
				nums[a] = t;
				a++;
			} else if (nums[i] == 2 && i < b) {
				int t = nums[i];
				nums[i] = nums[b];
				nums[b] = t;
				b--;
			} else
				i++;

		}
		for (int j = 0; j < nums.length; j++)
			System.out.print(nums[j] + " ");
	}

}
