import java.io.*;

import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int count = 0;
		int repetNumber = input.nextInt();
		
		while(count < repetNumber) {
			count++;
			int dayNumber = input.nextInt();
			int[] day = new int[dayNumber];
			int answer = 0;
			int partyNumber = input.nextInt();
			int[] hartalsNumber = new int[partyNumber];
			
			for(int i = 0; i < partyNumber; i++) {
				hartalsNumber[i] = input.nextInt();
			}
			
			for(int i = 0; i < partyNumber; i++) {
				for(int j = hartalsNumber[i] - 1; j < dayNumber; j +=hartalsNumber[i]) {
					if(j % 7 != 5 && j % 7 != 6) {
						day[j] = 1;
					}
				}
			}
			
			for(int k = 0; k < dayNumber; k++) {
				if(day[k] > 0) {
					answer++;
				}
			}
			
			System.out.println(answer);
			
		}
	}
}