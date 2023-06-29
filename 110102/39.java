import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int[] x = {1, -1, 1, -1, 1, -1, 0, 0};
		int[] y = {1, 1, -1, -1, 0, 0, 1, -1};
		int f = 1;
		int n; int m; String line;
		
		while(true)
		{
			n = scan.nextInt();
			m = scan.nextInt();
			if(n == 0 || m == 0) break;
			
			char[][] field = new char[n][m];
			int[][] result = new int[n][m];
			int x_move; int y_move;
			for(int i = 0; i < n; i++) {
				line = scan.next();
				field[i] = line.toCharArray();
				for(int j = 0; j < m; j++) {
					if(field[i][j] == '*'){
						for(int k = 0; k < 8; k++) {
							x_move = i + x[k];
							if((x_move >= n) || (x_move < 0)) continue;
							y_move = j + y[k];
							if((y_move >= m) || (y_move < 0)) continue;
							result[x_move][y_move] += 1;
						}
					}
				}
			}
			
			//출력
			System.out.println("Field #" + f + ":");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(field[i][j] == '*') System.out.print('*');
					else System.out.print(result[i][j]);
				}
				System.out.println();
			}
			
			f++;
			System.out.println();
		}
	}
}