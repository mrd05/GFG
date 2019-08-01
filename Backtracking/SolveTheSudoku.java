package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolveTheSudoku {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int arr[][] = new int[9][9];
				for (int i = 0; i < 9; i++) {
					String str[] = br.readLine().split("\\s+");
					for (int j = 0; j < 9; j++)
						arr[i][j] = Integer.parseInt(str[j]);
				}

				find(arr);

				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++)
						System.out.print(arr[i][j] + " ");
					System.out.println();
				}

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private static boolean find(int[][] arr) {

		int row = -1, col = -1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (arr[i][j] == 0) {
					row = i;
					col = j;
					break;
				}
			}
			if (row != -1)
				break;
		}
		if (row == -1)
			return true;

		for (int x = 1; x <= 9; x++)

		{
			if (isValid(x, row, col, arr)) {
				arr[row][col] = x;
				if (find(arr))
					return true;
				arr[row][col] = 0;
			}
		}
		return false;

	}

	private static boolean isValid(int x, int r, int c, int[][] arr) {

		for (int i = 0; i < 9; i++) {
			if (arr[r][i] == x)
				return false;
		}

		for (int i = 0; i < 9; i++) {
			if (arr[i][c] == x)
				return false;
		}

		int i = r / 3;
		int j = c / 3;
		for (int a = 3 * i; a < 3 * i + 3; a++) {
			for (int b = 3 * j; b < 3 * j + 3; b++) {
				if (arr[a][b] == x)
					return false;
			}
		}

		return true;
	}
}
