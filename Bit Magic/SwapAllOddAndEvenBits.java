package bitMagic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapAllOddAndEvenBits {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());

				int odd = n & 0xAAAAAAAA;
				int even = n & 0x55555555;

				odd = odd >> 1;
				even = even << 1;
				System.out.println(odd | even);

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
