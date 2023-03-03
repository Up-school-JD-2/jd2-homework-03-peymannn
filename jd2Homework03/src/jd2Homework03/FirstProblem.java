package jd2Homework03;

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
		while (whichPlayer > records.length || 1 > whichPlayer) {
			System.out.println("can be played with at least 1 person at most 5, try again");
			whichPlayer = scanner.nextInt();
		}

		//assign player
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

				//assign score
				records[whichPlayer - 1][whichGame] = ++count;

				showRecordTable();
				
				if (whichGame+1 < records.length || whichGame+1<records[0].length) {
					initializeGame();
					count = 0;
				}else
					break;

			}

		} while (true);

	}
	
	private static void showRecordTable() {
		System.out.println("Record Table");
		System.out.println("Player   Scores");
		for (int i = 0; i < records.length; i++) {
			System.out.print("   " + records[i][0] + "   ");
			for (int j = 1; j < records[i].length; j++) {
				System.out.print("   " + records[i][j]);
			}
			System.out.println();
		}
	}

}
