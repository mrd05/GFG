package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllPairsWithGivenSum {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int m = Integer.parseInt(str[1]);
				int x = Integer.parseInt(str[2]);
				int a[] = new int[n];
				str = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++)
					a[i] = Integer.parseInt(str[i]);
				List<Integer> b = new ArrayList<>();
				str = br.readLine().split("\\s+");
				for (int i = 0; i < m; i++)
					b.add(Integer.parseInt(str[i]));

				Set<Integer> set = new HashSet<>();
				for (int z : a)
					set.add(z);

				Collections.sort(b, Collections.reverseOrder());
				StringBuilder sb = new StringBuilder();

				for (int z : b) {
					if (set.contains(x - z)) {
						sb.append((x - z) + " " + z + ", ");
					}
				}
				System.out.println(sb.length() == 0 ? "-1" : sb.substring(0,
						sb.length() - 2));
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
