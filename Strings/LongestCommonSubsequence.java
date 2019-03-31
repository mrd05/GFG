package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				br.readLine();
				String s1 = br.readLine();
				String s2 = br.readLine();
				System.out.println(LCS(s1, s2));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int LCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0)
			return 0;
		int arr[][] = new int[s1.length() + 1][s2.length() + 1];
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();
		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				if (c1[i] == c2[j]) {
					arr[i + 1][j + 1] = arr[i][j] + 1;
				} else {
					arr[i + 1][j + 1] = Math.max(arr[i][j + 1], arr[i + 1][j]);
				}
			}
		}

		return arr[s1.length()][s2.length()];
	}

}
