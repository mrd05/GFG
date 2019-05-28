package stackAndQueue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class LRU_Cache {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			Set<Integer> s = new HashSet<Integer>();
			int n = sc.nextInt();
			LRUCache g = new LRUCache(n);
			int q = sc.nextInt();

			while (q > 0) {

				String c = sc.next();
				// System.out.println(c);
				if (c.equals("GET")) {
					int x = sc.nextInt();
					System.out.print(g.get(x) + " ");
				}
				if (c.equals("SET")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					g.set(x, y);
				}

				q--;
				// System.out.println();
			}
			t--;
			System.out.println();
		}
	}

	/*
	 * Please note that it's Function problem i.e. you need to write your
	 * solution in the form of Function(s) only. Driver Code to call/invoke your
	 * function is mentioned above.
	 */

	/* You are required to complete below class */
	static class LRUCache {

		int capacity;
		int count;
		Map<Integer, Node> map;
		Node head, tail;

		static class Node {

			int key, value;
			Node prev = null, next = null;

			Node(int key, int value) {
				this.key = key;
				this.value = value;
			}

			Node() {
				this.key = 0;
				this.value = 0;
			}

		}

		/* Inititalize an LRU cache with size N */
		public LRUCache(int N) {
			this.capacity = N;
			this.count = 0;
			map = new HashMap<>();
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;
		}

		/*
		 * Returns the value of the key x if present else returns -1
		 */
		public int get(int x) {
			Node n = map.get(x);
			if (n != null) {
				remove(n);
				add(n);
				return n.value;
			}
			return -1;
		}

		/* Sets the key x with value y in the LRU cache */
		public void set(int x, int y) {
			Node n = map.get(x);
			if (n != null) {
				n.value = y;
				remove(n);
				add(n);
			} else {
				if (count < capacity) {
					n = new Node(x, y);
					add(n);
					map.put(x, n);
					count++;
				} else {
					map.remove(tail.prev.key);
					remove(tail.prev);
					n = new Node(x, y);
					add(n);
					map.put(x, n);
				}

			}
		}

		void add(Node n) {
			Node next = head.next;
			head.next = n;
			n.next = next;
			n.prev = head;
			n.next.prev = n;
		}

		void remove(Node n) {
			n.prev.next = n.next;
			n.next.prev = n.prev;
		}
	}

}
