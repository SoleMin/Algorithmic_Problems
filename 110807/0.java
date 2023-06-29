import java.io.*;
import java.util.Scanner;

class Main {
	
	static int[][] puzzle;
	static String[] movedRoot;
	static String print;
	static int min;
	final static int[] SOLVED = { 
			0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1
	};
	static int[][] leastMoveGraph = {
			{0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
			{1, 1, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 1, 1},
			{1, 2, 2, 3, 3, 2, 2, 1, 1, 0, 0, 0, 1, 1, 2, 2, 3, 3, 2, 2, 1},
			{0, 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 1, 3, 2, 4, 3, 5, 4, 4, 3, 3},
			{1, 0, 0, 0, 1, 1, 2, 2, 3, 3, 2, 2, 3, 3, 4, 4, 5, 5, 4, 4, 3},
			{2, 2, 1, 1, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 3, 3, 2, 2},
			{3, 2, 2, 1, 1, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 3, 4, 2, 3},
			{2, 2, 3, 3, 4, 4, 3, 3, 2, 2, 1, 1, 0, 0, 0, 0, 0, 1, 1, 2, 2},
			{3, 2, 4, 3, 5, 4, 4, 3, 3, 2, 2, 1, 1, 0, 0, 0, 1, 1, 2, 2, 3},
			{3, 3, 4, 4, 5, 3, 4, 2, 3, 1, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0},
			{3, 4, 4, 5, 5, 4, 4, 3, 3, 2, 2, 3, 3, 2, 2, 1, 1, 0, 0, 0, 1}
	};
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());
		for(int r=0; r<repeat; r++) {
			// puzzle[0] 초기화
			puzzle = new int[17][24];
			movedRoot = new String[17];
			movedRoot[0] = "";

			String[] split = input.nextLine().split("\\s+");
			for(int i=0; i<24; i++)
				puzzle[0][i] = Integer.parseInt(split[i]);

			System.out.println(move());
		}
		input.close();
	}
	
	public static String move() {
		min = 17;
		if(isCorrectPuzzle(0))
			return "PUZZLE ALREADY SOLVED";
		move(0);
		if(min == 17)
			return "NO SOLUTION WAS FOUND IN 16 STEPS";
		else 
			return print;
	}

	public static void move(int moveCount) {
		if(moveCount >= min || moveCount == 16)
			return;
		if(moveCount + leastMove(moveCount) >= min)
			return;

		int next = moveCount + 1;
		for(int i=0; i<24; i++)
			puzzle[next][i] = puzzle[moveCount][i];

		int lastMove = 0;
		if(moveCount != 0)
			lastMove = movedRoot[moveCount].charAt(moveCount-1) - 48;

		if(lastMove != 3) {
			movedRoot[next] = movedRoot[moveCount] + "1";
			leftWheelSpin(next);
			if(isCorrectPuzzle(next)) {
				print = movedRoot[next];
				min = next;
				return;
			}
			move(next);
			leftWheelReverseSpin(next);
		}

		if(lastMove != 4) {
			movedRoot[next] = movedRoot[moveCount] + "2";
			rightWheelSpin(next);
			if(isCorrectPuzzle(next)) {
				print = movedRoot[next];
				min = next;
				return;
			}
			move(next);
			rightWheelReverseSpin(next);
		}

		if(lastMove != 1) {
			movedRoot[next] = movedRoot[moveCount] + "3";
			leftWheelReverseSpin(next);
			if(isCorrectPuzzle(next)) {
				print = movedRoot[next];
				min = next;
				return;
			}
			move(next);
			leftWheelSpin(next);
		}

		if(lastMove != 2) {
			movedRoot[next] = movedRoot[moveCount] + "4";
			rightWheelReverseSpin(next);
			if(isCorrectPuzzle(next)) {
				print = movedRoot[next];
				min = next;
				return;
			}
			move(next);
			rightWheelSpin(next);
		}
	}

	public static boolean isCorrectPuzzle(int next) {
		for(int i=0; i<24; i++)
			if(SOLVED[i] != puzzle[next][i])
				return false;
		return true;
	}

	public static void leftWheelSpin(int next) {
		int tempA = puzzle[next][10], tempB = puzzle[next][11];
		for(int i=10; i>=2; i-=2) {
			puzzle[next][i] = puzzle[next][i-2];
			puzzle[next][i+1] = puzzle[next][i-1];
		}
		puzzle[next][0] = tempA;
		puzzle[next][1] = tempB;

		puzzle[next][21] = puzzle[next][9];
		puzzle[next][22] = puzzle[next][10];
		puzzle[next][23] = puzzle[next][11];
	}

	public static void rightWheelSpin(int next) {
		int tempA = puzzle[next][12], tempB = puzzle[next][13];
		for(int i=14; i<=22; i+=2) {
			puzzle[next][i-2] = puzzle[next][i];
			puzzle[next][i-1] = puzzle[next][i+1];
		}
		puzzle[next][22] = tempA;
		puzzle[next][23] = tempB;

		puzzle[next][9] = puzzle[next][21];
		puzzle[next][10] = puzzle[next][22];
		puzzle[next][11] = puzzle[next][23];
	}

	public static void leftWheelReverseSpin(int next) {
		int tempA = puzzle[next][0], tempB = puzzle[next][1];
		for(int i=2; i<12; i+=2) {
			puzzle[next][i-2] = puzzle[next][i];
			puzzle[next][i-1] = puzzle[next][i+1];
		}
		puzzle[next][10] = tempA;
		puzzle[next][11] = tempB;

		puzzle[next][21] = puzzle[next][9];
		puzzle[next][22] = puzzle[next][10];
		puzzle[next][23] = puzzle[next][11];
	}

	public static void rightWheelReverseSpin(int next) {
		int tempA = puzzle[next][22], tempB = puzzle[next][23];
		for(int i=22; i>12; i-=2) {
			puzzle[next][i] = puzzle[next][i-2];
			puzzle[next][i+1] = puzzle[next][i-1];
		}
		puzzle[next][12] = tempA;
		puzzle[next][13] = tempB;

		puzzle[next][9] = puzzle[next][21];
		puzzle[next][10] = puzzle[next][22];
		puzzle[next][11] = puzzle[next][23];
	}

	public static int leastMove(int currentCount) {
		int max = 0;
		int min, n=0;
		for(int i=0; i<21; i++){
			n = puzzle[currentCount][i];
			min = leastMoveGraph[n][i];	// 숫자 n이 i번째 위치에 있을 경우 최소 이동수
			if(max < min)
				max = min;

		}
		return max;
	}
}