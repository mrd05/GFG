package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingElementsOfArrayByFrequency {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int arr[] = new int[n];

				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);

				Map<Integer, Integer> map = new HashMap<>();
				for (int a : arr)
					map.put(a, map.getOrDefault(a, 0) + 1);

				List<Node> list = new ArrayList<>();
				for (int a : map.keySet())
					list.add(new Node(a, map.get(a)));
				Collections.sort(list);

				for (Node l : list) {
					for (int i = 0; i < l.freq; i++)
						System.out.print(l.val + " ");
				}
				System.out.println();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class Node implements Comparable<Node> {
		int val;
		int freq;

		Node(int val, int freq) {
			this.val = val;
			this.freq = freq;
		}

		public int compareTo(Node obj) {
			if (this.val != obj.val)
				return obj.freq - this.freq;
			return this.val - obj.val;
		}
	}

}
