// Main Code at the Bottom
import java.util.*;
import java.io.*; 
public class Main{
	//Fast IO class
    static class FastReader {
        BufferedReader br; 
        StringTokenizer st; 
        public FastReader() {
        	boolean env=System.getProperty("ONLINE_JUDGE") != null;
        	//env=true;
        	if(!env) {
        		try {
					br=new BufferedReader(new FileReader("src\\input.txt"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
        	}
        	else br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) {
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
        int nextInt() {
            return Integer.parseInt(next()); 
        } 
        long nextLong() {
            return Long.parseLong(next()); 
        } 
        double nextDouble() {
            return Double.parseDouble(next()); 
        } 
        String nextLine() {
            String str = ""; 
            try {
                str = br.readLine(); 
            } 
            catch (IOException e) {
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }     
    static long MOD=(long)1e9+7;
    //debug
    static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    static FastReader sc=new FastReader();
    static PrintWriter out=new PrintWriter(System.out);  
    //Global variables and functions
    static long memo[];
    static long C[][];
    static long exp(long a,long x) {
    	if(x==0) return 1;
    	if(x%2==0) return exp((a*a)%MOD,x/2)%MOD;
    	return ((a%MOD)*((exp((a*a)%MOD,x/2))%MOD))%MOD;
    }
    static void fill(int n) {
    	C = new long[n+1][n+1];
    	for(int i = 1; i<=n;i++) C[i][0]=C[i][i]=1;
    	for(int i=2;i<=n;i++) {
    		for(int j=1;j<=n;j++) {
    			C[i][j]=(C[i-1][j]+C[i-1][j-1])%MOD;
    		}
    	}
    }
    //Main function(The main code starts from here)
    public static void main (String[] args) throws java.lang.Exception {
    	int test=1;
    	//test=sc.nextInt();
    	while(test-->0) {
    		int n = sc.nextInt();
    		MOD = sc.nextLong();
    		memo = new long[n+1];
    		fill(n);
    		long dp[][] = new long[n+5][n+5];
    		for(int i=1;i<=n;i++) dp[i][i]=exp(2,i-1);
    		for(int i = 2; i <= n; i++) {
    			for(int j = 1; j < i; j++) {
    				for(int k = 1; k <= j; k++) {
    					long val = (dp[i-k-1][j-k]*C[j][k])%MOD;
    					if(memo[k-1] ==0) memo[k-1] = exp(2, k-1);
    					val=(val*memo[k-1])%MOD;
    					dp[i][j]=(dp[i][j]+val)%MOD;
    				}
    			}
    		}
    		long ans = 0;
    		for(int i=0;i<=n;i++) ans=(ans+dp[n][i])%MOD;
    		out.println(ans);
    	}
        out.flush();
        out.close();
    }
}