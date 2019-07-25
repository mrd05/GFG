package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DFSofGraph {

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
					list.get(v).add(u);
				}
				boolean vis[] = new boolean[nov];
				for (int i = 0; i < nov; i++)
					vis[i] = false;
				new Traversal().dfs(0, list, vis);
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
	 * ArrayList<ArrayList<Integer>> list: which represents graph src:
	 * represents source vertexvis[]: boolean array
	 */
	static class Traversal {
		static void dfs(int src, ArrayList<ArrayList<Integer>> list,
				boolean vis[]) {
			vis[src] = true;
			System.out.print(src + " ");

			for (int a : list.get(src)) {
				if (!vis[a]) {
					vis[a] = true;
					dfs(a, list, vis);
				}
			}
		}
	}

}
