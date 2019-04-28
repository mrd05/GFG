package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestDistinctCharactersInString {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				String str = br.readLine();
				System.out.println(lengthOfLongestSubstring(str));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		int index[] = new int[256];
		Arrays.fill(index, -1);
		char c[] = s.toCharArray();
		int length = 1;
		int cur = 1;
		index[c[0]] = 0;
		int prev = -1;
		for (int i = 1; i < c.length; i++) {

			prev = index[c[i]];
			if (prev == -1 || i - cur > prev)
				cur++;
			else {
				length = Math.max(length, cur);
				cur = i - prev;
			}
			index[c[i]] = i;
		}
		return Math.max(cur, length);
	}

	public static int lengthOfLongestSubstring1(String s) {

		int ans = 0;
		Set<Character> set = new HashSet<Character>();
		char c[] = s.toCharArray();
		for (int i = 0, j = 0; i < c.length && j < c.length;) {
			if (set.contains(c[j])) {
				set.remove(c[i++]);
			} else {
				set.add(c[j++]);
				ans = Math.max(ans, j - i);
			}
		}
		return ans;
	}

}
