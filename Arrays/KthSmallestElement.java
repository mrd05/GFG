package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split(" ");
				int arr[] = new int[n];
				for (int j = 0; j < n; j++)
					arr[j] = Integer.parseInt(str[j]);
				Arrays.sort(arr);
				int k = Integer.parseInt(br.readLine());
				System.out.println(arr[k - 1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void solution2(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++)
			pq.add(arr[i]);
		while (k > 1) {
			pq.poll();
			k--;
		}
		System.out.println(pq.poll());
	}
}
