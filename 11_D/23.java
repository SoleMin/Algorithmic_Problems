import java.util.*;
import java.math.*;

public	class task
{
	public static void	main(String args[])
	{
		Scanner a = new Scanner(System.in);
		
		while(a.hasNext())
		{
			int n = a.nextInt();
			int m = a.nextInt();
			if(n == 0 && m == 0) break;
		    
			boolean[][] adj = new boolean[n][n];
			long res = 0;
			
			for (int i = 0; i < m; ++i) {
				int x = a.nextInt();
				int y = a.nextInt();
				adj[x - 1][y - 1] = true;
				adj[y - 1][x - 1] = true;
			}
			
			for (int i = 0; i < n; ++i) 
				for (int j = i + 1; j < n; ++j) 
					if (adj[i][j]) 
						--res;
						
			for (int i = 0; i < n; ++i) 
			{
				long[][] dp = new long[n - i][1 << (n - i)];
				dp[0][0] = 1;
				for (int mask = 0; mask < (1 << (n - i)); ++mask) 
				{
					for (int j = 0; j < n - i; ++j) 
					{
						if (dp[j][mask] != 0) 
						{
							for (int k = 0; k < n - i; ++k) 
							{
								if (((mask >> k) & 1) == 0 && adj[j + i][k + i]) 
									dp[k][mask | (1 << k)] += dp[j][mask];
								
							}
						}
					}
					if (((mask >> 0) & 1) != 0) {
						res += dp[0][mask];
					}
				}
			}
			System.out.println(res/2);
		}
	}
}
	