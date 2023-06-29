import java.util.*;
import java.math.*;
class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while (input.hasNextLine()) {
			BigInteger start = input.nextBigInteger();
			BigInteger end = input.nextBigInteger();
			if (start.equals(BigInteger.ZERO) && end.equals(BigInteger.ZERO)) break;
			
			List<BigInteger> list = new ArrayList<>();
			list.add(BigInteger.ONE); // f(1) = 1
			list.add(BigInteger.TWO); // f(2) = 2
			while (true) {
				int last = list.size() - 1;
				BigInteger fn_1 = list.get(last);
				BigInteger fn_2 = list.get(last-1);
				BigInteger fn = fn_1.add(fn_2); // f(n) = f(n-1) + f(n-2)
				if (fn.compareTo(end) > 0) {
					break;
				}
				list.add(fn);
			}
			int count = 0;
			for (int i=0; i < list.size(); i++) {
				BigInteger fib = list.get(i);
				if (0 <= fib.compareTo(start) && fib.compareTo(end) <= 0) {
					count++;
				} 
				if (0 < fib.compareTo(end)) break;
			}
		
			System.out.println(count);
		}
	}
}