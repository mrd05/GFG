package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImplementAtoi {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String s = br.readLine();
				System.out.println(myAtoi(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int myAtoi(String str) {
		if (str.length() == 0)
			return 0;
		char arr[] = str.toCharArray();

		int i = 0;
		for (; i < arr.length; i++) {
			if (arr[i] != ' ')
				break;
		}
		if (i == arr.length)
			return 0;
		int sign = 0;
		if (arr[i] == '+' || arr[i] == '-') {
			if (i + 1 == arr.length)
				return 0;
			sign = i;
			i++;
		}
		int sum = 0;
		while (i < arr.length) {
			if (arr[i] < '0' || arr[i] > '9')
				break;
			if (sum > (Integer.MAX_VALUE - (arr[i] - '0')) / 10) {
				if (arr[sign] == '-')
					return Integer.MIN_VALUE;
				return Integer.MAX_VALUE;
			}
			sum = sum * 10 + arr[i] - '0';
			i++;
		}
		if (arr[sign] == '-')
			sum = -sum;
		return sum;
	}

}
