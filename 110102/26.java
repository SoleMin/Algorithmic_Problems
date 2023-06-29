import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] field = new char[n+2][m+2];
		String temp = "";
		int count = 0;
		int tonum = 1;
		
		while(n != 0 && m !=0) {
			for(int i = 1; i <= n; i++) {
				temp = sc.next();
				int a = 0;
				for (int k = 1; k <= m; k++) {
					field[i][k] = temp.charAt(a);
					a++;
				}
			}
			System.out.printf("Field #%d:\n", tonum);
			tonum++;
			
			for (int i = 1; i <= n; i++) {
				for (int k = 1; k <= m; k++) {
					count = 0;
					if (field[i][k] == '*') {
						System.out.print('*');
					} else {
						if (field[i-1][k-1] == '*') count++;
						if (field[i-1][k] == '*')	count++;
						if (field[i-1][k+1] == '*')	count++;
						if (field[i][k-1] == '*')	count++;
						if (field[i][k+1] == '*')	count++;
						if (field[i+1][k-1] == '*')	count++;
						if (field[i+1][k] == '*')	count++;
						if (field[i+1][k+1] == '*')	count++;
						System.out.print(count);
					}
				}
				System.out.println();
			}
			n = sc.nextInt();
			m = sc.nextInt();
			field = new char[n+2][m+2];
			System.out.println();
		}
		
	}
}