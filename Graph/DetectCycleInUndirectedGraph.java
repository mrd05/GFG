package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DetectCycleInUndirectedGraph {

	static class DriverClass {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();

			while (t-- > 0) {
				ArrayList<ArrayList<Integer>> list = new ArrayList<>();
				int nov = sc.nextInt();
				int edg = sc.nextInt();

				for (int i = 0; i < nov + 1; i++)
					list.add(i, new ArrayList<Integer>());

				for (int i = 1; i <= edg; i++) {
					int u = sc.nextInt();
					int v = sc.nextInt();
					list.get(u).add(v);
					list.get(v).add(u);
				}
				if (new DetectCycle().isCyclic(list, nov) == true)
					System.out.println("1");
				else
					System.out.println("0");
			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	// User function Template for Java
	/*
	 * ArrayList<ArrayList<Integer>> list: represent graph containing 'V' number
	 * of vertices and edges between them V: represent number of vertices
	 */
	static class DetectCycle {
		static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
			boolean visited[] = new boolean[V];
			Arrays.fill(visited, false);
			for (int i = 0; i < V; i++) {
				if (visited[i] == false) {
					// dfs
					/*
					 * if(cycle(i,-1,list,visited)) return true;
					 */

					// bfs
					if (cycleBFS(i, V, list, visited))
						return true;
				}
			}
			return false;
		}

		static boolean cycle(int v, int parent,
				ArrayList<ArrayList<Integer>> list, boolean vis[]) {
			vis[v] = true;

			for (int a : list.get(v)) {
				if (vis[a] == false) {
					if (cycle(a, v, list, vis))
						return true;
				} else if (a != parent)
					return true;
			}
			return false;
		}

		static boolean cycleBFS(int v, int N,
				ArrayList<ArrayList<Integer>> list, boolean vis[]) {
			int parent[] = new int[N];
			Arrays.fill(parent, -1);

			Queue<Integer> q = new LinkedList<>();

			vis[v] = true;
			q.add(v);

			while (!q.isEmpty()) {
				v = q.poll();

				for (int a : list.get(v)) {
					if (vis[a] == false) {
						vis[a] = true;
						q.add(a);
						parent[a] = v;
					} else if (a != parent[v])
						return true;
				}
			}
			return false;
		}
	}

}
