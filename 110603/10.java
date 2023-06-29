import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		BigInteger C[] = new BigInteger[1000];
		
		C[0] = BigInteger.ZERO;
		C[1] = BigInteger.valueOf(2);
		C[2] = BigInteger.valueOf(5);
		C[3] = BigInteger.valueOf(13);
		
		
		for(int i=4; i<1000; i++) {
			C[i] = C[i-1].multiply(C[1]);
			C[i] = C[i].add(C[i-2]);
			C[i] = C[i].add(C[i-3]);
		}
			
		while (in.hasNextInt()) {
			n = in.nextInt();
			System.out.println(C[n]);
		}
	}
}