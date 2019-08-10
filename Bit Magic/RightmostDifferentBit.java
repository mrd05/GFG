package bitMagic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RightmostDifferentBit {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				int i = 0;
				for (; i < 32; i++) {
					if ((a & (1 << i)) != (b & (1 << i)))
						break;
				}
				if (i != 32)
					System.out.println(i + 1);
				else
					System.out.println(0);
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
