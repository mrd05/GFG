package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrangeCharacters {

	static class Node {
		char c;
		int freq;

		Node(char c, int freq) {
			this.c = c;
			this.freq = freq;
		}
	}

	static class NodeComp implements Comparator<Node> {
		public int compare(Node n1, Node n2) {
			if (n1.freq < n2.freq)
				return 1;
			else if (n1.freq > n2.freq)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str = br.readLine();
				PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComp());
				int count[] = new int[26];
				for (char c : str.toCharArray())
					count[c - 'a']++;
				for (int i = 0; i < 26; i++) {
					if (count[i] != 0) {
						pq.add(new Node((char) (i + 'a'), count[i]));
					}
				}
				StringBuilder sb = new StringBuilder();
				Node prev = new Node('a', -1);
				Node n = null;
				while (!pq.isEmpty()) {
					n = pq.poll();
					sb.append(n.c);

					if (prev.freq > 0)
						pq.add(prev);

					(n.freq)--;
					prev = n;
				}
				if (sb.length() == str.length())
					System.out.println(1);
				else
					System.out.println(0);
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
