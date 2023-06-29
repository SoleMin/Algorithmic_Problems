import java.util.*;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		BigInteger fib[] = new BigInteger[3];
		fib[0] = BigInteger.ZERO;
		fib[1] = BigInteger.valueOf(1);
		
		while(true) {
			BigInteger a = input.nextBigInteger();
			BigInteger b = input.nextBigInteger();
			if (BigInteger.ZERO.equals(a) && BigInteger.ZERO.equals(b)) break;
			
			int result = 0;
			while(true) {
				fib[2] = fib[0].add(fib[1]);
				fib[0] = fib[1];
				fib[1] = fib[2];
				
				if (a.compareTo(fib[2]) > 0) continue;
				if (b.compareTo(fib[2]) < 0) break;
				else result++;
			}
			
			fib[0] = BigInteger.ZERO;
			fib[1] = BigInteger.valueOf(1);
			
			System.out.println(result);
		}
	}
}