package bitMagic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerOf2 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				long n = Long.parseLong(br.readLine());

				int ones = 0;
				for (int i = 0; i < 64; i++) {
					if ((n & ((long) 1 << i)) > 0)
						ones++;
				}
				if (ones == 1)
					System.out.println("YES");
				else
					System.out.println("NO");
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
