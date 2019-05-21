package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateLinkedList {

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

	public static node rotate(node head, int k) {
		node cur = head;
		if (cur == null || cur.n == null)
			return cur;

		int len = 1;
		while (len < k && cur.n != null) {
			len++;
			cur = cur.n;
		}
		node res = cur;

		while (cur.n != null)
			cur = cur.n;
		cur.n = head;

		head = res.n;
		res.n = null;

		return head;

	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int k = Integer.parseInt(br.readLine());
				node root = null;
				for (String s : str)
					root = add(root, s);
				print(root);
				root = rotate(root, k);
				print(root);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
