package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String str = br.readLine();
				Set<Character> set = new HashSet<>();
				StringBuilder sb = new StringBuilder();
				for (char c : str.toCharArray()) {
					if (!set.contains(c)) {
						sb.append(c);
						set.add(c);
					}
				}
				System.out.println(sb.toString());
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
