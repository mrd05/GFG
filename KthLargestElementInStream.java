package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String str[] = br.readLine().split("\\s+");
				int k = Integer.parseInt(str[0]);
				int n = Integer.parseInt(str[1]);
				str = br.readLine().split("\\s+");
				int arr[] = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);
				PriorityQueue<Integer> que = new PriorityQueue<>(1,
						Collections.reverseOrder());
				int r, m;
				List<Integer> list;
				for (int i : arr) {
					r = 0;
					m = k;
					list = new ArrayList<>();
					que.add(i);
					while (m > 0 && !que.isEmpty()) {
						r = que.poll();
						list.add(r);
						m--;
					}
					if (m == 0)
						System.out.print(r + " ");
					else
						System.out.print(-1 + " ");
					for (int j : list)
						que.add(j);
				}
				System.out.println();

			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	class KthLargest {

		int k;
		PriorityQueue<Integer> que;

		public KthLargest(int k, int[] nums) {
			this.k = k;
			que = new PriorityQueue<>(1, Collections.reverseOrder());
			if (nums.length != 0) {
				for (int i : nums)
					que.add(i);
			}
		}

		public int add(int val) {
			int x = 0;
			List<Integer> set = new ArrayList<>();
			int j = k;
			que.add(val);
			while (j > 0) {
				x = que.poll();
				set.add(x);
				j--;
			}
			for (int i : set)
				que.add(i);
			return x;
		}
	}

	/**
	 * Your KthLargest object will be instantiated and called as such:
	 * KthLargest obj = new KthLargest(k, nums); int param_1 = obj.add(val);
	 */
}
