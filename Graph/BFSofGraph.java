package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSofGraph {

	static class Driverclass {
		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while (t-- > 0) {
				ArrayList<ArrayList<Integer>> list = new ArrayList<>();
				int nov = sc.nextInt();
				int edg = sc.nextInt();

				for (int i = 0; i < nov; i++)
					list.add(i, new ArrayList<Integer>());

				for (int i = 1; i <= edg; i++) {
					int u = sc.nextInt();
					int v = sc.nextInt();
					list.get(u).add(v);
				}
				boolean vis[] = new boolean[nov];
				for (int i = 0; i < nov; i++)
					vis[i] = false;
				new Traversal().bfs(0, list, vis);
				System.out.println();
			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	// User function Template for Java
	/*
	 * ArrayList<ArrayList<Integer>> list: represent graph containing vertices
	 * and edges between themvis[]: boolean array to represent visited vertexs:
	 * starting vertex
	 */
	static class Traversal {
		static void bfs(int s, ArrayList<ArrayList<Integer>> list,
				boolean vis[]) {
			Queue<Integer> q = new LinkedList<>();
			vis[s] = true;
			q.add(s);
			while (!q.isEmpty()) {
				s = q.poll();
				System.out.print(s + " ");
				for (int a : list.get(s)) {
					if (!vis[a]) {
						vis[a] = true;
						q.add(a);
					}
				}
			}

		}
	}

}
