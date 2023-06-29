import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int row = 0, column = 0, count = 0;
		int i = -1;
		int[][] intArr = new int[10][10];
			
		while(input.hasNextLine()) {
			String str = input.nextLine();
			char ch = str.charAt(0);
			
			if(ch == '0') break;
			if('0'<ch && ch<='9') {
				i = -1;
				row = ch - '0';
				column = str.charAt(2) - '0';
				intArr = new int[row][column];
				
				count++;
				System.out.println("Field #" + count + ":");
			}
			else {
				i++;
				for(int j=0; j<column; j++) {
					if(str.charAt(j) == '*') {
						intArr[i][j] = -1;
						for(int k=i-1; k<=i+1; k++) {
							if(k<0 || k>row-1) continue;
							for(int l=j-1; l<=j+1; l++) {
								if(l<0 || l>column-1) continue;
								if(intArr[k][l] == -1) continue;
								intArr[k][l]++;
							}
						}
					}
				}
				
				if(i == row-1) {
					for(int k=0; k<row; k++) {
						for(int l=0; l<column; l++) {
							if(intArr[k][l] == -1)
								System.out.print("*");
							else
								System.out.print(intArr[k][l]);
							
							if(l == column-1)
								System.out.println();
						}
						if(k == row-1)
							System.out.println();
					}
				}
			}
		}
	}
}