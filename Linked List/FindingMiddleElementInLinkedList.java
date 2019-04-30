package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingMiddleElementInLinkedList {

	public static class node {
		int d;
		node n = null;

		node(int d) {
			this.d = d;
		}
	}

	public static node insert(node root, int d) {
		if (root == null)
			return new node(d);
		else {
			node t = root;
			while (t.n != null)
				t = t.n;
			t.n = new node(d);
			return root;
		}
	}

	public static void print(node root) {
		node t = root;
		while (t != null) {
			System.out.print(t.d + "-->");
			t = t.n;
		}
		System.out.print("null\n");
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				String str[] = br.readLine().split("\\s+");
				node root = null;
				for (String s : str)
					root = insert(root, Integer.parseInt(s));
				print(root);
				System.out.println(getMiddle(root));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getMiddle(node head) {
		node a = head;
		node b = head;
		while (b != null && b.n != null) {
			a = a.n;
			b = b.n.n;
		}

		return a.d;
	}

}
