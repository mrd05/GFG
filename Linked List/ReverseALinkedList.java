package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseALinkedList {

	public static class node {
		public int d;
		public node n = null;

		public node(int d) {
			this.d = d;
		}
	}

	public static node add(node root, String s) {
		if (root == null)
			return new node(Integer.parseInt(s));

		node t = root;
		while (t.n != null)
			t = t.n;
		t.n = new node(Integer.parseInt(s));
		return root;
	}

	public static void print(node root) {
		while (root != null) {
			System.out.print(root.d + " ");
			root = root.n;
		}
		System.out.println();
	}

	public static node reverse(node head) {
		node prev = null, cur = head, next;
		if (cur == null || cur.n == null)
			return cur;

		while (cur != null) {
			next = cur.n;
			cur.n = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				node root = null;
				for (String s : str)
					root = add(root, s);
				print(root);
				root = reverse(root);
				print(root);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
