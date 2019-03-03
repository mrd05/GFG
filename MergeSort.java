package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int arr[] = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);
				mergeSort(arr, 0, n - 1);
				for (int i : arr)
					System.out.print(i + " ");
				System.out.println();
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	static void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	static void merge(int arr[], int l, int m, int r) {
		int a1[] = new int[m - l + 1];
		int a2[] = new int[r - m];
		for (int i = 0; i < m - l + 1; i++)
			a1[i] = arr[l + i];
		for (int i = 0; i < r - m; i++)
			a2[i] = arr[m + 1 + i];
		int i = 0, j = 0, index = l;
		while (i < m - l + 1 && j < r - m) {
			if (a1[i] < a2[j]) {
				arr[index++] = a1[i];
				i++;
			} else {
				arr[index++] = a2[j];
				j++;
			}
		}
		while (i < m - l + 1) {
			arr[index++] = a1[i];
			i++;
		}
		while (j < r - m) {
			arr[index++] = a2[j];
			j++;
		}
	}
}
