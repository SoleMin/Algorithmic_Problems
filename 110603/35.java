import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		BigInteger[] a = new BigInteger[1001];
		
		a[0] = BigInteger.valueOf(0);
		a[1] = BigInteger.valueOf(2);
		a[2] = BigInteger.valueOf(5);
		a[3] = BigInteger.valueOf(13);

		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			
			for(int i = 4; i <= 1000; i++){
				a[i] = a[i-1].multiply(a[1]);
				a[i] = a[i].add(a[i-2]);
				a[i] = a[i].add(a[i-3]);
			}
			System.out.println(a[n]);
		}
	}
}


