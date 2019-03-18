package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckIfStringIsRotatedByTwoPlaces {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String A = br.readLine();
				String B = br.readLine();
				System.out.println(rotateStringBetter(A, B) ? 1 : 0);
			}
			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static boolean rotateStringBetter(String A, String B) {
		if (A.length() != B.length())
			return false;
		String AB = A + A;
		if (AB.contains(B))
			return true;
		else
			return false;
	}

	public static boolean rotateString(String A, String B) {
		if (A.length() != B.length())
			return false;
		if (A.length() == 0)
			return true;
		if (A.length() == 1) {
			if (A.equals(B))
				return true;
			else
				return false;
		}

		char a[] = A.toCharArray();
		char b[] = new char[a.length];
		int i = 2;
		for (int j = 0; j < b.length; j++, i++) {
			if (i == b.length)
				i = 0;
			b[i] = a[j];
		}
		if (new String(b).equals(new String(B)))
			return true;

		b = new char[a.length];
		i = a.length - 2;
		for (int j = 0; j < b.length; j++, i++) {
			if (i == b.length)
				i = 0;
			b[i] = a[j];
		}
		if (new String(b).equals(new String(B)))
			return true;

		return false;
	}
}
