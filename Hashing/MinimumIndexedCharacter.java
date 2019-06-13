package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MinimumIndexedCharacter {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str = br.readLine();
				String patt = br.readLine();
				Map<Character, Integer> map = new HashMap<>();
				for (int i = 0; i < str.length(); i++) {
					if (!map.containsKey(str.charAt(i)))
						map.put(str.charAt(i), i);
				}
				int min = Integer.MAX_VALUE;
				boolean flag = true;
				for (char c : patt.toCharArray()) {

					if (map.containsKey(c)) {
						min = Math.min(min, map.get(c));
						flag = false;
					}
				}
				if (flag)
					System.out.println("$");
				else
					System.out.println(str.charAt(min));

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
