package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseLinkedListInGroupsOfGivenSize {

	static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}

	public static Node add(Node root, String s) {
		if (root == null)
			return new Node(Integer.parseInt(s));

		Node t = root;
		while (t.next != null)
			t = t.next;
		t.next = new Node(Integer.parseInt(s));
		return root;
	}

	public static void print(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
		System.out.println();
	}

	public static Node reverseInGroup(Node root, int k) {
		if (k == 0)
			return root;
		Node lastHead = null, nextHead = root, cur = root, prev = null, next, finalHead = null, curHead;
		int n = 0;
		boolean flag = true;
		while (nextHead != null) {
			cur = nextHead;
			curHead = cur;
			n = 0;
			while (n < k && nextHead != null) {
				nextHead = nextHead.next;
				n++;
			}

			prev = nextHead;
			while (cur != nextHead) {
				next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}
			if (flag) {
				finalHead = prev;
				flag = false;
			} else {
				lastHead.next = prev;
			}
			lastHead = curHead;
		}

		return finalHead;
	}

	public static Node reverseInGroupRecur(Node root, int k) {
		if (k == 0)
			return root;
		Node cur = root, prev = null, next = null;
		int n = 0;

		while (cur != null && n < k) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			n++;
		}
		if (next != null)
			root.next = reverseInGroupRecur(next, k);

		return prev;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int k = Integer.parseInt(br.readLine());
				Node root = null;
				for (String s : str)
					root = add(root, s);
				print(root);
				root = reverseInGroupRecur(root, k);
				print(root);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
