package bitMagic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountTotalSetBits {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());

				/*int dp[] = new int[n + 1];
				int ans = 0;

				for (int i = 1; i <= n; i++) {
					// dp[i] = dp[i / 2] + i % 2;
					// the above can be written using bit manipulation
					dp[i] = dp[i >> 1] + (i & 1);
					ans += dp[i];
				}
				System.out.println(ans);*/

				n++;
				int pow2 = 2;
				int count = n / 2;

				while (pow2 <= n) {
					int totalPairs = n / pow2;

					count += (totalPairs / 2) * pow2;

					count += (totalPairs % 2 == 1) ? n % pow2 : 0;

					pow2 = pow2 << 1;
				}
				System.out.println(count);
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
