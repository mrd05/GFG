package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FirstNonRepeatingCharacterInStream {

	static class Node {
		char c = '\0';
		boolean repeat = false;
		Node prev = null, next = null;

		Node() {
		}

		Node(char c) {
			this.c = c;
		}
	}

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());

			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				Node arr[] = new Node[26];
				Arrays.fill(arr, null);
				Node front = new Node();
				Node rear = new Node();
				front.next = rear;
				rear.prev = front;
				for (String s : str) {
					char c = s.toCharArray()[0];
					if (arr[c - 'a'] == null) {
						Node node = new Node(c);
						node.next = front.next;
						node.prev = front;
						front.next = node;
						node.next.prev = node;
						arr[c - 'a'] = node;
					} else {
						if (!arr[c - 'a'].repeat) {
							Node node = arr[c - 'a'];
							node.prev.next = node.next;
							node.next.prev = node.prev;
						}
						arr[c - 'a'].repeat = true;
					}
					if (rear.prev.c == '\0')
						System.out.print("-1 ");
					else
						System.out.print(rear.prev.c + " ");
				}
				System.out.println();
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
