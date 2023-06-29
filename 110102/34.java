
import java.util.Objects;
import java.util.Scanner;
class Main {
	
	static char[][] inputBoard;
	static String[][] outputBoard;
	static int cnt = 1;
	static Scanner sc = new Scanner(System.in);
	
	public static void initBoard(int row, int col) {
		
		inputBoard = new char[row][col];
		outputBoard = new String[row][col];
		
		for (int i = 0; i < row; i++) {
			String temp = sc.next();
			for (int j = 0; j < col; j++) {
				inputBoard[i][j] = temp.charAt(j);
				outputBoard[i][j] = "0";
				if (inputBoard[i][j] != '.') {
					outputBoard[i][j] = "*";
				}
			}
		}
	}
	
	public static void printBoard(int row, int col) {
		System.out.println("Field #" + cnt + ":");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(outputBoard[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void checkBoard(int row, int col) {
		for(int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(!Objects.equals(outputBoard[i][j], "*")) {
					for (int k = i - 1; k <= i + 1; k++) {
						for (int l = j - 1; l <= j + 1; l++) {
							if (k >= 0 && k < row && l >= 0 && l < col && Objects.equals(outputBoard[k][l], "*")) {
								outputBoard[i][j] = Integer.toString(Integer.parseInt(outputBoard[i][j]) + 1);
							}
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		
		while (true) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			if (row == 0 || col == 0)
				break;
			initBoard(row, col);
			checkBoard(row, col);
			printBoard(row, col);
			cnt++;
		}
		cnt = 0;
	}
}