package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayPairSumDivisibilityProblem {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s");
				int arr[] = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);
				int k = Integer.parseInt(br.readLine());

				int rem[] = new int[k];
				for (int i = 0; i < n; i++)
					rem[arr[i] % k]++;
				boolean flag = true;
				for (int i = 0; i < n; i++) {
					int r = arr[i] % k;
					if (k == 2 * r) {
						if (rem[r] % 2 != 0) {
							flag = false;
							break;
						}
					} else if (r == 0) {
						if (rem[r] % 2 != 0) {
							flag = false;
							break;
						}
					} else {
						if (rem[k - r] != rem[r]) {
							flag = false;
							break;
						}
					}
				}
				if (flag)
					System.out.println("True");
				else
					System.out.println("False");
				t--;
			}
			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
