import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while((input = br.readLine()) != null) {
			List<BigInteger> array = new ArrayList<>();
			
			int n = Integer.parseInt(input);
			
			array.add(BigInteger.valueOf(2));
			array.add(BigInteger.valueOf(5));
			array.add(BigInteger.valueOf(13));
			
			for(int i = 4; i < n + 1; i++) {
				BigInteger a = array.get(i - 4);
				BigInteger b = array.get(i - 3);
				BigInteger c = array.get(i - 2).multiply(BigInteger.valueOf(2));
				array.add(a.add(b).add(c));
			}
			System.out.println(array.get(n - 1));
		}
	}
}