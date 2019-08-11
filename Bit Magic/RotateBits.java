package bitMagic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateBits {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int k = Integer.parseInt(str[1]);
				k = k % 16;

				/*int pow = k;
				int ans = 0;
				for (int i = 0; i < 16; i++) {
					if ((n & (1 << i)) > 0)
						ans += 1 << pow;
					pow = (pow + 1) % 16;
				}
				System.out.println(ans);

				pow = 15 - k;
				ans = 0;
				for (int i = 15; i >= 0; i--) {
					if ((n & (1 << i)) > 0)
						ans += 1 << pow;
					pow = (pow - 1 + 16) % 16;
				}
				System.out.println(ans);*/

				System.out
						.println(((n << k) & ((1 << 16) - 1)) | n >> (16 - k));
				System.out
						.println(n >> k | ((n << (16 - k)) & ((1 << 16) - 1)));

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
