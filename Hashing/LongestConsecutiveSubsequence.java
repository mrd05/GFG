package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int arr[] = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);

				Set<Integer> set = new HashSet<>();
				for (int a : arr)
					set.add(a);

				int res = 0;
				for (int a : arr) {
					if (set.contains(a - 1))
						continue;
					else {
						int x = a + 1;
						while (set.contains(x))
							x++;
						if (res < x - a)
							res = x - a;
					}
				}
				System.out.println(res);

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
