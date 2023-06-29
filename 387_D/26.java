import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ali on 2/3/14.
 */
public class D
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();

		boolean [][] graph = new boolean[n][n];
		for(int i = 0 ; i < m ; i++)
		{
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;

			graph[a][b] = true;
		}

		int res = Integer.MAX_VALUE;
		for(int center = 0 ; center < n ; center++)
		{
			int calc = 0;
			for(int i = 0 ; i < n ; i++)
			{
				if(!graph[center][i])
					calc++;
				if(!graph[i][center])
					calc++;
			}

			if(!graph[center][center])
				calc--;

			int [] match = new int[n];
			Arrays.fill(match, -1);
			int max = 0;

			for(int i = 0 ; i < n ; i++)
				if(i != center)
					if(can(i, graph, new boolean[n], center, match))
						max++;

			int unusable = m - (2*n - 1 - calc) - max;
			calc += unusable;
			calc += (2*(n-1) - 2*max)/2;

			res = Math.min(res, calc);
		}

		System.out.println(res);


	}

	private static boolean can(int at, boolean[][] graph, boolean[] visited, int center, int [] match)
	{
		if(visited[at])
			return false;
		visited[at] = true;

		for(int to = 0 ; to < graph.length ; to++)
			if(graph[at][to])
				if(to != center)
					if(match[to] == -1 || can(match[to], graph, visited, center, match))
					{
						match[to] = at;
						return true;
					}

		return false;
	}
}
