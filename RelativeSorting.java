package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSorting {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int m = Integer.parseInt(str[1]);
				str = br.readLine().split("\\s+");
				int arr[] = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);
				str = br.readLine().split("\\s+");
				int rank[] = new int[m];
				for (int i = 0; i < m; i++)
					rank[i] = Integer.parseInt(str[i]);

				Map<Integer, Integer> map = new HashMap<>();
				for (int i : arr) {
					if (map.containsKey(i))
						map.put(i, map.get(i) + 1);
					else
						map.put(i, 1);
				}
				int res[] = new int[n];
				int index = 0;
				int a = 0;
				for (int i : rank) {
					if (map.containsKey(i)) {
						int count = map.get(i);
						a = a + count;
						for (int j = 0; j < count; j++)
							res[index++] = i;
						map.remove(i);
					}
				}
				int sor[] = new int[n - a];
				int in = 0;
				for (int i : map.keySet()) {
					int count = map.get(i);
					for (int j = 0; j < count; j++)
						sor[in++] = i;
				}
				Arrays.sort(sor);
				for (int i : sor)
					res[index++] = i;
				for (int i : res)
					System.out.print(i + " ");
				System.out.println();
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
