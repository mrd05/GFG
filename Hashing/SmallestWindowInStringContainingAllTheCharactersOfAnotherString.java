package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestWindowInStringContainingAllTheCharactersOfAnotherString {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String a = br.readLine();
				String b = br.readLine();
				if (a.length() < b.length()) {
					System.out.println(-1);
					t--;
					continue;
				}
				int ah[] = new int[256];
				int bh[] = new int[256];

				for (char c : b.toCharArray())
					bh[c]++;

				int start = 0, si = -1, count = 0, len = Integer.MAX_VALUE;
				for (int i = 0; i < a.length(); i++) {
					ah[a.charAt(i)]++;

					if (bh[a.charAt(i)] != 0
							&& ah[a.charAt(i)] <= bh[a.charAt(i)])
						count++;

					if (count == b.length()) {

						while (bh[a.charAt(start)] == 0
								|| ah[a.charAt(start)] > bh[a.charAt(start)]) {
							if (ah[a.charAt(start)] > bh[a.charAt(start)])
								ah[a.charAt(start)]--;
							start++;
						}

						int length = i - start + 1;
						if (len > length) {
							len = length;
							si = start;
						}
					}

				}

				if (si == -1)
					System.out.println(-1);
				else
					System.out.println(a.substring(si, si + len));

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
