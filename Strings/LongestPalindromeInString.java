package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromeInString {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String str = br.readLine();

				String s = "";
				String tem;
				/*for (int i = 0; i < str.length(); i++) {
					for (int j = i; j < str.length() + 1; j++) {
						tem = str.substring(i, j);
						if (isPalindrome(tem) && tem.length() > s.length())
							s = tem;
					}
				}*/
				// System.out.println(s);
				System.out.println(longestPalindrome(str));
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static boolean isPalindrome(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j))
				return false;
		}
		return true;
	}

	public static String longestPalindrome(String s) {
		if (s.length() == 0)
			return s;
		boolean arr[][] = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i][i] = true;
			if (i + 1 < s.length())
				arr[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
		}
		for (int j = 2; j < s.length(); j++) {
			for (int i = 0; i <= j - 2; i++) {
				arr[i][j] = arr[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
			}
		}
		int a = 0, b = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (arr[i][j] && (j - i) > (b - a)) {
					a = i;
					b = j;
				}
			}
		}
		return s.substring(a, b + 1);
	}
}
