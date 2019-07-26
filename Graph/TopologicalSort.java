package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

	static class DriverClass {
		public static void main(String[] args) throws IOException {
			BufferedReader read = new BufferedReader(new InputStreamReader(
					System.in));
			int t = Integer.parseInt(read.readLine());

			while (t-- > 0) {
				ArrayList<ArrayList<Integer>> list = new ArrayList<>();
				String st[] = read.readLine().trim().split("\\s+");
				int edg = Integer.parseInt(st[0]);
				int nov = Integer.parseInt(st[1]);
				for (int i = 0; i < nov + 1; i++)
					list.add(i, new ArrayList<Integer>());

				String s[] = read.readLine().trim().split("\\s+");
				int p = 0;
				for (int i = 1; i <= edg; i++) {
					int u = Integer.parseInt(s[p++]);
					int v = Integer.parseInt(s[p++]);
					list.get(u).add(v);

				}

				int res[] = new int[10001];
				res = new TopoSort().topoSort(list, nov);
				boolean valid = true;

				for (int i = 0; i < nov; i++) {
					int n = list.get(res[i]).size();
					for (int j = 0; j < list.get(res[i]).size(); j++) {
						for (int k = i + 1; k < nov; k++) {
							if (res[k] == list.get(res[i]).get(j))
								n--;
						}
					}
					if (n != 0) {
						valid = false;
						break;
					}
				}
				if (valid == true)
					System.out.println("0");
				else
					System.out.println("1");
			}
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	/* Complete the function below */
	/*
	 * ArrayList<ArrayList<>Integer>list: to represent graph containing 'N'
	 * vertices and edges between them N: represent number of vertices
	 */
	static class TopoSort {
		// using DFS
		static int[] topoSort1(ArrayList<ArrayList<Integer>> list, int N) {
			Stack<Integer> st = new Stack<>();
			boolean visited[] = new boolean[N];
			Arrays.fill(visited, false);
			for (int i = 0; i < N; i++) {
				if (visited[i] == false)
					topo(i, list, visited, st);
			}
			int arr[] = new int[N];
			for (int i = N - 1; i >= 0; i--) {
				arr[i] = st.pop();
			}
			return arr;
		}

		// using Kahns algorithm BFS
		static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N) {
			int inDegree[] = new int[N];
			for (ArrayList<Integer> l : list) {
				for (int a : l)
					inDegree[a]++;
			}

			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				if (inDegree[i] == 0)
					q.add(i);
			}

			int count = 0;
			int[] arr = new int[N];
			int i = N - 1;
			while (!q.isEmpty()) {
				int v = q.poll();
				arr[i--] = v;
				for (int a : list.get(v)) {
					inDegree[a]--;
					if (inDegree[a] == 0)
						q.add(a);
				}
				count++;
			}
			return arr;
		}

		static void topo(int v, ArrayList<ArrayList<Integer>> list,
				boolean vis[], Stack st) {
			vis[v] = true;
			for (int a : list.get(v)) {
				if (vis[a] == false)
					topo(a, list, vis, st);
			}
			st.push(v);
		}
	}

}
