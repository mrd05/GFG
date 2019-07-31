package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class RatInMazeProblem {

	static class Rat {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while (t-- > 0) {
				int n = sc.nextInt();
				int[][] a = new int[n][n];
				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++)
						a[i][j] = sc.nextInt();
				GfG g = new GfG();
				ArrayList<String> res = g.printPath(a, n);
				for (int i = 0; i < res.size(); i++)
					System.out.print(res.get(i) + " ");
				System.out.println();
			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	/* Complete the function below */
	static class GfG {
		public static ArrayList<String> printPath(int[][] m, int n) {

			boolean vis[][] = new boolean[n][n];

			ArrayList<String> list = new ArrayList<String>();
			vis[0][0] = true;
			getPath(0, 0, "", list, m, vis, n);

			return list;
		}

		static String dir[] = { "D", "L", "R", "U" };
		static int dx[] = { 1, 0, 0, -1 };
		static int dy[] = { 0, -1, 1, 0 };

		static void getPath(int i, int j, String s, ArrayList<String> list,
				int[][] m, boolean vis[][], int n) {
			if (i == n - 1 && j == n - 1) {
				list.add(s);
				return;
			}

			for (int a = 0; a <= 3; a++) {
				int x = i + dx[a];
				int y = j + dy[a];
				if (isValid(x, y, vis, n) && m[x][y] == 1) {
					vis[x][y] = true;

					getPath(x, y, s + dir[a], list, m, vis, n);

					vis[x][y] = false;
				}
			}
		}

		static boolean isValid(int x, int y, boolean vis[][], int n) {
			return x >= 0 && x < n && y >= 0 && y < n && vis[x][y] == false;
		}
	}

}
