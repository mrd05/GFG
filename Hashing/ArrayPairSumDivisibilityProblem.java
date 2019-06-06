package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayPairSumDivisibilityProblem {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s");
				int arr[] = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);
				int k = Integer.parseInt(br.readLine());

				t--;
			}
			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
