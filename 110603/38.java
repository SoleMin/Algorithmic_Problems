import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	
	static BigInteger[] integers = new BigInteger[1000];
	
	public static void counting() {
		integers[0] = BigInteger.valueOf(2);
		integers[1] = BigInteger.valueOf(5);
		integers[2] = BigInteger.valueOf(13);
		
		for(int i = 3; i < integers.length;i++)
			integers[i] = integers[i-1].add(integers[i-1]).add(integers[i-2]).add(integers[i-3]);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		counting();
		
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(integers[n-1]);
		}
	}
}