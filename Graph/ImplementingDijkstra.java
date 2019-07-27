package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class ImplementingDijkstra {

	static class Driverclass {
		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();

			while (t-- > 0) {
				int V = sc.nextInt();
				ArrayList<ArrayList<Integer>> list = new ArrayList<>(V);
				for (int i = 0; i < V; i++) {
					ArrayList<Integer> temp = new ArrayList<>(V);
					list.add(i, temp);
				}

				for (int i = 0; i < V; i++) {
					ArrayList<Integer> temp = list.get(i);
					for (int j = 0; j < V; j++) {
						temp.add(sc.nextInt());
					}
					list.add(temp);
				}
				int s = sc.nextInt();
				new Implementation().dijkstra(list, s, V);
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
	 * ArrayList<ArrayList<Integer>> list: arraylist of arraylist which
	 * represents graph src: it represents source vertex V: number of vertex
	 */
	static class Implementation {
		static void dijkstra(ArrayList<ArrayList<Integer>> list, int src, int V) {
			boolean sdtSet[] = new boolean[V];

			int dis[] = new int[V];

			for (int i = 0; i < V; i++) {
				sdtSet[i] = false;
				dis[i] = Integer.MAX_VALUE;
			}

			dis[src] = 0;

			for (int i = 0; i < V - 1; i++) {
				int u = minDis(sdtSet, dis, V);

				sdtSet[u] = true;

				for (int v = 0; v < V; v++) {
					if (sdtSet[v] == false && list.get(u).get(v) != 0
							&& dis[u] != Integer.MAX_VALUE
							&& dis[u] + list.get(u).get(v) < dis[v])
						dis[v] = dis[u] + list.get(u).get(v);
				}
			}
			for (int i = 0; i < V; i++)
				System.out.print(dis[i] + " ");
		}

		static int minDis(boolean sdtTree[], int dis[], int V) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int i = 0; i < V; i++) {
				if (sdtTree[i] == false && dis[i] < min) {
					min = dis[i];
					index = i;
				}
			}
			return index;
		}
	}

}
