import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		List<Integer> num = new ArrayList<>();
		List<BigInteger> f = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		int max = 0;
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if(max < n)
				max = n;

			num.add(n);
		}
		
		f.add(BigInteger.ZERO);
		f.add(BigInteger.ONE);
		
		for(int i = 2; i <= max; i++) {
			BigInteger exp = BigInteger.TWO.pow(i);
			BigInteger min = exp.subtract(BigInteger.ONE);
			
			
			for(int k = 1; k <= i-1; k++) {
				exp = exp.shiftRight(1);
				BigInteger o = f.get(k).multiply(BigInteger.TWO);
				o = o.add(exp);
				o = o.subtract(BigInteger.ONE);
				if(min.compareTo(o) > 0)
					min = new BigInteger(o.toString());
			}
			f.add(min);
		}
		for(Integer n : num) {
			System.out.println(f.get(n).toString());
		}
	}
}