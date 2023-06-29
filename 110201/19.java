import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			if (n>3000)
				break;
			
			int[] array = new int[n];
			int[] diff = new int[n-1];
			int[] curr = new int[n-1];
			int count = 0;
			int input;
			
			for (int i=0; i<n; i++) {
				input = sc.nextInt();
				array[i] = input;
			}
			
			for (int i=0; i<n-1; i++)
				diff[i] = Math.abs(array[i]-array[i+1]);
			
			Arrays.sort(diff);
			
			for (int i=0; i<n-1; i++) {
				curr[i] = i+1;
				if (curr[i] == diff[i])
					count++;
			}
			
			if (count == n-1)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
			
		}
	}
}