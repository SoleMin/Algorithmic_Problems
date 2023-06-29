import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int caseNum = input.nextInt();
		input.nextLine();
		
		for(int i = 0; i < caseNum; i++){
			int row = input.nextInt();
			int col = input.nextInt();
			input.nextLine();
			
			char[][] board = new char[row][col];
			for(int j = 0; j < row; j++){
				String s = input.nextLine().toLowerCase();
				for(int k = 0; k < col; k++)
					board[j][k] = s.charAt(k);
			}
			int num = input.nextInt();
			input.nextLine();
			
			for(int j = 0; j < num; j++){
				String name = input.nextLine().toLowerCase();
				int len = name.length();
				int rowCount = -1;
				int colCount = -1;
				for(int k = 0; k < row; k++){
					for(int l = 0; l < col; l++){
						if(name.charAt(0) == board[k][l]){
							boolean up = k + 1 >= len;
							boolean down = row - k >= len;
							boolean left = l + 1 >= len;
							boolean right = col - l >= len;
							if(up){
								boolean isFound = true;
								for(int m = 0; m < len; m++){
									if(name.charAt(m) != board[k - m][l]){
										isFound = false;
										break;
									}
								}
								if(isFound){
									rowCount = k + 1;
									colCount = l + 1;
									break;
								}
							}
							if(down){
								boolean isFound = true;
								for(int m = 0; m < len; m++){
									if(name.charAt(m) != board[k + m][l]){
										isFound = false;
										break;
									}
								}
								if(isFound){
									rowCount = k + 1;
									colCount = l + 1;
									break;
								}
							}
							if(left){
								boolean isFound = true;
								for(int m = 0; m < len; m++){
									if(name.charAt(m) != board[k][l - m]){
										isFound = false;
										break;
									}
								}
								if(isFound){
									rowCount = k + 1;
									colCount = l + 1;
									break;
								}
							}
							if(right){
								boolean isFound = true;
								for(int m = 0; m < len; m++){
									if(name.charAt(m) != board[k][l + m]){
										isFound = false;
										break;
									}
								}
								if(isFound){
									rowCount = k + 1;
									colCount = l + 1;
									break;
								}
							}
							if(up && left){
								boolean isFound = true;
								for(int m = 0; m < len; m++){
									if(name.charAt(m) != board[k - m][l - m]){
										isFound = false;
										break;
									}
								}
								if(isFound){
									rowCount = k + 1;
									colCount = l + 1;
									break;
								}
							}
							if(up && right){
								boolean isFound = true;
								for(int m = 0; m < len; m++){
									if(name.charAt(m) != board[k - m][l + m]){
										isFound = false;
										break;
									}
								}
								if(isFound){
									rowCount = k + 1;
									colCount = l + 1;
									break;
								}
							}
							if(down && left){
								boolean isFound = true;
								for(int m = 0; m < len; m++){
									if(name.charAt(m) != board[k + m][l - m]){
										isFound = false;
										break;
									}
								}
								if(isFound){
									rowCount = k + 1;
									colCount = l + 1;
									break;
								}
							}
							if(down && right){
								boolean isFound = true;
								for(int m = 0; m < len; m++){
									if(name.charAt(m) != board[k + m][l + m]){
										isFound = false;
										break;
									}
								}
								if(isFound){
									rowCount = k + 1;
									colCount = l + 1;
									break;
								}
							}
						}
					}
					if(rowCount != -1 && colCount != -1)
						break;
				}
				System.out.println(rowCount + " " + colCount);
			}
			System.out.println();
		}
		input.close();
	}
}