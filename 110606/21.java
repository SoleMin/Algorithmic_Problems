import java.io.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while ((input = br.readLine()) != null) {
			BigInteger result = BigInteger.ZERO;
			int n = Integer.parseInt(input);
			//int result = 0;
			
			int num = 0;
			int count = 1;
			int semiCount = 0;
			
			for (int i = 0; i < n; i++) {
				result = result.add(BigInteger.valueOf((long) Math.pow(2, num)));
				//result = result + (int) Math.pow(2, num);
				semiCount++;
				
				if (semiCount == count) {
					semiCount = 0;
					count++;
					num++;
				}
			}
			System.out.println(result);
		}
	}
}