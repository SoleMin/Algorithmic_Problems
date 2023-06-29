import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while (cases-- > 0) {
			int n = sc.nextInt();
			int addr[] = new int[n];
			int dif;
			int med;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				addr[i] = sc.nextInt();
			}
			Arrays.sort(addr);
		  med = addr[n/2];
			
			for (int i = 0; i < n; i++) 
				sum += Math.abs(addr[i]-med);
			
			System.out.println(sum);
		}
		sc.close();
	}
}