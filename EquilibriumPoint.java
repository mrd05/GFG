package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquilibriumPoint {

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
		if (nums.length == 1)
			return 1;
		int l = 0, r = nums.length - 1;
		int sl = nums[l];
		int sr = nums[r];

		while (l != r) {
			if (sl < sr) {
				l++;
				sl = sl + nums[l];
			} else {
				r--;
				sr = sr + nums[r];
			}
		}

		if (sl != sr)
			return -1;
		else
			return l;
	}
}
