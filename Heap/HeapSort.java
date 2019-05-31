package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HeapSort {
	void printArray(int arr[], int n) {
		// int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			while (T > 0) {
				int n = Integer.parseInt(br.readLine());
				String str[] = br.readLine().split("\\s+");
				int arr[] = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = Integer.parseInt(str[i]);
				HeapSort hs = new HeapSort();
				hs.heapSort(arr, n);
				hs.printArray(arr, n);
				T--;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void heapSort(int arr[], int n) {
		GfG g = new GfG();
		g.buildHeap(arr, n);
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			g.heapify(arr, i, 0);
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given
	 * below
	 */
	static class GfG {
		void buildHeap(int arr[], int n) {
			for (int i = n / 2 - 1; i >= 0; i--)
				heapify(arr, n, i);
			/*for (int i = n - 1; i >= 0; i--) {
				int t = arr[0];
				arr[0] = arr[i];
				arr[i] = t;

				heapify(arr, i, 0);
			}*/
		}

		// To heapify a subtree rooted with node i which is
		// an index in arr[]. n is size of heap
		void heapify(int arr[], int n, int i) {
			int largest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;
			if (l < n && arr[l] > arr[largest])
				largest = l;
			if (r < n && arr[r] > arr[largest])
				largest = r;
			if (largest != i) {
				int t = arr[largest];
				arr[largest] = arr[i];
				arr[i] = t;
				heapify(arr, n, largest);
			}
		}
	}
}