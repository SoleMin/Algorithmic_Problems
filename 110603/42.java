import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<Integer> num = new ArrayList<>();
	
	
		while(sc.hasNextInt()) {
			num.add(sc.nextInt());
		}
		for(int n : num) {
			List<BigInteger> table = new ArrayList<>();
			table.add(new BigInteger("1"));
			table.add(new BigInteger("2"));
			table.add(new BigInteger("5"));
			
			for(int i = 3; i <= n; i++) {
				BigInteger k = table.get(i-1).multiply(table.get(1));
				k = k.add(table.get(i-3));
				k = k.add(table.get(i-2));
				table.add(k);
			}
		System.out.println(table.get(n).toString());

		}
	}
}