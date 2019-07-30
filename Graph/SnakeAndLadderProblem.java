package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadderProblem {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {

				List<ArrayList<Integer>> list = new ArrayList<>();
				for (int i = 0; i < 30; i++)
					list.add(new ArrayList<Integer>());

				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();

				for (int i = 0; i < n; i++)
					map.put(Integer.parseInt(str[i * 2]) - 1,
							Integer.parseInt(str[i * 2 + 1]) - 1);

				// creating edges from i to i+1 till i+6 directly if no snake or ladder
				// else we make edge from i to end of snake and ladder
				for (int i = 0; i < 30; i++) {
					for (int j = i + 1; j < 30 && j <= i + 6; j++)
						list.get(i).add(map.getOrDefault(j, j));
				}
				// the above section of creating graph can be skipped
				// by putting same condition in BFS we can get the next element
				// from map or the actual value

				// as all edges have equal weight we apply BFS
				boolean vis[] = new boolean[30];
				Queue<Cell> q = new LinkedList<>();

				q.add(new Cell(0, 0));
				vis[0] = true;

				while (!q.isEmpty()) {
					Cell c = q.poll();

					if (c.v == 29) {
						System.out.println(c.dis);
						break;
					}

					for (int v : list.get(c.v)) {
						if (vis[v] == false) {
							vis[v] = true;
							q.add(new Cell(v, c.dis + 1));
						}
					}

				}

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static class Cell {
		int v, dis;

		Cell(int u, int d) {
			v = u;
			dis = d;
		}
	}
}
