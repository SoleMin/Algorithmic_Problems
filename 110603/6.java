import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		BigInteger[] gustavo = new BigInteger[1001];
		for(int i = 0; i < 1001; i++) {
			gustavo[i] = BigInteger.valueOf(0);
		}
		gustavo[1] = BigInteger.valueOf(2);
		gustavo[2] = BigInteger.valueOf(5);
		gustavo[3] = BigInteger.valueOf(13);
		
		for(int i = 4; i < 1001; i++) {
			gustavo[i] = gustavo[i].add(gustavo[i-1]);
			gustavo[i] = gustavo[i].add(gustavo[i-1]);
			gustavo[i] = gustavo[i].add(gustavo[i-2]);
			gustavo[i] = gustavo[i].add(gustavo[i-3]);
		}
		
		while(input.hasNext()) {
			int n = input.nextInt();
			
			System.out.println(gustavo[n]);
			
		}
	}

}
