package arrays;

import java.util.Scanner;

public class SumOfBitDifferences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++)
				arr[j] = in.nextInt();
			int count = 0;
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int b = arr[j] ^ arr[k];
					char[] str = Integer.toBinaryString(b).toCharArray();
					for (int z = 0; z < str.length; z++) {
						if (str[z] == '1')
							count++;
					}
				}
			}
			System.out.println(2 * count);
		}
	}

}
