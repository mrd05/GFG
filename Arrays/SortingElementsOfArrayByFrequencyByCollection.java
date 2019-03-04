package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingElementsOfArrayByFrequencyByCollection {

	public static class node implements Comparable<node> {
		int data;
		int freq;

		public node(int d, int f) {
			data = d;
			freq = f;
		}

		public int compareTo(node obj) {
			if (this.freq != obj.freq)
				return obj.freq - this.freq;
			else
				return this.data - obj.data;
		}

	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				Map<Integer, Integer> map = new HashMap<>();
				for (int i = 0; i < n; i++) {
					int a = Integer.parseInt(str[i]);
					if (map.containsKey(a))
						map.put(a, map.get(a) + 1);
					else
						map.put(a, 1);
				}
				List<node> list = new ArrayList<node>();
				for (int a : map.keySet())
					list.add(new node(a, map.get(a)));
				Collections.sort(list);
				for (node a : list) {
					for (int i = 0; i < a.freq; i++)
						System.out.print(a.data + " ");
				}
				System.out.println();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
