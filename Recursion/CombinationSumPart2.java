package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumPart2 {

	static class Comp implements Comparator<List<Integer>> {
		public int compare(List<Integer> l1, List<Integer> l2) {
			for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
				if (l1.get(i) != l2.get(i))
					return l1.get(i) - l2.get(i);
			}
			return l1.size() - l2.size();
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int sum = Integer.parseInt(br.readLine());

				int arr[] = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);
				Arrays.sort(arr);

				Set<List<Integer>> res = new HashSet<>();
				List<Integer> l = new ArrayList<>();
				comb(arr, sum, res, l, -1, 0);

				List<List<Integer>> rl = new ArrayList<>(res);
				Collections.sort(rl, new Comp());
				for (List<Integer> li : rl) {
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

	private static void comb(int[] arr, int sum, Set<List<Integer>> res,
			List<Integer> l, int i, int s) {
		if (s == sum) {
			res.add(new ArrayList<>(l));
			return;
		}
		if (s > sum)
			return;
		i++;
		int prev = -1;
		while (i < arr.length && s + arr[i] <= sum) {
			if (prev == arr[i]) {
				i++;
				continue;
			}
			l.add(arr[i]);
			comb(arr, sum, res, l, i, s + arr[i]);
			l.remove(l.size() - 1);
			i++;
		}
	}
}
