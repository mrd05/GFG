package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
