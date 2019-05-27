package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextLargerElement {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			Stack<Long> st = null;
			long arr[];
			long a;
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				st = new Stack<>();
				arr = new long[n];
				arr[n - 1] = -1;
				st.push(Long.parseLong(str[n - 1]));
				for (int x = n - 2; x >= 0; x--) {
					a = Long.parseLong(str[x]);
					if (!st.isEmpty()) {
						while (!st.isEmpty() && st.peek() <= a)
							st.pop();
					}
					arr[x] = st.isEmpty() ? -1 : st.peek();
					st.push(a);
				}
				for (int x = 0; x < n; x++)
					System.out.print(arr[x] + " ");
				System.out.println();
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
