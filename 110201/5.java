import java.io.*;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int MAX_N = 3000;
		int[] present = new int[MAX_N];
		int diff, jolly;
		while (scan.hasNextInt()) {
			int n = scan.nextInt();
			jolly = 1;
			for(int i = 1; i <= n; i++) {
				present[i] = 0;
			}
			int prev = scan.nextInt();
			for(int i = 1; i < n; i++) {
				int curr = scan.nextInt();
				diff = Math.abs(curr - prev);
				if(diff <= 0 || diff >= n || present[diff] == 1) {
					jolly = 0;
					break;
				}
				present[diff] = 1;
				prev = curr;
			}
			scan.nextLine();
			if(jolly == 1) System.out.println("Jolly");
			else System.out.println("Not jolly");
		}
	}
}