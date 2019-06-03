package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialKeyboard {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				System.out.println(countDP(n));

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static int count(int n) {
		if (n <= 6)
			return n;
		int max = 0;
		int cur;
		for (int i = n - 3; i >= 1; i--) {
			cur = (n - i - 1) * count(i);
			if (cur > max)
				max = cur;
		}
		return max;
	}

	static int countDP(int n) {
		if (n <= 6)
			return n;

		int arr[] = new int[n + 1];
		for (int i = 1; i <= 6; i++)
			arr[i] = arr[i - 1] + 1;

		for (int i = 7; i <= n; i++) {
			arr[i] = arr[i - 1] + 1;
			for (int k = i - 3; k >= 1; k--) {
				arr[i] = Math.max(arr[i], arr[k] * (i - k - 1));
			}
		}

		return arr[n];
	}
}
