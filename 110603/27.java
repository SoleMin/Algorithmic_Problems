import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		BigInteger[] result = new BigInteger[10001];
		result[1] = new BigInteger("2");
		result[2] = new BigInteger("5");
		result[3] = new BigInteger("13");
		for(int i = 4; i <= 10000; i++)
			result[i] = result[i-1].multiply(new BigInteger("2")).add(result[i-2]).add(result[i-3]);
		
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(result[n]);
		}
	}
}