import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int caseNum = input.nextInt();
		
		input.nextLine();
		input.nextLine();
		
		for(int a = 0; a < caseNum; a++) {
			int m = input.nextInt();
			int n = input.nextInt();
			
			char grid[][] = new char[m + 2][n + 2];
			
			input.nextLine();
			
			for(int i = 1; i < m + 1; i++) {
				String s = input.nextLine().toLowerCase();
				
				for(int j = 1; j < n + 1; j++)
					grid[i][j] = s.charAt(j - 1);
			}
			
			int w = input.nextInt();
			String word;
			
			input.nextLine();
			
			System.out.println();
			
			for(int i = 0; i < w; i++) {
				word = input.nextLine().toLowerCase();
				waldorf(grid, word);
			}
		}
		input.close();
	}
	
	public static void waldorf(char grid[][], String word) {
		for(int i = 1; i < grid.length - 1; i++) {
			for(int j = 1; j < grid[i].length - 1; j++) {
				if(grid[i][j] == word.charAt(0)) {
					if(waldorfFinder(grid, word, i, j)) {
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		}
	}
	
	public static boolean waldorfFinder(char grid[][], String word, int m, int n) {
		boolean check = false;
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				if(grid[m + i][n + j] == word.charAt(1)) {
					if(word.length() == 2)
						return true;
					int a, b;
					if(i == -1 && j == -1) {
						a = m + i - 1;
						b = n + j - 1;
						for(int k = 2; k < word.length(); k++) {
							if(grid[a][b] == word.charAt(k)) {
								a--;
								b--;
								check = true;
							}
							else {
								check = false;
								break;
							}
						}
					}
					else if(i == -1 && j == 0) {
						a = m + i - 1;
						b = n + j;
						for(int k = 2; k < word.length(); k++) {
							if(grid[a][b] == word.charAt(k)) {
								a--;
								check = true;
							}
							else {
								check = false;
								break;
							}
						}
					}
					else if(i == -1 && j == 1) {
						a = m + i - 1;
						b = n + j + 1;
						for(int k = 2; k < word.length(); k++) {
							if(grid[a][b] == word.charAt(k)) {
								a--;
								b++;
								check = true;
							}
							else {
								check = false;
								break;
							}
						}
					}
					else if(i == 0 && j == -1) {
						a = m + i;
						b = n + j - 1;
						for(int k = 2; k < word.length(); k++) {
							if(grid[a][b] == word.charAt(k)) {
								b--;
								check = true;
							}
							else {
								check = false;
								break;
							}
						}
					}
					else if(i == 0 && j == 1) {
						a = m + i;
						b = n + j + 1;
						for(int k = 2; k < word.length(); k++) {
							if(grid[a][b] == word.charAt(k)) {
								b++;
								check = true;
							}
							else {
								check = false;
								break;
							}
						}
					}
					else if(i == 1 && j == -1) {
						a = m + i + 1;
						b = n + j - 1;
						for(int k = 2; k < word.length(); k++) {
							if(grid[a][b] == word.charAt(k)) {
								a++;
								b--;
								check = true;
							}
							else {
								check = false;
								break;
							}
						}
					}
					else if(i == 1 && j == 0) {
						a = m + i + 1;
						b = n + j;
						for(int k = 2; k < word.length(); k++) {
							if(grid[a][b] == word.charAt(k)) {
								a++;
								check = true;
							}
							else {
								check = false;
								break;
							}
						}
					}
					else if(i == 1 && j == 1) {
						a = m + i + 1;
						b = n + j + 1;
						for(int k = 2; k < word.length(); k++) {
							if(grid[a][b] == word.charAt(k)) {
								a++;
								b++;
								check = true;
							}
							else {
								check = false;
								break;
							}
						}
					}
				}
				if(check)
					return check;
			}
		}
		return check;
	}
}