package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CheckIfTwoArraysAreEqualOrNot {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				long a[] = new long[n];
				long b[] = new long[n];
				String str[] = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++)
					a[i] = Long.parseLong(str[i]);

				str = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++)
					b[i] = Long.parseLong(str[i]);

				Map<Long, Integer> map = new HashMap<>();
				for (long x : a)
					map.put(x, map.getOrDefault(x, 0) + 1);

				boolean flag = true;
				for (long x : b) {
					if (!map.containsKey(x) || map.get(x) == 0) {
						flag = false;
						break;
					} else {
						map.put(x, map.get(x) - 1);
					}
				}
				System.out.println(flag ? 1 : 0);

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
