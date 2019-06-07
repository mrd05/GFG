package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ArraySubsetOfAnotherArray {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int m = Integer.parseInt(str[1]);
				int a[] = new int[n];
				str = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++)
					a[i] = Integer.parseInt(str[i]);
				int b[] = new int[m];
				str = br.readLine().split("\\s+");
				for (int i = 0; i < m; i++)
					b[i] = Integer.parseInt(str[i]);

				Set<Integer> set = new HashSet<>();
				for (int x : a)
					set.add(x);
				boolean flag = true;
				for (int x : b) {
					if (!set.contains(x)) {
						flag = false;
						break;
					}
				}
				if (flag)
					System.out.println("Yes");
				else
					System.out.println("No");
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
