package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String str[] = br.readLine().split("\\s+");
				int s1[] = new int[128];
				int s2[] = new int[128];
				for (char c : str[0].toCharArray())
					s1[c]++;
				for (char c : str[1].toCharArray())
					s2[c]++;

				int i = 0;
				for (; i < 128; i++) {
					if (s1[i] != s2[i]) {
						System.out.println("NO");
						break;
					}
				}
				if (i == 128)
					System.out.println("YES");
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}