import java.io.*;
import java.util.Scanner;

class Main {
	
	static int[][] puzzle;
	static String[] movedRoot;
	static String print;
	static int min;
	final static int[] SOLVED = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			11, 12, 13, 14, 15, 0 };
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());
		for(int r=0; r<repeat; r++) {
			// puzzle[0] 초기화
			puzzle = new int[51][16];
			movedRoot = new String[51];
			movedRoot[0] = "";
			for(int i=0; i<4; i++) {
				String[] split = input.nextLine().split("\\s+");
				for(int j=0; j<4; j++)
					puzzle[0][4*i + j] = Integer.parseInt(split[j]);
			}

			System.out.println(move());
		}
		input.close();
	}
	
	public static String move() {
		min = 51;
		if(!isAble())
			return "This puzzle is not solvable.";
		if(isCorrectPuzzle(0))
			return "";
		move(0);
		if(min == 51)
			return "This puzzle is not solvable.";
		else
			return print;
	}

	static int count = 0;
	public static void move(int moveCount) {
		if(moveCount >= min || moveCount == 50)
			return;
		if(moveCount + leastMove(moveCount) >= min)
			return;
		
		int index = 0;
		for(int i=0; i<16; i++)
			if(puzzle[moveCount][i] == 0) {
				index = i; break;
			}

		int next = moveCount + 1;
		for(int i=0; i<16; i++)
			puzzle[next][i] = puzzle[moveCount][i];

		char lastMove = 'O';
		if(moveCount != 0)
			movedRoot[moveCount].charAt(moveCount-1);

		if(index > 3 && lastMove != 'D') {
			movedRoot[next] = movedRoot[moveCount] + "U";
			exchange(puzzle[next], index, index-4);
			if(isCorrectPuzzle(next)) {
				print = movedRoot[next];
				min = next;
				return;
			}
			move(next);
			exchange(puzzle[next], index, index-4);
		}

		if(index%4 != 3 && lastMove != 'L') {
			movedRoot[next] = movedRoot[moveCount] + "R";
			exchange(puzzle[next], index, index+1);
			if(isCorrectPuzzle(next)) {
				print = movedRoot[next];
				min = next;
				return;
			}
			move(next);
			exchange(puzzle[next], index, index+1);
		}

		if(index%4 != 0 && lastMove != 'R') {
			movedRoot[next] = movedRoot[moveCount] + "L";
			exchange(puzzle[next], index, index-1);
			if(isCorrectPuzzle(next)) {
				print = movedRoot[next];
				min = next;
				return;
			}
			move(next);
			exchange(puzzle[next], index, index-1);
		}

		if(index < 12 && lastMove != 'U') {
			movedRoot[next] = movedRoot[moveCount] + "D";
			exchange(puzzle[next], index, index+4);
			if(isCorrectPuzzle(next)) {
				print = movedRoot[next];
				min = next;
				return;
			}
			move(next);
			exchange(puzzle[next], index, index+4);
		}


	}

	public static boolean isCorrectPuzzle(int next) {
		for(int i=0; i<16; i++)
			if(SOLVED[i] != puzzle[next][i])
				return false;
		return true;
	}

	public static void exchange(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int leastMove(int currentCount) {
		int count = 0;
		int n;
		for(int i=0; i<16; i++)
			if(puzzle[currentCount][i] != 0) {
				n = puzzle[currentCount][i]-1;
				count += Math.abs(n/4 - i/4);
				count += Math.abs(n%4 - i%4);
			}
		return count;
	}
	
	public static boolean isAble() {
		int count = 0;
		int zeroPosition = 0;
		for(int i=0; i<16; i++) {
			if(puzzle[0][i] != 0) {
				for(int j=i+1; j<16; j++) {
					if(puzzle[0][j] != 0)
						if(puzzle[0][i] > puzzle[0][j])
							count++;
				}
			}
			else {
				zeroPosition = i/4;
			}
		}

		if((count + zeroPosition)%2 != 0)
			return true;
		return false;
	}
}