package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestSourceToDestinationPath {

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

				boolean vis[][] = new boolean[n][m];

				Queue<Node> q = new LinkedList<>();
				if (arr[0][0] == 1) {
					q.add(new Node(0, 0, 0));
					vis[0][0] = true;
				}

				int dx[] = { -1, 0, 1, 0 };
				int dy[] = { 0, 1, 0, -1 };

				Node node = null;
				while (!q.isEmpty()) {

					node = q.poll();
					if (node.x == x && node.y == y)
						break;

					for (int i = 0; i < 4; i++) {
						int a = node.x + dx[i];
						int b = node.y + dy[i];
						if (a >= 0 && a < n && b >= 0 && b < m
								&& arr[a][b] == 1 && vis[a][b] == false) {
							vis[a][b] = true;
							q.add(new Node(a, b, node.dis + 1));
						}
					}
				}
				if (node != null && node.x == x && node.y == y)
					System.out.println(node.dis);
				else
					System.out.println(-1);
				t--;
			}
			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static class Node {
		int x, y, dis;

		Node(int a, int b, int d) {
			x = a;
			y = b;
			dis = d;
		}
	}
}
