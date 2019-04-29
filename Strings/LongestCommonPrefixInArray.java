package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestCommonPrefixInArray {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				System.out.println(trie(str));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String sorting(String[] str) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(str);
		for (int i = 0; i < str[0].length(); i++) {
			if (str[0].charAt(i) == str[str.length - 1].charAt(i))
				sb.append(str[0].charAt(i));
			else
				break;
		}

		return sb.length() == 0 ? "-1" : sb.toString();
	}

	static class TrieNode {
		public int numberChilds = 0;
		public TrieNode[] childs = new TrieNode[26];
		public boolean end = false;

		public TrieNode() {
			for (int i = 0; i < 26; i++)
				this.childs[i] = null;
		}

		void insert(String s) {
			TrieNode t = this;
			for (char c : s.toCharArray()) {
				if (t.childs[c - 'a'] == null) {
					t.numberChilds++;
					t.childs[c - 'a'] = new TrieNode();
				}
				t = t.childs[c - 'a'];
			}
			t.end = true;
		}
	}

	public static String walkTrie(TrieNode root) {
		StringBuilder sb = new StringBuilder();
		int index;
		while (root.numberChilds == 1 && root.end == false) {
			index = indexOfChild(root.childs);
			sb.append((char) ('a' + index));
			root = root.childs[index];
		}

		return sb.length() == 0 ? "-1" : sb.toString();
	}

	private static int indexOfChild(TrieNode[] childs) {
		int index = 0;
		for (int i = 0; i < childs.length; i++)
			if (childs[i] != null) {
				index = i;
				break;
			}

		return index;
	}

	public static String trie(String[] s) {

		TrieNode root = new TrieNode();
		for (String st : s)
			root.insert(st);

		return walkTrie(root);
	}

}
