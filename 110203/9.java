import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		final int MAX_N = 3650;
		final int MAX_P = 100;
		
		int t, n, p;
		int i, j, k;
		int lost;
		
		int[] h = new int[MAX_P];
		
		t = sc.nextInt();
		for(i = 0; i < t; i++)
		{
			n = sc.nextInt();
			p = sc.nextInt();
			
			for(j = 0; j < p; j++)
			{
				h[j] = sc.nextInt();
			}
			lost = 0;
			for(j = 1; j <= n; j++)
			{
				if((j - 1) % 7 < 5)
					for(k = 0; k < p; k++)
					{
						if(j % h[k] == 0)
						{
							lost++;
							break;
						}
						
					}
			}
			System.out.println(lost);
		}
		
		sc.close();
	}
}