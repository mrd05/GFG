package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CuttedSegments {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int len = Integer.parseInt(br.readLine().trim());
				String str[] = br.readLine().split("\\s+");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				int c = Integer.parseInt(str[2]);

				int dp[] = new int[len + 1];

				Arrays.fill(dp, -1);
				dp[0] = 0;
				for (int i = 0; i <= len; i++) {
					if (dp[i] != -1) {
						if (i + a <= len)

							dp[i + a] = Math.max(dp[i + a], 1 + dp[i]);
						if (i + b <= len)
							dp[i + b] = Math.max(dp[i + b], 1 + dp[i]);
						if (i + c <= len)
							dp[i + c] = Math.max(dp[i + c], 1 + dp[i]);
					}
				}
				System.out.println(dp[len]);

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
