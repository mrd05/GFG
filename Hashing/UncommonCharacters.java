package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UncommonCharacters {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());

			while (t > 0) {
				String a = br.readLine();
				String b = br.readLine();

				int arr[] = new int[26];
				Arrays.fill(arr, 0);
				for (char c : a.toCharArray())
					arr[c - 'a'] = 1;

				for (char c : b.toCharArray()) {
					if (arr[c - 'a'] == 1)
						arr[c - 'a'] = 3;
					else if (arr[c - 'a'] == 0)
						arr[c - 'a'] = 2;
				}

				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 26; i++) {
					if (arr[i] != 0 && arr[i] != 3)
						sb.append((char) ('a' + i));

				}
				System.out.println(sb.toString());
				t--;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
