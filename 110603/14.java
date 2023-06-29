import java.util.*;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextInt()) {
			BigInteger[] integer = new BigInteger[1001];
			integer[1] = BigInteger.valueOf(2);
			integer[2] = BigInteger.valueOf(5);
			integer[3] = BigInteger.valueOf(13);

			for(int i=4; i<1001; i++) {
				integer[i] = integer[i-1].multiply(integer[1]);
				integer[i] = integer[i].add(integer[i-2]);
				integer[i] = integer[i].add(integer[i-3]);
			}

			int n = input.nextInt();
			System.out.println(integer[n]);
		}
	}
}