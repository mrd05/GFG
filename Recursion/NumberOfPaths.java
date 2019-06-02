package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfPaths {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int m = Integer.parseInt(str[1]);
				System.out.println(path(0, 0, n, m));

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static int path(int x, int y, int n, int m) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return 0;
		if (x == n - 1 && y == m - 1)
			return 1;
		return path(x + 1, y, n, m) + path(x, y + 1, n, m);
	}

	public static int pathDP(int n, int m) {
		int arr[][] = new int[m][n];
		for (int i = 0; i < m; i++)
			arr[i][0] = 1;
		for (int i = 0; i < n; i++)
			arr[0][i] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++)
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
		}
		return arr[m - 1][n - 1];

	}
}
