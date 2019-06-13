package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckIfFrequenciesCanBeEqual {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str = br.readLine();
				int arr[] = new int[26];
				for (char c : str.toCharArray())
					arr[c - 'a']++;
				boolean flag = checkSame(arr);

				if (!flag) {
					for (int i = 0; i < 26; i++) {
						if (arr[i] != 0) {
							arr[i]--;
							flag = checkSame(arr);
							if (flag)
								break;
							arr[i]++;
						}
					}
					System.out.println(flag ? 1 : 0);
				} else
					System.out.println("1");
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static boolean checkSame(int arr[]) {
		int freq = 0;
		int i = 0;
		for (; i < 26; i++) {
			if (arr[i] != 0) {
				freq = arr[i];
				break;
			}
		}
		for (int j = i + 1; j < 26; j++) {
			if (arr[j] != 0 && arr[j] != freq)
				return false;
		}

		return true;
	}
}
