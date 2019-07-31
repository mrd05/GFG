package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				List<List<Integer>> list = new ArrayList<>();
				List<Integer> l = new ArrayList<>();
				boolean vis[][] = new boolean[n][n];
				getLoc(0, list, l, vis, n);
				if (list.isEmpty())
					System.out.println(-1);
				else {
					for (List<Integer> li : list) {
						System.out.print('[');
						for (int x : li)
							System.out.print(x + " ");
						System.out.print("] ");
					}
					System.out.println();
				}
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private static void getLoc(int col, List<List<Integer>> list,
			List<Integer> l, boolean[][] vis, int n) {

		if (l.size() == n) {
			list.add(new ArrayList<Integer>(l));
			return;
		}

		for (int row = 0; row < n; row++) {
			if (isValid(row, col, vis, n)) {
				vis[row][col] = true;
				l.add(row + 1);
				getLoc(col + 1, list, l, vis, n);
				vis[row][col] = false;
				l.remove(l.size() - 1);
			}
		}
	}

	private static boolean isValid(int row, int col, boolean[][] vis, int n) {

		// only check for left side is required as we are filling form left side
		// right side will never contain

		// same row
		for (int c = 0; c < col; c++) {
			if (vis[row][c] == true)
				return false;
		}

		// same column check not required as we are keeping only one queen in a
		// column at a time

		// left upper diagonal
		for (int x = row, y = col; x >= 0 && y >= 0; x--, y--) {
			if (vis[x][y] == true)
				return false;
		}

		// left lower diagonal
		for (int x = row, y = col; x < n && y >= 0; x++, y--) {
			if (vis[x][y] == true)
				return false;
		}

		return true;
	}
}
