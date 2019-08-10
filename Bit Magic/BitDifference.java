package bitMagic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitDifference {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);

				int diff = 0;
				for (int i = 0; i < 32; i++) {
					if ((a & (1 << i)) != (b & (1 << i)))
						diff++;
				}
				System.out.println(diff);
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
