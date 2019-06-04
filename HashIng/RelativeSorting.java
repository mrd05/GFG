package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelativeSorting {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int m = Integer.parseInt(str[1]);
				str = br.readLine().split("\\s+");
				int a1[] = new int[n];
				for (int i = 0; i < n; i++)
					a1[i] = Integer.parseInt(str[i]);
				str = br.readLine().split("\\s+");
				int a2[] = new int[m];
				for (int i = 0; i < m; i++)
					a2[i] = Integer.parseInt(str[i]);

				Map<Integer, Integer> map = new HashMap<>();
				for (int a : a1)
					map.put(a, map.getOrDefault(a, 0) + 1);

				for (int a : a2) {
					if (map.containsKey(a)) {
						for (int i = 0; i < map.get(a); i++)
							System.out.print(a + " ");
						map.remove(a);
					}
				}

				List<Integer> list = new ArrayList<>(map.keySet());
				Collections.sort(list);
				for (int a : list) {
					for (int i = 0; i < map.get(a); i++)
						System.out.print(a + " ");
					map.remove(a);
				}
				System.out.println();
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
