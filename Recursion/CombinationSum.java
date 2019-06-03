package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int sum = Integer.parseInt(br.readLine());

				Set<Integer> set = new HashSet<>();
				for (int i = 0; i < n; i++)
					set.add(Integer.parseInt(str[i]));
				List<Integer> arr = new ArrayList<>(set);
				Collections.sort(arr);

				List<List<Integer>> res = new ArrayList<>();
				List<Integer> l = new ArrayList<>();
				comb(arr, sum, res, l, 0, 0);

				for (List<Integer> li : res) {
					System.out.print("(");
					for (int a = 0; a < li.size(); a++) {
						if (a < li.size() - 1)
							System.out.print(li.get(a) + " ");
						else
							System.out.print(li.get(a) + ")");

					}
				}
				if (res.isEmpty())
					System.out.println("Empty");
				else
					System.out.println();
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private static void comb(List<Integer> arr, int sum,
			List<List<Integer>> res, List<Integer> l, int i, int s) {
		if (s == sum) {
			res.add(new ArrayList<>(l));
			return;
		}
		if (s > sum)
			return;
		while (i < arr.size() && s + arr.get(i) <= sum) {
			l.add(arr.get(i));
			comb(arr, sum, res, l, i, s + arr.get(i));
			l.remove(l.size() - 1);
			i++;
		}
	}
}
