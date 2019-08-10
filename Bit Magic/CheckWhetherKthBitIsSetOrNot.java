package bitMagic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckWhetherKthBitIsSetOrNot {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				int k = Integer.parseInt(br.readLine());

				if ((n & (1 << k)) > 0)
					System.out.println("Yes");
				else
					System.out.println("No");
				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
