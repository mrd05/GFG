package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ShortestCommonSupersequence {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");

				int n = str[0].length();
				int m = str[1].length();
				int lcs[][] = new int[n + 1][m + 1];

				for (int i = 0; i <= n; i++)
					Arrays.fill(lcs[i], 0);

				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m; j++) {
						if (str[0].charAt(i - 1) == str[1].charAt(j - 1))
							lcs[i][j] = lcs[i - 1][j - 1] + 1;
						else
							lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
					}
				}
				System.out.println(n + m - lcs[n][m]);
				t--;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
