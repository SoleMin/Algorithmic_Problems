import java.io.*;
import java.util.*;
import java.math.*;

class Main {/*
	static char a[101], b[101];
	static char fib[3][101];
	static int lengtha, lengthb, length[3];
	static int result;
	*/
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		List <BigInteger> list = new ArrayList<>();
		
		list.add(0, BigInteger.valueOf(1));
		list.add(1, BigInteger.valueOf(1));
		for (int i = 2; i < 1000; i++) {
			list.add(i, list.get(i-1).add(list.get(i-2)));
		}
		
		while (true) {
			int result = 0;
			String tmp = sc.next();
			BigInteger i1 = new BigInteger(tmp);
			tmp = sc.next();
			BigInteger i2 = new BigInteger(tmp);
			if (i1.compareTo(BigInteger.ZERO) == 0 && i1.compareTo(i2) == 0) break;
			
			if (i1.compareTo(BigInteger.valueOf(1)) == 0) result++;
			for (int i = 2; i < 1000; i++) {
				if (i1.compareTo(list.get(i)) <= 0 && i2.compareTo(list.get(i)) >= 0)
					result ++;
			}
			System.out.println(result);

		}
	}
}