import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int casenum = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i < casenum ; i++){
			scan.nextLine();
			int m = scan.nextInt();
			int n = scan.nextInt();
			scan.nextLine();
			int num = 0;
			char[][] grid = new char[m][n];
			String[] input = new String[m];
			for(int q = 0; q < m; q++){
				input[q] = scan.nextLine().toUpperCase();
			}
			for(int j = 0 ; j < m ; j ++){
				for(int k = 0 ; k < n ; k ++){
					grid[j][k] = input[j].charAt(num++); 
				}
				num = 0;
			}
			int linenum = scan.nextInt();
			scan.nextLine();
			for (int j = 0 ; j < linenum; j++ ){
				String line = scan.nextLine().toUpperCase();
				int M = -1;
				int N = -1;
				for(int row = 0 ; row < m ; row++) {
					for(int col = 0; col < n; col++){
						if(grid[row][col] == line.charAt(0)){
							int leng = line.length();
							if((row + 1) >= leng){ // 위 탐색
								boolean find = true;
								for(int k = 0; k < leng ; k++){
									if(line.charAt(k) != grid[row-k][col]) {
										find = false; 
										break;
									}
								}
								if(find) {
									M = row+1;
									N = col+1;
									break;
								}
							}
							if((m - row) >= leng ){ // 아래 탐색
								boolean find = true;
								for(int k = 0; k < leng; k++){
									if(line.charAt(k) != grid[row+k][col]){
										find = false; 
										break;
									}
								}
								if(find){
									M = row+1;
									N = col+1;
									break;
								}
							}
							if((col + 1) >= leng){ //왼쪽 탐색
								boolean find = true;
								for(int k = 0 ; k < leng ; k++){
									if(line.charAt(k) != grid[row][col-k]) {
										find = false; 
										break;
									}
								}
								if(find){
									M = row+1;
									N = col+1;
									break;
								}
							}
							if((n - col) >= leng){ // 오른쪽 탐색
								boolean find = true;
								for(int k = 0; k < leng ; k++){
									if(line.charAt(k) != grid[row][col+k]) {
										find = false;
										break;
									}
								}
								if(find) {
									M = row+1;
									N = col+1;
									break;
								}
							}
							if((row+1 )>= leng && (col +1) >= leng){
								boolean find = true;
								for(int k = 0; k < leng; k++){
									if(line.charAt(k) != grid[row-k][col-k]){
										find = false;
										break;
									}
								}
								if(find){
									M = row+1;
									N= col+1;
								}
							}
							if((row+1) >= leng && (n - col) >= leng){
								boolean find = true;
								for(int k = 0 ; k < leng; k++){
									if(line.charAt(k) != grid[row-k][col+k]) {
										find = false; 
										break;
									}
								}
								if(find){
									M = row +1;
									N = col +1;
								}
							}
							if((m - row) >= leng && (col + 1) >= leng){
								boolean find = true;
								for(int k=0; k< leng; k++){
									if(line.charAt(k) != grid[row+k][col-k]){
										find = false;
										break;
									}
								}
								if(find) {
									M = row+1;
									N = col+1;
									break;
								}
							}
							if((m-row) >= leng && (n - col) >= leng){
								boolean find = true;
								for(int k = 0; k < leng; k++){
									if(line.charAt(k) != grid[row+k][col+k]) {
										find = false; 
										break;
									}
								}
								if(find){
									M = row+1;
									N = col+1;
									break;
								}
							}
						}
					}
					if(M != -1 && N != -1)
						break;
				}
				System.out.println(M +" "+ N);
			}
			System.out.println();
		}
	}
}