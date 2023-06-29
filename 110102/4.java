import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int field_num = 1;
		int row;
		int col;
		char [][] array;
		
		while(true) {
			row = scan.nextInt();
			col = scan.nextInt();
			scan.nextLine();
			if(row == 0 && col == 0)
				break;
			
			array = new char[row][col];
			for(int i = 0; i < row; i++) {
				String s = scan.nextLine();
				for(int j = 0; j< col; j++) {
					if(s.charAt(j) == '.')
						array[i][j] = '0';
					else
						array[i][j] = s.charAt(j);
				}
			}
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					if(array[i][j] == '0') {
						if(i != 0 && j != 0 && array[i - 1][j - 1] == '*')
							array[i][j]++;
						if(i != 0 && array[i - 1][j] == '*')
							array[i][j]++;
						if(i != 0 && j != col - 1 && array[i - 1][j + 1] == '*')
							array[i][j]++;
						if(j != 0 && array[i][j - 1] == '*')
							array[i][j]++;
						if(j != col - 1 && array[i][j + 1] == '*')
							array[i][j]++;
						if(i != row - 1 && j != 0 && array[i + 1][j - 1] == '*')
							array[i][j]++;
						if(i != row - 1 && array[i + 1][j] == '*')
							array[i][j]++;
						if(i != row - 1 && j != col - 1 && array[i + 1][j + 1] == '*')
							array[i][j]++;
					}
				}
			}
			
			System.out.println();
			System.out.println("Field #" + field_num++ + ":");
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					System.out.print(array[i][j]);
				}
				System.out.println();
			}
		}
		scan.close();
		System.out.println();
	}
}