package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllFourSumNumbers {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t > 0) {
				String str[] = br.readLine().split("\\s+");
				int n = Integer.parseInt(str[0]);
				int x = Integer.parseInt(str[1]);
				int arr[] = new int[n];
				str = br.readLine().split("\\s+");
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);
				Arrays.sort(arr);

				List<List<Integer>> list = new ArrayList<>();
				for (int i = 0; i < arr.length - 3; i++) {
					if (i > 0 && arr[i] == arr[i - 1])
						continue;
					for (int j = i + 1; j < arr.length - 2; j++) {
						if (j > i + 1 && arr[j] == arr[j - 1])
							continue;
						int l = j + 1;
						int r = arr.length - 1;
						while (l < r) {
							int sum = arr[i] + arr[j] + arr[l] + arr[r];
							// System.out.println(i+" "+j+" "+l+" "+r+" "+sum+" "+target);
							if (sum == x) {
								list.add(Arrays.asList(arr[i], arr[j], arr[l],
										arr[r]));
								while (l + 1 < r && arr[l + 1] == arr[l])
									l++;
								while (r - 1 > l && arr[r - 1] == arr[r])
									r--;
								l++;
								r--;
							} else if (sum < x)
								l++;
							else
								r--;
						}

					}
				}

				for (List<Integer> li : list) {
					for (int a : li)
						System.out.print(a + " ");
					System.out.print("$");
				}
				if (list.isEmpty())
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
