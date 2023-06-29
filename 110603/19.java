import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	
	public static void main (String[] args) {
		
		int number;
		
		
		
		Scanner input = new Scanner (System.in);
		
		
		while (input.hasNextInt()) {
			
			number = input.nextInt();
			
			BigInteger [] bi = new BigInteger [number + 1];
			
			
			bi[1] = (new BigInteger("2"));
			
			if (number == 1) {
				System.out.println(bi[number]);
				continue;
			}
			
			bi[2] = (new BigInteger("5"));
			
			if (number == 2) {
				System.out.println(bi[number]);
				continue;
			}
			
			bi[3] = (BigInteger.valueOf(13));
			
			if (number == 3) {
				System.out.println(bi[number].toString());
				continue;
			}
			
			for (int i = 4; i <= number; i++) {
				bi[i] = ((bi[i - 1].multiply(BigInteger.valueOf(2))).add(bi[i - 2]).add(bi[i - 3]));
			}
			
			System.out.println(bi[number].toString());
			
		}
	}
}