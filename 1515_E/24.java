import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class Solution{
	
	static long mod = -1;
	static long[] fact, invfact, pow;
	static long[][] C;
	static long[][] dp;
	static final int N = 405;
	static int n;
	
	
	public static void main(String[] args) throws IOException {
		FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
    	
    	int tt = 1;
    	outer:
    	while(tt-->0) {
    		
    		n = fs.nextInt();
    		mod = fs.nextLong();
    		
    		dp = new long[N][N];
    		precompute();
    		
    		dp[0][0] = 1;
    		
    		for(int i=0;i<n;i++) {
    			for(int j=0;j<=i;j++) {
    				for(int k=1;i+k<=n;k++) {
    					dp[i+k+1][j+k] += (((dp[i][j]*pow[k-1])%mod)*C[j+k][k])%mod;
    					dp[i+k+1][j+k] %= mod;
    				}
    			}
    		}
    		
    		long ans = 0;
    		for(int i=0;i<=n;i++) {
    			ans = (ans + dp[n+1][i])%mod;
    		}
    		
    		out.println(ans);
    		
    		
    		
    		
    	}
    	
    	out.close();
    }
	
	
	static void precompute() {
		fact = new long[N]; invfact = new long[N]; C = new long[N][N]; pow = new long[N];
		fact[0] = 1;
		for(int i=1;i<=n;i++) fact[i] = (fact[i-1]*i)%mod;
		invfact[n] = inv(fact[n]);
		for(int i=n-1;i>=0;i--) invfact[i] = (invfact[i+1]*(i+1))%mod;
		
		pow[0] = 1;
		for(int i=1;i<=n;i++) pow[i] = (pow[i-1]*2)%mod;
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0 || j==i) C[i][j] = 1;
				else C[i][j] = (C[i-1][j-1] + C[i-1][j])%mod;
			}
		}
		
		
	}
	
	
	static long exp(long a, long n) {
		long res = 1;
		while(n>0) {
			if((n&1)==1) res = (res*a)%mod;
			a = (a*a)%mod;
			n = n>>1;
		}
		return res;
	}
	
	static long inv(long n) {
		return exp(n, mod-2);
	}
	

	
    static final Random random=new Random();
    
    static <T> void shuffle(T[] arr) {
    	int n = arr.length;
    	for(int i=0;i<n;i++	) {
    		int k = random.nextInt(n);
    		T temp = arr[k]; arr[k] = arr[i]; arr[i] = temp;
    	}
    }
    
    	
    static void ruffleSort(int[] a) {
    	int n=a.length;//shuffle, then sort 
    	for (int i=0; i<n; i++) {
    		int oi=random.nextInt(n); int temp=a[oi];
    		a[oi]=a[i]; a[i]=temp;
    	}
    	Arrays.sort(a);
    }
    
    static void ruffleSort(long[] a) {
    	int n=a.length;//shuffle, then sort 
    	for (int i=0; i<n; i++) {
    		int oi=random.nextInt(n); long temp=a[oi];
    		a[oi]=a[i]; a[i]=temp;
    	}
    	Arrays.sort(a);
    }
   
  
    
    static void reverse(int[] arr, int l, int r) {
    	for(int i=l;i<l+(r-l)/2;i++){
    		int temp = arr[i]; arr[i] = arr[r-i+l-1]; arr[r-i+l-1] = temp;
    	}
    }
    
    static void reverse(long[] arr, int l, int r) {
    	for(int i=l;i<l+(r-l)/2;i++){
    		long temp = arr[i]; arr[i] = arr[r-i+l-1]; arr[r-i+l-1] = temp;
    	}
    }
    
    
    static <T> void reverse(T[] arr, int l, int r) {
    	for(int i=l;i<l+(r-l)/2;i++) {
    		T temp = arr[i]; arr[i] = arr[r-i+l-1]; arr[r-i+l-1] = temp;
    	}
    }
    	
    	
    static class FastScanner{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer("");
     
    	public String next(){
    		while(!st.hasMoreElements()){
    			try{
    				st = new StringTokenizer(br.readLine());
    			} catch(IOException e){
    				e.printStackTrace();
    			}
    		}
    		return st.nextToken();
    	}
    		
    	public String nextLine() throws IOException {
    		return br.readLine();
    	}
    		
    	public int nextInt(){
    		return Integer.parseInt(next());
    	}
     
    	public int[] readArray(int n){
    		int[] a = new int[n];
    		for(int i=0;i<n;i++)
    			a[i] = nextInt();
    		return a;
    	}
    		
    	public long nextLong() {
    		return Long.parseLong(next());
    	}
    		
    	public char nextChar() {
    		return next().toCharArray()[0];
    	}
    }
   	
}
