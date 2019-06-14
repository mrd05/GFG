package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumOperations {

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

	static int countDP(int n) {
		if (n == 0)
			return 0;
		int count = 0;
		while (n > 0) {
			if ((n & 1) == 0) // n%2==0
				n = n / 2;
			else
				n = n - 1;
			count++;
		}
		return count;
	}

	static int count(int sum, int n) {
		if (sum == n)
			return 0;
		if (sum > n)
			return 1;
		if (sum == 0)
			return 1 + count(sum + 1, n);

		return Math.min(1 + count(sum + 1, n), 1 + count(sum * 2, n));
	}
}
