package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				String str[] = br.readLine().split(" ");
				int n = Integer.parseInt(str[0]);
				int k = Integer.parseInt(str[1]);
				str = br.readLine().split(" ");
				int arr[] = new int[n];
				for (int j = 0; j < n; j++)
					arr[j] = Integer.parseInt(str[j]);
				PriorityQueue<Integer> pq = new PriorityQueue<>(k,
						Collections.reverseOrder());
				for (int j = 0; j < n; j++) {
					if (j < k - 1) {
						pq.add(arr[j]);
					} else {
						pq.add(arr[j]);
						System.out.print(pq.peek() + " ");
						pq.remove(arr[j - k + 1]);
					}
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
