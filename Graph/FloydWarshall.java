package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloydWarshall {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				int g[][] = new int[n][n];

				for (int i = 0; i < n; i++) {
					String str[] = br.readLine().split("\\s+");
					for (int j = 0; j < n; j++) {
						if (str[j].equals("10000000"))
							g[i][j] = 10000000;
						else
							g[i][j] = Integer.parseInt(str[j]);
					}
				}

				int dis[][] = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++)
						dis[i][j] = g[i][j];
				}

				for (int k = 0; k < n; k++) {
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							if (dis[i][k] != 10000000 && dis[k][j] != 10000000
									&& dis[i][k] + dis[k][j] < dis[i][j])
								dis[i][j] = dis[i][k] + dis[k][j];
						}
					}
				}

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (dis[i][j] == 10000000)
							System.out.print("INF" + " ");
						else
							System.out.print(dis[i][j] + " ");
					}
					System.out.println();
				}

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
