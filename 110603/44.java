import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()){
			int num = scan.nextInt();
			System.out.println(countNum(num));
		}
	}
		private static BigInteger countNum(int n){
			BigInteger c[] = new BigInteger[1001];
			c[0] = BigInteger.ZERO;
			c[1] = BigInteger.valueOf(2);
			c[2] = BigInteger.valueOf(5);
			c[3] = BigInteger.valueOf(13);
			
			for(int i = 4 ; i < 1001; ++i){
				c[i] = c[i-1].multiply(c[1]);
				c[i] = c[i].add(c[i-2]);
				c[i] = c[i].add(c[i-3]);
			}
			return c[n];
		}
	}
