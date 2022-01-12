package br.com.codenation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatisticUtil {

	public static int average(int[] elements) {
		int sum;
		int divisionBasis;
		int average;

		sum = Arrays.stream(elements).sum();
		divisionBasis = elements.length;
		average = sum / divisionBasis;

		return average;
	}

	public static int mode(int[] elements) {
		HashMap<Integer, Integer> duplicateValues = new HashMap<>();
		int result;

		for (int i = 0; i < elements.length; i++) {
			int count = 1;
			for (int j = 1; j < elements.length; j++) {
				if (elements[i] == elements[j]) {
					duplicateValues.put(elements[i], count ++ );
				}
			}
		}

		result = duplicateValues.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.get()
				.getKey();

		return result;
	}

	public static int median(int[] elements) {
		int middleValue = elements.length / 2;
		int result = 0;

		Arrays.sort(elements);

		if (elements.length % 2 == 1) {
			result = elements[middleValue];
		} else {
			result = (elements[middleValue - 1] + elements[middleValue]) / 2;
		}

		return result;
	}

	public static void main(String[] args) {
		int x = median(new int[]{-6, -5, -1, -3, -4, -2});

		System.out.println(x);
	}
}