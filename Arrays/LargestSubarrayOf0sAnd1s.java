package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayOf0sAnd1s {

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
				System.out.println(maxLen(arr));
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static int maxLen(int[] arr) {
		if (arr.length == 0 || arr.length == 1)
			return 0;
		int count = 0;
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			count += (arr[i] == 0 ? 1 : -1);
			if (map.containsKey(count))
				max = Math.max(max, i - map.get(count));
			else
				map.put(count, i);
		}

		return max;
	}
}
