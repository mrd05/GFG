package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KadanesAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int t = Integer.parseInt(br.readLine());
			for (int i = 1; i <= t; i++) {
				int n = Integer.parseInt(br.readLine());
				int[] arr = new int[n];
				String str[] = br.readLine().split(" ");

				for (int j = 0; j < n; j++)
					arr[j] = Integer.parseInt(str[j]);

				int msf = arr[0];
				int ste = arr[0];
				for (int j = 1; j < n; j++) {
					if (arr[j] > ste + arr[j])
						ste = arr[j];
					else
						ste = ste + arr[j];
					if (msf < ste)
						msf = ste;
				}
				System.out.println(msf);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
