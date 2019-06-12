package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class FindFirstRepeatedCharacter {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str = br.readLine();
				Set<Character> set = new HashSet<>();
				boolean flag = true;
				for (char c : str.toCharArray()) {
					if (set.contains(c)) {
						flag = false;
						System.out.println(c);
						break;
					}
					set.add(c);
				}
				if (flag)
					System.out.println("-1");
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
