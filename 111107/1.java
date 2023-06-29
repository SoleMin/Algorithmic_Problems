import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());

		for(int r=0; r<repeat; r++) {
			String[] split = input.nextLine().split("\\s+");
			int people = Integer.parseInt(split[0]) + 8;

			split = input.nextLine().split("\\s+");
			int[] chopsticks = new int[split.length];
			for(int i=0; i<chopsticks.length; i++)
				chopsticks[i] = Integer.parseInt(split[i]);
			
			int[] chopsticksDiffer = new int[chopsticks.length-1];
			for(int i=0; i<chopsticksDiffer.length; i++)
				chopsticksDiffer[i] = (chopsticks[i] - chopsticks[i+1]) * (chopsticks[i] - chopsticks[i+1]);
			
			int[][] matrix = new int[people + 1][chopsticksDiffer.length];
			boolean[][] unusable = new boolean[people + 1][chopsticksDiffer.length];
			
			for(int i=1; i<=people; i++) {
				boolean isFirst = true;
				for(int j=chopsticksDiffer.length-3*i+1; j>=0; j--) {
					int temp;
					if(unusable[i-1][j+1])
						temp = matrix[i-1][j+2];
					else
						temp = matrix[i-1][j+1];
					temp += chopsticksDiffer[j];
					
					if(isFirst) {
						matrix[i][j] = temp;
						isFirst = false;
						continue;
					}
					
					if(temp >= matrix[i][j+1]) {
						matrix[i][j] = matrix[i][j+1];
					}
					else {
						matrix[i][j] = temp;
						unusable[i][j] = true;
					}
				}
			}
			
			System.out.println(matrix[people][0]);
		}
		input.close();
	}
}
