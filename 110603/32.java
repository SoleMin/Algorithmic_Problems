import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		BigInteger f0 = BigInteger.ONE; // f(0) = 1
		BigInteger f1 = BigInteger.TWO; // f(1) = 2
		BigInteger f2 = BigInteger.valueOf(5); // f(2) = 5
		BigInteger f3 = BigInteger.valueOf(13); // f(3) = 13
		
		List<BigInteger> list = new ArrayList<>();
		list.add(f0);
		list.add(f1);
		list.add(f2);
		list.add(f3);
		for(int n=4; n <= 1000; n++) {
			BigInteger fn_1 = list.get(n-1);
			BigInteger fn_2 = list.get(n-2);
			BigInteger fn_3 = list.get(n-3);
			BigInteger fn = fn_1.add(fn_1).add(fn_2).add(fn_3); // f(n) = f(n-1)*2 + f(n-2) + f(n-3)
			list.add(fn);
		}
		
		while (input.hasNextLine()) {
			int n = input.nextInt();
			System.out.println(list.get(n));
			input.nextLine();
		}
		input.close();
	}
}