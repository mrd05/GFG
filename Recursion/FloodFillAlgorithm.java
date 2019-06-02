package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloodFillAlgorithm {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int m = Integer.parseInt(str[1]);
				int arr[][] = new int[n][m];
				str = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++)
						arr[i][j] = Integer.parseInt(str[i * m + j]);
				}
				str = br.readLine().split("\\s+");
				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);
				int k = Integer.parseInt(str[2]);

				arr = floodFill(arr, x, y, arr[x][y], k);

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++)
						System.out.print(arr[i][j] + " ");
				}
				System.out.println();
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static int[][] floodFill(int[][] arr, int x, int y, int a, int k) {
		if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length)
			return arr;
		if (arr[x][y] == a) {
			arr[x][y] = k;
			arr = floodFill(arr, x - 1, y, a, k);
			arr = floodFill(arr, x + 1, y, a, k);
			arr = floodFill(arr, x, y - 1, a, k);
			arr = floodFill(arr, x, y + 1, a, k);
		}

		return arr;
	}

}
