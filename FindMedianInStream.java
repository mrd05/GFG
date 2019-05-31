package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInStream {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> left = new PriorityQueue<>(
					Collections.reverseOrder());
			PriorityQueue<Integer> right = new PriorityQueue<>();
			int e;
			for (int i = 0; i < n; i++) {
				e = Integer.parseInt(br.readLine());
				if (left.isEmpty()) {
					System.out.println(e);
					left.add(e);
				} else {
					if (!right.isEmpty() && e > right.peek()) {
						right.add(e);
						left.add(right.poll());
					} else {
						left.add(e);
					}
					if (left.size() > 1 + right.size())
						right.add(left.poll());

					if (i % 2 == 0) {// odd
						System.out.println(left.peek());
					} else {// even
						System.out.println((left.peek() + right.peek()) / 2);
					}
				}
			}
			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
