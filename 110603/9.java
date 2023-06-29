import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		 
		while (sc.hasNextInt())
		{
			int n = sc.nextInt();
			
			BigInteger c[] = new BigInteger[1001];
			
			c[0] = BigInteger.ZERO;
			c[1] = BigInteger.valueOf(2);
			c[2] = BigInteger.valueOf(5);
			c[3] = BigInteger.valueOf(13);
			
			for (int i = 4; i < 1001; ++i)
			{
				c[i] = c[i-1].multiply(c[1]);
				c[i] = c[i].add(c[i - 2]);
				c[i] = c[i].add(c[i - 3]);
			}
			
			System.out.println(c[n]);
			
			
			
		}

	}
}