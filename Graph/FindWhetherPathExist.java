package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindWhetherPathExist {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int k = 0; k < t; k++) {
				int n = Integer.parseInt(br.readLine());
				int arr[][] = new int[n][n];
				String str[] = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++)
						arr[i][j] = Integer.parseInt(str[i * n + j]);
				}

				Cell start = new Cell(-1, -1);
				Cell end = new Cell(-1, -1);
				boolean vis[][] = new boolean[n][n];

				for (int i = 0; i < n; i++) {
					Arrays.fill(vis[i], false);
					for (int j = 0; j < n; j++) {
						switch (arr[i][j]) {
						case 0:
							vis[i][j] = true;
							break;
						case 1:
							start.x = i;
							start.y = j;
							break;
						case 2:
							end.x = i;
							end.y = j;
							break;
						}
					}
				}
				if (start.x == -1 || end.x == -1) {
					System.out.println(0);
					continue;
				}

				Queue<Cell> q = new LinkedList<>();
				q.add(start);
				vis[start.x][start.y] = true;

				int dx[] = { -1, 0, 1, 0 };
				int dy[] = { 0, 1, 0, -1 };

				Cell c = null;
				while (!q.isEmpty()) {
					c = q.poll();

					if (c.x == end.x && c.y == end.y)
						break;

					for (int i = 0; i < 4; i++) {
						int a = c.x + dx[i];
						int b = c.y + dy[i];

						if (a >= 0 && a < n && b >= 0 && b < n
								&& vis[a][b] == false) {
							vis[a][b] = true;
							q.add(new Cell(a, b));
						}
					}
				}
				if (c != null && c.x == end.x && c.y == end.y)
					System.out.println(1);
				else
					System.out.println(0);
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static class Cell {
		int x, y;

		Cell(int a, int b) {
			x = a;
			y = b;
		}
	}
}
