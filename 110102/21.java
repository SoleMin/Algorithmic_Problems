import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int fieldNumber = 0;
		
		while(input.hasNextLine()) {
			
			int n = input.nextInt();
			int m = input.nextInt();
			
			if(n == 0 && m == 0)
				break;
			else
				fieldNumber++;
			
			char [][] mine = new char[n + 2][m + 2];
			
			for(int i = 0; i < n; i++) {
				String temp = input.next();
				for(int j = 0; j < m; j++) 
					mine[i + 1][j + 1] = temp.charAt(j);
			}
			
			System.out.println("Field #" + fieldNumber + ":");
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					int count = 0;
					if(mine[i + 1][j + 1] == '*')
						System.out.print('*');
					else {
						for(int k = 0; k < 3; k++)
							for(int l = 0; l < 3; l++)
								if(mine[i + k][j + l] == '*')
									count++;
						System.out.print(count);
					}
				}
				System.out.println();
			}
			System.out.println();
		}
		input.close();
	}
}