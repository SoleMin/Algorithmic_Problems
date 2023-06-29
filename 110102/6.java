import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int i = 1, j = 1;
		int count = 0;
		
		while(i != 0 && j != 0) {
			i = input.nextInt();
			j = input.nextInt();
			
			if(i == 0 && j == 0) {
				break;
			}
		
		
		String bomb = "";
		
		for(int k = 0; k < i; k++) {
			bomb = bomb + input.next();
		}
		
		String realBomb = bomb.replace(".", "0");
		
		char[] test = realBomb.toCharArray();
		
		char[][] testBomb = new char[100][100];
		
		int temp = 0;
		for(int a = 0; a < i; a++) {
			for(int b = 0; b < j; b++) {
				testBomb[a][b] = test[b + (j*temp)];
			}
			temp++;
		}
		count++;
		
		for(int a = 0; a < i; a++) {
			for(int b = 0; b < j; b++) {
				if(testBomb[a][b] != '*') {
					if((b-1 >= 0) && (testBomb[a][b-1] == '*')) {testBomb[a][b]++; }
					if((b+1 < j) && testBomb[a][b+1] == '*') {testBomb[a][b]++;}
					if((a+1 < i) && testBomb[a+1][b] == '*') {testBomb[a][b]++;}
					if((a-1 >= 0) && testBomb[a-1][b] == '*') {testBomb[a][b]++;}
					if((a-1 >= 0) && (b-1 >= 0) && testBomb[a-1][b-1] == '*') {testBomb[a][b]++;}
					if((a-1 >= 0) && (b +1 < j) && testBomb[a-1][b+1] == '*') {testBomb[a][b]++;}
					if((a+1 < i) && (b-1 >= 0) && testBomb[a+1][b-1] == '*') {testBomb[a][b]++;}
					if((a+1 < i) && (b+1 < j) && testBomb[a+1][b+1] == '*') {testBomb[a][b]++;}
				}
			}
		}
		
		System.out.println("Field #" + count + ":");
		for(int a = 0; a < i; a++) {
			for(int b = 0; b < j; b++){
				System.out.print(testBomb[a][b]);
			}
			System.out.println();
		}
			System.out.println();
	}
}
}