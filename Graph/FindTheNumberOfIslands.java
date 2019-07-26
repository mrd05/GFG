package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindTheNumberOfIslands {

	static class Driverclass {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();

			while (t-- > 0) {
				int N = sc.nextInt();
				int M = sc.nextInt();

				ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

				// creating arraylist of arraylist
				for (int i = 0; i < N; i++) {
					ArrayList<Integer> temp = new ArrayList<>(M);
					list.add(i, temp);
				}

				// adding elements to the arraylist of arraylist
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						int val = sc.nextInt();
						list.get(i).add(j, val);
					}
				}

				System.out.println(new Islands().findIslands(list, N, M));

			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	// User function Template for Java
	static class Islands {

		// Function to find the number of island in the given list
		// N, M: size of list row and column respectively
		static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {
			boolean vis[][] = new boolean[N][M];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (list.get(i).get(j) == 1 && vis[i][j] == false) {
						// dfs(i,j,list,vis,N,M);
						bfs(i, j, list, vis, N, M);
						count++;
					}
				}
			}
			return count;
		}

		static void dfs(int i, int j, ArrayList<ArrayList<Integer>> list,
				boolean vis[][], int N, int M) {
			if (list.get(i).get(j) == 0)
				return;
			vis[i][j] = true;

			int x[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
			int y[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
			for (int a = 0; a < 8; a++) {
				if (isInside(i + x[a], j + y[a], N, M)
						&& vis[i + x[a]][j + y[a]] == false)
					dfs(i + x[a], j + y[a], list, vis, N, M);
			}
		}

		static boolean isInside(int x, int y, int N, int M) {
			if (x >= 0 && x < N && y >= 0 && y < M)
				return true;
			return false;
		}

		static void bfs(int i, int j, ArrayList<ArrayList<Integer>> list,
				boolean vis[][], int N, int M) {
			int x[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
			int y[] = { -1, -1, -1, 0, 1, 1, 1, 0 };

			Queue<P> q = new LinkedList<>();
			q.add(new P(i, j));
			vis[i][j] = true;

			while (!q.isEmpty()) {
				P p = q.poll();

				for (int a = 0; a < 8; a++) {
					if (isInside(i + x[a], j + y[a], N, M)
							&& list.get(i + x[a]).get(j + y[a]) == 1
							&& vis[i + x[a]][j + y[a]] == false) {
						vis[i + x[a]][j + y[a]] = true;
						bfs(i + x[a], j + y[a], list, vis, N, M);
					}
				}
			}
		}

		static class P {
			int x, y;

			P(int a, int b) {
				x = a;
				y = b;
			}
		}
	}

}
