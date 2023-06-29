import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while((input = br.readLine()) != null) {
			if ("0 0".equals(input)) {
				break;
			}
			String numbers[] = input.split(" ");
			
			BigInteger min = new BigInteger(numbers[0]);
			BigInteger max = new BigInteger(numbers[1]);
			
			List<BigInteger> fibs = new ArrayList<>();
			
			int count = 0;
			int j = 0;
			BigInteger fib = BigInteger.ZERO;
			
			while(true) {
				if(j == 0) {
					long a = 1;
					BigInteger b = BigInteger.valueOf(a);
					fibs.add(b);
					fib = b;
				}
				else if(j == 1) {
					long a = 2;
					BigInteger b = BigInteger.valueOf(a);
					fibs.add(b);
					fib = b;
				}
				else {
					BigInteger a = fibs.get(j - 2);
					BigInteger b = fibs.get(j - 1);
					fib = a.add(b);
					fibs.add(fib);
				}
				
				if ((fib.compareTo(min) == 1 || fib.compareTo(min) == 0) && (fib.compareTo(max) == 0 || fib.compareTo(max) == -1)) {
					count++;
				}
				
				if (fib.compareTo(max) == 1 || fib.compareTo(max) == 0) {
					System.out.println(count);
					break;
				}
				
				j++;
			}
		}
	}
}