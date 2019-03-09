package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWordsInGivenString {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String str[] = br.readLine().split("\\.");
				String res = "";
				for (int i = str.length - 1; i >= 0; i--)
					res += str[i] + ".";
				if (res.length() == 0)
					System.out.println(res);
				else
					System.out.println(res.substring(0, res.length() - 1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
