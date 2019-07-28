package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnectedComponents {

	static class DriverClass {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();

			while (t-- > 0) {
				// arraylist of arraylist to represent graph
				ArrayList<ArrayList<Integer>> list = new ArrayList<>();

				int nov = sc.nextInt();
				int edg = sc.nextInt();

				for (int i = 0; i < nov; i++)
					list.add(i, new ArrayList<Integer>());

				for (int i = 1; i <= edg; i++) {
					int u = sc.nextInt();
					int v = sc.nextInt();

					// adding directed edge between
					// vertex 'u' and 'v'
					list.get(u).add(v);
				}
				System.out.println(new SCC().kosaraju(list, nov));
			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	// User function Template for Java
	/*
	 * ArrayList<ArrayList<Integer>> list: to represent graph containing 'N'
	 * number of vertices and edges between them N: represent number of vertices
	 */
	static class SCC {

		public int kosaraju(ArrayList<ArrayList<Integer>> list, int N) {
			boolean vis[] = new boolean[N];
			Arrays.fill(vis, false);
			Stack<Integer> st = new Stack<>();

			for (int i = 0; i < N; i++) {
				if (vis[i] == false)
					dfsStack(i, list, vis, st);
			}

			ArrayList<ArrayList<Integer>> rev = reverse(list, N);

			Arrays.fill(vis, false);
			int count = 0;
			while (!st.isEmpty()) {
				int v = st.pop();
				if (vis[v] == false) {
					count++;
					dfs(v, rev, vis);
				}
			}
			return count;
		}

		static void dfsStack(int v, ArrayList<ArrayList<Integer>> list,
				boolean[] vis, Stack<Integer> st) {
			vis[v] = true;
			for (int i : list.get(v)) {
				if (vis[i] == false)
					dfsStack(i, list, vis, st);
			}
			st.push(v);
		}

		static ArrayList<ArrayList<Integer>> reverse(
				ArrayList<ArrayList<Integer>> list, int n) {
			ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

			for (int i = 0; i < n; i++)
				ret.add(new ArrayList<Integer>());

			for (int i = 0; i < n; i++) {
				for (int a : list.get(i))
					ret.get(a).add(i);
			}
			return ret;
		}

		static void dfs(int v, ArrayList<ArrayList<Integer>> list, boolean[] vis) {
			vis[v] = true;

			for (int i : list.get(v)) {
				if (vis[i] == false)
					dfs(i, list, vis);
			}
		}

	}

}
