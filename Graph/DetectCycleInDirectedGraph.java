package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DetectCycleInDirectedGraph {

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
	/* Complete the function below */
	/*
	 * ArrayList<ArrayList<Integer>> list: to represent graph containing 'v'
	 * vertices and edges between them V: represent number of vertices
	 */
	static class DetectCycle {
		static int white = 0, gray = 1, black = 2;

		static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
			boolean recStack[] = new boolean[V];
			boolean visited[] = new boolean[V];

			int color[] = new int[V];
			Arrays.fill(color, white);
			for (int i = 0; i < V; i++) {
				/*
				 * if(cycle(i,list,recStack,visited)) return true;
				 */

				// using colours
				if (color[i] == white && cycleColor(i, list, color))
					return true;
			}
			return false;
		}

		static boolean cycle(int v, ArrayList<ArrayList<Integer>> list,
				boolean recSt[], boolean vis[]) {
			vis[v] = true;
			recSt[v] = true;
			for (int a : list.get(v)) {
				if (vis[a] == false && cycle(a, list, recSt, vis))
					return true;
				if (recSt[a] == true)
					return true;
			}

			recSt[v] = false;
			return false;
		}

		static boolean cycleColor(int v, ArrayList<ArrayList<Integer>> list,
				int color[]) {
			color[v] = gray;
			for (int a : list.get(v)) {
				if (color[a] == white && cycleColor(a, list, color))
					return true;

				if (color[a] == gray)
					return true;
			}

			color[v] = black;
			return false;
		}
	}
}
