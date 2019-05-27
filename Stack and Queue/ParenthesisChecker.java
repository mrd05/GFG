package stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesisChecker {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				String str = br.readLine();
				Stack<Character> st = new Stack<>();
				Map<Character, Character> map = new HashMap<>();
				map.put(')', '(');
				map.put(']', '[');
				map.put('}', '{');
				boolean flag = true;
				;
				for (char c : str.toCharArray()) {
					if (st.isEmpty())
						st.push(c);
					else {
						if (map.containsKey(c)) {
							if (!st.pop().equals(map.get(c))) {
								flag = false;
								break;
							}
						} else
							st.push(c);
					}
				}
				if (flag && st.isEmpty())
					System.out.println("balanced");
				else
					System.out.println("not balanced");

			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
