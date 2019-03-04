package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpirallyTraversingMatrix {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String str[] = br.readLine().split("\\s+");
				int m = Integer.parseInt(str[0]);
				int n = Integer.parseInt(str[1]);
				str = br.readLine().split("\\s+");
				int arr[][] = new int[m][n];
				int index = 0;
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++)
						arr[i][j] = Integer.parseInt(str[index++]);
				}
				int i = 0, j = 0;
				int a = 0, b = 0;
				while (a < m && b < n) {
					if (b == n)
						break;
					while (b < n)
						System.out.print(arr[a][b++] + " ");
					n--;
					b--;
					a++;
					if (a == m)
						break;
					while (a < m)
						System.out.print(arr[a++][b] + " ");
					m--;
					a--;
					b--;
					if (b < i)
						break;
					while (b >= i)
						System.out.print(arr[a][b--] + " ");
					i++;
					b++;
					a--;
					if (a <= j)
						break;
					while (a > j)
						System.out.print(arr[a--][b] + " ");
					j++;
					a++;
					b++;
				}
				System.out.println();
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
