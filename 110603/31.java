import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		BigInteger[] array = new BigInteger[1000];
		String str;
		array[0] = BigInteger.valueOf(2);
		array[1] = BigInteger.valueOf(5);
		array[2] = BigInteger.valueOf(13);
		for(int i = 3; i < array.length; i++) {
			array[i] = BigInteger.valueOf(0);
		}
		while(input.hasNextInt()) {
			//str = input.nextLine();
			//if(str.length() == 0) break;
			int n = input.nextInt();
			//BigInteger result = BigInteger.valueOf(0);
			for(int i = 3; i < n; i++) {
				BigInteger result = BigInteger.valueOf(0);
				if(array[i].intValue() == 0) {
					result = result.add(array[i-1]);
					result = result.add(array[i-1]);
					result = result.add(array[i-2]);
					result = result.add(array[i-3]);
					array[i] = result;
					//System.out.println(result.intValue());
				}
			}
			System.out.println(array[n-1]);
		}
	}
}