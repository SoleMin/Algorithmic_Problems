import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[][] array = new int[20][20];
		int n, m, index = 0;
		int i, j, tempI, tempJ = 0;
		String str = "";
		char temp;
		
		while(true) {
			n = input.nextInt();
			m = input.nextInt();
			if(n == 0 || m == 0)
				break;
			
			for(i = 0; i < n; i++) {
				str = input.next();
				for(j = 0; j < m; j++) {
					temp = str.charAt(j);
					if(temp == '*') {
						array[i][j] = 100;
						for(tempI = i-1; tempI < i+2; tempI++) {
							if(tempI < 0 || tempI >= n);
							else
								for(tempJ = j-1; tempJ < j+2; tempJ++) {
									if(tempJ < 0 || tempJ >= m || (tempJ == j && tempI == i));
									else
										array[tempI][tempJ]++;
								}
						}
					}
				}
			}
			
			System.out.print("Field #" + ++index + ":\n");
			for(i = 0; i < n; i++){
				for(j = 0; j < m; j++){
					if(array[i][j] >= 100)
						System.out.print("*");
					else
						System.out.print(array[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			
			array = new int[20][20];
		}
	}
}