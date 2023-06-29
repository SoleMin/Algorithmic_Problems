import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class D11 {

	static StreamTokenizer in;
	static PrintWriter out;
	
	static int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
	}
	
	static String nextString() throws IOException {
		in.nextToken();
		return in.sval;
	}

	public static void main(String[] args) throws IOException {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(System.out);

		n = nextInt();
		m = nextInt();
		
		g = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int a = nextInt()-1, b = nextInt()-1;
			g[a][b] = g[b][a] = true;
		}
		
		long ans = 0;
		for (int i = n; i > 0; i--) {
			//long cur = solve(i);
			long cur = calc(g, i-1);
			ans += cur;
		}
		
		out.println(ans/2);
		
		out.flush();
	}

	static int n, m, V;
	static boolean[][] g;
	
	/*static long solve(int V) {
		int v = V-1;
		long[][] memo = new long[V][1 << V];
		
		memo[v][1 << v] = 1;
		for (int mask = 1; mask < (1 << V); mask++)
			for (int i = 0; i < V; i++) if ((mask&(1 << i)) != 0)
				for (int j = 0; j < V; j++) if (g[i][j] && (mask&(1 << j)) == 0)
					memo[j][mask|(1 << j)] += memo[i][mask];
		
		long res = 0;
		for (int mask = 1; mask < (1 << V); mask++)
			for (int i = 0; i < V; i++)
				if (Integer.bitCount(mask) > 2 && g[v][i]) res += memo[i][mask];
		return res/2;
	}*/
	
	static long calc(boolean[][] bs,int n){
        long[][] dp=new long[1<<n][n];
        for(int i=0;i<n;i++){
                if(bs[i][n])
                        dp[1<<i][i] ++;
        }
        for(int i=1;i<1<<n;i++){
                for(int j=0;j<n;j++)if(((i>>j)&1)==1)
                        for(int k=0;k<n;k++)if(((i>>k)&1)==0 && bs[j][k]){//add
                                dp[i|(1<<k)][k] += dp[i][j];
                        }
        }
        long res=0;
        for(int i=0;i<1<<n;i++)for(int j=0;j<n;j++)if(Integer.bitCount(i)>=2&&bs[j][n])res+=dp[i][j];
        return res;
}
}
