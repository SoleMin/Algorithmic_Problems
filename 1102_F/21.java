import java.util.*;
import java.io.*;

public class main{

	static int max = 5000+1;
	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);
	static int N = 18;
	static int[][] mn1 = new int[N][N]; 
	static int[][] mn2 = new int[N][N];
	static int[][] dp = new int[1<<N][N];
	static int n,m;
	
	static void solve(){
		n = in.nextInt(); m = in.nextInt();
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++)for(int j=0;j<m;j++)a[i][j] = in.nextInt();
		for(int i=0;i<n;i++){
			Arrays.fill(mn1[i],Integer.MAX_VALUE);
			Arrays.fill(mn2[i],Integer.MAX_VALUE);
		}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				for(int k=0;k<m;k++){
					mn1[i][j] = Math.min(mn1[i][j],Math.abs(a[i][k]-a[j][k]));
					if(k<=m-2)
						mn2[i][j] = Math.min(mn2[i][j],Math.abs(a[i][k]-a[j][k+1]));
				}
		int ans = 0;
		for(int i=0;i<n;i++){
			for(int x=0;x<1<<n;x++)Arrays.fill(dp[x],-1);
			for(int j=0;j<n;j++)dp[1<<j][j] = 0;
			dp[1<<i][i] = Integer.MAX_VALUE;
			for(int j=0;j<n;j++)
				ans = Math.max(ans,Math.min(mn2[j][i],calc((1 << n) - 1, j)));
		}
		out.println(ans);
	}

	static int calc(int mask, int v){
		if (dp[mask][v] != -1)
			return dp[mask][v];
		dp[mask][v] = 0;
		for(int u=0;u<n;u++) if (v != u && (((mask >> u) & 1)>0))
			dp[mask][v] = Math.max(dp[mask][v], Math.min(mn1[u][v], calc(mask ^ (1 << v), u)));
		return dp[mask][v];
	}


	public static void main(String[] args){
		solve();
		out.flush();
		out.close();
	}	

	static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";
            try{   
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }  
            return str;
        }
        int nextInt(){return Integer.parseInt(in.next());}
    	long nextLong(){return Long.parseLong(in.next());}
    	double nextDouble(){return Double.parseDouble(in.next());}
    }
}




// |xvcxv|vcv[cvcvc|cxv||]vcvx:v|c|vxc|[|cvx:cxvx||||]