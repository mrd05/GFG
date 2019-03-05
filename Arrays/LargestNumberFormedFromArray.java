package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumberFormedFromArray {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");

				String s = "";
				List<node> list = new ArrayList<>();
				for (int i = 0; i < n; i++)
					list.add(new node(str[i] + ""));
				Collections.sort(list);
				for (node no : list)
					s = s + no.data;
				if (s.matches("0*"))
					System.out.println("0");
				else
					System.out.println(s);
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static class node implements Comparable<node> {
		String data;

		public node(String d) {
			this.data = d;
		}

		public int compareTo(node obj) {
			String s1 = this.data + obj.data;
			String s2 = obj.data + this.data;
			return s2.compareTo(s1);
		}
	}
}
