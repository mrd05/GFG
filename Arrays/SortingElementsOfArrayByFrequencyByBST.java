package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortingElementsOfArrayByFrequencyByBST {

	public static class node {
		int data;
		int freq;
		node left = null;
		node right = null;
	}

	public static node insertData(node root, int x) {
		if (root == null) {
			node t = new node();
			t.data = x;
			t.freq = 1;
			return t;
		} else {
			if (root.data == x)
				root.freq++;
			else if (x < root.data)
				root.left = insertData(root.left, x);
			else
				root.right = insertData(root.right, x);

			return root;
		}
	}

	public static node traverseRoot(node newroot, node root) {
		if (root == null)
			return newroot;
		newroot = traverseRoot(newroot, root.left);
		newroot = insertFreq(newroot, root);
		newroot = traverseRoot(newroot, root.right);

		return newroot;
	}

	private static node insertFreq(node newroot, node root) {
		if (newroot == null) {
			node t = new node();
			t.data = root.data;
			t.freq = root.freq;
			return t;
		} else {
			if (newroot.freq < root.freq)
				newroot.left = insertFreq(newroot.left, root);
			else
				newroot.right = insertFreq(newroot.right, root);

			return newroot;
		}
	}

	public static void traverse(node root) {
		if (root == null)
			return;
		traverse(root.left);
		for (int i = 0; i < root.freq; i++)
			System.out.print(root.data + " ");
		traverse(root.right);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				node root = null;
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++)
					root = insertData(root, Integer.parseInt(str[i]));
				node newroot = null;
				newroot = traverseRoot(newroot, root);
				traverse(newroot);
				System.out.println();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
