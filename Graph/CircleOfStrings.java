package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CircleOfStrings {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int k = 0; k < t; t--) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");

				// we need to make graph and check if we have a eulerian circuit
				// Add an edge from first character to last character

				ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
				for (int i = 0; i < 26; i++)
					graph.add(new ArrayList<Integer>());

				for (int i = 0; i < str.length; i++) {
					int u = str[i].charAt(0) - 'a';
					int v = str[i].charAt(str[i].length() - 1) - 'a';
					graph.get(u).add(v);
				}

				// checking if inDeg==outDeg of each vertex
				int inDeg[] = new int[26];
				for (int i = 0; i < 26; i++) {
					for (int v : graph.get(i))
						inDeg[v]++;
				}

				int i = 0;
				for (i = 0; i < 26; i++) {
					if (graph.get(i).size() != inDeg[i]) {
						System.out.println(0);
						break;
					}
				}
				if (i < 26)
					continue;

				boolean vis[] = new boolean[26];

				int v = 0;
				for (; v < 26; v++) {
					if (graph.get(v).size() > 0)
						break;
				}
				dfs(v, graph, vis);

				for (i = 0; i < 26; i++) {
					if (graph.get(i).size() > 0 && vis[i] == false) {
						System.out.println(0);
						break;
					}
				}
				if (i < 26)
					continue;

				// reverse or transpose the graph
				ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
				for (i = 0; i < 26; i++)
					rev.add(new ArrayList<Integer>());

				for (i = 0; i < 26; i++) {
					for (int u : graph.get(i))
						rev.get(u).add(i);
				}

				v = 0;
				for (; v < 26; v++) {
					if (rev.get(v).size() > 0)
						break;
				}

				Arrays.fill(vis, false);
				dfs(v, rev, vis);

				for (i = 0; i < 26; i++) {
					if (rev.get(i).size() > 0 && vis[i] == false) {
						System.out.println(0);
						break;
					}
				}
				if (i < 26)
					continue;

				System.out.println(1);
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static void dfs(int v, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
		vis[v] = true;
		for (int u : list.get(v)) {
			if (vis[u] == false)
				dfs(u, list, vis);
		}
	}
}
