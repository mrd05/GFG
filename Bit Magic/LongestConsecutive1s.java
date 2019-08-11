package bitMagic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestConsecutive1s {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());

				int max = 0;
				int cur = 0;
				for (int i = 0; i < 32; i++) {
					if ((n & (1 << i)) > 0) {
						cur++;
						max = Math.max(max, cur);
					} else
						cur = 0;
				}
				System.out.println(max);
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
