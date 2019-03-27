package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormPalindrome {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				char[] s = br.readLine().toCharArray();

				// System.out.println(minPalin(s, 0, s.length - 1));
				int arr[][] = new int[s.length][s.length];
				for (int i = 0; i < s.length; i++)
					arr[i][i] = 0;
				for (int i = 1; i < s.length; i++) {
					for (int j = 0; j < s.length - i; j++) {
						if (s[j] == s[i + j])
							arr[j][i + j] = arr[j + 1][i + j - 1];
						else
							arr[j][i + j] = Math.min(arr[j][i + j - 1],
									arr[j + 1][i + j]) + 1;
					}
				}
				System.out.println(arr[0][s.length - 1]);
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static int minPalin(char[] s, int l, int r) {
		if (l > r)
			return 0;
		if (s[l] == s[r])
			return minPalin(s, l + 1, r - 1);
		else
			return Math.min(minPalin(s, l + 1, r), minPalin(s, l, r - 1)) + 1;
	}
}
