package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonElements {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n1 = Integer.parseInt(str[0]);
				int n2 = Integer.parseInt(str[1]);
				int n3 = Integer.parseInt(str[2]);
				int a[] = new int[n1];
				int b[] = new int[n2];
				int c[] = new int[n3];

				str = br.readLine().split("\\s+");
				for (int i = 0; i < n1; i++)
					a[i] = Integer.parseInt(str[i]);
				str = br.readLine().split("\\s+");
				for (int i = 0; i < n2; i++)
					b[i] = Integer.parseInt(str[i]);
				str = br.readLine().split("\\s+");
				for (int i = 0; i < n3; i++)
					c[i] = Integer.parseInt(str[i]);

				int i = 0, j = 0, k = 0;
				boolean flag = true;
				while (i < n1 && j < n2 && k < n3) {
					if (a[i] == b[j] && b[j] == c[k]) {
						flag = false;
						System.out.print(a[i] + " ");
						i++;
						while (i < n1 && a[i] == a[i - 1])
							i++;
						j++;
						while (j < n2 && b[j] == b[j - 1])
							j++;
						k++;
						while (k < n3 && c[k] == c[k - 1])
							k++;
					} else if (a[i] < b[j])
						i++;
					else if (b[j] < c[k])
						j++;
					else
						k++;
				}
				if (flag)
					System.out.println("-1");
				else
					System.out.println();

				t--;
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
