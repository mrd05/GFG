package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {

				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int m = Integer.parseInt(str[1]);

				char a[] = br.readLine().toCharArray();
				char b[] = br.readLine().toCharArray();

				int arr[][] = new int[n + 1][m + 1];
				int res = 0;
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m; j++) {
						if (a[i - 1] == b[j - 1]) {
							arr[i][j] = 1 + arr[i - 1][j - 1];
							res = Math.max(res, arr[i][j]);
						} else
							arr[i][j] = 0;
					}
				}
				System.out.println(res);

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
