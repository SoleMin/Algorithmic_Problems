import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt()) {
			
			int num = sc.nextInt();
			int[] numlist = new int[num];
			int[] oxlist = new int[num];

			for (int i = 0; i < num; i++) {
				numlist[i] = sc.nextInt();
			}
			
			first: if (num == 1) {
				System.out.println("Jolly");
			} else if (num == 2) {
				if (Math.abs(numlist[1] - numlist[0]) == 1) {
					System.out.println("Jolly");
				} else {
					System.out.println("Not jolly");
				}
			} else { //입력 받을려는 갯수기 1,2 아닌경우
				for ( int k = 0; k < num - 1; k++) {
					oxlist[k] = Math.abs(numlist[k] - numlist[k+1]);
					if (oxlist[k] > num) {
						System.out.println("Not jolly");
						break first;
					}
				}
				Arrays.sort(oxlist);
				for (int i = 1; i < num; i++) {
					if ( i != oxlist[i]) {
						System.out.println("Not jolly");
						break;
					} 
					if (i == num - 1) {
						System.out.println("Jolly");
					}
				}
			}
		}
	}
}
