package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarrays {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int arr[] = new int[n];
				;
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);

				Map<Integer, Integer> map = new HashMap<>();
				int sum = 0, count = 0;
				map.put(0, 1);
				for (int i = 0; i < n; i++) {
					sum += arr[i];
					if (map.containsKey(sum))
						count += map.get(sum);
					map.put(sum, map.getOrDefault(sum, 0) + 1);
				}
				System.out.println(count);
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
