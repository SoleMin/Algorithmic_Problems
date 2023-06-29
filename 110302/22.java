import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int i = 0; i < testcase; i++) {
			int row_n = sc.nextInt();
			int column_n = sc.nextInt();
			String[] table = new String[row_n];
			sc.skip("\n");
			for(int row = 0; row < row_n; row++) {
				table[row] = sc.nextLine().toLowerCase();
			}
			int k = sc.nextInt();
			sc.nextLine();
			for(int j = 0; j < k; j++) {
				String word = sc.nextLine().toLowerCase();
				int w_len = word.length();
				
				for(int row = 0; row < row_n; row++) {
					int row_res = -1;
					int col_res = -1;
					for(int column = 0; column < column_n; column++) { 
						if(table[row].charAt(column) == word.charAt(0)) {
							boolean up = (row + 1) >= w_len;
							boolean down = (row_n - row ) >= w_len;
							boolean left = (column + 1) >= w_len;
							boolean right = (column_n - column ) >= w_len;
							boolean check = true;
							
							if(up) {
								for(int idx = 1; idx < w_len; idx++) {
									if(table[row-idx].charAt(column) != word.charAt(idx)) {
										check = false;
										break;
									}
								}
								if(check) {
									row_res = row;
									col_res = column;
									break;
								}
							}
	
							if(up&&right) {
								check = true;
								for(int idx = 1; idx < w_len; idx++) {
									if(table[row-idx].charAt(column+idx) != word.charAt(idx)) {
										check = false;
										break;
									}
								}
								if(check) {
									row_res = row;
									col_res = column;
									break;
								}
							}
							
							if(right) {
								check = true;
								for(int idx = 1; idx < w_len; idx++) {
									if(table[row].charAt(column+idx) != word.charAt(idx)) {
										check = false;
										break;
									}
								}
								if(check) {
									row_res = row;
									col_res = column;
									break;
								}
							}
							
							if(down&&right) {
								check = true;
								for(int idx = 1; idx < w_len; idx++) {
									if(table[row+idx].charAt(column+idx) != word.charAt(idx)) {
										check = false;
										break;
									}
								}
								if(check) {
									row_res = row;
									col_res = column;
									break;
								}
							}
							
							if(down) {
								check = true;
								for(int idx = 1; idx < w_len; idx++) {
									if(table[row+idx].charAt(column) != word.charAt(idx)) {
										check = false;
										break;
									}
								}
								if(check) {
									row_res = row;
									col_res = column;
									break;
								}
							}
							
							if(down&&left) {
								check = true;
								for(int idx = 1; idx < w_len; idx++) {
									if(table[row+idx].charAt(column-idx) != word.charAt(idx)) {
										check = false;
										break;
									}
								}
								if(check) {
									row_res = row;
									col_res = column;
									break;
								}
							}
							
							if(left) {
								check = true;
								for(int idx = 1; idx < w_len; idx++) {
									if(table[row].charAt(column-idx) != word.charAt(idx)) {
										check = false;
										break;
									}
								}
								if(check) {
									row_res = row;
									col_res = column;
									break;
								}
							}
							
							if(up&&left) {
								check = true;
								for(int idx = 1; idx < w_len; idx++) {
									if(table[row-idx].charAt(column-idx) != word.charAt(idx)) {
										check = false;
										break;
									}
								}
								if(check) {
									row_res = row;
									col_res = column;
									break;
								}
							}
						}
					}
					if(row_res != -1) {
						System.out.printf("%d %d\n",row_res+1,col_res+1);
						break;
					}
				}
			}
			System.out.println();
		}
		
	}
	
}