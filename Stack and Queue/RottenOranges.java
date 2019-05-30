package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	static int r;
	static int c;

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String str[] = br.readLine().split("\\s+");
				r = Integer.parseInt(str[0]);
				c = Integer.parseInt(str[1]);
				int arr[][] = new int[r][c];
				str = br.readLine().split("\\s+");
				Queue<Node> q = new LinkedList<>();
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						arr[i][j] = Integer.parseInt(str[i * c + j]);
						if (arr[i][j] == 2)
							q.add(new Node(i, j));
					}
				}
				Queue<Node> rq = null;
				Node n;
				boolean flag;
				int res = 0;
				while (!q.isEmpty()) {
					rq = new LinkedList<>();
					flag = false;
					while (!q.isEmpty()) {
						n = q.poll();
						if (isValid(n.x, n.y + 1) && arr[n.x][n.y + 1] == 1) {
							arr[n.x][n.y + 1] = 2;
							flag = true;
							rq.add(new Node(n.x, n.y + 1));
						}
						if (isValid(n.x, n.y - 1) && arr[n.x][n.y - 1] == 1) {
							arr[n.x][n.y - 1] = 2;
							flag = true;
							rq.add(new Node(n.x, n.y - 1));
						}
						if (isValid(n.x + 1, n.y) && arr[n.x + 1][n.y] == 1) {
							arr[n.x + 1][n.y] = 2;
							flag = true;
							rq.add(new Node(n.x + 1, n.y));
						}
						if (isValid(n.x - 1, n.y) && arr[n.x - 1][n.y] == 1) {
							arr[n.x - 1][n.y] = 2;
							flag = true;
							rq.add(new Node(n.x - 1, n.y));
						}
					}
					if (flag)
						res++;
					q = rq;
				}
				flag = true;
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (arr[i][j] == 1) {
							flag = false;
							break;
						}
					}
				}
				if (flag)
					System.out.println(res);
				else
					System.out.println(-1);

			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static boolean isValid(int x, int y) {
		if (x >= 0 && x < r && y >= 0 && y < c)
			return true;
		return false;
	}
}
