package jd2Homework03;

import java.util.Scanner;

public class SecondProblem {

	public static void main(String[] args) {
		System.out.println("Enter the word:");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next();
		String reverseWord = findReserveWord(word);
		String result = "This word is not Polindrom.";
		System.out.println("The reserve of '" + word + "' word is '" + reverseWord + "'.");
		if (word.equals(reverseWord)) {
			result = "This word is Polindrom.";
		}
		System.out.println(result);
	}

	private static String findReserveWord(String word) {
		String reverseWord = "";
		StringBuilder sb = new StringBuilder(reverseWord);
		String[] characterOfWord = word.split("");
		for (int i = 0; i < characterOfWord.length; i++) {
			sb.append(characterOfWord[characterOfWord.length - 1 - i]);
		}
		return sb.toString();
	}

}
