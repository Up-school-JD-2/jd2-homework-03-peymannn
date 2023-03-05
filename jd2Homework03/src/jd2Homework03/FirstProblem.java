package jd2Homework03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FirstProblem {
	static int whichGame = 0;
	static int whichPlayer = 0;
	static int randomNumber;
	static int[][] records;

	public static void main(String[] args) {
		records = new int[5][6];
		initializeGame();
		guessGame();
	}

	public static void initializeGame() {
		System.out.println("\nInitializing " + ++whichGame + ". Game ");

		System.out.println("which player");
		Scanner scanner = new Scanner(System.in);
		whichPlayer = scanner.nextInt();

		if ((whichGame > records.length || whichPlayer > records.length)) {
			extandRecordTable();
		}
		// assign player
		records[whichPlayer - 1][0] = whichPlayer;

		Random random = new Random();
		randomNumber = random.nextInt(100);

		System.out.println("\n Enter a number from 1-100 " + randomNumber);
	}

	private static void guessGame() {
		int number;
		int count = 0;
		do {
			Scanner scanner = new Scanner(System.in);
			number = scanner.nextInt();

			if (randomNumber > number) {
				System.out.println("Too low, try again");
				count++;
			} else if (randomNumber < number) {
				System.out.println("Too high, try again");
				count++;
			} else if (randomNumber == number) {
				System.out.println("Bingooo  " + randomNumber);

				// assign score
				records[whichPlayer - 1][whichGame] = ++count;

				showRecordTable();

				if (whichGame + 1 > records.length || whichPlayer > records.length) {
					extandRecordTable();
				}
				initializeGame();
				count = 0;

			}

		} while (true);

	}

	private static void showRecordTable() {
		System.out.println("Record Table");
		System.out.println("Player   Scores");
		for (int i = 0; i < records.length; i++) {
			
			System.out.printf("   %02d   ",records[i][0]);
			for (int j = 1; j < records[i].length; j++) {
				System.out.printf("   %02d", records[i][j]);				
			}
			System.out.println();
		}
	}

	private static void extandRecordTable() {
		int[][] copyRecords = new int[records.length + 5][records[0].length + 5];

		// 2D dizi kopyalama işlemi
		for (int i = 0; i < records.length; i++) {
			System.arraycopy(records[i], 0, copyRecords[i], 0, records[i].length);
		}

		records = copyRecords;
	}

}
