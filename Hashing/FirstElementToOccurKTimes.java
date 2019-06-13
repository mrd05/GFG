package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FirstElementToOccurKTimes {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int k = Integer.parseInt(str[1]);
				str = br.readLine().split("\\s+");
				int arr[] = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);

				Map<Integer, Integer> map = new HashMap<>();
				for (int a : arr)
					map.put(a, map.getOrDefault(a, 0) + 1);

				boolean flag = true;
				for (int a : arr) {
					if (map.get(a) == k) {
						System.out.println(a);
						flag = false;
						break;
					}
				}
				if (flag)
					System.out.println("-1");

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
