import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		BigInteger gustavo[] = new BigInteger[1000];
		gustavo[0] = BigInteger.valueOf(2);
		gustavo[1] = BigInteger.valueOf(5);
		gustavo[2] = BigInteger.valueOf(13);
		gustavo[3] = BigInteger.valueOf(33);
		for (int i = 4; i <= 999; i++) {
			gustavo[i] = BigInteger.valueOf(0);
			gustavo[i] = gustavo[i].add(gustavo[i - 1]);
			gustavo[i] = gustavo[i].add(gustavo[i - 2]);
			gustavo[i] = gustavo[i].add(gustavo[i - 3]);
			gustavo[i] = gustavo[i].add(gustavo[i - 1]);
		}
		Scanner input = new Scanner(System.in);
		int n;
		while (input.hasNextInt()) {
			n = input.nextInt();
			System.out.println(gustavo[n - 1]);
		}
	}
}