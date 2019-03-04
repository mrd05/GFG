package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortArrayOf0s1s2s {

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
		int a = 0, b = 0;
		boolean f1 = true;
		boolean f2 = true;
		for (int i = 0; i < nums.length; i++) {
			switch (nums[i]) {
			case 0:
				if (!f1 || !f2) {
					if (!f1 && !f2) {
						nums[a] = 0;
						a++;
						nums[b] = 1;
						b++;
						nums[i] = 2;
					} else if (!f1) {
						nums[a] = 0;
						a++;
						nums[i] = 1;
					} else if (!f2) {
						nums[b] = 0;
						b++;
						nums[i] = 2;
					}
				}
				break;
			case 1:
				if (f1) {
					a = i;
					f1 = false;
				}
				if (!f2) {
					if (a == i)
						a = b;
					nums[b] = 1;
					b++;
					nums[i] = 2;
				}
				break;
			case 2:
				if (f2) {
					b = i;
					f2 = false;
				}
				break;
			}

		}
		for (int j = 0; j < nums.length; j++)
			System.out.print(nums[j] + " ");
	}

}
