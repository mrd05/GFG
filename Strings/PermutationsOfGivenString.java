package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsOfGivenString {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String str = br.readLine();
				// Arrays.sort(arr);
				List<String> list = new ArrayList<>();
				permute(str, 0, str.length() - 1, list);
				Collections.sort(list);
				for (String s : list)
					System.out.print(s + " ");
				System.out.println();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void permute(String str, int l, int r, List<String> list) {
		if (l == r)
			list.add(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r, list);
				str = swap(str, l, i);
			}
		}
	}

	public static String swap(String str, int l, int i) {
		char[] arr = str.toCharArray();
		char t = arr[i];
		arr[i] = arr[l];
		arr[l] = t;
		return String.valueOf(arr);
	}
}
