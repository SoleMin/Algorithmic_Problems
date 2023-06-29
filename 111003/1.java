import java.io.*;
import java.util.*;
class Main {
public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
	
		int num = (int) 1e8;
		int count = Integer.parseInt(br.readLine().trim());
		br.readLine();
		boolean first = true;
		while(count-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(!first)
				pw.append("\n");
			first = false;
			int f = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			boolean[] hasStation = new boolean[n];
			while(f-->0)
				hasStation[Integer.parseInt(br.readLine())-1] = true;
			int[][] ind = new int[n][n];
			for (int i = 0; i < n; i++)     
				for (int j = 0; j < n; j++) 
					ind[i][j] = num;
			while(br.ready())
			{
				st = new StringTokenizer(br.readLine());
				if(st.countTokens()==0)
					break;
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				ind[a][b] = c;
				ind[b][a] = c;				
			}
			for (int i = 0; i < n; i++) 
				ind[i][i] = 0;
			for (int k = 0; k < n; k++) 
				for (int i = 0; i < n; i++) 
					for (int j = 0; j < n; j++) 
						ind[i][j] = Math.min(ind[i][j],ind[i][k] + ind[k][j]);
			int[] dist = new int[n];
			for (int i = 0; i < n; i++) 
			{
				dist[i] = num;
				for (int j = 0; j < n; j++) 
				{
					if(hasStation[j])
					{
						dist[i] = Math.min(dist[i], ind[i][j]);
					}
				}
			}
			int t=0,max =num;
			for (int i = 0; i < n; i++) 
			{
				int cur = 0;
				for (int j = 0; j < n; j++) 
					cur = Math.max(cur,Math.min(dist[j], ind[i][j]));
				if(cur<max)
				{
					max = cur;
					t = i+1;
				}
			}
			pw.append(t+"\n");
		}
		pw.flush();
	}
}