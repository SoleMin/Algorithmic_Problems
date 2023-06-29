/**
 * Problem: 
 * Source: 
 * Link: 
 * 
 * @author Alexei Ostrovski
 */

import java.io.*;
import java.util.*;


public class SpidersSolver {

	public static final boolean DEBUG = false;
	
	public static void main(String[] args) {
		//redirect input and output
		if (DEBUG)
		{
			try {
				System.setIn(new FileInputStream("input.txt"));
				//System.setOut(new PrintStream("input.txt"));
			} catch (IOException e) {
				//nothing
			}
		}
		Scanner sc = new Scanner(System.in);

		//read data
		int n = sc.nextInt(), m = sc.nextInt();
			
		//solve
		if (n < m) {
			int tmp = n;
			n = m;
			m = tmp;
		}
		// Now (n >= m) && (m <= 6)
		int pow = 1;
		for (int i = 0; i < m; i++)
			pow *= 2;

		int[] count = new int[pow];
		for (int cur = 0; cur < pow; cur++)
		{
			int x = cur;
			while (x > 0)
			{
				count[cur] += (x % 2);
				x /= 2;
			}
			count[cur] = m - count[cur];
		}
		//System.out.println(Arrays.toString(count));
		
		int[][] C = new int[pow][pow];
		for (int cur = 0; cur < pow; cur++)
		{
			C[0][cur] = 0;//count[cur];
			for (int last = 1; last < pow; last++)
				C[last][cur] = Integer.MIN_VALUE;
		}
		
		for (int i = 0; i < n; i++)
		{
			int[][] newC = new int[pow][pow];
			
			for (int cur = 0; cur < pow; cur++)
				for (int next = 0; next < pow; next++)
				{
					int mask = cur | (cur << 1) | (cur >> 1) | next;
					mask %= pow;
					
					int max = 0;
					for (int last = 0; last < pow; last++)
						if (((last | mask) == pow - 1) && (max < count[cur] + C[last][cur]))
							max = count[cur] + C[last][cur];
					
					newC[cur][next] = max;
				}
			C = newC;
		}
		
		int result = 0;
		for (int cur = 0; cur < pow; cur++)
			result = Math.max(result, C[cur][0]);
			
		//output
		System.out.println(result);
	}
}
