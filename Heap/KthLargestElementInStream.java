package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				String str[] = br.readLine().split("\\s+");
				int k = Integer.parseInt(str[0]);
				int n = Integer.parseInt(str[1]);
				str = br.readLine().split("\\s+");
				PriorityQueue<Integer> pq = new PriorityQueue<>();
				int j = 0;
				for (; j < k - 1; j++) {
					int x = Integer.parseInt(str[j]);
					pq.add(x);
					System.out.print("-1 ");
				}
				for (; j < n; j++) {
					int x = Integer.parseInt(str[j]);
					if (j == k - 1) {
						pq.add(x);
						System.out.print(pq.peek() + " ");
					} else {
						if (pq.peek() < x) {
							pq.poll();
							pq.add(x);
						}
						System.out.print(pq.peek() + " ");
					}
				}
				System.out.println();

			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
