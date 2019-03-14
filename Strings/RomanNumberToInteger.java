package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RomanNumberToInteger {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				String str = br.readLine();
				System.out.println(romanToInt(str));
			}

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static int romanToInt1(String s) {
		if (s.length() == 0)
			return 0;
		char arr[] = s.toCharArray();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (i + 1 < arr.length) {
				switch (arr[i]) {
				case 'I':
					if (arr[i + 1] == 'V') {
						map.put(4, map.getOrDefault(4, 0) + 1);
						i++;
					} else if (arr[i + 1] == 'X') {
						map.put(9, map.getOrDefault(9, 0) + 1);
						i++;
					} else
						map.put(1, map.getOrDefault(1, 0) + 1);
					break;
				case 'V':
					map.put(5, map.getOrDefault(5, 0) + 1);
					break;
				case 'X':
					if (arr[i + 1] == 'L') {
						map.put(40, map.getOrDefault(40, 0) + 1);
						i++;
					} else if (arr[i + 1] == 'C') {
						map.put(90, map.getOrDefault(90, 0) + 1);
						i++;
					} else
						map.put(10, map.getOrDefault(10, 0) + 1);
					break;
				case 'L':
					map.put(50, map.getOrDefault(50, 0) + 1);
					break;
				case 'C':
					if (arr[i + 1] == 'D') {
						map.put(400, map.getOrDefault(400, 0) + 1);
						i++;
					} else if (arr[i + 1] == 'M') {
						map.put(900, map.getOrDefault(900, 0) + 1);
						i++;
					} else
						map.put(100, map.getOrDefault(100, 0) + 1);
					break;
				case 'D':
					map.put(500, map.getOrDefault(500, 0) + 1);
					break;
				case 'M':
					map.put(1000, map.getOrDefault(1000, 0) + 1);
					break;
				}
			} else {
				switch (arr[i]) {
				case 'I':
					map.put(1, map.getOrDefault(1, 0) + 1);
					break;
				case 'V':
					map.put(5, map.getOrDefault(5, 0) + 1);
					break;
				case 'X':
					map.put(10, map.getOrDefault(10, 0) + 1);
					break;
				case 'L':
					map.put(50, map.getOrDefault(50, 0) + 1);
					break;
				case 'C':
					map.put(100, map.getOrDefault(100, 0) + 1);
					break;
				case 'D':
					map.put(500, map.getOrDefault(500, 0) + 1);
					break;
				case 'M':
					map.put(1000, map.getOrDefault(1000, 0) + 1);
					break;
				}
			}
		}
		int sum = 0;
		for (int a : map.keySet()) {
			sum += a * map.get(a);
		}
		return sum;
	}

	public static int romanToInt(String s) {
		if (s.length() == 0)
			return 0;
		char arr[] = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i + 1 < arr.length) {
				int a = map.get(arr[i]);
				int b = map.get(arr[i + 1]);
				if (a >= b) {
					sum += a;
				} else {
					sum += b - a;
					i++;
				}

			} else {
				sum += map.get(arr[i]);
			}
		}

		return sum;
	}
}
