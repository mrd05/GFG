package strings;

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
			for (int x = 0; x < t; x++) {
				char ch[] = br.readLine().toCharArray();
				Stack<Character> st = new Stack<>();
				Map<Character, Character> map = new HashMap<>();
				map.put(')', '(');
				map.put(']', '[');
				map.put('}', '{');
				for (char c : ch) {
					if (st.isEmpty()) {
						st.push(c);
					} else {
						if (st.peek().equals(map.get(c))) {
							st.pop();
						} else {
							st.push(c);
						}
					}
				}
				if (st.isEmpty())
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
